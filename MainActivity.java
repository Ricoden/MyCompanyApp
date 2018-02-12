package com.example.roman.mycompanyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ArrayList<Employee> employees = new ArrayList();

    ListView lvEmployees;

   // int img = R.drawable.1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



        if (employees.size()==0){
            employees.add(new Employee("John Silverstain","Marketing",
                    "Melbourne", 243, R.drawable.photo1));
            employees.add(new Employee("Pam Tailor","Design",
                    "Sidney", 24, R.drawable.photo5));
            employees.add(new Employee("Casy Niman","Accounts",
                    "Hobart", 257, R.drawable.photo4));
            employees.add(new Employee("George Tach","Design",
                    "Newcstle", 127, R.drawable.photo6));
            employees.add(new Employee("Cristina Maciel","Mobile Dev.",
                    "Hobart", 80, R.drawable.photo2));
            employees.add(new Employee("Simon Deuva","Media",
                    "Melbourne", 420, R.drawable.photo3));

        }

        lvEmployees = findViewById(R.id.lvEmployees);
        EmployeeAdapter adapter = new EmployeeAdapter(this, R.layout.item, employees);
        lvEmployees.setAdapter(adapter);
    }
}
