package com.simplefactory;

import com.models.AbstractCourse;

public class SimpleFactoryDemo {

	public static void main(String[] args) {
		SimpleCourseFactory factory = new SimpleCourseFactory();
		AbstractCourse course = factory.createCourse("Java");
		
		
		RefactoredSimpleCourseFactory refactoredFactory = new RefactoredSimpleCourseFactory();
		course = refactoredFactory.createCourse("OnJava");
		
	}

}

/* 
Advantages of SimpleFactory
  - Whenever new course will be introduced, the one which gets changed is factory not in client code.
  - As SimpleFactory is class with createCourse method which anyone can use it who have access. In short Course logic now can be reused.
  
Note: this is not Factory Method pattern. It's just a programming idiom.

What happens if we will serve new courses both online and offline courses? OnJavaCoure, OffJavaCourse, OnNetCourse, OffNetCourse
  - New added classes are derived from AbstractCourse, adding more case conditions in a SimpleFactory => violates SOLID Principle SRP – Single Responsibility Principle. (SRP says a class should have only one reason to change.). And here Factory class will be changed
  - Whenever new offline and online course introduces or modified.
  
How about if we create multiple simple factories for online and offline courses?

*/