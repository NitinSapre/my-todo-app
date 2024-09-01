package app.service;

import app.convertor.TodoItemConvertor;
import app.model.dto.TodoDto;
import app.model.entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repository.TodoItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoItemServiceImpl implements TodoItemService {

  @Autowired
  private TodoItemRepository todoItemRepository;

  @Autowired
  private TodoItemConvertor todoItemConvertor;

  public List<TodoDto> getAllTodoItems() {
    return todoItemRepository.findAll().stream()
        .map(todoItemConvertor::convertToDto)
        .collect(Collectors.toList());
  }

  public TodoDto createTodoItem(TodoDto newTodoItem) {
    return todoItemConvertor.convertToDto(todoItemRepository.save(todoItemConvertor.convertToEntity(newTodoItem)));
  }

  public TodoDto getTodoItem(String id) {
    return todoItemConvertor.convertToDto(todoItemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID")));
  }

  public void deleteTodoItem(String id) {
    todoItemRepository.deleteById(id);
  }

  public TodoDto updateTodoItem(TodoDto todoItem) {
    return todoItemConvertor.convertToDto(todoItemRepository.save(todoItemConvertor.convertToEntity(todoItem)));
  }
}
