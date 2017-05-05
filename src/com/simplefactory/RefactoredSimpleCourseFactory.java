package com.simplefactory;

import com.models.AbstractCourse;
import com.models.OffJavaCourse;
import com.models.OffNetCourse;
import com.models.OnJavaCourse;
import com.models.OnNetCourse;

public class RefactoredSimpleCourseFactory {
	public AbstractCourse createCourse(String input) {
		AbstractCourse course = null;
		switch (input) {
		case "OnJava":
			course = new OnJavaCourse(input);
			break;
		case "OffJava":
			course = new OffJavaCourse(input);
			break;
		case "OnNET":
			course = new OnNetCourse(input);
			break;
		case "OffNET":
			course = new OffNetCourse(input);
			break;
		default:
			break;
		}
		course.printCourseSummary();
		return course;
	}
}
