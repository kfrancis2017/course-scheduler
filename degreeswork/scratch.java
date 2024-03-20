
public void getAllMajors(JSONArray jsonData) {
    MajorList majors = MajorList.getInstance();
    CourseList courses = CourseList.getInstance();

    for (Object majorObj : jsonData) {
        JSONObject majorData = (JSONObject) majorObj;
        String name = (String) majorData.get("name");
        Major major = new Major(name);
        JSONArray options = (JSONArray) majorData.get("options");
        for (Object optionObj : options) {
            JSONArray coursesArray = (JSONArray) optionObj;
            for (Object courseObj : coursesArray) {
                JSONObject courseData = (JSONObject) courseObj;
                String courseName = (String) courseData.get("course");
                Course course = courses.findCourseByCode(courseName);
                if (course != null) {
                    major.addCourse(course);
                } else {
                    System.out.println("Course '" + courseName + "' not found in the course list.");
                    // You may want to handle this case according to your application's logic
                }
            }
        }
        // After constructing the Major object and adding courses, add the major to the MajorList
        majors.addMajor(major);
    }
}