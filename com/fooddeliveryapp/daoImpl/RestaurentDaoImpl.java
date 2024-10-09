package com.fooddeliveryapp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.fooddeliveryapp.dao.RestaurentDao;
import com.fooddeliveryapp.model.Restaurent;
import com.fooddeliveryapp.util.DBConnectionUtil;

public class RestaurentDaoImpl implements RestaurentDao {

    @Override
    public void addRestaurent(Restaurent restaurent) {
        String insertQuery = "INSERT INTO restaurents (restaurentName, restaurentAddress, phone, rating, cuisineType, isActive, estimateTime, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(insertQuery)) {

            pstmt.setString(1, restaurent.getRestaurentname());
            pstmt.setString(2, restaurent.getRestaurentaddress());
            pstmt.setInt(3, restaurent.getPhone());
            pstmt.setDouble(4, restaurent.getRating());
            pstmt.setString(5, restaurent.getCuisineType());
            pstmt.setBoolean(6, restaurent.isActive());
            pstmt.setInt(7, restaurent.getEstimateTime());
            pstmt.setString(8, restaurent.getImagepath());

            pstmt.executeUpdate();
            System.out.println("Restaurent added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Restaurent getRestaurent(int restaurentId) {
        String selectQuery = "SELECT * FROM restaurent WHERE restaurentId = ?";
        Restaurent restaurent = null;
		try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(selectQuery)) {

            pstmt.setInt(1, restaurentId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                restaurent  = new Restaurent();
                restaurent.setRestaurentId(rs.getInt("restaurentId"));
                restaurent.setRestaurentaddress(rs.getString("restaurentName"));
                restaurent.setRestaurentaddress(rs.getString("restaurentAddress"));
                restaurent.setPhone(rs.getInt("phone"));
                restaurent.setRating(rs.getDouble("rating"));
                restaurent.setCuisineType(rs.getString("cuisineType"));
                restaurent.setActive(rs.getBoolean("isActive"));
                restaurent.setEstimateTime(rs.getInt("estimateTime"));
                restaurent.setImagepath(rs.getString("imagePath"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurent;
    }

    @Override
    public void updateRestaurent(Restaurent restaurent) {
        String updateQuery = "UPDATE restaurent SET restaurentName = ?, restaurentAddress = ?, phone = ?, rating = ?, cuisineType = ?, isActive = ?, estimateTime = ?, imagePath = ? WHERE restaurentId = ?";

        try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(updateQuery)) {

            pstmt.setString(1, restaurent.getRestaurentname());
            pstmt.setString(2, restaurent.getRestaurentaddress());
            pstmt.setInt(3, restaurent.getPhone());
            pstmt.setDouble(4, restaurent.getRating());
            pstmt.setString(5, restaurent.getCuisineType());
            pstmt.setBoolean(6, restaurent.isActive());
            pstmt.setInt(7, restaurent.getEstimateTime());
            pstmt.setString(8, restaurent.getImagepath());
            pstmt.setInt(9, restaurent.getRestaurentId());

            pstmt.executeUpdate();
            System.out.println("Restaurent updated successfully");

        } catch (SQLException e) {
            e.printStackTrace();
    }
 }

    @Override
    public void deleteRestaurent(int restaurentId) {
        String deleteQuery = "DELETE FROM restaurent WHERE restaurentId = ?";

        try(Connection con = DBConnectionUtil.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(deleteQuery)) {
                pstmt.setInt(1, restaurentId);
                pstmt.executeUpdate();
                System.out.println("Restaurent deleted successfully");            
    } catch (SQLException e) {
       e.printStackTrace();
    }
 }
    @Override
    public List<Restaurent> getAllRestaurents() {
        List<Restaurent> restaurentList = new ArrayList<>();
        String selectAllQuery = "SELECT * FROM restaurents";
        try (Connection con = DBConnectionUtil.getInstance().getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(selectAllQuery)) {

            while (rs.next()) {
                Restaurent restaurent = new Restaurent();
                restaurent.setRestaurentId(rs.getInt("restaurentId"));
                restaurent.setRestaurentname(rs.getString("restaurentName"));
                restaurent.setRestaurentaddress(rs.getString("restaurentAddress"));
                restaurent.setPhone(rs.getInt("phone"));
                restaurent.setRating(rs.getDouble("RestaurentRatings"));
                restaurent.setCuisineType(rs.getString("cuisineType"));
                restaurent.setActive(rs.getBoolean("isActive"));
                restaurent.setEstimateTime(rs.getInt("DeliveryTime"));
                restaurent.setImagepath(rs.getString("imagePath"));

                restaurentList.add(restaurent);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurentList;
    }
}
