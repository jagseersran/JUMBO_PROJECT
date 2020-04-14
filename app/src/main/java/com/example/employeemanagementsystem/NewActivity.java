package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class NewActivity extends AppCompatActivity {

    Tester tester = new Tester();
    Programmer programmer = new Programmer();
    Manager manager = new Manager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2);

        Intent myIntent = getIntent();
        Bundle bundle = myIntent.getExtras();
        String VehicleCategory = bundle.getString("VehicleCategory1");
        TextView txtName = findViewById(R.id.txtName);
        TextView txtAge = findViewById(R.id.txtAge);
        TextView lblVehicle = findViewById(R.id.lblVehicle);
        TextView txtModel = findViewById(R.id.txtModel);
        TextView txtPlate = findViewById(R.id.txtPlate);
        TextView txtColor = findViewById(R.id.txtColor);
        TextView txtType = findViewById(R.id.txtType);
        TextView txtOccRate = findViewById(R.id.txtOccRate);
        TextView txtAIncome = findViewById(R.id.txtAIncome);
        TextView lblPerformance = findViewById(R.id.lblPerformance);
        Log.d("Vehicle Category1 =",VehicleCategory);

        if (Employee.emptype.equals("Tester"))
        {
            tester.set(myIntent,bundle,txtName,txtAge,txtAIncome,txtOccRate,lblPerformance, txtModel, txtPlate, lblVehicle,txtColor, txtType,VehicleCategory);
        }
        else if(Employee.emptype == "Programmer")
        {
            programmer.set(myIntent,bundle,txtName,txtAge,txtAIncome,txtOccRate,lblPerformance, lblVehicle, txtModel, txtPlate, txtColor, txtType,VehicleCategory);
        }
        else if(Employee.emptype == "Manager")
        {
            manager.set(myIntent,bundle,txtName,txtAge,txtAIncome,txtOccRate,lblPerformance, lblVehicle, txtModel, txtPlate, txtColor, txtType,VehicleCategory);
        }
    }
}
