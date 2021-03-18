package com.legist.myapp.service.impl;

import com.legist.myapp.dto.CarDto;
import com.legist.myapp.service.CarService;
import com.legist.myapp.domain.*;
import com.legist.myapp.repository.*;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private final BrandOfCarRepository brandOfCarRepository;

    private final ModelOfCarRepository modelOfCarRepository;

    private final TypeOfBodyRepository typeOfBodyRepository;

    private final TypeOfTransportRepository typeOfTransportRepository;

    private final CarRepository carRepository;

    public CarServiceImpl(BrandOfCarRepository brandOfCarRepository, ModelOfCarRepository modelOfCarRepository, TypeOfBodyRepository typeOfBodyRepository, TypeOfTransportRepository typeOfTransportRepository, CarRepository carRepository) {
        this.brandOfCarRepository = brandOfCarRepository;
        this.modelOfCarRepository = modelOfCarRepository;
        this.typeOfBodyRepository = typeOfBodyRepository;
        this.typeOfTransportRepository = typeOfTransportRepository;
        this.carRepository = carRepository;
    }

    @Override
    public Car buildCar(CarDto carDto) {
        BrandOfCar brandOfCar = brandOfCarRepository.findByName(carDto.getBrandOfCar());
        ModelOfCar modelOfCar = modelOfCarRepository.findByName(carDto.getModelOfCar());
        TypeOfBody typeOfBody = typeOfBodyRepository.findByName(carDto.getTypeOfBody());
        TypeOfTransport typeOfTransport = typeOfTransportRepository.findByName(carDto.getTypeOfTransport());

        Car car = new Car(carDto.getRegNum(), brandOfCar, modelOfCar, typeOfBody, typeOfTransport);
        if (car.getRegNum() != null) {
            carRepository.save(car);
            return car;
        }

        return null;
    }
}
