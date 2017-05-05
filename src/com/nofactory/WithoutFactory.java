package com.nofactory;

import com.models.AbstractCourse;
import com.models.JavaCourse;
import com.models.NetCourse;

public class WithoutFactory {

	public static void main(String[] args) {
		AbstractCourse course = null;
		String input = "Java";
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
	}
}
/*
Issues:
	- Add new online courses like C++, VC++ etc. and would like to stop few courses in future.
	- In future offline courses are going to be conducted, so make sure to make everything reusable.
	=> add new class for new courses, and modify switch case logic to adapt => violate open-close principle
	=> approach: SimpleFactory
*/