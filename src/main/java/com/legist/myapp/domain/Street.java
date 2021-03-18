package com.legist.myapp.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Length(max = 256,  message = "Многа букав!")
    private String name;

    @OneToMany(mappedBy = "street1", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Message> messages1;

    @OneToMany(mappedBy = "street2", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Message> messages2;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

    public Street() {
    }

    public Street(String name) {
        this.name = name;
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

    public Set<Message> getMessages1() {
        return messages1;
    }

    public void setMessages1(Set<Message> messages1) {
        this.messages1 = messages1;
    }

    public Set<Message> getMessages2() {
        return messages2;
    }

    public void setMessages2(Set<Message> messages2) {
        this.messages2 = messages2;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
