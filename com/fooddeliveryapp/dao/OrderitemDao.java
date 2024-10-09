package com.fooddeliveryapp.dao;

import java.util.List;

import com.fooddeliveryapp.model.Orderitem;

public interface OrderitemDao {
	void addOrderItem(Orderitem orderitem);
	Orderitem getOrderitem(int Orderitem);
	void updateOrderitem(Orderitem orderitem);
	void deleteOrderitem(int orderitemId);
	List<Orderitem> getOrderItemByOrder(int orderId);
}

