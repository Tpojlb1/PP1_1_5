package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
public static void main(String[] args) {
    User userIvan = new User("Иван", "Иванов", (byte) 45);
    User userAnton = new User("Антон", "Петров", (byte) 35);
    User userBoris = new User("Борис", "Кузьмин", (byte) 45);
    User userJake = new User("Джейк", "Смит", (byte) 55);

    UserServiceImpl userService = new UserServiceImpl();

    userService.createUsersTable();

    userService.saveUser(userIvan.getName(), userIvan.getLastName(), userIvan.getAge());
    userService.saveUser(userAnton.getName(), userAnton.getLastName(), userAnton.getAge());
    userService.saveUser(userBoris.getName(), userBoris.getLastName(), userBoris.getAge());
    userService.saveUser(userJake.getName(), userJake.getLastName(), userJake.getAge());

    List<User> userList = userService.getAllUsers();

    for (User us : userList) {
        System.out.println(us.toString());
    }

    userService.cleanUsersTable();

    userService.dropUsersTable();
}
}