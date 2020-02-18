package by.itstep.service;


import by.itstep.model.ToDoItem;
import by.itstep.model.dto.ObjectID;
import by.itstep.repo.TodoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    TodoRepo todoRepo;

    public List<ToDoItem> getAll() {

        return todoRepo.getAll();

    }

    public int save(ToDoItem todoItem) {

        if (todoItem.getId() == null || todoItem.getId() == 0) {
            todoItem.setID((int) (Math.random() * Integer.MAX_VALUE));

        }
        todoRepo.save(todoItem);
        return todoItem.getId();
    }




    public void delete(int id) {


        todoRepo.delete(id);
    }


}
