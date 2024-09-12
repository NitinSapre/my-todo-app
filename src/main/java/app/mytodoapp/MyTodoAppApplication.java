package app.mytodoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "app")
@EnableMongoRepositories(basePackages = "app.repository")
public class MyTodoAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyTodoAppApplication.class, args);
  }
}
