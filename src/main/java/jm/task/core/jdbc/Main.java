package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
public static void main(String[] args) {
    UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
    UserServiceImpl userService = new UserServiceImpl();
    userDaoHibernate.createUsersTable();
    userDaoHibernate.saveUser("Иван", "Иванов", (byte) 45);
    userDaoHibernate.saveUser("Антон", "Петров", (byte) 35);
    userDaoHibernate.saveUser("Борис", "Кузьмин", (byte) 45);
    userDaoHibernate.saveUser("Джейк", "Смит", (byte) 55);
    System.out.println(userDaoHibernate.getAllUsers());

    userService.cleanUsersTable();

    userService.dropUsersTable();
}

}
