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
    com.example.employeemanagementsystem.DataHelper myDB ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new com.example.employeemanagementsystem.DataHelper(this);
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

                Log.d("Vehicle Color",Vehicle.color);
                Log.d("Vehicle Category",Vehicle.category);
                Log.d("Employee Type",Employee.emptype);
            }
        });

        grpbxSCar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rdobtnYes)
                {
                    RadioButton rb = (RadioButton) findViewById(checkedId);
                    txtsidecar = rb.getText().toString();
                }
                else if(checkedId == R.id.rdobtnNo)
                {
                    RadioButton rb = (RadioButton) findViewById(checkedId);
                    txtsidecar = rb.getText().toString();
                }
            }
        });


        final Spinner spinner1 = findViewById(R.id.spinnerVColor);
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Choose color");
        arrayList1.add("RED");
        arrayList1.add("GREEN");
        arrayList1.add("YELLOW");
        arrayList1.add("BLACK");
        arrayList1.add("PURPLE");
        arrayList1.add("ORANGE");
        arrayList1.add("PINK");
        arrayList1.add("BROWN");
        arrayList1.add("WHITE");
        arrayList1.add("GREY");
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayList1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Vcolor = parent.getItemAtPosition(position).toString();
                Vehicle.color = Vcolor;
            }

            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });


        final Button btnReg = findViewById(R.id.btnReg);
        btnReg.setOnClickListener(new View.OnClickListener() {


            EditText txtfname = findViewById(R.id.txtfName);
            EditText txtlname = findViewById(R.id.txtlName);
            EditText txtbyear = findViewById(R.id.txtBYear);
            EditText txtmsalary = findViewById(R.id.txtMSalary);
            EditText txtorate = findViewById(R.id.txtORate);
            EditText txtpno = findViewById(R.id.txtPNo);
            EditText txtbno =findViewById(R.id.txtBNo);
            EditText txtcno =findViewById(R.id.txtCNo);
            EditText txtcartype =findViewById(R.id.txtCarType);
            EditText txtvmodel = findViewById(R.id.txtVModel);
            EditText txtplateno = findViewById(R.id.txtPlateNo);
            EditText txtempId = findViewById(R.id.txtEId);


            @Override
            public void onClick(View v) {

                if(Integer.parseInt(txtbyear.getText().toString())<1900 || Integer.parseInt(txtbyear.getText().toString())>Calendar.getInstance().get(Calendar.YEAR))
                {
                    Toast.makeText(MainActivity.this, "Birth Year Should be Greater Than 1900 And Less than Equal to Current Year", Toast.LENGTH_SHORT).show();
                    txtbyear.setText("");
                    Toast.makeText(MainActivity.this, "Please Enter Birth Year Again between(1900 and "+Calendar.getInstance().get(Calendar.YEAR)+")", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(txtorate.getText().toString())>100 || Integer.parseInt(txtorate.getText().toString())<0)
                {
                    Toast.makeText(MainActivity.this, "Occupation Rate Should be Greater Than 0 And Less than Equal to 100", Toast.LENGTH_SHORT).show();
                    txtorate.setText("");
                    Toast.makeText(MainActivity.this, "Please Enter Occupation Rate Again between(0 and 100)", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(txtbyear.getText().toString())>1900 || Integer.parseInt(txtbyear.getText().toString())<=Calendar.getInstance().get(Calendar.YEAR) && Integer.parseInt(txtorate.getText().toString())<=100 || Integer.parseInt(txtorate.getText().toString())>0)
                {
                    switch (Employee.emptype)
                    {
                        case "Tester":
                            if(Vehicle.category.equals("Car"))
                            {
                                myDB.insertData(Employee.name,String.valueOf(Employee.age),String.valueOf(Employee.annualsalary),txtorate.getText().toString(),txtempId.getText().toString(),txtbno.getText().toString(),Employee.emptype,Vehicle.category,txtcartype.getText().toString(), txtvmodel.getText().toString(),txtplateno.getText().toString(),Vehicle.color);
                            }
                            else if(Vehicle.category.equals("Motor Cycle"))
                            {
                                myDB.insertData(Employee.name,String.valueOf(Employee.age),String.valueOf(Employee.annualsalary),txtorate.getText().toString(),txtempId.getText().toString(),txtbno.getText().toString(),Employee.emptype,Vehicle.category,txtsidecar, txtvmodel.getText().toString(),txtplateno.getText().toString(),Vehicle.color);
                            }
                            tester.get(txtfname,txtlname,txtbyear,txtmsalary,txtorate,txtbno,txtcartype,txtvmodel,txtplateno,txtsidecar);
                            break;
                        case "Programmer":
                            if(Vehicle.category.equals("Car"))
                            {
                                myDB.insertData(Employee.name,String.valueOf(Employee.age),String.valueOf(Employee.annualsalary),txtorate.getText().toString(),txtempId.getText().toString(),txtpno.getText().toString(),Employee.emptype,Vehicle.category,txtcartype.getText().toString(), txtvmodel.getText().toString(),txtplateno.getText().toString(),Vehicle.color);
                            }
                            else if(Vehicle.category.equals("Motor Cycle"))
                            {
                                myDB.insertData(Employee.name,String.valueOf(Employee.age),String.valueOf(Employee.annualsalary),txtorate.getText().toString(),txtempId.getText().toString(),txtpno.getText().toString(),Employee.emptype,Vehicle.category,txtsidecar, txtvmodel.getText().toString(),txtplateno.getText().toString(),Vehicle.color);
                            }
                            programmer.get(txtfname,txtlname,txtbyear,txtmsalary,txtorate,txtpno,txtcartype,txtvmodel,txtplateno,txtsidecar);
                            break;
                        case "Manager":
                            if(Vehicle.category.equals("Car"))
                            {
                                myDB.insertData(Employee.name,String.valueOf(Employee.age),String.valueOf(Employee.annualsalary),txtorate.getText().toString(),txtempId.getText().toString(),txtcno.getText().toString(),Employee.emptype,Vehicle.category,txtcartype.getText().toString(), txtvmodel.getText().toString(),txtplateno.getText().toString(),Vehicle.color);
                            }
                            else if(Vehicle.category.equals("Motor Cycle"))
                            {
                                myDB.insertData(Employee.name,String.valueOf(Employee.age),String.valueOf(Employee.annualsalary),txtorate.getText().toString(),txtempId.getText().toString(),txtcno.getText().toString(),Employee.emptype,Vehicle.category,txtsidecar, txtvmodel.getText().toString(),txtplateno.getText().toString(),Vehicle.color);
                            }
                            manager.get(txtfname,txtlname,txtbyear,txtmsalary,txtorate,txtcno,txtcartype,txtvmodel,txtplateno,txtsidecar);
                    }
                    Intent myIntent = new Intent(MainActivity.this,NewActivity.class);
                    myIntent.putExtra("VehicleCategory1",Vehicle.category);
                    if(Employee.emptype == "Tester")
                    {
                        tester.activity_store(myIntent);
                    }
                    else if(Employee.emptype == "Programmer")
                    {
                        programmer.activity_store(myIntent);
                    }
                    else if(Employee.emptype == "Manager")
                    {
                        manager.activity_store(myIntent);
                    }
                    startActivity(myIntent);
                }
            }
        });
    }
}
