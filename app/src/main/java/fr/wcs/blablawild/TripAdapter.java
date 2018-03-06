package fr.wcs.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by wilder on 05/03/18.
 */


public class TripAdapter extends ArrayAdapter<TripModel> {
    public TripAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TripModel trip = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }
        // Lookup view for data population
        TextView firstname = (TextView) convertView.findViewById(R.id.textView_firstname);
        TextView  lastname= (TextView) convertView.findViewById(R.id.textView_lastname);
        TextView price = (TextView) convertView.findViewById(R.id.textView_prix) ;
        TextView date = (TextView) convertView.findViewById(R.id.textView_date);

        String stringPrice = String.valueOf(trip.getPrice());
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String stringDate = simpleDate.format(trip.getDate());

        // Populate the data into the template view using the data object
        firstname.setText(trip.getFirstname());
        lastname.setText(trip.getLastname());
        price.setText("$" + stringPrice);
        date.setText(stringDate + "PM");
        // Return the completed view to render on screen
        return convertView;
    }
}

