package by.bsuir.lab2.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TabletPC extends Appliance{

    @XmlElement
    public String displayType;
    @XmlElement
    public String processor;

    public TabletPC() {
        this.displayType = null;
        this.processor = null;
    }

    public TabletPC(String displayType, String processor) {
        this.setDisplayType(displayType);
        this.setProcessor(processor);
    }

    public String getDisplayType() {
        return this.displayType;
    }

    public String getProcessor() {
        return this.processor;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public String toString() {
        return String.format("TabletPC: " + super.toString() + ", Display type: "+ this.displayType + ", Processor: " + this.processor);
    }
}
