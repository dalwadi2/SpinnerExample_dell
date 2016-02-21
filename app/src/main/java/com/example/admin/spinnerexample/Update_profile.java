package com.example.admin.spinnerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Update_profile extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] states = {"select state","Gujarat", "Rajasthan", "Maharashtra"};
    String[] disticts = {"select district","Ahmedabad", "udaipur", "Mumbai"};
    String[] cities = {"select city","Ahmedabad", "udaipur", "Mumbai"};
    String[] areas = {"select area","naranpura", "jaymangal", "mulund"};
    Spinner spinner_state;
    Spinner spinner_district;
    Spinner spinner_city;
    Spinner spinner_area;
    EditText java_contact;
    EditText xml_address;
    Button update;
    Dbhelper obj_dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        obj_dbhelper=new Dbhelper(this);
       update =(Button)findViewById(R.id.update_button);
        xml_address =(EditText)findViewById(R.id.update_address);
        java_contact =(EditText)findViewById(R.id.update_contact);
        spinner_state=(Spinner)findViewById(R.id.update_state);
        spinner_district=(Spinner)findViewById(R.id.update_district);
        spinner_city=(Spinner)findViewById(R.id.update_city);
        spinner_area=(Spinner)findViewById(R.id.update_area);

        spinner_state.setOnItemSelectedListener(this);
        spinner_district.setOnItemSelectedListener(this);
        spinner_city.setOnItemSelectedListener(this);
        spinner_area.setOnItemSelectedListener(this);

        ArrayAdapter adapter_states = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, states);
        ArrayAdapter adapter_district = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, disticts);
        ArrayAdapter adapter_city = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cities);
        ArrayAdapter adapter_area = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, areas);

        spinner_state.setAdapter(adapter_states);
        spinner_district.setAdapter(adapter_district);
        spinner_city.setAdapter(adapter_city);
        spinner_area.setAdapter(adapter_area);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
