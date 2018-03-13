package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ItinerarySearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        final Calendar myCalendar = Calendar.getInstance();

        final EditText edittext= (EditText) findViewById(R.id.editText_date);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            private void updateLabel() {
                String myFormat = "dd/MM/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

                edittext.setText(sdf.format(myCalendar.getTime()));
            }

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }


        });

        Button buttonSearch = findViewById(R.id.button_search);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editDeparture = findViewById(R.id.editText_departure);
                String departure = editDeparture.getText().toString();
                EditText editDestination = findViewById(R.id.editText_destination);
                String destination = editDestination.getText().toString();

                if ((departure.length()<1) || (destination.length()<1)) {
                    Toast.makeText(ItinerarySearchActivity.this, "Please fill all cases", Toast.LENGTH_SHORT).show();
                }
                else {

                    Intent intentSearch = new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class);
                    intentSearch.putExtra("message",departure);
                    intentSearch.putExtra("message2",destination);
                    ItinerarySearchActivity.this.startActivity(intentSearch);
                }

            }
        });

    }

    private void updateLabel() {

    }
}
