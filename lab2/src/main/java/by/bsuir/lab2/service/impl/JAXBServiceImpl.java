package by.bsuir.lab2.service.impl;

import by.bsuir.lab2.entity.Appliance;
import by.bsuir.lab2.entity.Appliances;
import by.bsuir.lab2.service.JAXBService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JAXBServiceImpl implements JAXBService {
    public List<Appliance> unmarshalAppliance(File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Appliances.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Appliances appliances = (Appliances) jaxbUnmarshaller.unmarshal(file);
            return appliances.getAppliances();
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
