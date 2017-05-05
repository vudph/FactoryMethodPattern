package com.models;

public abstract class AbstractCourse {
	protected float duration;
	protected String name;
	
	public void printCourseSummary() {
		System.out.println("Course name: " + this.name);
		System.out.println("Material: ");
		this.prepareMaterial();
	}
	
	abstract protected void prepareMaterial();

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
