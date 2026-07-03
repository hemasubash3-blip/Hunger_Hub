

package com.tap.DAO;

import java.util.List;

import com.tap.Model.Orderitem;

public interface OrderitemDAO {

    int addOrderItem(Orderitem oi);

    Orderitem getOrderItem(int orderItemId);

    List<Orderitem> getAllOrderItems();

    int updateOrderItem(Orderitem oi);

    int deleteOrderItem(int orderItemId);
}