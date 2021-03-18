package com.legist.myapp.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "model_of_cars")
public class ModelOfCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Length(max = 256,  message = "Многа букав!")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private BrandOfCar brandOfCar;

    @OneToMany(mappedBy = "car_modelOfCar", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Car> cars;

    public ModelOfCar() {
    }

    public ModelOfCar(String name) {
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

    public BrandOfCar getBrandOfCar() {
        return brandOfCar;
    }

    public void setBrandOfCar(BrandOfCar brandOfCar) {
        this.brandOfCar = brandOfCar;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
