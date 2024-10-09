package com.fooddeliveryapp.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fooddeliveryapp.dao.OrderhistoryDao;
import com.fooddeliveryapp.model.Orderhistory;
import com.fooddeliveryapp.util.DBConnectionUtil;

public class OrderhistoryDaoImpl implements OrderhistoryDao {

    @Override
    public void addOrderhistory(Orderhistory orderhistory) {
        // Implementation for adding an order history
        String sql = "INSERT INTO orderhistory (orderhistoryid,orderid, userid, orderdate, totalamount,status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, orderhistory.getOrderhistoryid());
            pstmt.setInt(2, orderhistory.getOrderid());
            pstmt.setInt(3, orderhistory.getUserid());
            pstmt.setDate(4, orderhistory.getOrderdate());
            pstmt.setDouble(5, orderhistory.getTotalamount());
            pstmt.setString(6, orderhistory.getStatus());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
    }
    }

    @Override
    public void updateOrderHistory(int orderhistoryId) {
        // Implementation for updating an order history
        String updateQuery = "UPDATE orderhistory SET orderid = ?, userid = ?, orderdate = ?, totalamount = ?, status = ? WHERE orderhistoryid = ?";

        try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(updateQuery)) {
            pstmt.setInt(1, 1);
            pstmt.setInt(2, 1);
            pstmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            pstmt.setDouble(4, 1);
            pstmt.setString(5, "status");
            pstmt.setInt(6, orderhistoryId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
}

@Override
public Orderhistory getOrderHistory(int orderhistoryId) {
    String getQuery = "SELECT * FROM orderhistory WHERE orderhistoryid = ?";
    Orderhistory orderhistory = null;
    try (Connection con = DBConnectionUtil.getInstance().getConnection();
         PreparedStatement pstmt = con.prepareStatement(getQuery)) {
        pstmt.setInt(1, orderhistoryId);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            orderhistory = new Orderhistory();
            orderhistory.setOrderhistoryid(rs.getInt("orderhistoryid"));
            orderhistory.setOrderid(rs.getInt("orderid"));
            orderhistory.setUserid(rs.getInt("userid"));
            orderhistory.setOrderdate(rs.getDate("orderdate"));
            orderhistory.setTotalamount(rs.getDouble("totalamount"));
            orderhistory.setStatus(rs.getString("status"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
        
    } catch (Exception e) {
        e.printStackTrace();
    }

    return new Orderhistory();
}

@Override
public List<Orderhistory> getOrderHistoriesByUser(int userId) {
    String getQuery = "SELECT * FROM orderhistory WHERE userid = ?";
    List<Orderhistory> orderhistories = new ArrayList<>();
    try (Connection con = DBConnectionUtil.getInstance().getConnection();
         PreparedStatement pstmt = con.prepareStatement(getQuery)) {
        pstmt.setInt(1, userId);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Orderhistory orderhistory = new Orderhistory();
            orderhistory.setOrderhistoryid(rs.getInt("orderhistoryid"));
            orderhistory.setOrderid(rs.getInt("orderid"));
            orderhistory.setUserid(rs.getInt("userid"));
            orderhistory.setOrderdate(rs.getDate("orderdate"));
            orderhistory.setTotalamount(rs.getDouble("totalamount"));

            orderhistories.add(orderhistory);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return orderhistories;
}
}

