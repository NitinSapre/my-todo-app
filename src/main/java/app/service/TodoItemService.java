package app.service;

import app.model.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repository.TodoItemRepository;

import java.util.List;

@Service
public class TodoItemService {

  @Autowired
  private TodoItemRepository todoItemRepository;

  public List<TodoItem> getAllTodoItems() {
    return todoItemRepository.findAll();
  }

  public TodoItem createTodoItem(TodoItem newTodoItem) {
    return todoItemRepository.save(newTodoItem);
  }

  public TodoItem getTodoItem(String id) {
    return todoItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"));
  }

  public void deleteTodoItem(String id) {
    todoItemRepository.deleteById(id);
  }

  public TodoItem updateTodoItem(TodoItem todoItem) {
    return todoItemRepository.save(todoItem);
  }
}
