package com.fooddeliveryapp.daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fooddeliveryapp.util.DBConnectionUtil;
import com.fooddeliveryapp.dao.MenuDao;
import com.fooddeliveryapp.model.Menu;

public class MenuDaoImpl implements MenuDao {
    
    @Override
    public void addMenu(Menu menu) {
       
        String addmenu = "INSERT INTO menu (menuid, itemname, description, price, ratings, isavailable, restaurentId, imagepath) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(addmenu)) {
            pstmt.setInt(1, menu.getMenuid());
            pstmt.setString(2, menu.getItemname());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setFloat(5, menu.getRatings());
            pstmt.setBoolean(6, menu.isIsavailable());
            pstmt.setInt(7, menu.getRestaurentId());
            pstmt.setString(8, menu.getImagepath());
            pstmt.executeUpdate();
            System.out.println("Menu added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Menu getMenu(int menuId) {
       String getMenu = "SELECT * FROM menu WHERE menuid = ?";
       Menu menu = null;
        try (Connection con = DBConnectionUtil.getInstance().getConnection();
             PreparedStatement pstmt = con.prepareStatement(getMenu)) {
            pstmt.setInt(1, menuId);
           ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                  menu =new Menu();
                menu.setMenuid(rs.getInt("menuid"));
                menu.setItemname(rs.getString("itemname"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setRatings(rs.getFloat("ratings"));
                menu.setIsavailable(rs.getBoolean("isavailable"));
                menu.setRestaurentId(rs.getInt("restaurentId"));
                menu.setImagepath(rs.getString("imagepath"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        } 
        return menu;
    }

    @Override
    public void updateMenu(Menu menu){
        String updateMenu = "UPDATE Menu SET itemname = ?, description = ?, price = ?, ratings = ?, isavailable = ?, restaurentId = ?, imagepath = ? WHERE menuid = ?";

        try (Connection con = DBConnectionUtil.getInstance().getConnection();
        PreparedStatement pstmt = con.prepareStatement(updateMenu)) {
            pstmt.setString(1, menu.getItemname());
            pstmt.setString(2, menu.getDescription());
            pstmt.setDouble(3, menu.getPrice());
            pstmt.setFloat(4, menu.getRatings());
            pstmt.setBoolean(5, menu.isIsavailable());
            pstmt.setInt(6, menu.getRestaurentId());
            pstmt.setString(7, menu.getImagepath());
            pstmt.setInt(8, menu.getMenuid());
            pstmt.executeUpdate();
            System.out.println("Menu updated successfully!");
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu(int menuId){
        String deleteMenu = "Delete from menu where menuid = ?";

        try (Connection con = DBConnectionUtil.getInstance().getConnection();
        PreparedStatement pstmt = con.prepareStatement(deleteMenu)) {
            pstmt.setInt(1, menuId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Menu> getAllMenusByRestaurant(int restaurantId) {
		
        List<Menu> getAllMenusByRestaurent =new ArrayList<>();
        String query = "SELECT * FROM menu WHERE restaurentId = ?";
            Menu menu = null;
        try (Connection con = DBConnectionUtil.getInstance().getConnection();
            PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, restaurantId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                 menu = new Menu();
                menu.setMenuid(rs.getInt("menuid"));
                menu.setItemname(rs.getString("itemname"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setRatings(rs.getFloat("ratings"));
                menu.setIsavailable(rs.getBoolean("isavailable"));
                menu.setRestaurentId(rs.getInt("restaurentId"));
                menu.setImagepath(rs.getString("imagepath"));
                getAllMenusByRestaurent.add(menu);
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        return getAllMenusByRestaurent;
	}
}