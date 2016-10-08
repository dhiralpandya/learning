package com.omt.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.omt.gson.bean.Car;

public class MainGson {

	public static void main(String[] args) {

		Car car1 = new Car();
		car1.setColor("White");
		car1.setId(1);
		car1.setPrice(1239483);

		Gson gson = new Gson();

		String json = gson.toJson(car1);

		System.out.println(json);

		Car carObj = gson.fromJson(json, Car.class);
		System.out.println(carObj.getColor());

		Car car2 = new Car();
		car2.setColor("Red");
		car2.setId(234);
		car2.setPrice(77719483);

		List<Car> cars = new ArrayList<>();
		cars.add(car1);
		cars.add(car2);

		json = gson.toJson(cars);

		System.out.println(json);

		Type list = (new TypeToken<List<Car>>() {
		}).getType();

		cars = gson.fromJson(json, list);

		for (Car c : cars) {
			System.out.println(c.getId());
		}

	}

}
