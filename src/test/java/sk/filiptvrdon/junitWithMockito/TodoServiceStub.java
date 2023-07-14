package sk.filiptvrdon.junitWithMockito;

import java.util.Arrays;
import java.util.List;

// a stub implementation of TodoService
public class TodoServiceStub implements TodoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to dance");
    }
}
