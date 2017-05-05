package com.models;


public class OnJavaCourse extends AbstractCourse {

	public OnJavaCourse(String name) {
		this.name = name;
	}
	
	@Override
	protected void prepareMaterial() {
		System.out.println("  1. Java Core 1 Ebook");
		System.out.println("  2. Java Core 2 Ebook");
	}

}
