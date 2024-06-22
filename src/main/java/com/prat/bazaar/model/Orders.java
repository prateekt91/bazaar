package com.prat.bazaar.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Document(collection = "Orders")
public class Orders {

    @Id
    private String _id;
    private String userId;
    private double totalPrice;
    private String status;
    private Date orderDate;
    private ShippingAddress shippingAddress;
    private List<OrderedProducts> products;

    @Override
    public String toString() {
        return "Orders{" +
                "_id='" + _id + '\'' +
                ", userId='" + userId + '\'' +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", shippingAddress=" + shippingAddress +
                ", products=" + products +
                '}';
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<OrderedProducts> getProducts() {
        return products;
    }

    public void setProducts(List<OrderedProducts> products) {
        this.products = products;
    }
}
