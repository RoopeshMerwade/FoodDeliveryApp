package com.fooddeliveryapp.daoImpl;
import com.fooddeliveryapp.dao.OrderDao;
import com.fooddeliveryapp.model.Order;
import com.fooddeliveryapp.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;;

public class OrderDaoImpl implements OrderDao {

    @Override
    public void addOrder(Order order) {
        String addorder = "Insert into Order(OrderId,UserId,RestaurentId,OrderDate,Amount,Status,PaymentMode) values(?,?,?,?,?,?,?)";

        try (Connection con = DBConnectionUtil.getInstance().getConnection();
        PreparedStatement pstmt = con.prepareStatement(addorder)) {
            pstmt.setInt(1, order.getOrderId());
            pstmt.setInt(2, order.getUserid());
            pstmt.setInt(3, order.getRestaurentid());
            pstmt.setDate(4, order.getOrderdate());
            pstmt.setDouble(5, order.getAmount());
            pstmt.setString(6, order.getStatus());
            pstmt.setString(7, order.getPaymentmode());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrder(int orderId) {
       
        String getOrder = "SELECT * FROM Order WHERE OrderId = ?";
        Order order = null;
        try (Connection con = DBConnectionUtil.getInstance().getConnection();
        PreparedStatement pstmt = con.prepareStatement(getOrder)) {
            pstmt.setInt(1, orderId);
            pstmt.executeQuery();
            if (pstmt.getResultSet().next()) {
                order = new Order();
                order.setOrderId(pstmt.getResultSet().getInt("OrderId"));
                order.setUserid(pstmt.getResultSet().getInt("userid"));
                order.setRestaurentid(pstmt.getResultSet().getInt("restaurentid"));
                order.setOrderdate(pstmt.getResultSet().getDate("orderdate"));
                order.setAmount(pstmt.getResultSet().getDouble("amount"));
                order.setStatus(pstmt.getResultSet().getString("status"));
                order.setPaymentmode(pstmt.getResultSet().getString("paymentmode"));
                // return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void updateOrder(Order order) {
       

        String update = "UPDATE Order SET UserId = ?, RestaurentId = ?, OrderDate = ?, Amount = ?, Status = ?, PaymentMode = ? WHERE OrderId = ?";
        try (Connection con = DBConnectionUtil.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(update)) {
            pstmt.setInt(1, order.getUserid());
            pstmt.setInt(2, order.getRestaurentid());
            pstmt.setDate(3, order.getOrderdate());
            pstmt.setDouble(4, order.getAmount());
            pstmt.setString(5, order.getStatus());
            pstmt.setString(6, order.getPaymentmode());
            pstmt.setInt(7, order.getOrderId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
    }catch (Exception e) {
        e.printStackTrace();
    }
}

    @Override
    public void deleteOrder(int orderId) {
        
        String delete = "DELETE FROM Order WHERE OrderId = ?";
        try (Connection con = DBConnectionUtil.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(delete)) {
            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Order> getOrderByUser(int userId) {
        String getOrderByUser = "SELECT * FROM Order WHERE UserId = ?";
        List<Order> orderList = new ArrayList<>();;
        try (Connection con = DBConnectionUtil.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(getOrderByUser)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Order order = new Order();
                order.setOrderId(pstmt.getResultSet().getInt("OrderId"));
                order.setUserid(pstmt.getResultSet().getInt("UserId"));
                order.setRestaurentid(pstmt.getResultSet().getInt("RestaurentId"));
                order.setOrderdate(pstmt.getResultSet().getDate("OrderDate"));
                order.setAmount(pstmt.getResultSet().getDouble("Amount"));
                order.setStatus(pstmt.getResultSet().getString("Status"));
                order.setPaymentmode(pstmt.getResultSet().getString("PaymentMode"));
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
