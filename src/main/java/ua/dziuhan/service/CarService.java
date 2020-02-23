package ua.dziuhan.service;

import ua.dziuhan.entities.CarData;

import java.util.List;

public interface CarService {
    List<CarData> selectAllCars();

    List<String> selectAllProducersCar();

    List<String> selectAllRanksCar();

    List<CarData> selectCarsByProducersRanks(String[] producers, String[] ranks);

    CarData selectCarById(int id);

    void removeCar(int idCar);

    void addCar(CarData carData);

    void updateCar(CarData carData);
}
