package by.bsuir.lab2.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Laptop extends Appliance{

    @XmlElement
    private double memory;
    @XmlElement
    private double capacity;
    @XmlElement
    private double diagonal;

    public Laptop() {
        this.memory = 0;
        this.capacity = 0;
        this.diagonal = 0;
    }

    public Laptop(double memory, double capacity, double diagonal) {
        this.setMemory(memory);
        this.setCapacity(capacity);
        this.setDiagonal(diagonal);
    }

    public double getMemory() {
        return this.memory;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getDiagonal() {
        return this.diagonal;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return String.format("Laptop: " + super.toString() + ", Memory: " + this.memory + ", Capacity: " + this.capacity + ", Diagonal: " + this.diagonal);
    }
}
