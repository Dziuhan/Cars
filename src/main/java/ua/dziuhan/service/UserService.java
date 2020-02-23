package ua.dziuhan.service;

import ua.dziuhan.entities.UserData;

import java.util.List;

public interface UserService {
    UserData selectUserByLogin(UserData userData);

    UserData selectUserByLogin(String login);

    void createNewUser(UserData userData);

    List<UserData> selectAllUsers();

    void updateUser(UserData userData);

    List<UserData> searchUserByLogin(String login);
}
