package com.fooddeliveryapp.dao;

import java.util.List;

import com.fooddeliveryapp.model.Orderhistory;

public interface OrderhistoryDao {

    void addOrderhistory(Orderhistory orderhistory);
    Orderhistory getOrderHistory(int orderHistoryId);
	void updateOrderHistory(int orderHistoryId);
	List<Orderhistory> getOrderHistoriesByUser(int userId);

}
