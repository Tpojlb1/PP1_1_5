package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
private Transaction transaction;

public UserDaoHibernateImpl() {

}


@Override
public void createUsersTable() {
    try (Session session = Util.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS users" + "(id INT PRIMARY KEY AUTO_INCREMENT," + "name VARCHAR(100), lastName VARCHAR(100), age INT(3));").executeUpdate();
        transaction.commit();
    } catch (HibernateException e) {
        System.out.printf("%s - ошибка создания таблицы user_data", e.getMessage());
        if (transaction != null) {
            transaction.rollback();
        }
    }
}

@Override
public void dropUsersTable() {
    try (Session session = Util.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF EXISTS Users").executeUpdate();
        transaction.commit();
    } catch (Exception e) {
        System.out.printf("%s - ошибка удаления таблицы user_data", e.getMessage());
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }

}

@Override
public void saveUser(String name, String lastName, byte age) {
    Transaction transaction = null;
    try (Session session = Util.getSessionFactory().openSession()) {
        boolean a = session.isOpen();
        transaction = session.beginTransaction();
        session.save(new User(name, lastName, age));
        transaction.commit();
        System.out.printf("User с именем – %s добавлен в базу данных\n", name);
    } catch (HibernateException e) {
        System.out.printf("%s - ошибка сохранения пользователя с именем - %s", e.getMessage(), name);
        if (transaction != null) {
            transaction.rollback();
        }
    }
}

@Override
public void removeUserById(long id) {
    Transaction transaction = null;
    try (Session session = Util.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.delete(session.get(User.class, id));
        transaction.commit();
    } catch (HibernateException e) {
        System.out.printf("%s - ошибка удаления пользователя с Id - %s", e.getMessage(), id);
        if (transaction != null) {
            transaction.rollback();
        }
    }
}

@Override
public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();

    Transaction transaction = null;
    try (Session session = Util.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        users = session.createQuery("from User ").list();
        transaction.commit();
    } catch (HibernateException e) {
        System.out.printf("%s - ошибка получения всех пользователей из таблицы user_data", e.getMessage());
        if (transaction != null) {
            transaction.rollback();
        }
    }
    return users;
}

@Override
public void cleanUsersTable() {
    try (Session session = Util.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.createSQLQuery("TRUNCATE TABLE Users").executeUpdate();
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
    }

}
}
