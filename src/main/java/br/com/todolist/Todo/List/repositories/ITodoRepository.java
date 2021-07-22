package br.com.todolist.Todo.List.repositories;

import br.com.todolist.Todo.List.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoRepository extends JpaRepository<Todo,Integer> {
}
