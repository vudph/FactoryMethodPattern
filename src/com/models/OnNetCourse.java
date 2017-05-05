package com.models;


public class OnNetCourse extends AbstractCourse {

	public OnNetCourse(String name) {
		this.name = name;
	}
	
	@Override
	protected void prepareMaterial() {
		System.out.println("  1. NET Framework Programming Ebook");
	}

}
