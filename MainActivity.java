package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
        setContentView(R.layout.activity_main);
        myDB = new DataHelper(this);
        ArrayList<String> arrayList = new ArrayList<>();
    }
}
