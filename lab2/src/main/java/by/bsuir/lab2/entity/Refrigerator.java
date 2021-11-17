package by.bsuir.lab2.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Refrigerator extends Appliance{

    @XmlElement
    private int volume;
    @XmlElement
    private int voltage;

    public Refrigerator() {
        this.volume = 0;
        this.voltage = 0;
    }

    public Refrigerator(int volume, int voltage) {
        this.setVolume(volume);
        this.setVoltage(voltage);
    }

    public int getVolume() {
        return this.volume;
    }

    public int getVoltage() {
        return this.voltage;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return String.format("Refrigerator: " + super.toString() + ", Volume: " + this.volume + ", Voltage: " + this.voltage);
    }
}
