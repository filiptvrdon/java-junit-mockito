package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    @Test
    public void getGradeTestWithReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GradeCalculator gc = new GradeCalculator();

        Class[] parameters = new Class[1];
        parameters[0] = Integer.class;

        Method methodCall = gc.getClass().getDeclaredMethod("getGrade", parameters);
        methodCall.setAccessible(true);

        Object[] methodArgument = new Object[1];
        methodArgument[0] = 70;

        String actualResult = (String) methodCall.invoke(gc, methodArgument);
        assertEquals("fail", actualResult);

        methodArgument[0] = 100;
        actualResult = (String) methodCall.invoke(gc, methodArgument);
        assertEquals("pass", actualResult);
    }


}