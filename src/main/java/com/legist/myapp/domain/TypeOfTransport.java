package com.legist.myapp.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "type_of_transports")
public class TypeOfTransport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Length(max = 256,  message = "Многа букав!")
    private String name;

    @OneToMany(mappedBy = "typeOfTransport", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Car> cars;

    public TypeOfTransport() {
    }

    public TypeOfTransport(String name) {
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

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
