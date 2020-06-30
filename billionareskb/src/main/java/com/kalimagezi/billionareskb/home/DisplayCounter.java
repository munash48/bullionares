package com.kalimagezi.billionareskb.home;

public class DisplayCounter {
	private int snumber;
	private String fullName;
	private int percentage;
	private String color;
	private String category;
	public DisplayCounter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DisplayCounter(int snumber, String fullName, int percentage, String color, String category) {
		super();
		this.snumber = snumber;
		this.fullName = fullName;
		this.percentage = percentage;
		this.color = color;
		this.category = category;
	}

	@Override
	public String toString() {
		return "DisplayCounter [snumber=" + snumber + ", fullName=" + fullName + ", percentage=" + percentage
				+ ", color=" + color + ", category=" + category + "]";
	}
	public int getSnumber() {
		return snumber;
	}
	public void setSnumber(int snumber) {
		this.snumber = snumber;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	


}
