package com.example.myprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    GridView grid;
    ArrayList<MenuGridItem> menuList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        grid = (GridView)findViewById(R.id.menuGrid);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Creating array if items for grid
        MenuGridItem faq = new MenuGridItem("Faqs", R.drawable.faq_icon);
        MenuGridItem meditate = new MenuGridItem("Meditate", R.drawable.meditate_icon);
        MenuGridItem symptoms = new MenuGridItem("Symptoms", R.drawable.syptoms_icon);
        MenuGridItem community = new MenuGridItem("Community", R.drawable.community_icon);
        MenuGridItem location = new MenuGridItem("Location", R.drawable.location_icon);
        MenuGridItem hygiene = new MenuGridItem("Hygiene", R.drawable.hygiene_icon);
        MenuGridItem rules14days = new MenuGridItem("rules14days", R.drawable.syptoms_icon);

        menuList.add(faq);
        menuList.add(meditate);
        menuList.add(symptoms);
        menuList.add(community);
        menuList.add(location);
        menuList.add(hygiene);
        menuList.add(rules14days);
        //Assigns custom adapter to the gridview grid
        MenuAdapter adapter = new MenuAdapter(this, R.layout.homepage_grid, menuList);
        grid.setAdapter(adapter);

        //Sets Listeners for every item within the grid
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object item = (Object) grid.getAdapter().getItem(i);
                MenuGridItem chosen =(MenuGridItem)item;
                Intent intent = null;
                String menuOption = chosen.getMenuTitle();
                if(menuOption.equalsIgnoreCase("location")) {
                     intent = new Intent(getApplicationContext(), Location.class);
                }
                else if(menuOption.equalsIgnoreCase("Hygiene")){
                     intent = new Intent(getApplicationContext(), HygienePractices.class);
                }
                else if(menuOption.equalsIgnoreCase("Rules14Days")){
                    intent = new Intent(getApplicationContext(), rules14days.class);
                }else
                    intent = new Intent(getApplicationContext(), Location.class);

            startActivity(intent);
            }


        });
    }
}
