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

    final String ATTRIBUTE_NAME_NAME = "name";
    final String ATTRIBUTE_NAME_POSITION = "pos";
    final String ATTRIBUTE_NAME_CITY = "city";
    final String ATTRIBUTE_NAME_FOLLOWERS = "follow";
    final String ATTRIBUTE_NAME_IMAGE = "image";

    ListView lvSimple;
    TextView tvAdd;

    // массивы данных
    String[] names = { "John Silverstain", "Pam Tailor", "Casy Niman",
            "George Tach", "Cristina Maciel", "Simon Deuva" };
    String[] positions = { "Marketing", "Design", "Accounts",
            "Design", "Mobile Dev.", "Media" };
    String[] cities = { "Melbourne", "Sidney", "Hobart",
            "Newcstle", "Hobart", "Melbourne" };
    int[] followers = { 243, 24, 257, 127, 80, 420};
    int img = R.drawable.ic_launcher_background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tvAdd = findViewById(R.id.tvAdd);
        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        // упаковываем данные в понятную для адаптера структуру
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(
                names.length);
        Map<String, Object> m;
        for (int i = 0; i < names.length; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_NAME, names[i]);
            m.put(ATTRIBUTE_NAME_POSITION, positions[i]);
            m.put(ATTRIBUTE_NAME_CITY, cities[i]);
            m.put(ATTRIBUTE_NAME_FOLLOWERS, followers[i]+" Followers");
            m.put(ATTRIBUTE_NAME_IMAGE, img);
            data.add(m);
        }

        // массив имен атрибутов, из которых будут читаться данные
        String[] from = { ATTRIBUTE_NAME_NAME, ATTRIBUTE_NAME_POSITION, ATTRIBUTE_NAME_CITY,
                ATTRIBUTE_NAME_FOLLOWERS, ATTRIBUTE_NAME_IMAGE };
        // массив ID View-компонентов, в которые будут вставлять данные
        int[] to = { R.id.tvNameSurname, R.id.tvPosition, R.id.tvCity, R.id.tvFollowers, R.id.imgViewPhoto };

        // создаем адаптер
        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.item,
                from, to);

        // определяем список и присваиваем ему адаптер
        lvSimple = (ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(sAdapter);
    }
}
