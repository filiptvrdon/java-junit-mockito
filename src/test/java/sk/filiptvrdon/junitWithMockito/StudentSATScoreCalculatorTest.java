package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

// parameterized testing

class StudentSATScoreCalculatorTest {
    StudentSATScoreCalculator sc = new StudentSATScoreCalculator();

    private static Object[] testValues(){
        return new Object[]{
                new Object[]{0, 0, 0},
                new Object[]{10, 10, 100},
                new Object[]{-10, 100, -1},
                new Object[]{10, -10, -1},
                new Object[]{-10, -10, -1},
                new Object[]{101, 100, -1},
                new Object[]{100, 101, -1},
                new Object[]{101, 101, -1}
        };
    }
    @ParameterizedTest
    @MethodSource("testValues")
    public void studentScoreCalculatorRegular(int mathScore, int verbalScore, int expectedScore){
        assertEquals(expectedScore, sc.calulateSATScore(mathScore, verbalScore));



    }

}