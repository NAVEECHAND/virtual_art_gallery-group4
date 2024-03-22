package com.model;

import java.time.LocalDate;

public class Artwork {
	private int id;
	private String title;
	private String description;
	private LocalDate date;
	private String medium;
	private String imageurl;
	private double price;
	
	public Artwork() {}
	
	public Artwork(int id, String title, String description, LocalDate date, String medium, String imageurl,
			double price) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.medium = medium;
		this.imageurl = imageurl;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Artwork [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date
				+ ", medium=" + medium + ", imageurl=" + imageurl + ", price=" + price + "]";
	}
	
}