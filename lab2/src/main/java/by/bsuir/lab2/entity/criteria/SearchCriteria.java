package by.bsuir.lab2.entity.criteria;

public final class SearchCriteria {
	
	public static enum Oven{
		PRICE, COUNTRY, HEIGHT, WIDTH, DEPTH, MAX_TEMPERATURE
	}
	
	public static enum Laptop{
		PRICE, COUNTRY, MEMORY, CAPACITY, DIAGONAL
	}
	
	public static enum Refrigerator{
		PRICE, COUNTRY, VOLUME, VOLTAGE
	}
	
	public static enum VacuumCleaner{
		PRICE, COUNTRY, VOLUME, CABLE
	}
	
	public static enum TabletPC{
		PRICE, COUNTRY, DISPLAY_TYPE, PROCESSOR
	}
	
	public static enum Speakers{
		PRICE, COUNTRY, CABLE
	}
	
	private SearchCriteria() {}
}

