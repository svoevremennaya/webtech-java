package by.bsuir.lab2.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Appliance {

    @XmlElement
    private double price;
    @XmlElement
    private String country;

    public Appliance() {
        this.price = 0;
        this.country = null;
    }

    public Appliance(double price, String country) {
        this.price = price;
        this.country = country;
    }

    public double getPrice() {
        return this.price;
    }

    public String getCountry() {
        return this.country;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
