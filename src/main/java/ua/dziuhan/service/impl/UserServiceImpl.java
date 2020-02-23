package ua.dziuhan.service.impl;

import org.springframework.stereotype.Service;
import ua.dziuhan.dao.RoleDAO;
import ua.dziuhan.dao.UserDAO;
import ua.dziuhan.entities.UserData;
import ua.dziuhan.service.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    private RoleDAO roleDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public UserData selectUserByLogin(UserData userData){
        return userDAO.selectUserByLogin(userData.getLogin());
    }
    @Override
    public  void createNewUser(UserData userData){
        userData.setRole(roleDAO.selectRole("client"));
        userDAO.addUser(userData);
    }

    @Override
    public UserData selectUserByLogin(String login) {
        return userDAO.selectUserByLogin(login);
    }

    @Override
    public List<UserData> selectAllUsers() {
        return userDAO.selectAllUsers();
    }

    @Override
    public void updateUser(UserData userData) { // ??????????
        UserData userFromDB=userDAO.selectUserByLogin(userData.getLogin());
        if (userFromDB!=null){
            userFromDB.setBan(userData.isBan());
            userFromDB.setRole(roleDAO.selectRole(userData.getRole().getRole()));
            userDAO.updateUser(userFromDB);
        }
    }

    @Override
    public List<UserData> searchUserByLogin(String login) {
        return userDAO.searchUserByLogin(login);
    }
}
