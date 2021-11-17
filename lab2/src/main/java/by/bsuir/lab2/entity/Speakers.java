package by.bsuir.lab2.entity;

import javax.xml.bind.annotation.XmlElement;

public class Speakers extends Appliance{

    @XmlElement
    private boolean cable;

    public Speakers() {
        this.cable = true;
    }

    public Speakers(boolean cable) {
        this.setCable(cable);
    }

    public boolean getCable() {
        return this.cable;
    }

    public void setCable(boolean cable) {
        this.cable = cable;
    }

    @Override
    public String toString() {
        return String.format("Speakers: " + super.toString() + ", Cable: " + this.cable);
    }
}
