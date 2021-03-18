package com.legist.myapp.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "brand_of_cars")
public class BrandOfCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Length(max = 256,  message = "Многа букав!")
    private String name;

    @OneToMany(mappedBy = "brandOfCar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ModelOfCar> modelOfCars;

    @OneToMany(mappedBy = "car_brandOfCar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Car> cars;

    public BrandOfCar() {
    }

    public BrandOfCar(String name) {
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

    public Set<ModelOfCar> getModelOfCars() {
        return modelOfCars;
    }

    public void setModelOfCars(Set<ModelOfCar> modelOfCars) {
        this.modelOfCars = modelOfCars;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
