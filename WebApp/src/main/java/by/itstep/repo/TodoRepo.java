package by.itstep.repo;

import by.itstep.model.ToDoItem;

import java.util.List;
import java.util.Map;

public interface TodoRepo {

    void save(ToDoItem todoItem);

    List<ToDoItem> getAll();



    void delete(int id);

    //ToDoItem getTodoItemByID(int todoItemID);


}
