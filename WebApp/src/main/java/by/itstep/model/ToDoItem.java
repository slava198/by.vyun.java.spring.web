package by.itstep.model;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data


public class ToDoItem {

    public ToDoItem() {
    }

    public ToDoItem(String title, String description) {
        //this.id = ((int) (Math.random() * Integer.MAX_VALUE));
        this.title = title;
        this.description = description;
    }

    public ToDoItem(Integer id, String title, String description) {

        this.id = id;
        this.title = title;
        this.description = description;
    }


    public void setID(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    Integer id;
    String title;
    String description;

//    public ToDoItem(String title, String description) {
//        this.title = title;
//        this.description = description;
//    }
}
