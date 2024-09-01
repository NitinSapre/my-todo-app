package app.controller;

import app.model.dto.TodoDto;
import app.model.entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import app.service.TodoItemServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoItemController {

  @Autowired
  private TodoItemServiceImpl todoItemService;

  @GetMapping
  public ResponseEntity<List<TodoDto>> getAllTodos() {
    return new ResponseEntity<>(todoItemService.getAllTodoItems(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TodoDto> getTodoById(@PathVariable String id) {
    return new ResponseEntity<>(todoItemService.getTodoItem(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto newTodo) {
    return new ResponseEntity<>(todoItemService.createTodoItem(newTodo), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<TodoDto> updateTodoItem(@RequestBody TodoDto updatedTodo) {
    return new ResponseEntity<>(todoItemService.updateTodoItem(updatedTodo), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTodo(@PathVariable String id) {
    todoItemService.deleteTodoItem(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
