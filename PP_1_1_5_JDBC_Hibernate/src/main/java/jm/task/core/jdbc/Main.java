package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Nikita", "Kuz", (byte) 21);
        userService.saveUser("Anton", "Fulba", (byte) 45);
        userService.saveUser("Oleg", "Laska", (byte) 77);
        userService.getAllUsers();
        userService.removeUserById(2L);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.getAllUsers();
        userService.dropUsersTable();
}
}
