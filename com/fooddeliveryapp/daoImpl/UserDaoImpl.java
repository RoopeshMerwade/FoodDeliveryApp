package com.fooddeliveryapp.daoImpl;

import com.fooddeliveryapp.dao.UserDao;
import com.fooddeliveryapp.model.User;
import com.fooddeliveryapp.util.DBConnectionUtil; 
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser(User user) {
        String insertQuery = "insert into user(UserId, Name, Username, Password, Email, Address, ROLE) values(?,?,?,?,?,?,?)";
        
        try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(insertQuery)) {
            
            pstmt.setInt(1, user.getUserId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getUsername());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getAddress());
            pstmt.setString(7, user.getRole());
            
            pstmt.executeUpdate();
            System.out.println("User added successfully!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(int userId) {
        // for (User user : users) {
        //     if (user.getUserId() == id) {
        //         return user;
        //     }
        // }
        // return null;

        User user = null;
        String selectQuery = "SELECT * FROM users WHERE userid = ?";
        try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(selectQuery)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String selectAllQuery = "SELECT * FROM users";
        try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(selectAllQuery)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));

                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    

    @Override
    public void updateUser(User user) {
        String updateQuery = "UPDATE users SET username = ?, password = ?, email = ? WHERE userid = ?";
        try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(updateQuery)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setInt(4, user.getUserId());

            pstmt.executeUpdate();
            System.out.println("User updated successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) {
        // users.removeIf(user -> user.getUserId() == id);

        String deleteQuery = "DELETE FROM user WHERE UserId = ?";
		  
		  try(Connection con = DBConnectionUtil.getInstance().getConnection();
				  PreparedStatement pstmt2 =con.prepareStatement(deleteQuery)) {
              pstmt2.setInt(1, userId);
			  pstmt2.executeUpdate();
			  System.out.println("User deleted Sucessfully");
			  
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    }
}
