package by.itstep.service;


import by.itstep.model.ToDoItem;
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

    public void save(ToDoItem todoItem) {


        todoRepo.save(todoItem);



    }


}
