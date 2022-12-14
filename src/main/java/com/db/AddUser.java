package com.db;

import com.func.Utils;
import com.fxproject.Controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddUser {
    private static String usernameCreated;
    private static String passwordCreated;
    public AddUser(String username, String password) {
        String sql = "INSERT INTO accounts (first_name, last_name, username, password, position, permission, date_created ) VALUEs (?,?)";
        try{
            PreparedStatement stmt = Connections.con.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            stmt.execute();
            usernameCreated = username;
            passwordCreated = password;
        } catch (SQLException e) {
            System.out.println("[DB] Error Creating User");
            e.printStackTrace();
        }
    }

    public static void log(){
        String sql = "INSERT INTO account_creation_logs (caller, username, original_password, current_password, time) VALUEs (?,?,?,?,?)";
        try{
            PreparedStatement stmt = Connections.con.prepareStatement(sql);
            stmt.setString(1, Controller.curUser);
            stmt.setString(2, usernameCreated);
            stmt.setString(3, passwordCreated);
            stmt.setString(4, passwordCreated);
            stmt.setString(5, Utils.getTime());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("[DB] Error Creating User");
            e.printStackTrace();
        }

    }
}
