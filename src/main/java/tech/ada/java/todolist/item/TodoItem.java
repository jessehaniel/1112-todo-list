package tech.ada.java.todolist.item;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    @Column(columnDefinition = "UUID default RANDOM_UUID()")
    private UUID uuid;
    private String titulo;
    private String detalhes;
    private LocalDateTime data;
    @Column(columnDefinition = "boolean default false")
    private Boolean concluido;
    @Enumerated(EnumType.STRING)
    private PrioridadeEnum prioridade;

    enum PrioridadeEnum {
        ALTA,
        MEDIA,
        BAIXA
    }

}
