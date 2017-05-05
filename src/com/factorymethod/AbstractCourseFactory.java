package com.factorymethod;

import com.models.AbstractCourse;

public abstract class AbstractCourseFactory {
	
	public void displayCourseDetails(String input) {
		AbstractCourse course = createCourse(input);
		System.out.println("\n");
		System.out.println("=============================");
		course.printCourseSummary();
		System.out.println("=============================");
		System.out.println("\n");
	}
	
	abstract protected AbstractCourse createCourse(String input);

}
