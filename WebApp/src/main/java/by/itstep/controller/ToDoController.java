package by.itstep.controller;


import by.itstep.model.ToDoItem;
import by.itstep.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class ToDoController {

    TodoService todoService;


    @ResponseBody
    @GetMapping("/todo/getAll")
    List<ToDoItem> getAll() {
//        List<ToDoItem> items = new ArrayList<>();
//        items.add(new ToDoItem("learn java", "read the book"));
//        items.add(new ToDoItem("make party", "call to friends"));
        return todoService.getAll();
    }



    @PostMapping("/todo/save")
    public ResponseEntity saveTodo(ToDoItem todoItem) {

        todoItem.setId((int) (Math.random() * Integer.MAX_VALUE));
        todoService.save(todoItem);

        return ResponseEntity.ok().build();


    }


    //TODO
    @GetMapping("/todo/delete")
    public void deleteByID(int id) {

    }




}
