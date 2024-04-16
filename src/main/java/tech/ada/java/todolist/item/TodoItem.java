package tech.ada.java.todolist.item;

import java.time.LocalDateTime;
import java.util.UUID;

public final class TodoItem {

    private String titulo;
    private String detalhes;
    private LocalDateTime data;
    private final UUID uuid;
    private Boolean concluido;

    public TodoItem(String titulo, String detalhes, LocalDateTime data, UUID uuid, Boolean concluido) {
        this.titulo = titulo;
        this.detalhes = detalhes;
        this.data = data;
        this.uuid = uuid;
        this.concluido = concluido;
    }

    public TodoItem(String titulo, String detalhes, LocalDateTime data) {
        this(titulo, detalhes, data, UUID.randomUUID(), false);
    }

    public UUID getUuid() {
        return uuid;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "TodoItem[" +
            "titulo=" + titulo + ", " +
            "detalhes=" + detalhes + ", " +
            "data=" + data + ", " +
            "uuid=" + uuid + ", " +
            "concluido=" + concluido + ']';
    }

}
