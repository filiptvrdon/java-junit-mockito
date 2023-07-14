package sk.filiptvrdon.junitWithMockito;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void testList_sizeSingleValue() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
    }

    @Test
    public void testList_sizeMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3).thenReturn(4);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
        assertEquals(4, listMock.size());
    }

    @Test
    public void testListGet_specificValue(){
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("SomeString");
        assertEquals("SomeString", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    public void testListGet_anyInt(){
        List listMock = mock(List.class);

        // argument matcher - anyInt()
        when(listMock.get(anyInt())).thenReturn("SomeString");
        assertEquals("SomeString", listMock.get(0));
        assertEquals("SomeString", listMock.get(1));
        assertEquals("SomeString", listMock.get(2));
    }
    @Test
    public void testListException(){
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            listMock.get(0);
        });

    }



}
