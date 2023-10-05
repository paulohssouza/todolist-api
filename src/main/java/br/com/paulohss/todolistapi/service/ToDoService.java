package br.com.paulohss.todolistapi.service;

import br.com.paulohss.todolistapi.entity.ToDo;
import br.com.paulohss.todolistapi.repository.ToDoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> create(ToDo todo) {
        toDoRepository.save(todo);
        return list();
    }

    public List<ToDo> list() {
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("name").ascending()
        );
        return toDoRepository.findAll(sort);
    }

    public List<ToDo> update(ToDo toDo) {
        toDoRepository.save(toDo);
        return list();
    }

    public List<ToDo> delete(Long id) {
        toDoRepository.deleteById(id);
        return list();
    }
}
