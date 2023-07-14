package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class CustomerOrderTest2 {

    @Spy
    BreakfastWaiter breakfastWaiter;

    @Spy
    DinnerWaiter dinnerWaiter;

    @InjectMocks
    CustomerOrder customerOrder;

    @Test
    public void testServeVegetarianBreakfast() {

        List<String> expectedBreakfast = Arrays.asList("Apple", "Beans", "Hash brown", "Toast");
        List<String> actualBreakfast = customerOrder.vegetarianBreakfast();
        assertEquals(expectedBreakfast, actualBreakfast);
    }

    @Test
    public void testServeMeatDinner() {

        List<String> expectedDinner = Arrays.asList("Calamari", "Roast Chicken", "Sticky toffee pudding");
        List<String> actualDinner = customerOrder.meatDinner();
        assertEquals(expectedDinner, actualDinner);
    }


}