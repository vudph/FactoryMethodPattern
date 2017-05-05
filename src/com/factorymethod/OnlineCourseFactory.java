package com.factorymethod;

import com.models.AbstractCourse;
import com.models.OnJavaCourse;
import com.models.OnNetCourse;

public class OnlineCourseFactory extends AbstractCourseFactory {

	@Override
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
		return course;
	}

}
