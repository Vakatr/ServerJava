package com.legist.myapp.service;

import com.legist.myapp.domain.Car;
import com.legist.myapp.dto.CarDto;

public interface CarService {
    Car buildCar(CarDto carDto);
}
