package com.qrrollcall.qrrollcall;
import android.os.AsyncTask;
import android.os.AsyncTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector extends AsyncTask<Void, Void, Connection> {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/deneme";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    @Override
    protected Connection doInBackground(Void... params) {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}


/*
public class DatabaseConnector {


    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/deneme_123";
    private static final String USER = "postgres@Deneme";
    private static final String PASSWORD = "12345";

    @Override
    protected Connection doInBackground(Void... params) {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
*/