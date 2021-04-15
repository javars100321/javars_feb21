package com.rs.fer.vo;

public class EditExpenseVO {

	private String id;
	private String type;
	private String date;

	private float price;
	private int numerOfItems;
	private float total;

	private String bywhom;

	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNumerOfItems() {
		return numerOfItems;
	}

	public void setNumerOfItems(int numerOfItems) {
		this.numerOfItems = numerOfItems;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getBywhom() {
		return bywhom;
	}

	public void setBywhom(String bywhom) {
		this.bywhom = bywhom;
	}

}
