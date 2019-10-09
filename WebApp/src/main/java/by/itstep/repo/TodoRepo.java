package by.itstep.repo;

import by.itstep.model.ToDoItem;

import java.util.List;

public interface TodoRepo {

    void save(ToDoItem todoItem);

    List<ToDoItem> getAll();

    void delete();


}
