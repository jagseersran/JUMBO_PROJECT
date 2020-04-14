package com.example.employeemanagementsystem;

import android.content.Intent;
import android.widget.EditText;

public class Car extends Vehicle {
    private String type;

    Car()
    {
        type ="";
    }

    public void get(EditText txtcartype, EditText txtvmodel, EditText txtplateno)
    {
        super.get(txtvmodel,txtplateno);
        type = txtcartype.getText().toString();
    }
    public void activity_store(Intent intent)
    {
        super.activity_store(intent);
        intent.putExtra("Type",type);
    }