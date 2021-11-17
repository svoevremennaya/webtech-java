package by.bsuir.lab2.main;

import by.bsuir.lab2.entity.Appliance;
import by.bsuir.lab2.entity.criteria.Criteria;
import by.bsuir.lab2.entity.criteria.SearchCriteria;
import by.bsuir.lab2.service.ServiceFactory;
import by.bsuir.lab2.service.ApplianceService;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		Criteria criteriaOven = new Criteria(SearchCriteria.Oven.class.getSimpleName());//"Oven"
		criteriaOven.add(SearchCriteria.Oven.DEPTH.toString(), 3);

		appliances = service.find(criteriaOven);
		PrintApplianceInfo.print(appliances);

		criteriaOven = new Criteria(SearchCriteria.Oven.class.getSimpleName());
		criteriaOven.add(SearchCriteria.Oven.HEIGHT.toString(), 200);
		criteriaOven.add(SearchCriteria.Oven.DEPTH.toString(), 300);

		appliances = service.find(criteriaOven);
		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////
		
		Criteria criteriaTabletPC = new Criteria(SearchCriteria.TabletPC.class.getSimpleName());
		criteriaTabletPC.add(SearchCriteria.TabletPC.DISPLAY_TYPE.toString(), "OLED");
		criteriaTabletPC.add(SearchCriteria.TabletPC.PROCESSOR.toString(), "ARM");
		//criteriaTabletPC.add(SearchCriteria.TabletPC.MEMORY_ROM.toString(), 4);

		appliances = service.find(criteriaOven);// find(Object...obj)
		PrintApplianceInfo.print(appliances);


		System.out.println("The cheapest item");
		PrintApplianceInfo.print(service.sortByPrice().get(0));
		System.out.println();
	}

}
