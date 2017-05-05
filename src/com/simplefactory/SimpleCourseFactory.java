package com.simplefactory;

import com.models.AbstractCourse;
import com.models.JavaCourse;
import com.models.NetCourse;

public class SimpleCourseFactory {
	public AbstractCourse createCourse(String input) {
		AbstractCourse course = null;
		switch (input) {
		case "Java":
			course = new JavaCourse(input);
			break;			
		case "NET":
			course = new NetCourse(input);
			break;
		default:
			break;
		}
		course.printCourseSummary();
		return course;
	}
}
