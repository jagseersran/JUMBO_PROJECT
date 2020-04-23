package com.example.employeemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Manager extends Employee {
    private int nbClients;
    Car car = new Car();
    MotorCycle motorcycle = new MotorCycle();

    Manager()
    {
        nbClients = 0;
    }

    public void get(EditText txtfname,EditText txtlname,EditText txtbyer,EditText txtmsalary,EditText txtorate,EditText txtcno, EditText txtcartype,EditText txtvmodel,EditText txtplateno,String txtsidecar)
    {
        super.get(txtfname,txtlname,txtbyer,txtmsalary,txtorate);
        if(Vehicle.category.equals("Car"))
        {
            car.get(txtcartype,txtvmodel,txtplateno);
        }
        else if(Vehicle.category.equals("Motor Cycle"))
        {
            motorcycle.get(txtvmodel,txtplateno,txtsidecar);
        }
        nbClients = Integer.parseInt(txtcno.getText().toString());
    }

    public void activity_store(Intent intent)
    {
        super.activity_store(intent);
        car.activity_store(intent);
        motorcycle.activity_store(intent);
        intent.putExtra("Performance","He/She has bought "+nbClients+" clients");
    }

    public void set(Intent intent, Bundle bundle, TextView txtname, TextView txtage, TextView txtaIncome, TextView txtrate, TextView txtperformance,TextView txtvtype,TextView txtmodel,TextView txtplate,TextView txtcolor,TextView txttype,String VehicleCategory)
    {
        super.set(intent,bundle,txtname,txtage,txtaIncome,txtrate);
        if(VehicleCategory.equals("Car"))
        {
            car.set(intent,bundle,txtmodel,txtplate,txtvtype,txtcolor,txttype);
        }
        else if(VehicleCategory.equals("Motor Cycle"))
        {
            motorcycle.set(intent,bundle,txtmodel,txtplate,txtvtype,txtcolor,txttype);
        }
        String tempperformance = bundle.getString("Performance");
        txtperformance.setText(tempperformance);
    }

}
