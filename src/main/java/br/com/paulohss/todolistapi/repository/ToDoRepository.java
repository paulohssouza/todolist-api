package br.com.paulohss.todolistapi.repository;

import br.com.paulohss.todolistapi.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
