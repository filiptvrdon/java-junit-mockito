package sk.filiptvrdon.business;

import org.junit.jupiter.api.Test;
import sk.filiptvrdon.data.api.TodoService;
import sk.filiptvrdon.sk.filiptvrdon.business.impl.TodoBusinessImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodoRelatedToSpring_usingMock() {
        TodoService todoServiceMock = mock(TodoService.class); // mock creation
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance"));

        List<String> resultList = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");
        assertEquals(2, resultList.size());
    }


    @Test
    public void testRetrieveTodoRelatedToSpring_usingMockWithEmptyList() {
        TodoService todoServiceMock = mock(TodoService.class); // mock creation
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(Arrays.asList());

        List<String> resultList = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");
        assertEquals(0, resultList.size());
    }


    /* TODO
    - clean up the code
    - identify bad practices
    - play around with it
     */
}
