package by.bsuir.lab2.service;

import by.bsuir.lab2.entity.Appliance;

import java.io.File;
import java.util.List;

public interface JAXBService {
    List<Appliance> unmarshalAppliance(File file);
}

