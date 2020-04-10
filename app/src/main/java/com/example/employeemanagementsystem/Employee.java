package com.example.employeemanagementsystem;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import android.util.StateSet;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class Employee extends AppCompatActivity {
    static String name;
    static int age;
    private int birthYear;
    private double monthlySalary;
    private String rate;
    static double annualsalary;
    static String emptype;

    Employee()
    {
        name = "";
        age = 0;
        birthYear = 0;
        monthlySalary = 0.0;
        rate = "";
    }

    public void get(EditText txtfname,EditText txtlname,EditText txtbyer,EditText txtmsalary,EditText txtorate)
    {
        String fname = txtfname.getText().toString();
        String lname = txtlname.getText().toString();
        name = fname.concat(" ".concat(lname));
        birthYear = Integer.parseInt(txtbyer.getText().toString());
        age = Calendar.getInstance().get(Calendar.YEAR) - birthYear;
        monthlySalary = Double.parseDouble(txtmsalary.getText().toString());
        rate = txtorate.getText().toString();
        annualsalary = monthlySalary *12;
    }


}