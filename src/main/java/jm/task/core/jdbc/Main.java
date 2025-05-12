package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.DriverManager;
import java.util.List;

public class Main {
    private static jm.task.core.jdbc.util.Util Util;

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        System.out.println("Создание таблицы User");
        userService.dropUsersTable();
        userService.createUsersTable();
        System.out.println("Таблица 'User' создана");

        System.out.println("\n Добавление пользователей");
        userService.saveUser("Иван", "Иванов", (byte) 25);
        userService.saveUser("Петр", "Петров", (byte) 30);
        userService.saveUser("Алексей", "Смирнов", (byte) 22);

        System.out.println("\n Вывод всех пользователей ");
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}

