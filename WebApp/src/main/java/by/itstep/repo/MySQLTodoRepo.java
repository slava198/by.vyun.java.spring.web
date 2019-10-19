package by.itstep.repo;

import by.itstep.model.ToDoItem;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class MySQLTodoRepo implements TodoRepo {

    private static final String SELECT_ALL_TODO = "SELECT * FROM `todoItem`";
    private static final String INSERT_TODO = "INSERT INTO `todoList`.`todoItem` " +
                                                    "(`id`, `title`, `description`)" +
                                                    "VALUES (?, ?, ?)" +
                                                    "ON DUPLICATE KEY UPDATE  `title` = ?, `description` = ?";

    private static final String DELETE_TODO = "DELETE FROM `todoList`.`todoItem`" +
                                              "WHERE `todoitem`.`id` = ?";




    @Override
    public void save(ToDoItem todoItem) {

        try ( Connection conn = C3poDataSource.getConnection();
              PreparedStatement ps = conn.prepareStatement(INSERT_TODO)){
            ps.setInt(1, todoItem.getId());
            ps.setString(2, todoItem.getTitle());
            ps.setString(3, todoItem.getDescription());
            ps.setString(4, todoItem.getTitle());
            ps.setString(5, todoItem.getDescription());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<ToDoItem> getAll() {

        List<ToDoItem> items = new ArrayList<>();

        try (Connection conn = C3poDataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_TODO)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String description = rs.getString(3);
                ToDoItem item = new ToDoItem(id, title, description);
                items.add(item);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return items;
    }

    @Override
    public void delete(int id) {

        try ( Connection conn = C3poDataSource.getConnection();
              PreparedStatement ps = conn.prepareStatement(DELETE_TODO)){
            ps.setInt(1, id);


            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

