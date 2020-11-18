package Util;

public class IdGenerator {
    private static Long currentId = 0L;

    public static Long getId() {
        return currentId++;
    }
}
