package by.bsuir.lab2.service.validation;

import by.bsuir.lab2.entity.criteria.Criteria;
import by.bsuir.lab2.entity.criteria.SearchCriteria;

public class Validator {
	
	public static boolean criteriaValidator(Criteria criteria) {
		String groupSearchName = criteria.getGroupSearchName();

		for (String key : criteria.getCriterias().keySet()) {
			try {
				if (groupSearchName.equals("Laptop"))
					SearchCriteria.Laptop.valueOf(key);
				else if (groupSearchName.equals("Oven"))
					SearchCriteria.Oven.valueOf(key);
				else if (groupSearchName.equals("Refrigerator"))
					SearchCriteria.Refrigerator.valueOf(key);
				else if (groupSearchName.equals("Speakers"))
					SearchCriteria.Speakers.valueOf(key);
				else if (groupSearchName.equals("TabletPC"))
					SearchCriteria.TabletPC.valueOf(key);
				else if (groupSearchName.equals("VacuumCleaner"))
					SearchCriteria.VacuumCleaner.valueOf(key);
				else
					return false;
			} catch (IllegalArgumentException e) {
				return false;
			}
		}
		
		return true;
	}

}