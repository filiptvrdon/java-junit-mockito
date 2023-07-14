package sk.filiptvrdon.junitWithMockito;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void squareTestHappyPath() {
        Calculator calculator = new Calculator();

        assertEquals(9, calculator.square(3));
        assertEquals(16, calculator.square(4));

    }


    @Test
    public void squareTestUpperBoundary() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.square(46341));
    }

    @Test
    public void squareTestLowerBoundary() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.square(-46341));
    }
}