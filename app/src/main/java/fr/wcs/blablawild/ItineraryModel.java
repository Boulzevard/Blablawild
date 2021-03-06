package fr.wcs.blablawild;

import java.util.Date;

public class ItineraryModel {
    private String departure;
    private String destination;
    private String driver;
    private Date date;
    private int price;

    public ItineraryModel(String departure, String destination, String driver, Date date, int price) {
        this.departure = departure;
        this.destination = destination;
        this.driver = driver;
        this.date = date;
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getDriver() {
        return driver;
    }

    public Date getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }
}
