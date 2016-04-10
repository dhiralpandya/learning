package com.omt.factory;

public class Main {

	public static void main(String... a) {
		Bio b = new Bio();
		Bio b1 = new Bio();
		Bio b2 = new Bio();
		Bio b3 = new Bio();
		Bio b4 = new Bio();
		com.omt.temp.Bio bio = new com.omt.temp.Bio();

		// Total Objects are created
		System.out.println("Total Objects Created By Application :" + ObjectCounter.totalObjectsCreated());
		// Get Number Of Objects created for class.
		System.out.println("[" + com.omt.temp.Bio.class.getName() + "] Objects Created :"
				+ ObjectCounter.getCount(com.omt.temp.Bio.class));
		System.out.println("[" + Bio.class.getName() + "] Objects Created :" + ObjectCounter.getCount(Bio.class));
		System.out.println("[" + Maths.class.getName() + "] Objects Created :" + ObjectCounter.getCount(Maths.class));

	}

}
