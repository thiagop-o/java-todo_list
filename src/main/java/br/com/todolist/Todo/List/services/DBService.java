package br.com.todolist.Todo.List.services;

import br.com.todolist.Todo.List.entity.Todo;
import br.com.todolist.Todo.List.repositories.ITodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DBService {
   ITodoRepository iTodoRepository;

    @Autowired
    public DBService(ITodoRepository iTodoRepository) {
        this.iTodoRepository = iTodoRepository;
    }


    public void instanciaDB(){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Todo t1 = new Todo("Estudar", "Estudar SpringBoot 2", LocalDateTime.parse("25/03/2022 10:40",dateFormatter),false);
        Todo t2 = new Todo("Estudar", "Estudar Angular", LocalDateTime.parse("25/04/2022 10:40",dateFormatter),false);
        iTodoRepository.saveAll(Arrays.asList(t1,t2));
    }

    public List<Todo> findAll() {
        return iTodoRepository.findAll();
    }

    public Optional<Todo> getById(Integer idTodo){
        return iTodoRepository.findById(idTodo);
    }

}
