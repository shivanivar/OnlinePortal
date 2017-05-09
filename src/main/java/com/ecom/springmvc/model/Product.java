package com.ecom.springmvc.model;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "Product")
public class Product {

	@Id
	@Column(name = "Code")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int code;

	@Column(name = "Create_Date")
	private Date create_date;

	@Column(name = "Image")
	private Blob image;

	@Column(name = "Name")
	private String name;

	@Column(name = "Price")
	private double price;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", create_date=" + create_date + ", image=" + image + ", name=" + name
				+ ", price=" + price + "]";
	}

}
