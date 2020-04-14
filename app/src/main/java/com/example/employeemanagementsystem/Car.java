package com.example.employeemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

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
    public void set(Intent intent, Bundle bundle, TextView txtmodel, TextView txtplate, TextView txtcategory, TextView txtcolor, TextView txttype)
    {
        super.set(intent,bundle,txtmodel,txtplate,txtcategory,txtcolor);
        String tmptype = bundle.getString("Type");
        txttype.setText(tmptype);
    }
}
