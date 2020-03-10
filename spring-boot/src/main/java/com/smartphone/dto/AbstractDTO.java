package com.smartphone.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbstractDTO<T> {

	private Long id;
	private Date createDate;
	private Date modifiedDate;
	private List<T> listDTO = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public List<T> getListDTO() {
		return listDTO;
	}

	public void setListDTO(List<T> listDTO) {
		this.listDTO = listDTO;
	}
}
