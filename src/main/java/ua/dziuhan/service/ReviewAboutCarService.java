package ua.dziuhan.service;

import ua.dziuhan.entities.CarData;
import ua.dziuhan.entities.ReviewAboutCarData;

import java.util.List;

public interface ReviewAboutCarService {

    void addReviewAboutCar(ReviewAboutCarData reviewAboutCarData,String login,int car_id);

    List<ReviewAboutCarData> selectAllReviewAboutCarData(CarData carData);


}
