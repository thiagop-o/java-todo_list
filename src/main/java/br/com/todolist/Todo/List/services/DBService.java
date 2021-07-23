package br.com.todolist.Todo.List.services;

import br.com.todolist.Todo.List.entity.Todo;
import br.com.todolist.Todo.List.repositories.ITodoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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


    public void instanciaDB() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Todo t1 = new Todo("Estudar", "Estudar SpringBoot 2", sdf.parse("25/03/2022"),false);
        Todo t2 = new Todo("Ler", "Estudar Angular",sdf.parse("25/04/2022"),true);
        Todo t3 = new Todo("Trabalhar", "Estudar Angular", sdf.parse("25/04/2022"),false);
        Todo t4 = new Todo("Meditar", "Estudar Angular", sdf.parse("25/04/2022"),false);
        iTodoRepository.saveAll(Arrays.asList(t1,t2,t3,t4));
    }

    public List<Todo> findAll() {
        return iTodoRepository.findAll();
    }

    public Optional<Todo> getById(Integer idTodo){
        return iTodoRepository.findById(idTodo);
    }

    public Todo saveTodo(Todo todo){
        return iTodoRepository.save(todo);

    }

    public List<Todo> findAllOpen() {
        List<Todo> active = iTodoRepository.findAllOpen();
        return active;
    }

    public List<Todo> findAllClosed() {
        List<Todo> closed = iTodoRepository.findAllClosed();
        return closed;
    }

    public Todo updateTodo(Todo todo){
        return iTodoRepository.save(todo);

    }



    public void deleteTodo(Integer idTodo) {
        iTodoRepository.deleteById(idTodo);
    }
}
