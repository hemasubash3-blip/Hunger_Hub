package com.tap.DAO;

import java.util.List;

import com.tap.Model.Ordertable1;

public interface Ordertable1DAO {

	int addOrdertable1(Ordertable1 ordertable1);

    Ordertable1 getOrdertable1(int orderId);

//    void updateOrdertable1(Ordertable1 ordertable1);

    void deleteOrdertable1(int orderId);

    List<Ordertable1> getAllOrdertables();

	void updateOrdertable1(Ordertable1 o);
	List<Ordertable1> getOrdersByUserId(int userId);

	
	

	

}