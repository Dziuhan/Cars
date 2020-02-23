package ua.dziuhan.dao;

import ua.dziuhan.entities.RoleData;

public interface RoleDAO {
    RoleData selectRole(String role);
}
