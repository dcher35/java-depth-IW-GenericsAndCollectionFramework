package com.edu.chmnu.ki_123.c3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SessionUsersTest {
    private ConnectionSession session;
    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        session = new ConnectionSession();
        user1 = new User("user1", "password1");
        user2 = new User("user2", "password2");
    }
    //Тест перевіряє додавання користувачів до сесії
    @Test
    void testAddUser() {
        assertTrue(session.addUser(user1), "User1 should be added successfully.");
        assertTrue(session.addUser(user2), "User2 should be added successfully.");
        assertFalse(session.addUser(user1), "Adding User1 again should return false.");
    }

    //Тест перевіряє успішну і невдалу аутентифікацію користувачів
    @Test
    void testAuthenticateUser() {
        session.addUser(user1);
        session.addUser(user2);

        assertTrue(session.authenticate("user1", "password1"), "User1 should authenticate successfully.");
        assertFalse(session.authenticate("user1", "wrongPassword"), "Authentication with the wrong password should fail.");
        assertFalse(session.authenticate("nonExistentUser", "password"), "Non-existent user should not authenticate.");
    }

    //Тест перевіряє видалення користувачів із сесії
    @Test
    void testRemoveUser() {
        session.addUser(user1);
        session.addUser(user2);

        assertTrue(session.removeUser("user1"), "User1 should be removed successfully.");
        assertFalse(session.removeUser("user1"), "Removing User1 again should return false.");
        assertFalse(session.removeUser("nonExistentUser"), "Removing a non-existent user should return false.");
    }

    //Тест перевіряє поведінку при роботі з пустою сесією
    @Test
    void testEmptySession() {
        assertFalse(session.authenticate("user1", "password1"), "Authentication should fail for an empty session.");
        assertFalse(session.removeUser("user1"), "Removing a user from an empty session should return false.");
    }
}