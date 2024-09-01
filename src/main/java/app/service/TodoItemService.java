package app.service;

import app.model.dto.TodoDto;

import java.util.List;

public interface TodoItemService {
  List<TodoDto> getAllTodoItems();

  TodoDto createTodoItem(TodoDto newTodoItem);

  TodoDto getTodoItem(String id);

  void deleteTodoItem(String id);

  TodoDto updateTodoItem(TodoDto todoItem);
}
