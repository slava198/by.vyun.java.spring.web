package by.itstep.repo;

import by.itstep.model.ToDoItem;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Repository
public class RAMTodoRepo implements TodoRepo {

    List<ToDoItem> todoItems = new ArrayList<>();

    @Override
    public void save(ToDoItem todoItem) {
        todoItems.add(todoItem);

    }

    @Override
    public List<ToDoItem> getAll() {
        return todoItems;
    }

    @PostConstruct
    void postConstruct() {

        todoItems.add(new ToDoItem("learn JS", "read the book"));
        todoItems.add(new ToDoItem("make sleep", "go to bed"));
    }

}
