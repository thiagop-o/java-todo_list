package br.com.todolist.Todo.List.controllers;

import br.com.todolist.Todo.List.entity.Todo;
import br.com.todolist.Todo.List.repositories.ITodoRepository;
import br.com.todolist.Todo.List.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/main")
public class TodoController {
    @Autowired
    DBService dbService;

    @GetMapping
    public List<Todo> getTodoList(){
        return dbService.findAll();
    }

    @GetMapping("/{idTodo}")
    public ResponseEntity<Todo> getTodoByID(@PathVariable("idTodo") Integer idTodo) throws Exception{
        return ResponseEntity.ok(dbService.getById(idTodo).orElseThrow(() -> new NoSuchElementException("Not Found!")));
    }

    @GetMapping("/active")
    public ResponseEntity<List<Todo>> getTodoListActive() throws Exception{
        List<Todo> listActive = dbService.findAllOpen();
        return ResponseEntity.ok().body(listActive);

    }

    @GetMapping("/closed")
    public ResponseEntity<List<Todo>> getTodoListClosed() throws Exception{
        List<Todo> listClosed = dbService.findAllClosed();
        return ResponseEntity.ok().body(listClosed);

    }



    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        return dbService.saveTodo(todo);
    }
}
