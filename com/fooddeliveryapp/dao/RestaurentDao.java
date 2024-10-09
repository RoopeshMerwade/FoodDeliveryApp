package com.fooddeliveryapp.dao;
import java.util.List;

import com.fooddeliveryapp.model.Restaurent;

public interface RestaurentDao {
	void addRestaurent(Restaurent restaurent);
	Restaurent getRestaurent(int restaurentId);
	void updateRestaurent(Restaurent restaurent);
	void deleteRestaurent(int restaurentId);
	List<Restaurent> getAllRestaurents();
}

