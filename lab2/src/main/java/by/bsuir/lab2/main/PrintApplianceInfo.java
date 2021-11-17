package by.bsuir.lab2.main;

import by.bsuir.lab2.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {
	
	public static void print(List<Appliance> appliances) {
		System.out.println("Search result:");
		if (appliances != null) {
			for (Appliance appliance : appliances) {
				System.out.println(appliance);
			}
		} else {
			System.out.println("Not found");
		}
		System.out.println();
	}

	public static void print(Appliance appliance) {
		if (appliance != null) {
			System.out.println(appliance);
		} else {
			System.out.println("No appliance");
		}
	}

}
