package com.legist.myapp.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Length(max = 15,  message = "Многа букав!")
    private String regNum;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private BrandOfCar car_brandOfCar;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id")
    private ModelOfCar car_modelOfCar;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "body_id")
    private TypeOfBody typeOfBody;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transport_id")
    private TypeOfTransport typeOfTransport;


    public Car(String regNum,
               BrandOfCar car_brandOfCar,
               ModelOfCar car_modelOfCar,
               TypeOfBody typeOfBody,
               TypeOfTransport typeOfTransport) {
        this.regNum = regNum;
        this.car_brandOfCar = car_brandOfCar;
        this.car_modelOfCar = car_modelOfCar;
        this.typeOfBody = typeOfBody;
        this.typeOfTransport = typeOfTransport;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public BrandOfCar getCar_brandOfCar() {
        return car_brandOfCar;
    }

    public void setCar_brandOfCar(BrandOfCar car_brandOfCar) {
        this.car_brandOfCar = car_brandOfCar;
    }

    public ModelOfCar getCar_modelOfCar() {
        return car_modelOfCar;
    }

    public void setCar_modelOfCar(ModelOfCar car_modelOfCar) {
        this.car_modelOfCar = car_modelOfCar;
    }

    public TypeOfBody getTypeOfBody() {
        return typeOfBody;
    }

    public void setTypeOfBody(TypeOfBody typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    public TypeOfTransport getTypeOfTransport() {
        return typeOfTransport;
    }

    public void setTypeOfTransport(TypeOfTransport typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }
}
