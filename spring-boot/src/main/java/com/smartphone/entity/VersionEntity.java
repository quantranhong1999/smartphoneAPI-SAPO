package com.smartphone.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "version")
public class VersionEntity extends BaseEntity {

	@Column
	private String color;

	@Column
	private String rom;

	@Column
	private String battery;

	@OneToMany(mappedBy = "version")
	List<ProductEntity> products = new ArrayList<ProductEntity>();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

}
