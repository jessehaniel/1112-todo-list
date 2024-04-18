package tech.ada.java.todolist.item;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.ada.java.todolist.item.TodoItem.PrioridadeEnum;
import tech.ada.java.todolist.usuario.UsuarioDto;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TodoItemDto implements Serializable {

    private UUID uuid;
    private String titulo;
    private String detalhes;
    private LocalDateTime data;
    private Boolean concluido;
    private PrioridadeEnum prioridade;
    private UsuarioDto usuario;
}