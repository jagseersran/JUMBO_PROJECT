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
                if(tutorialsName == "Programmer")
                {
                    lblBNo.setVisibility(View.GONE);
                    txtBNo.setVisibility(View.GONE);
                    lblCNo.setVisibility(View.GONE);
                    txtCNo.setVisibility(View.GONE);
                    lblProjNo.setVisibility(View.VISIBLE);
                    txtProjNo.setVisibility(View.VISIBLE);
                }
                else if(tutorialsName == "Tester")
                {
                    lblProjNo.setVisibility(View.GONE);
                    txtProjNo.setVisibility(View.GONE);
                    lblCNo.setVisibility(View.GONE);
                    txtCNo.setVisibility(View.GONE);

                    lblBNo.setVisibility(View.VISIBLE);
                    txtBNo.setVisibility(View.VISIBLE);
                }
                else if(tutorialsName == "Manager")
                {
                    lblBNo.setVisibility(View.GONE);
                    txtBNo.setVisibility(View.GONE);
                    lblProjNo.setVisibility(View.GONE);
                    txtProjNo.setVisibility(View.GONE);

                    lblCNo.setVisibility(View.VISIBLE);
                    txtCNo.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(),"Manager",Toast.LENGTH_SHORT).show();
                }
                Employee.emptype = tutorialsName;
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });

        final RadioGroup grpbxVehicle = findViewById(R.id.rdogrpVType);
        final RadioGroup grpbxSCar = findViewById(R.id.rdogrpSideCar);
        final TextView lblSideCar = findViewById(R.id.lblSideCar);
        final TextView lblCarType = findViewById(R.id.lblCarType);
        final EditText txtCType = findViewById((R.id.txtCarType));


        grpbxVehicle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rdobtnCar)
                {
                    grpbxSCar.setVisibility(View.GONE);
                    lblSideCar.setVisibility(View.GONE);
                    lblCarType.setVisibility(View.VISIBLE);
                    txtCType.setVisibility(View.VISIBLE);
                    RadioButton rb = (RadioButton) findViewById(checkedId);
                    Vcategory = rb.getText().toString();

                }
                else if(checkedId == R.id.rdobtnMCycle)
                {
                    txtCType.setVisibility(View.GONE);
                    lblCarType.setVisibility(View.GONE);
                    lblSideCar.setVisibility(View.VISIBLE);
                    grpbxSCar.setVisibility(View.VISIBLE);
                    RadioButton rb = (RadioButton) findViewById(checkedId);
                    Vcategory = rb.getText().toString();
                }
                Vehicle.category = Vcategory;

            }