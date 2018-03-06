package fr.wcs.blablawild;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wilder on 05/03/18.
 */

public class TripModel {

    String firstname;
    String lastname;
    Date date;
    int price;


    public TripModel(String firstname, String lastname, Date date, int price) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.date = date;
        this.price = price;
    }


    public int getPrice() {
        return price;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getDate() {
        return date;
    }

}
