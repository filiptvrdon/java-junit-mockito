package sk.filiptvrdon.junitWithMockito;

public class Calculator {

    public int square(int i) {
        int number = verifyInput(i);
        return number * number;
    }

    private int verifyInput(int number) {
        System.out.println("Verifying input");
        if (number > 46340) {
            throw new IllegalArgumentException("number cannot be greater than 46340");
        } else if (number < -46340) {
            throw new IllegalArgumentException("number cannot be less than -46340");
        }
        return number;
    }
}
