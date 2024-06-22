package com.prat.bazaar.service;

import com.prat.bazaar.model.Orders;

public interface OrderService {

       Orders createOrder(Orders order);
       Orders updateOrder(Orders order);
       Orders deleteOrder(int orderId);
       Orders getOrderByUserId(int orderId);
}
