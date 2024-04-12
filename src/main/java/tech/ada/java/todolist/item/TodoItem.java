package tech.ada.java.todolist.item;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public final class TodoItem {

    private final String titulo;
    private final String detalhes;
    private final LocalDateTime data;
    private final UUID uuid;
    private final Boolean concluido;

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

    public String titulo() {
        return titulo;
    }

    public String detalhes() {
        return detalhes;
    }

    public LocalDateTime data() {
        return data;
    }

    public UUID uuid() {
        return uuid;
    }

    public Boolean concluido() {
        return concluido;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (TodoItem) obj;
        return Objects.equals(this.titulo, that.titulo) &&
            Objects.equals(this.detalhes, that.detalhes) &&
            Objects.equals(this.data, that.data) &&
            Objects.equals(this.uuid, that.uuid) &&
            Objects.equals(this.concluido, that.concluido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, detalhes, data, uuid, concluido);
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
