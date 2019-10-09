package by.itstep.model;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data


public class ToDoItem {

    public ToDoItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public ToDoItem(int id, String title, String description) {

        this.id = id;
        this.title = title;
        this.description = description;
    }

    int id;
    String title;
    String description;

//    public ToDoItem(String title, String description) {
//        this.title = title;
//        this.description = description;
//    }
}
