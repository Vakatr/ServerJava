package com.legist.myapp.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "statuses")
public class MessageStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Length(max = 256,  message = "Многа букав!")
    private String name;

    @OneToMany(mappedBy = "messageStatus", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Message> messages;

    public MessageStatus(String messageStatus) {
        this.name = messageStatus;
    }

    public MessageStatus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageStatus status = (MessageStatus) o;
        return id.equals(status.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
