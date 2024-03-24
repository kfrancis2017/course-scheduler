package test;

import java.util.ArrayList;

import javax.xml.crypto.Data;

import org.junit.Assert;
import org.junit.Test;

import degreeswork.CourseList;
import degreeswork.DataLoader;

public class testDataLoader {
    
    @Test
    public void testDataLoaderGetAllCourses() {
        DataLoader.getAllCourses();
        CourseList.getInstance();
    }
}
