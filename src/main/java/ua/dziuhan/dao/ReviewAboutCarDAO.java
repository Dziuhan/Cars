package ua.dziuhan.dao;

import ua.dziuhan.entities.CarData;
import ua.dziuhan.entities.ReviewAboutCarData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ReviewAboutCarDAO {
    void addReviewAboutCar(ReviewAboutCarData reviewAboutCarData);

    List<ReviewAboutCarData> selectAllReviewsAboutCar(CarData carData);

}
