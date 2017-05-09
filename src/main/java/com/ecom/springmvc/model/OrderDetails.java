package com.ecom.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Order_Details")
public class OrderDetails {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;

	@ManyToOne
	@JoinColumn(name = "Order_Id", referencedColumnName = "order_Id")
	private Orders order_id;

	@ManyToOne
	@JoinColumn(name = "Product_Code", referencedColumnName = "Code")
	private Product product_code;

	@Column(name = "Price")
	double price;

	@Column(name = "Quanity")
	int quanity;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Orders getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Orders order_id) {
		this.order_id = order_id;
	}


	public Product getProduct_code() {
		return product_code;
	}

	public void setProduct_code(Product product_code) {
		this.product_code = product_code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	@Override
	public String toString() {
		return "Order_Details [Id=" + Id + ", order_id=" + order_id + ", product_id=" + product_code + ", price=" + price
				+ ", quanity=" + quanity + "]";
	}

}
