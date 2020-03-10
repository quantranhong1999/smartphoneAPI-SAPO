package com.smartphone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
	@Column
	private String variant;
	
	@Column
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	

	@ManyToOne
	@JoinColumn(name = "version_id")
	private VersionEntity version;

	

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	

	

	public VersionEntity getVersion() {
		return version;
	}

	public void setVersion(VersionEntity version) {
		this.version = version;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
