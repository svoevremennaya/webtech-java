package by.bsuir.lab2.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VacuumCleaner extends Appliance{

    @XmlElement
    private int volume;
    @XmlElement
    private boolean cable;

    public VacuumCleaner() {
        this.volume = 0;
        this.cable = true;
    }

    public VacuumCleaner(int volume, boolean cable) {
        this.setVolume(volume);
        this.setCable(cable);
    }

    public int getVolume() {
        return this.volume;
    }

    public boolean getCable() {
        return this.cable;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setCable(boolean cable) {
        this.cable = cable;
    }

    @Override
    public String toString() {
        return String.format("Vacuum cleaner: " + super.toString() + ", Volume: " + this.volume + ", Cable: " + this.cable);
    }
}
