package ua.dziuhan.dao;

import ua.dziuhan.entities.CarData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CarDAO {

    void addCar(CarData carData);

    void updateCar(CarData carData);

    CarData selectCarById(int id);

    List<String> selectAllProducersCar();

    List<String> selectAllRanksCar();

    List<CarData> selectAllCars();

    List<CarData> selectCarsByProducersRanks(String[] producers,
                                             String[] ranks);

    void deleteCarById(int id);
}
