package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        Intent textRamene = getIntent();
        String textRamene1 = textRamene.getStringExtra("message");
        String textRamene2 = textRamene.getStringExtra("message2");
        setTitle(textRamene1 + ">>" +textRamene2 );
    }
}
