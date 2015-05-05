/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;
/**
 *
 * @author Chan
 */
public class PostgreConnection {

    private static PostgreConnection postgre;

    private String url;
    private String user;
    private String password;
    private String characterEncoding;
    private Connection connection;

    private PostgreConnection() throws SQLException {
        this.url = "jdbc:postgresql://localhost:5432/QLHDT";
        this.user = "postgres";
        this.password = "postgres";
        this.characterEncoding = "utf8";

        Properties info = new Properties();
        info.setProperty("characterEncoding", this.characterEncoding);
        info.setProperty("user", this.user);
        info.setProperty("password", this.password);

        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);

        this.connection = DriverManager.getConnection(this.url, info);

    }

    public static PostgreConnection getInstance() throws SQLException {
        if (postgre == null) {
            postgre = new PostgreConnection();
        }
        return postgre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCharacterEncoding() {
        return characterEncoding;
    }

    public void setCharacterEncoding(String characterEncoding) {
        this.characterEncoding = characterEncoding;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}

