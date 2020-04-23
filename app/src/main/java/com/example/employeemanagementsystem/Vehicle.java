package com.example.employeemanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class Vehicle extends Employee {
    public static String make;
    public static String plate;
    public static String color;
    public static String category;

    Vehicle()
    {
        make = "";
        plate = "";
        color = "";
        category = "";
    }

    public void get(EditText txtmodel,EditText txtplateno)
    {
        make = txtmodel.getText().toString();
        plate = txtplateno.getText().toString();
    }

    public void activity_store(Intent intent)
    {
        intent.putExtra("Model",make);
        intent.putExtra("Plate",plate);
        intent.putExtra("Category","Employee has a ".concat(" ".concat(category)));
        intent.putExtra("Color",color);
    }

    public void set(Intent intent, Bundle bundle, TextView txtmodel,TextView txtplate,TextView txtcategory,TextView txtcolor)
    {
        String tmpmodel = bundle.getString("Model");
        String tmpplate = bundle.getString("Plate");
        String tmpcategory = bundle.getString("Category");
        String tmpcolor = bundle.getString("Color");
        txtmodel.setText(tmpmodel);
        txtplate.setText(tmpplate);
        txtcategory.setText(tmpcategory);
        txtcolor.setText(tmpcolor);
    }
}
