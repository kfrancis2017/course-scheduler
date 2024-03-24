package test;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import degreeswork.Major;
import degreeswork.MajorList;

public class testMajorList {
    
    @Test
    public void testAddMajor() {
        MajorList majorList = MajorList.getInstance();
        Major major1 = new Major("Computer Science");
        Major major2 = new Major("Electrical Engineering");

        Assert.assertTrue(majorList.addMajor(major1));
        Assert.assertTrue(majorList.addMajor(major2));
        Assert.assertFalse(majorList.addMajor(major1)); // Adding duplicate major should fail
    }

    @Test
    public void testModifyMajor() {
        MajorList majorList = MajorList.getInstance();
        Major oldMajor = new Major("Computer Science");
        majorList.addMajor(oldMajor);

        Major newMajor = new Major("Software Engineering");
        Assert.assertTrue(majorList.modifyMajor(newMajor, oldMajor));
    }

    @Test
    public void testDeleteMajor() {
        MajorList majorList = MajorList.getInstance();
        Major major = new Major("Computer Science");
        majorList.addMajor(major);

        Assert.assertTrue(majorList.deleteMajor(major));
        Assert.assertFalse(majorList.deleteMajor(major)); // Deleting the same major again should fail
    }

    @Test
    public void testGetMajorByName() {
        MajorList majorList = MajorList.getInstance();
        Major major = new Major("Computer Science");
        majorList.addMajor(major);

        Major foundMajor = majorList.getMajorByName("Computer Science");
        Assert.assertEquals(major, foundMajor);
    }

    @Test
    public void testGetMajors() {
        MajorList majorList = MajorList.getInstance();
        Major major1 = new Major("Computer Science");
        Major major2 = new Major("Electrical Engineering");

        majorList.addMajor(major1);
        majorList.addMajor(major2);

        ArrayList<Major> majors = majorList.getMajors();
        Assert.assertEquals(2, majors.size());
        Assert.assertTrue(majors.contains(major1));
        Assert.assertTrue(majors.contains(major2));
    }
}
