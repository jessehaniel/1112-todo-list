package tech.ada.java.todolist.item;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.ada.java.todolist.usuario.Usuario;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private UUID uuid;
    private String titulo;
    private String detalhes;
    private LocalDateTime data;
    private Boolean concluido;
    @Enumerated(EnumType.STRING)
    private PrioridadeEnum prioridade;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public enum PrioridadeEnum {
        ALTA,
        MEDIA,
        BAIXA
    }

    public TodoItemDto toDto() {
        return TodoItemDto.builder()
            .uuid(this.uuid)
            .titulo(this.titulo)
            .detalhes(this.detalhes)
            .data(this.data)
            .concluido(this.concluido)
            .prioridade(this.prioridade)
            .usuario(this.usuario.toDto())
            .build();
    }

    public static TodoItem fromRequest(TodoItemRequest request) {
        TodoItem todoItem = new TodoItem();
        todoItem.setTitulo(request.getTitulo());
        todoItem.setDetalhes(request.getDetalhes());
        todoItem.setData(request.getData());
        todoItem.setPrioridade(request.getPrioridade());
        return todoItem;
    }

    public static TodoItem fromUpdateRequest(TodoItemUpdateRequest request, Integer id, Usuario usuario) {
        TodoItem todoItem = TodoItem.fromRequest(request);
        todoItem.setUuid(request.getUuid());
        todoItem.setConcluido(request.getConcluido());
        todoItem.setId(id);
        todoItem.setUsuario(usuario);
        return todoItem;
    }

}
