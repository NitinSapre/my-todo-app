package app.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoItem {
  @Id
  private String id;

  private boolean completed;

  private String description;

  public TodoItem(String id, String description) {
    this.description = description;
    this.id = id;
  }

  @Override
  public String toString() {
    return id + " " + (completed ? "[COMPLETED] " : "[ ] ") + description;
  }
}
