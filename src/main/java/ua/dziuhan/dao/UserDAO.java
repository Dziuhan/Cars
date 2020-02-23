package ua.dziuhan.dao;

import ua.dziuhan.entities.UserData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<UserData> selectAllUsers();

    UserData selectUserByLogin(String login);

    void addUser(UserData user);

    void updateUser(UserData userData);

    List<UserData> searchUserByLogin(String login);

}
