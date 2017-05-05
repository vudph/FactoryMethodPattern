package com.simplefactory;

import com.models.AbstractCourse;
import com.models.OffJavaCourse;
import com.models.OffNetCourse;
import com.models.OnJavaCourse;
import com.models.OnNetCourse;

public class OnlineSimpleCourseFactory {
	public AbstractCourse createCourse(String input) {
		AbstractCourse course = null;
		switch (input) {
		case "OnJava":
			course = new OnJavaCourse(input);
			break;
		case "OnNET":
			course = new OnNetCourse(input);
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
