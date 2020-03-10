package com.smartphone.dto;

public class VersionDTO extends AbstractDTO<VersionDTO>{
	private String versionName;
	private String color;
	private String rom;
	private String battery;
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
