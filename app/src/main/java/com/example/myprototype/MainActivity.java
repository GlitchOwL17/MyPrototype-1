package com.example.myprototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Assigns custom toolbar to act as action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Sets up the navigation for fragments login and signup pages
        BottomNavigationView logNav = findViewById(R.id.navLogin);
        logNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentSection,new LoginPage()).commit();
        //NavController fragmentSection = Navigation.findNavController(logNav);

        submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goHomePage();
            }
        });

    }

    public void goHomePage(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectFragment = null;

                    switch(menuItem.getItemId()){

                        case R.id.login_nav:
                            selectFragment = new LoginPage();
                            break;
                        case R.id.signUp_nav:
                            selectFragment = new SignUpPage();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentSection, selectFragment).commit();
                    return true;
                }
            };

}