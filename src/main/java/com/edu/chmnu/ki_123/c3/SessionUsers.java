package com.edu.chmnu.ki_123.c3;

public class SessionUsers {
    public static void main(String[] args) {
        ConnectionSession session = new ConnectionSession();

        System.out.println("Adding users:");
        System.out.println("User 1 added: " + session.addUser(new User("user1", "password1")));
        System.out.println("User 2 added: " + session.addUser(new User("user2", "password2")));
        System.out.println("User 3 added: " + session.addUser(new User("user3", "password3")));
        System.out.println("User 1 re-added: " + session.addUser(new User("user1", "password1")));

        System.out.println("\nAuthenticating users:");
        System.out.println("Authenticate user1: " + session.authenticate("user1", "password1"));
        System.out.println("Authenticate user2: " + session.authenticate("user2", "password2"));
        System.out.println("Authenticate non-existent user: " + session.authenticate("userX", "passwordX"));

        System.out.println("\nRemoving users:");
        System.out.println("Remove user1: " + session.removeUser("user1"));
        System.out.println("Remove non-existent user: " + session.removeUser("userX"));

        System.out.println("\nFinal user count: " + session.getUserCount());
    }
}