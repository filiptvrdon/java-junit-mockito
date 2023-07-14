package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CustomerOrderTest {
    CustomerOrder customerOrder = new CustomerOrder(new BreakfastWaiter(), new DinnerWaiter());

    @Test
    public void testVegetarianBreakfast() {
        List<String> expectedBreakfast = Arrays.asList("Apple", "Beans", "Hash brown", "Toast");
        List<String> actualBreakfast = customerOrder.vegetarianBreakfast();
        assertEquals(expectedBreakfast, actualBreakfast);
    }

    @Test
    public void testMeatBreakfast() {
        List<String> expectedBreakfast = Arrays.asList("Apple", "Sausages", "Bacon", "Toast");
        List<String> actualBreakfast = customerOrder.meatBreakfast();
        assertEquals(expectedBreakfast, actualBreakfast);
    }

    @Test
    public void testVegetarianDinner() {
        List<String> expectedDinner = Arrays.asList("Garlic bread", "Vegetable Lasagne", "Chocolate Brownie");
        List<String> actualDinner = customerOrder.vegetarianDinner();
        assertEquals(expectedDinner, actualDinner);
    }

    @Test
    public void testMeatDinner() {
        List<String> expectedDinner = Arrays.asList("Calamari", "Roast Chicken", "Sticky toffee pudding");
        List<String> actualDinner = customerOrder.meatDinner();
        assertEquals(expectedDinner, actualDinner);
    }

}