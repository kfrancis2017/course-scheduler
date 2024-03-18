package degreeswork;

import java.util.ArrayList;

public class MajorList {
    private static MajorList MajorList;
    private ArrayList<Major> Majors;

    public MajorList() {
        Majors = new ArrayList<Major>();
    }

    public MajorList(ArrayList<Major> Majors) {
        this.Majors = Majors;
    }

    public static MajorList getInstance() {
        if (MajorList == null)
            MajorList = new MajorList();
        return MajorList;
    }

    public boolean addMajor(Major Major) {
        if (Major == null || findMajorByCode(Major.getName()) != null)
            return false;
        Majors.add(Major);
        return true;
    }
    
    public boolean modifyMajor(Major newMajor, Major oldMajor) {
        if (newMajor == oldMajor)
            return false;
        int index = Majors.indexOf(oldMajor);
        if(index != -1) {  // old Major exists
            Majors.set(index, newMajor);
            return true;
        }
        return false;
    }

    public boolean deleteMajor(Major Major) {
        return Majors.remove(Major);
    }

    public Major findMajorByCode(String MajorID) {
        for (Major Major : Majors) {
            if (Major.getName().equals(MajorID)) {
                return Major;
            }
        }
        return null;
    }

    public ArrayList<Major> getMajors() {
        return Majors;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Major Major : Majors) {
            sb.append(Major.getName());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String allToString() {
        StringBuilder sb = new StringBuilder();
        for (Major Major : Majors) {
            sb.append(Major.toString());
            sb.append("\n");
        }
        return sb.toString();        
    }
}
