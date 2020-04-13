package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Programmer programmer = new Programmer();
    Tester tester = new Tester();
    Manager manager = new Manager();
    String txtsidecar = new String();
    String Vcategory = new String();
    String Vcolor = new String();
    DataHelper myDB ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DataHelper(this);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Choose type");
        arrayList.add("Manager");
        arrayList.add("Tester");
        arrayList.add("Programmer");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner spinner = findViewById(R.id.spinnerEType);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                final TextView lblBNo = findViewById(R.id.lblBNo);
                final EditText txtBNo = findViewById(R.id.txtBNo);
                final TextView lblCNo = findViewById(R.id.lblCNo);
                final EditText txtCNo = findViewById(R.id.txtCNo);
                final TextView lblProjNo = findViewById(R.id.lblPNo);
                final EditText txtProjNo = findViewById(R.id.txtPNo);
            }