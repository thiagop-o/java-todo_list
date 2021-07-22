package br.com.todolist.Todo.List;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ToDoListApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(ToDoListApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
