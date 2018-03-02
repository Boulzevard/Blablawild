package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

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
}
