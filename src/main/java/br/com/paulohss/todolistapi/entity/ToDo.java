package br.com.paulohss.todolistapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "todos")

public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private Boolean accomplished;
    private int priority;

    public ToDo(String name, String description, Boolean accomplished, int priority) {
        this.name = name;
        this.description = description;
        this.accomplished = accomplished;
        this.priority = priority;
    }
}
