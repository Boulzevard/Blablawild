package fr.wcs.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class VehicleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        Spinner spinnerVehicul = (Spinner) findViewById(R.id.spinner_vehicul);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_vehicul, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerVehicul.setAdapter(adapter);

        spinnerVehicul.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                final EditText editBrand = findViewById(R.id.editText_brand);
                final EditText editModel = findViewById(R.id.editText_model);
                final EditText editKilimeters = findViewById(R.id.editText_kilometers);
                final EditText editHours = findViewById(R.id.editText_hours);
                final EditText editSpeed = findViewById(R.id.editText_speed);
                Button buttonSend = findViewById(R.id.button_send);

                if (i == 0) {
                    editKilimeters.setVisibility(View.GONE);
                    editHours.setVisibility(View.GONE);
                    editSpeed.setVisibility(View.GONE);
                    buttonSend.setEnabled(false);
                }
                else if (i ==1 ) {
                    editKilimeters.setVisibility(View.VISIBLE);
                    editHours.setVisibility(View.GONE);
                    editSpeed.setVisibility(View.GONE);
                    buttonSend.setEnabled(true);

                    buttonSend.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String stringBrand = editBrand.getText().toString();
                                        String stringModel = editModel.getText().toString();
                                        String stringKilometers = editKilimeters.getText().toString();
                                        if ( stringBrand.equals("") || stringModel.equals("") || stringKilometers.equals("")){
                                            Toast.makeText(VehicleActivity.this, "please fill all cases", Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            int intKilometers = Integer.valueOf(stringKilometers);
                                            VehicleCar descriptionCar = new VehicleCar(stringBrand, stringModel, intKilometers);

                                            Toast.makeText(VehicleActivity.this, descriptionCar.getDescription(), Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                });


                }
                else if (i == 2) {

                    editHours.setVisibility(View.VISIBLE);
                    editKilimeters.setVisibility(View.GONE);
                    editSpeed.setVisibility(View.GONE);
                    buttonSend.setEnabled(true);

                    buttonSend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String stringBrand = editBrand.getText().toString();
                            String stringModel = editModel.getText().toString();
                            String stringHours = editHours.getText().toString();
                            if ( stringBrand.equals("") || stringModel.equals("") || stringHours.equals("")){
                                Toast.makeText(VehicleActivity.this, "please fill all cases", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                int intHours = Integer.valueOf(stringHours);
                                VehicleBoat descriptionBoat = new VehicleBoat(stringBrand, stringModel, intHours);

                                Toast.makeText(VehicleActivity.this, descriptionBoat.getDescription(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }

                else if (i == 3) {
                    editSpeed.setVisibility(View.VISIBLE);
                    editHours.setVisibility(View.GONE);
                    editKilimeters.setVisibility(View.GONE);
                    buttonSend.setEnabled(true);

                    buttonSend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String stringBrand = editBrand.getText().toString();
                            String stringModel = editModel.getText().toString();
                            String stringSpeed = editSpeed.getText().toString();
                            if ( stringBrand.equals("") || stringModel.equals("") || stringSpeed.equals("")){
                                Toast.makeText(VehicleActivity.this, "please fill all cases", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                int intSpeed = Integer.valueOf(stringSpeed);
                                VehiclePlane descriptionPlane = new VehiclePlane(stringBrand, stringModel, intSpeed);

                                Toast.makeText(VehicleActivity.this, descriptionPlane.getDescription(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
