package org.techtown.tab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment1).commit();

        BottomNavigationView bottomNavigation=findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnItemSelectedListener(
                new BottomNavigationView.
        );

        );
    }
}