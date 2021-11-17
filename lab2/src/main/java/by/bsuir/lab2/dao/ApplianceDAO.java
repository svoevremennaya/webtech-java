package by.bsuir.lab2.dao;

import by.bsuir.lab2.entity.criteria.Criteria;
import by.bsuir.lab2.entity.Appliance;

import java.util.List;

public interface ApplianceDAO {
	List<Appliance> find(Criteria criteria);

	List<Appliance> sortByPrice();
}
