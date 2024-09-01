package app.convertor;

import app.model.dto.TodoDto;
import app.model.entity.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemConvertor {
  public TodoDto convertToDto(TodoItem todoItem) {
    return new TodoDto(todoItem.getId(), todoItem.isCompleted(), todoItem.getDescription());
  }

  public TodoItem convertToEntity(TodoDto todoDto) {
    return new TodoItem(todoDto.getId(), todoDto.getDescription());
  }
}
