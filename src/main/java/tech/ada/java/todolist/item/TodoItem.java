package tech.ada.java.todolist.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TodoItem {

    private String titulo;
    private String detalhes;
    private LocalDateTime data;
    private UUID uuid;
    private Boolean concluido;

    @JsonCreator
    public TodoItem(String titulo, String detalhes, LocalDateTime data) {
        this(titulo, detalhes, data, UUID.randomUUID(), false);
    }


}
