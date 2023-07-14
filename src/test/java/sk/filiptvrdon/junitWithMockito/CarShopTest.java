package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


public class CarShopTest {

    static CarShop carShopSpy;
    static Map<String, Integer> carsInStock = new HashMap<>();

    @BeforeAll
    public static void setUp() {
        carShopSpy = Mockito.mock(CarShop.class);
        carsInStock.put("BMW", 5);

        // actually calls the method + performs type check in compile time
        when(carShopSpy.getCarsInStock()).thenReturn(carsInStock);

        // doesn' actually call the method -> just returns the value
        doReturn(carsInStock).when(carShopSpy).getCarsInStock();



    }

    @Test
    public void getCarsInStockTest(){
        assertEquals(carsInStock, carShopSpy.getCarsInStock());
    }

    @Test
    public void getStockForBrandTest(){
        assertEquals(5, carShopSpy.getStockForBrand("BMW"));
    }



}