package com.factorymethod;

import com.models.AbstractCourse;
import com.models.OffJavaCourse;
import com.models.OffNetCourse;

public class OfflineCourseFactory extends AbstractCourseFactory {

	@Override
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
		return course;
	}

}
