package sk.filiptvrdon.junitWithMockito;

import java.util.ArrayList;
import java.util.List;

// SUT - system under test
public class TodoBusinessImpl {

    private TodoService todoService; // dependency we don't have control over

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodoRelatedToSpring(String user){
        List<String> filteredTodos = new ArrayList<>();
        List<String> todos = todoService.retrieveTodos(user);

        for (String todo: todos){
            if (todo.contains("Spring")){
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
}
