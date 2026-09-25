package util;

public class Validator {
    private Validator() {
    }

    public static void notNull(Object value, String message) {
        if (value == null)
            throw new IllegalStateException(message);
    }

    public static void isNull(Object value, String message) {
        if (value != null)
            throw new IllegalStateException(message);
    }
}
