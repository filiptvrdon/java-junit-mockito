package sk.filiptvrdon.business;

import org.junit.jupiter.api.Test;
import sk.filiptvrdon.data.api.TodoService;
import sk.filiptvrdon.data.api.TodoServiceStub;
import sk.filiptvrdon.sk.filiptvrdon.business.impl.TodoBusinessImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TodoBusinessImplStubTest {

    @Test
    public void testRetrieveTodoRelatedToSpring_usingStub() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

        List<String> resultList = todoBusinessImpl.retrieveTodoRelatedToSpring("Dummy");
        assertEquals(2, resultList.size());
    }
}
