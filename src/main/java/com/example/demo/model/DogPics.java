package com.example.demo.model;

import javax.persistence.Id;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "springboot-mongo")
public class DogPics {

	@Id
	private String id;
	private String title;
	private Binary image;

	public DogPics(String title, Binary image) {
		super();
		this.title = title;
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Binary getImage() {
		return image;
	}

	public void setImage(Binary image) {
		this.image = image;
	}

	public DogPics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DogPics(String title) {
		// TODO Auto-generated constructor stub
		this.title = title;
	}
}
