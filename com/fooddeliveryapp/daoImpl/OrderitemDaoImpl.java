package com.fooddeliveryapp.daoImpl;
import java.util.ArrayList;
import java.util.List;

import com.fooddeliveryapp.dao.OrderitemDao;
import com.fooddeliveryapp.model.Orderitem;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fooddeliveryapp.util.DBConnectionUtil;

public class OrderitemDaoImpl implements OrderitemDao {

    @Override
    public void addOrderItem(Orderitem orderitem) {
        String additem = "INSERT INTO orderitem (orderitemid, orderid, menuid,quantity,totalprice) VALUES (?, ?, ? ,?,?)";

        try(Connection con = DBConnectionUtil.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(additem)){
               pstmt.setInt(1, orderitem.getOrderitemid());
                pstmt.setInt(2, orderitem.getOrderid());
                pstmt.setInt(3, orderitem.getMenuid());
                pstmt.setInt(4, orderitem.getQuantity());
                pstmt.setDouble(5, orderitem.getTotalprice());
                pstmt.executeUpdate();
                System.out.println("Orderitem added successfully!");
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }

    @Override
    public Orderitem getOrderitem(int Orderitem) {
       String query = "SELECT * FROM orderitem WHERE orderitemid = ?";
        Orderitem orderitem = null;

        try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, Orderitem);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                orderitem = new Orderitem();
                orderitem.setOrderitemid(rs.getInt("orderitemid"));
                orderitem.setOrderid(rs.getInt("orderid"));
                orderitem.setMenuid(rs.getInt("menuid"));
                orderitem.setQuantity(rs.getInt("quantity"));
                orderitem.setTotalprice(rs.getDouble("totalprice"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderitem;
    }   

    @Override
    public void updateOrderitem(Orderitem orderitem) {
        String query = "UPDATE orderitem SET orderid = ?, menuid = ?, quantity = ?, totalprice = ? WHERE orderitemid = ?";

        try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, orderitem.getOrderid());
            pstmt.setInt(2, orderitem.getMenuid());
            pstmt.setInt(3, orderitem.getQuantity());
            pstmt.setDouble(4, orderitem.getTotalprice());
            pstmt.setInt(5, orderitem.getOrderitemid());

            pstmt.executeUpdate();
            System.out.println("Order item updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderitem(int orderitemId) {
        String query = "DELETE FROM orderitem WHERE orderitemid = ?";

        try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, orderitemId);
            pstmt.executeUpdate();
            System.out.println("Order item deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
    }
    }

    @Override
    public List<Orderitem> getOrderItemByOrder(int orderId) {   
        String query = "SELECT * FROM orderitem WHERE orderid = ?";
        List<Orderitem> orderItemList = new ArrayList<>();

        try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Orderitem orderitem = new Orderitem();
                orderitem.setOrderitemid(rs.getInt("orderitemid"));
                orderitem.setOrderid(rs.getInt("orderid"));
                orderitem.setMenuid(rs.getInt("menuid"));
                orderitem.setQuantity(rs.getInt("quantity"));
                orderitem.setTotalprice(rs.getDouble("totalprice"));

                orderItemList.add(orderitem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return orderItemList;
    }

}
