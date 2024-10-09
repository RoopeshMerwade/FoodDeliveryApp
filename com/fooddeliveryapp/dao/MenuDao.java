package com.fooddeliveryapp.dao;

import java.util.List;
import com.fooddeliveryapp.model.Menu;

public interface MenuDao {
    void addMenu(Menu menu);
    Menu getMenu(int menuId);
    void updateMenu(Menu menu);
    void deleteMenu(int menuId);

    List<Menu> getAllMenusByRestaurant(int restaurantId);
}
