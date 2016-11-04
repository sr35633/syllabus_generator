package edu.uga.mist5740.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import edu.uga.mist5740.tools.database.SyllabyeDBConnection;

public class EducatorManager {
    private static ArrayList<Educator> educators;
    private static Connection connection;

    private EducatorManager() {

    }

    public static ArrayList<Educator> getEducators() throws NamingException, SQLException {
        ArrayList<Educator> result = new ArrayList<>();
        if (educators != null) {

        } else {
            connection = SyllabyeDBConnection.getConnection();
            educators = new ArrayList<>();
            populateEducators();

        }
        for (Educator educator : educators) {
            result.add(educator);
        }
        return result;

    }
    
    private static void populateEducators() throws SQLException{
        createConnection();
        String query = "SELECT * FROM educator";
        ResultSet results = null;
        PreparedStatement ps = connection.prepareStatement(query);
        results = ps.executeQuery();
        while (results.next()) {
            addSingleEducator(results);
        }
    }
    
    private static void addSingleEducator(ResultSet results) throws SQLException{
        //TODO set all educator fields based on database
    }
    
    private static void createConnection(){
        if (connection == null) {
            try {
                connection = SyllabyeDBConnection.getConnection();
                educators = new ArrayList<>();
                populateEducators();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
