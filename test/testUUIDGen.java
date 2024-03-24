package test;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

import degreeswork.UUIDGen;

public class testUUIDGen {
    
    @Test
    public void testGenerateID() {
        UUID id1 = UUIDGen.generateID();
        UUID id2 = UUIDGen.generateID();
        
        Assert.assertNotNull(id1);
        Assert.assertNotNull(id2);
        Assert.assertNotEquals(id1, id2);
    }
}
