package by.bsuir.lab2.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
public class Appliances implements Serializable {
    @XmlElements({ @XmlElement(name = "Appliance", type = Appliance.class),
            @XmlElement(name = "Laptop", type = Laptop.class), @XmlElement(name = "Oven", type = Oven.class),
            @XmlElement(name = "Refrigerator", type = Refrigerator.class),
            @XmlElement(name = "Speakers", type = Speakers.class),
            @XmlElement(name = "TabletPC", type = TabletPC.class),
            @XmlElement(name = "VacuumCleaner", type = VacuumCleaner.class) })
    private List<Appliance> appliances;

    public List<Appliance> getAppliances() {
        return appliances;
    }

    public void setAppliances(List<Appliance> appliances) {
        this.appliances = appliances;
    }
}
