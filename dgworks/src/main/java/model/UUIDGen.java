package model;

import java.util.UUID;

// Use to generate unique identifiers
public class UUIDGen {
    
    public static void main(String[] args) {
        UUID id = UUID.randomUUID();
        System.out.println(id);
    }

    public static UUID generateID() {
        return UUID.randomUUID();
    }
}
