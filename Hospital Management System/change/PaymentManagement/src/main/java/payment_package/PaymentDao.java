package payment_package;

import java.util.*;  
import java.sql.*;  

public class PaymentDao {
	// ENCAPSULATION (Connection details hidden)
	// Method to establish a connection to the database
    public static Connection getConnection() {  
        Connection con = null;  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "root", "12301230");  
        } catch (Exception e) {
            System.out.println(e);
        }  
        return con;  
    }  
    
    //create part in c r u d operations
    // Save a new Payment record to the database
    public static int save(Payment e) {  
        int status = 0;  
        try {  
            Connection con = PaymentDao.getConnection();  
            PreparedStatement ps = con.prepareStatement("insert into payment(name,email,phone,medicine,quantity,method,amount) values (?, ?, ?, ?, ?, ?, ?)");  
            ps.setString(1, e.getName());  
            ps.setString(2, e.getEmail());  
            ps.setString(3, e.getPhone());  
            ps.setString(4, e.getMedicine()); 
            ps.setString(5, e.getQuantity()); 
            ps.setString(6, e.getMethod());  
            ps.setString(7, e.getAmount());  

            status = ps.executeUpdate();  
            con.close();  
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
        return status;  
    }  

    //update part in c r u d operations
    // Update an existing Payment record in the database
    public static int update(Payment e) {  
        int status = 0;  
        try {  
            Connection con = PaymentDao.getConnection();  
            PreparedStatement ps = con.prepareStatement("update payment set name=?, email=?, phone=?, medicine=?,quantity=?, method=?,amount=? where id=?");  
            ps.setString(1, e.getName());  
            ps.setString(2, e.getEmail());  
            ps.setString(3, e.getPhone());  
            ps.setString(4, e.getMedicine());  
            ps.setString(5, e.getQuantity());  
            ps.setString(6, e.getMethod());  
            ps.setString(7, e.getAmount());  
            ps.setInt(8, e.getId());

            status = ps.executeUpdate();  
            con.close();  
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
        return status;  
    }  
    
    // delete part in c r u d operations
    // Delete a Payment record by ID
    public static int delete(int id) {  
        int status = 0;  
        try {  
            Connection con = PaymentDao.getConnection();  
            PreparedStatement ps = con.prepareStatement("delete from payment where id=?");  
            ps.setInt(1, id);  
            status = ps.executeUpdate();  
            con.close();  
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return status;  
    }  

    // Retrieve a Payment record by its ID
    public static Payment getPaymentById(int id) {  
        Payment e = new Payment();  
        try {  
            Connection con = PaymentDao.getConnection();  
            PreparedStatement ps = con.prepareStatement("select * from payment where id=?");  
            ps.setInt(1, id);  
            ResultSet rs = ps.executeQuery();  
            if (rs.next()) {  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));  
                e.setPhone(rs.getString(4));  
                e.setMedicine(rs.getString(5)); 
                e.setQuantity(rs.getString(6));  
                e.setMethod(rs.getString(7));  
                e.setAmount(rs.getString(8));  
            }  
            con.close();  
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
        return e;  
    }  
    
    // COLLECTIONS FRAMEWORK
    // Retrieve all Payment records from the database
    public static List<Payment> getAllPayments() {  
        List<Payment> list = new ArrayList<Payment>();  
        try {  
            Connection con = PaymentDao.getConnection();  
            PreparedStatement ps = con.prepareStatement("select * from payment");  
            ResultSet rs = ps.executeQuery();  
            while (rs.next()) {  
                Payment e = new Payment();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));  
                e.setPhone(rs.getString(4));  
                e.setMedicine(rs.getString(5)); 
                e.setQuantity(rs.getString(6)); 
                e.setMethod(rs.getString(7)); 
                e.setAmount(rs.getString(8)); 
                list.add(e);  
            }  
            con.close();  
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return list;  
    }

    // Search Payment records by name
    public static List<Payment> searchPaymentsByName(String name) {  
        List<Payment> list = new ArrayList<Payment>();  
        try {  
            Connection con = PaymentDao.getConnection();  
            PreparedStatement ps = con.prepareStatement("select * from payment where name like ?");  
            ps.setString(1, "%" + name + "%");  
            ResultSet rs = ps.executeQuery();  
            while (rs.next()) {  
                Payment e = new Payment();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));  
                e.setPhone(rs.getString(4));  
                e.setMedicine(rs.getString(5)); 
                e.setQuantity(rs.getString(6)); 
                e.setMethod(rs.getString(7)); 
                e.setAmount(rs.getString(8)); 
                list.add(e);  
            }  
            con.close();  
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return list;  
    }  
}
