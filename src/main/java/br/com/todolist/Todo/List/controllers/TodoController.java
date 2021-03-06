package br.com.todolist.Todo.List.controllers;

import br.com.todolist.Todo.List.entity.Todo;
import br.com.todolist.Todo.List.exceptions.ObjectNotFoundException;
import br.com.todolist.Todo.List.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("*")
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
        return ResponseEntity.ok(dbService.getById(idTodo).orElseThrow(() ->
                new ObjectNotFoundException("Objeto de ID: "+ idTodo + " Não Encontrado")));
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

    @PutMapping("/{idTodo}")
    public Todo updateTodo(@RequestBody Todo todo){
        return dbService.updateTodo(todo);
    }

    @DeleteMapping("/{idTodo}")
    public ResponseEntity deleteByID(@PathVariable("idTodo") Integer idTodo) throws Exception {
        try {
            dbService.deleteTodo(idTodo);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.noContent().build();

    }
}
