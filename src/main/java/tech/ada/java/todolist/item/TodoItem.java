package tech.ada.java.todolist.item;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public final class TodoItem {

    private String titulo;
    private String detalhes;
    private LocalDateTime data;
    private final UUID uuid;
    private Boolean concluido;


    public TodoItem(String titulo, String detalhes, LocalDateTime data) {
        this(titulo, detalhes, data, UUID.randomUUID(), false);
    }


}
