package com.factorymethod;

public class FactoryMethodDemo {

	public static void main(String[] args) {
		AbstractCourseFactory onlineFac = new OnlineCourseFactory();
		onlineFac.displayCourseDetails("OnJava");
		
		AbstractCourseFactory offlineFac = new OfflineCourseFactory();
		offlineFac.displayCourseDetails("OffNET");

	}

}
