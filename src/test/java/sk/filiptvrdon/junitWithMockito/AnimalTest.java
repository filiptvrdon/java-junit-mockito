package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class AnimalTest {

    @Test
    public void testAnimal() {
        // returns 0, null
        Animal lion = mock(Animal.class);
        System.out.println(lion.getAge());
        System.out.println(lion.getZooKeeper());
        System.out.println("--------------------");

        // returns 0, smart null
        Animal lion2 = mock(Animal.class, RETURNS_SMART_NULLS);
        System.out.println(lion2.getAge());
        System.out.println(lion2.getZooKeeper());
        System.out.println("--------------------");

        // returns 0, smart null
        Animal lion3 = mock(Animal.class, RETURNS_SMART_NULLS);
        when(lion3.getAge()).thenReturn(10);
        when(lion3.getZooKeeper()).thenReturn(new Zookeeper("John"));
        System.out.println(lion3.getAge());
        System.out.println(lion3.getZooKeeper());
        System.out.println("--------------------");

        Animal lion4 = mock(Animal.class, RETURNS_MOCKS);
        System.out.println(lion4.getAge());
        System.out.println(lion4.getZooKeeper());
        System.out.println("--------------------");

        Animal lion5 = mock(Animal.class, RETURNS_DEEP_STUBS);
        when(lion5.getZooKeeper().getName()).thenReturn("Frank");
        System.out.println(lion5.getZooKeeper().getName());
        System.out.println("--------------------");

    }


}