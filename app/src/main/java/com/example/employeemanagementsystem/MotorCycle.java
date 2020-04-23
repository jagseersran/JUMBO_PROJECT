package com.example.employeemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.concurrent.TimeoutException;

public class MotorCycle extends Vehicle {
    private String sideCar;

    MotorCycle()
    {
        sideCar = "";
    }

    public void get(EditText txtmodel,EditText txtplateno,String txtsidecar)
    {
        super.get(txtmodel,txtplateno);
        sideCar = txtsidecar;
    }

    public void activity_store(Intent intent)
    {
        super.activity_store(intent);
        if(sideCar.equals("YES"))
        {
            intent.putExtra("Type","With Side Car");
        }
        else if(sideCar.equals("NO"))
        {
            intent.putExtra("Type","Without Side Car");
        }
    }


    public void set(Intent intent, Bundle bundle, TextView txtmodel,TextView txtplate,TextView txtcategory,TextView txtcolor,TextView txtsidecar)
    {
        super.set(intent,bundle,txtmodel,txtplate,txtcategory,txtcolor);
        String tmptype = bundle.getString("Type");
        txtsidecar.setText(tmptype);
    }

}
