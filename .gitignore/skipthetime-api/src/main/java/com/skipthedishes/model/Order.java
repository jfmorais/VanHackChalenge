package com.skipthedishes.model;

import java.util.List;

public class Order {
	private int id;
	private String date;
	private int customerId;
	private String deliveryAddress;
	private String contact;
	private int storeId;
	private List<OrderItems> orderItems;
	private double total;
	private String status;
	private String lastUpdate ;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getContact() {
		
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal() {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public void calculateTotal() {
		for (OrderItems x : orderItems) {
			this.total = this.total + x.getTotal();
		}
	}

}
