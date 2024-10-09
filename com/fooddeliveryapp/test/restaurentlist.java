package com.fooddeliveryapp.test;

import java.util.List;

import com.fooddeliveryapp.daoImpl.RestaurentDaoImpl;
import com.fooddeliveryapp.model.Restaurent;

public class restaurentlist {

    public static void main(String[] args) {
      
        RestaurentDaoImpl restaurentlist = new RestaurentDaoImpl();

        List<Restaurent> restaurents = restaurentlist.getAllRestaurents();

         if (restaurents != null && !restaurents.isEmpty()) {
            System.out.println("List of Restaurents:");
            for (Restaurent restaurent : restaurents) {
                System.out.println(restaurent);
            }
        } else {
            System.out.println("No restaurents found. Sorry Fella!");
        }
    }

}
