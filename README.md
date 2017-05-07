# FactoryMethodPattern

1. Without factory
--------------

```java
public abstract class AbstractCourse {
	protected float duration;
	protected String name;
	
	public void printCourseSummary() {
		System.out.println("Course name: " + this.name);
		System.out.println("Material: ");
		this.prepareMaterial();
	}
	
	abstract protected void prepareMaterial();
}

public class JavaCourse extends AbstractCourse {
	public JavaCourse(String name) {
		this.name = name;
	}
	
	@Override
	protected void prepareMaterial() {
		System.out.println("  1. Java Core 1");
		System.out.println("  2. Java Core 2");
	}
}
public class NetCourse extends AbstractCourse {
	public NetCourse(String name) {
		this.name = name;
	}
	
	@Override
	protected void prepareMaterial() {
		System.out.println("  1. NET Framework Programming");
	}

}

public class ClientDemoWithoutFactory {
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
```

1.1 Problems
--------------
* Add new online courses like C++, VC++ etc. and would like to stop few courses in future => add/remove case conditions in client code. Assume we have hundreds of course => a huge switch case
* In future offline courses are going to be conducted, so make sure to make everything reusable.
	=> add new class for new courses, and modify switch case logic in client code to adapt => violate open-close principle
	=> approach: SimpleFactory

2. SimpleFactory
--------------

```java
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
public class ClientDemoSimpleFactory {
	public static void main(String[] args) {
		SimpleCourseFactory factory = new SimpleCourseFactory();
		AbstractCourse course = factory.createCourse("Java");
	}

}
```

2.1 Advantages of SimpleFactory
--------------

* Whenever new course will be introduced, the one which gets changed is factory not in client code.
* As SimpleFactory is class with createCourse method which anyone can use it who have access. In short Course logic now can be reused.
  
NOTE: this is not Factory Method pattern. It's just a programming idiom.

2.2 Problems of SimpleFactory
--------------

What happens if we will serve new courses both online and offline courses? OnJavaCoure, OffJavaCourse, OnNetCourse, OffNetCourse
* New added classes are derived from AbstractCourse, adding more case conditions in a SimpleFactory => violates SOLID Principle SRP – Single Responsibility Principle. (SRP says a class should have only one reason to change.). And here SimpleFactory class will be changed
* Whenever new offline and online course introduces or modified.

How about if we create multiple simple factories separately for online and offline courses?

2.3 Mutilple SimpleFactory
--------------

```java
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

public class ClientDemoMultipleSimpleFactories {
	public static void main(String[] args) {
		OnlineSimpleCourseFactory onlineFactory = new OnlineSimpleCourseFactory();
		AbstractCourse course = onlineFactory.createCourse("OnJava");
		
		OfflineSimpleCourseFactory offlineFactory = new OfflineSimpleCourseFactory();
		course = offlineFactory.createCourse("OffJava");
	}

}
```

2.4 Problem of MultipleSimpleFactories
--------------

* Every factory is independent here. There is no strict rule for defining factories. In this approach each factory can have their own structure and standards.

3. Factory Method pattern
--------------

```java
public abstract class AbstractCourseFactory {	
	public void displayCourseDetails(String input) {
		AbstractCourse course = createCourse(input);
		System.out.println("\n");
		System.out.println("=============================");
		course.printCourseSummary();
		System.out.println("=============================");
		System.out.println("\n");
	}
	abstract protected AbstractCourse createCourse(String input);
}

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

public class ClientDemoFactoryMethod {
	public static void main(String[] args) {
		AbstractCourseFactory onlineFac = new OnlineCourseFactory();
		onlineFac.displayCourseDetails("OnJava");
		
		AbstractCourseFactory offlineFac = new OfflineCourseFactory();
		offlineFac.displayCourseDetails("OffNET");

	}
}
```

*NOTE: This sample simulates how Factory Method pattern deals with 2 concrete factories. Actually one factory is fine with base definition of the pattern.

What problem Factory Method solves?
--------------

Factory Method solves the problem of how to create an object that conform to abstract interface in a way that separates the responsibility for creating the object from the client which will use the object.

Diagrams
--------------

* Base class diagram

![alt text](https://github.com/vudph/FactoryMethodPattern/blob/master/resources/BasePattern.png "Base Diagram")

* With 2 concrete factories

![alt text](https://github.com/vudph/FactoryMethodPattern/blob/master/resources/FactoryMethod.png "Class Diagram")