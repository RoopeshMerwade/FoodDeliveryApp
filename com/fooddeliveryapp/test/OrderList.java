package com.fooddeliveryapp.test;

import java.util.List;

import com.fooddeliveryapp.daoImpl.OrderDaoImpl;
import com.fooddeliveryapp.model.Order;

public class OrderList {
    
        public static void main(String[] args) {
           
            OrderDaoImpl orderlist = new OrderDaoImpl();
            List<Order> orders = orderlist.getOrderByUser(106);

             if (orders != null && !orders.isEmpty()) {
                System.out.println("List of Orders:");
                for (Order order : orders) {
                    System.out.println(order);
                }
            } else {
                System.out.println("No orders found. Sorry Fella!");
            }
    
        }

}
