package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
private final static UserService userService = new UserServiceImpl();
public static void main(String[] args) {
    userService.createUsersTable();
    userService.saveUser("Иван", "Иванов", (byte) 45);
    userService.saveUser("Антон", "Петров", (byte) 35);
    userService.saveUser("Борис", "Кузьмин", (byte) 45);
    userService.saveUser("Джейк", "Смит", (byte) 55);
    userService.removeUserById(3);
    System.out.println(userService.getAllUsers());
    userService.cleanUsersTable();
    userService.dropUsersTable();
}
}
