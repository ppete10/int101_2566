package work01;

public class Utilitor {
    public static String testString(String value, String message) {
        if (value == null) {
            throw new NullPointerException();
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    public static double testPositive(double value) {
        if (value < 0)
            throw new IllegalArgumentException("Value is Negative");
        return value;
    }

    public static long computeIsbn10(long isbn10) {
        int sum = 0;
        int weight = 10;

        for (int i = 2; i <= 10; i++){
            int digit = (int) isbn10 % 10;
            sum += weight * digit;
            weight--;
            isbn10/=10;
        }
        sum = (sum%11);
        return sum;
    }
}
