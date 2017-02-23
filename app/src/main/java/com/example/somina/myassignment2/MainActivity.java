package com.example.somina.myassignment2;

import android.os.Bundle;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4;
    Button b1, b2;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Age = "ageKey";
    public static final String Phone = "phoneKey";
    public static final String City = "cityKey";


    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.txtname);
        ed2 = (EditText) findViewById(R.id.txtage);
        ed3 = (EditText) findViewById(R.id.txtphone);
        ed4 = (EditText) findViewById(R.id.txtcity);

        b1 = (Button) findViewById(R.id.showinformation);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b2 = (Button) findViewById(R.id.storeinformation);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed1.getText().toString();
                String age = ed2.getText().toString();
                String phone = ed3.getText().toString();
                String city = ed4.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, name);
                editor.putString(Age, age);
                editor.putString(Phone, phone);
                editor.putString(City, city);
                editor.commit();
                Toast.makeText(MainActivity.this,"Name: " + name+"\n"+"Age:" +age+"\n"+"Phone:" +phone+"\n"+"City:" +city, Toast.LENGTH_LONG).show();


                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String n = ed1.getText().toString();
                        String a = ed3.getText().toString();
                        String ph = ed2.getText().toString();
                        String c = ed4.getText().toString();

                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        editor.putString(Name, n);
                        editor.putString(Age, a);
                        editor.putString(Phone, ph);
                        editor.putString(City, c);
                        editor.commit();
                        Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_LONG).show();
                    }
                });
            }


        });
    }
}