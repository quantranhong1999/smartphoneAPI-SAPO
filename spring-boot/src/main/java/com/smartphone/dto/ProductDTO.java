package com.smartphone.dto;



public class ProductDTO extends AbstractDTO<ProductDTO> {

	private String productName;
	private String color;
	private String rom;
	private String battery;
	private int quantity;

	private String categoryName;

	

	private String versionName;

	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getColor() {
		return color;
	}

	public String getRom() {
		return rom;
	}

	public String getBattery() {
		return battery;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
