package by.itstep.repo;

import by.itstep.model.ToDoItem;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;


//@Repository
public class RAMTodoRepo implements TodoRepo {

    Map<Integer, ToDoItem> itemsMap = new HashMap<>();

    @Override
    public void save(ToDoItem todoItem) {
        itemsMap.put(todoItem.getId(), todoItem);

    }

    @Override
    public List<ToDoItem> getAll() {

        return new ArrayList<>(itemsMap.values());
    }

    @Override
    public void delete(int id) {
        itemsMap.remove(id);
    }


    @PostConstruct
    void postConstruct() {

        save(new ToDoItem(1,"learn JS", "read the book"));
        save(new ToDoItem(2,"make sleep", "go to bed"));
    }

}
