package model;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDFont;
import java.io.IOException;
import java.util.ArrayList;

public class PDFGen {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> tablesData = getData();

        try (PDDocument doc = new PDDocument()) {
            PDFont font = PDType0Font.load(doc, PDFGen.class.getResourceAsStream("BerlingskeSerif.ttf"), true);
            PDPage page = new PDPage();
            doc.addPage(page);
            PDPageContentStream contentStream = new PDPageContentStream(doc, page);

            float margin = 50;
            float startY = page.getMediaBox().getHeight() - margin; // Top of the page

            // Title Text
            contentStream.beginText();
            contentStream.setFont(font, 18); // Larger font size for title
            contentStream.setNonStrokingColor(0, 0, 0); // Set text color to black
            contentStream.newLineAtOffset(margin, startY - 20); // Position for the title
            contentStream.showText("Course Plan for John Doe, Fall 2023");
            contentStream.endText();
            contentStream.setFont(font, 12); // Reset font size for table text

            // Reset startY for tables, just below the title
            startY -= 60; // Move down to start tables below the title

            for (ArrayList<String> table : tablesData) {
                if (startY < margin * 2 + 2) { // Check if new page is needed
                    contentStream.close();
                    page = new PDPage();
                    doc.addPage(page);
                    contentStream = new PDPageContentStream(doc, page);
                    startY = page.getMediaBox().getHeight() - margin;
                }

                float tableHeight = drawTable(doc, page, contentStream, margin, startY, table, font);
                startY -= (tableHeight + 2); // Update startY for next table, add space between tables
            }
            contentStream.close();
            doc.save("DynamicPDFTables.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static float drawTable(PDDocument doc, PDPage page, PDPageContentStream contentStream, float margin, float startY, ArrayList<String> rows, PDFont font) throws IOException {
        float rowHeight = 20;
        float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
        float columnWidth = tableWidth / rows.get(0).split("\t").length; // Assuming all rows have the same number of columns
    
        contentStream.setFont(font, 12);
    
        // Draw the lines and background for headers
        float nextY = startY;
        boolean isHeader = true; // Flag to indicate header row
    
        for (int i = 0; i <= rows.size(); i++) {
            // Draw horizontal lines
            contentStream.moveTo(margin, nextY);
            contentStream.lineTo(margin + tableWidth, nextY);
            contentStream.stroke();
    
            if (i < rows.size()) {
                // Set fill color for header
                if (isHeader) {
                    contentStream.setNonStrokingColor(115 / 255f, 0 / 255f, 10 / 255f); // Convert RGB to 0..1 scale for PDFBox
                    contentStream.addRect(margin, nextY - rowHeight, tableWidth, rowHeight);
                    contentStream.fill();
                }
    
                // Prepare to draw text
                String[] columns = rows.get(i).split("\t");
                float nextX = margin + 5; // Small padding from left
                for (String field : columns) {
                    contentStream.beginText();
                    contentStream.newLineAtOffset(nextX, nextY - 15); // Adjust to vertically center text
                    // Set text color
                    if (isHeader) {
                        contentStream.setNonStrokingColor(1f, 1f, 1f); // White color for 
                    } else {
                        contentStream.setNonStrokingColor(0f, 0f, 0f); // Black color for body text, values are already within 0..1
                    }
                    contentStream.showText(field);
                    contentStream.endText();
                    nextX += columnWidth; // Move to next column
                }
                if (isHeader) {
                    isHeader = false; // Only the first row is header
                }
            }
    
            nextY -= rowHeight;
        }
    
        // Draw vertical lines
        float nextX = margin;
        for (int i = 0; i <= rows.get(0).split("\t").length; i++) {
            contentStream.moveTo(nextX, startY);
            contentStream.lineTo(nextX, startY - (rowHeight * (rows.size())));
            contentStream.stroke();
            nextX += columnWidth;
        }
    
        return startY - nextY + rowHeight; // Return the total height of the table
    }

    public static ArrayList<ArrayList<String>> getData() {

        //Load all courses
        DataLoader.getAllCourses();
        ArrayList<Course> courses = CourseList.getInstance().getCourses();

        // Load majors from DataLoader
        DataLoader.getAllMajors();
        ArrayList<Major> majors = MajorList.getInstance().getMajors();

        // Create student and set their major and finished courses
        Student student = new Student("username", "password", "First", "Last");
        student.setMajor(majors.get(0));//gets CS major
        ArrayList<ArrayList<String>> finishedCourses = new ArrayList<>();
        student.setFinishedCourses(finishedCourses);

        // Create scheduler and generate schedule
        Scheduler scheduler = new Scheduler(majors.get(0), student, courses);
        ArrayList<ArrayList<Course>> schedule = scheduler.createSchedule();

        ArrayList<ArrayList<String>> semesters = new ArrayList<>();
        int startYear = 2001;  // Example start year

        System.out.println("Generated Schedule for " + student.getFirstName() + " " + student.getLastName() + ":");

        for (int semester = 0; semester < schedule.size(); semester++) {
            // Determine the semester label based on the index
            String semesterName = (semester % 2 == 0) ? "Fall" : "Spring";
            int year = startYear + semester / 2; // Correcting the year calculation
    
            // Adjust year based on the semester index (odd/even)
            if (semester % 2 == 1) { // If the semester is Spring, increment the year
                year++;
            }
    
            String semesterTitle = semesterName + " " + year;
    
            // Create a list for this semester
            ArrayList<String> semesterCourses = new ArrayList<>();
            semesterCourses.add("Semester " + (semester + 1) + "\t " + semesterTitle); // Adding the semester title as the first element
    
            // Add each course detail to the semester list
            for (Course course : schedule.get(semester)) {
                String courseDetail = course.getCourseID() + " - " + course.getHours() + " hours\t" + course.getTitle();
                semesterCourses.add(courseDetail);
            }
    
            // Add this semester's list to the main list
            semesters.add(semesterCourses);
        }
    
        return semesters;
    }
}
