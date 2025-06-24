package feedback_package;

import java.util.*;  
import java.sql.*;

public class feedbackDao {
	
	// ENCAPSULATION
    // Connection details are encapsulated within this class
    public static Connection getConnection(){  
        Connection con = null;  
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "root", "12301230");  
        } catch(Exception e) {
            System.out.println(e);
        }  
        return con;  
    }

    // Save a new Feedback record to the database
    public static int save(feedback e){  
        int status = 0;  
        try {  
            Connection con = feedbackDao.getConnection();  
            PreparedStatement ps = con.prepareStatement(  
                "insert into feedback(cname, ename, fdate, fcomment) values (?, ?, ?, ?)");  
            
            // ENCAPSULATION
            // Using getters to access object's properties
            ps.setString(1, e.getCname());  
            ps.setString(2, e.getEname());  
            ps.setString(3, e.getFdate());  
            ps.setString(4, e.getFcomment());  
              
            status = ps.executeUpdate();  
            con.close();  
        } catch(Exception ex) {
            ex.printStackTrace();
        }  
        return status;  
    }

    // Update an existing feedback record in the database
    public static int update(feedback e){  
        int status = 0;  
        try {  
            Connection con = feedbackDao.getConnection();  
            PreparedStatement ps = con.prepareStatement(  
                "update feedback set cname=?, ename=?, fdate=?, fcomment=? where id=?");  
            ps.setString(1, e.getCname());  
            ps.setString(2, e.getEname());  
            ps.setString(3, e.getFdate());  
            ps.setString(4, e.getFcomment());  
            ps.setInt(5, e.getId()); // Corrected the parameter index
              
            status = ps.executeUpdate();  
            con.close();  
        } catch(Exception ex) {
            ex.printStackTrace();
        }  
        return status;  
    }

    // Delete a feedback record by ID
    public static int delete(int id){  
        int status = 0;  
        try {  
            Connection con = feedbackDao.getConnection();  
            PreparedStatement ps = con.prepareStatement("delete from feedback where id=?");  
            ps.setInt(1, id);  
            status = ps.executeUpdate();  
            con.close();  
        } catch(Exception e) {
            e.printStackTrace();
        }  
        return status;  
    }

    // Retrieve a feedback record by its ID
    public static feedback getFeedbackById(int id){  
        feedback e = new feedback();  
        try {  
            Connection con = feedbackDao.getConnection();  
            PreparedStatement ps = con.prepareStatement("select * from feedback where id=?");  
            ps.setInt(1, id);  
            ResultSet rs = ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setCname(rs.getString(2));  
                e.setEname(rs.getString(3));  
                e.setFdate(rs.getString(4));  
                e.setFcomment(rs.getString(5));  
            }  
            con.close();  
        } catch(Exception ex) {
            ex.printStackTrace();
        }  
        return e;  
    }

    // Retrieve all feedback records from the database
    public static List<feedback> getAllFeedbacks(){  
        List<feedback> list = new ArrayList<feedback>();  
        try {  
            Connection con = feedbackDao.getConnection();  
            PreparedStatement ps = con.prepareStatement("select * from feedback");  
            ResultSet rs = ps.executeQuery();  
            while(rs.next()){  
                feedback e = new feedback();  
                e.setId(rs.getInt(1));  
                e.setCname(rs.getString(2));  
                e.setEname(rs.getString(3));  
                e.setFdate(rs.getString(4));  
                e.setFcomment(rs.getString(5)); 

                list.add(e);  
            }  
            con.close();  
        } catch(Exception e) {
            e.printStackTrace();
        }  
        return list;  
    }

}
