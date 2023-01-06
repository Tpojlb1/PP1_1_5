package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import java.util.List;

public interface UserDao {
void createUsersTable();

void dropUsersTable();

void saveUser(String name, String lastName, byte age);

List<User> getAllUsers();

void removeUserById(long id);

void cleanUsersTable();
}