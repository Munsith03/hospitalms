package com.appointment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class AppointmentDBUtil {
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    
    // OOP Principle: Abstraction - Hides the complexity of database operations from other parts of the application

    // Method to validate user details by name and email
    public static List<Appointment> validate(String patientName, String email) {
        ArrayList<Appointment> cus = new ArrayList<>();

        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM appointment WHERE patientName='" + patientName + "' AND email='" + email + "'";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int id = rs.getInt(1);
                String patientName1 = rs.getString(2);
                String patientAge = rs.getString(3);
                String gender = rs.getString(4);
                String contactNumber = rs.getString(5);
                String email1 = rs.getString(6);
                String doctorName = rs.getString(7);
                String specialization = rs.getString(8);
                String appointmentDate = rs.getString(9);
                String reasonForVisit = rs.getString(10);

                Appointment c = new Appointment(id, patientName1, patientAge, gender, contactNumber, email1, doctorName, specialization, appointmentDate, reasonForVisit);
                cus.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cus;
    }

    // Method to insert customer details into the database
    public static boolean insertCustomer(String patientName, String patientAge, String gender, String contactNumber, String email,
                                         String doctorName, String specialization, String appointmentDate, String reasonForVisit) {
        boolean isSuccess = false;

        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "INSERT INTO appointment VALUES (0, '" + patientName + "', '" + patientAge + "', '" + gender + "', '" + contactNumber + "', '" + email + "', '" + doctorName + "', '" + specialization + "', '" + appointmentDate + "', '" + reasonForVisit + "')";
            int rs = stmt.executeUpdate(sql);

            isSuccess = (rs > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    // Method to update customer details in the database
    public static boolean updateCustomer(String id, String patientName, String patientAge, String gender, String contactNumber, String email,
                                         String doctorName, String specialization, String appointmentDate, String reasonForVisit) {
        boolean isSuccess = false;
        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "UPDATE appointment SET patientName='" + patientName + "', patientAge='" + patientAge + "', gender='" + gender + "', contactNumber='" + contactNumber + "', email='" + email + "', doctorName='" + doctorName + "', specialization='" + specialization + "', appointmentDate='" + appointmentDate + "', reasonForVisit='" + reasonForVisit + "' WHERE id='" + id + "'";
            int rs = stmt.executeUpdate(sql);

            isSuccess = (rs > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    // Method to retrieve customer details from the database
    public static List<Appointment> getCustomerDetails(String id) {
        int convertedID = Integer.parseInt(id);
        ArrayList<Appointment> cus = new ArrayList<>();

        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM appointment WHERE id='" + convertedID + "'";
            rs = stmt.executeQuery(sql);
            
            // COLLECTIONS FRAMEWORK
            while (rs.next()) {
                int appointmentId = rs.getInt(1);
                String patientName1 = rs.getString(2);
                String patientAge = rs.getString(3);
                String gender = rs.getString(4);
                String contactNumber = rs.getString(5);
                String email1 = rs.getString(6);
                String doctorName = rs.getString(7);
                String specialization = rs.getString(8);
                String appointmentDate = rs.getString(9);
                String reasonForVisit = rs.getString(10);

                Appointment c = new Appointment(appointmentId, patientName1, patientAge, gender, contactNumber, email1, doctorName, specialization, appointmentDate, reasonForVisit);
                cus.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cus;
    }

    // Method to delete a customer from the database
    public static boolean deleteCustomer(String id) {
        boolean isSuccess = false;
        int convId = Integer.parseInt(id);

        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "DELETE FROM appointment WHERE id='" + convId + "'";
            int r = stmt.executeUpdate(sql);

            isSuccess = (r > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
