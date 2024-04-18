package tech.ada.java.todolist.item;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.ada.java.todolist.item.TodoItem.PrioridadeEnum;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TodoItemRequest implements Serializable {

    private String titulo;
    private String detalhes;
    private LocalDateTime data;
    private PrioridadeEnum prioridade;

}