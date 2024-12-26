package project.TODO.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
@Table(name="todo_items")
public class TodoItem implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Description is required !")
    private String description;

    private Boolean isComplete;

    private Instant createdAt;

    private Instant updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    // public Instant getCreatedAt() {
    //     return createdAt;
    // }

    // public void setCreatedAt(Instant createdAt) {
    //     this.createdAt = createdAt;
    // }

    // public Instant getUpdatedAt() {
    //     return updatedAt;
    // }

    // public void setUpdatedAt(Instant updatedAt) {
    //     this.updatedAt = updatedAt;
    // }

    // @Override
    // public String toString() {
    //     return String.format("TodoItem{id=%d, description='%s', isComplete='%s', createdAt='%s', updatedAt='%s'}",
    //             id,description,isComplete,createdAt,updatedAt);
    // }

     private static final DateTimeFormatter FORMATTER = 
            DateTimeFormatter.ofPattern("yyyy-MM-dd, 'at' h:mm:ss a");

    // Utility to format 'createdAt'
    public String getFormattedCreatedAt() {
        return formatInstant(createdAt);
    }

    // Utility to format 'updatedAt'
    public String getFormattedUpdatedAt() {
        return formatInstant(updatedAt);
    }

    // Helper method to format an Instant
    private String formatInstant(Instant instant) {
        if (instant == null) {
            return "N/A"; // Return a placeholder if the value is null
        }
        return ZonedDateTime.ofInstant(instant, ZoneId.systemDefault()).format(FORMATTER);
    }

    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, description='%s', isComplete='%s', createdAt='%s', updatedAt='%s'}",
                id, description, isComplete, getFormattedCreatedAt(), getFormattedUpdatedAt());
    }
}