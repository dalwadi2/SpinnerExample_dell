package com.example.admin.spinnerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity {
    EditText java_old_contact;
    EditText java_new_contact;
    Button java_update_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        java_new_contact=(EditText)findViewById(R.id.xml_new_contact);
        java_old_contact=(EditText)findViewById(R.id.xml_old_Contact);
        java_update_button=(Button)findViewById(R.id.update_button);
       // java_update_button.setOnClickListener();
    }

}
