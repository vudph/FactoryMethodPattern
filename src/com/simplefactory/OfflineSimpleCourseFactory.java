package com.simplefactory;

import com.models.AbstractCourse;
import com.models.OffJavaCourse;
import com.models.OffNetCourse;

public class OfflineSimpleCourseFactory {
	public AbstractCourse createCourse(String input) {
		AbstractCourse course = null;
		switch (input) {
		case "OffJava":
			course = new OffJavaCourse(input);
			break;
		case "OffNET":
			course = new OffNetCourse(input);
			break;
		default:
			break;
		}
		System.out.println("\n");
		System.out.println("=============================");
		course.printCourseSummary();
		System.out.println("=============================");
		System.out.println("\n");
		return course;
	}
}
