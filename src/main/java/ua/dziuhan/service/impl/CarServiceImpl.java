package ua.dziuhan.service.impl;

import org.springframework.stereotype.Service;
import ua.dziuhan.dao.CarDAO;
import ua.dziuhan.entities.CarData;
import ua.dziuhan.service.CarService;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private CarDAO carDAO;

    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<CarData> selectAllCars(){
        List<CarData> carDataList=carDAO.selectAllCars();
        return carDataList;
    }

    @Override
    public List<String> selectAllProducersCar(){
        return carDAO.selectAllProducersCar();
    }
    @Override
    public List<String> selectAllRanksCar(){
        return carDAO.selectAllRanksCar();
    }

    @Override
    public List<CarData> selectCarsByProducersRanks(String[] producers, String[] ranks){
        return carDAO.selectCarsByProducersRanks(producers, ranks);
    }

    @Override
    public CarData selectCarById(int id){
        return carDAO.selectCarById(id);
    }

    @Override
    public void addCar(CarData carData) {
        carDAO.addCar(carData);
    }

    @Override
    public void updateCar(CarData carData) {
        carDAO.updateCar(carData);
    }

    @Override
    public void removeCar(int idCar) {
        carDAO.deleteCarById(idCar);
    }
}
