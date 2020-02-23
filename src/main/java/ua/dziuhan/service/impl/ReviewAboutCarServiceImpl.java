package ua.dziuhan.service.impl;

import org.springframework.stereotype.Service;
import ua.dziuhan.dao.ReviewAboutCarDAO;
import ua.dziuhan.dao.impl.CarDAOImpl;
import ua.dziuhan.dao.impl.UserDAOImpl;
import ua.dziuhan.entities.CarData;
import ua.dziuhan.entities.ReviewAboutCarData;
import ua.dziuhan.service.ReviewAboutCarService;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ReviewAboutCarServiceImpl implements ReviewAboutCarService {

    private ReviewAboutCarDAO reviewAboutCarDAO;

    private UserDAOImpl userDAO;

    private CarDAOImpl carDAO;

    public void setReviewAboutCarDAO(ReviewAboutCarDAO reviewAboutCarDAO) {
        this.reviewAboutCarDAO = reviewAboutCarDAO;
    }

    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    public void setCarDAO(CarDAOImpl carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public void addReviewAboutCar(ReviewAboutCarData reviewAboutCarData,String login,int car_id) { // ?????
        reviewAboutCarData.setCarData(carDAO.selectCarById(car_id));
        reviewAboutCarData.setUserData(userDAO.selectUserByLogin(login));
        reviewAboutCarDAO.addReviewAboutCar(reviewAboutCarData);
    }

    @Override
    public List<ReviewAboutCarData> selectAllReviewAboutCarData(CarData carData) {
        return reviewAboutCarDAO.selectAllReviewsAboutCar(carData);
    }
}
