package com.legist.myapp.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "type_of_road_objects")
public class TypeOfRoadObj {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Length(max = 256,  message = "Многа букав!")
    private String name;

    @OneToMany(mappedBy = "typeOfRoadObj", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Message> typeOfRoadObj;

    public TypeOfRoadObj() {
    }

    public TypeOfRoadObj(String name) {
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

    public Set<Message> getTypeOfRoadObj() {
        return typeOfRoadObj;
    }

    public void setTypeOfRoadObj(Set<Message> typeOfRoadObj) {
        this.typeOfRoadObj = typeOfRoadObj;
    }
}
