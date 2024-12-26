package project.TODO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.TODO.models.TodoItem;

public interface TodoItemRepository  extends JpaRepository<TodoItem, Long>
{

}
