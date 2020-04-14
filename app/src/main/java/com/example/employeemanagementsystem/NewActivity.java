package com.example.employeemanagementsystem;



import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

    Tester tester = new Tester();
    Programmer programmer = new Programmer();
    Manager manager = new Manager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2);
