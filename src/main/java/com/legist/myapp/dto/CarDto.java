package com.legist.myapp.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.legist.myapp.domain.*;

@JsonAutoDetect
public class CarDto {
    private Long id;
    private String regNum;
    private String brandOfCar;
    private String modelOfCar;
    private String typeOfBody;
    private String typeOfTransport;

    public Car toCar(){
        Car car = new Car();
        car.setId(id);
        car.setRegNum(regNum);
        car.setCar_brandOfCar(new BrandOfCar(brandOfCar));
        car.setCar_modelOfCar(new ModelOfCar(modelOfCar));
        car.setTypeOfBody(new TypeOfBody(typeOfBody));
        car.setTypeOfTransport(new TypeOfTransport(typeOfTransport));
        return car;
    }

 /*   public static CarDto fromCar(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setRegNum(car.getRegNum());
        carDto.setBrandOfCar(car.getCar_brandOfCar().getName());
        carDto.setModelOfCar(car.getCar_modelOfCar().getName());
        carDto.setTypeOfBody(car.getTypeOfBody().getName());
        carDto.setTypeOfTransport(car.getTypeOfTransport().getName());
        return carDto;
    }*/

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

    public String getBrandOfCar() {
        return brandOfCar;
    }

    public void setBrandOfCar(String brandOfCar) {
        this.brandOfCar = brandOfCar;
    }

    public String getModelOfCar() {
        return modelOfCar;
    }

    public void setModelOfCar(String modelOfCar) {
        this.modelOfCar = modelOfCar;
    }

    public String getTypeOfBody() {
        return typeOfBody;
    }

    public void setTypeOfBody(String typeOfBody) {
        this.typeOfBody = typeOfBody;
    }

    public String getTypeOfTransport() {
        return typeOfTransport;
    }

    public void setTypeOfTransport(String typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }
}
