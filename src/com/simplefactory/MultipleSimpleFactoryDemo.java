package com.simplefactory;

import com.models.AbstractCourse;

public class MultipleSimpleFactoryDemo {

	public static void main(String[] args) {
		OnlineSimpleCourseFactory onlineFactory = new OnlineSimpleCourseFactory();
		AbstractCourse course = onlineFactory.createCourse("OnJava");
		
		OfflineSimpleCourseFactory offlineFactory = new OfflineSimpleCourseFactory();
		course = offlineFactory.createCourse("OffJava");

	}

}
/*
Problem: Every factory is independent here. There is no strict rule for defining factories. In this approach each factory can have their own structure and standards.
*/