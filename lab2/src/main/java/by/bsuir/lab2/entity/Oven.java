package by.bsuir.lab2.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Oven extends Appliance{

    @XmlElement
    private int height;
    @XmlElement
    private int width;
    @XmlElement
    private int depth;
    @XmlElement
    private int maxTemperature;

    public Oven() {
        this.height = 0;
        this.width = 0;
        this.depth = 0;
        this.maxTemperature = 0;
    }

    public Oven(int height, int width, int depth, int maxTemperature) {
        this.setHeight(height);
        this.setWidth(width);
        this.setDepth(depth);
        this.setMaxTemperature(maxTemperature);
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getDepth() {
        return this.depth;
    }

    public int getMaxTemperature() {
        return this.maxTemperature;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Override
    public String toString() {
        return String.format("Oven: " + super.toString() + ", Height: " + this.height + ", Width: " + this.width + ", Depth: " + this.depth + ", MaxTemperature: " + this.maxTemperature);
    }
}
