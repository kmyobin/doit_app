package org.techtown.tab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

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

        NavigationBarView bottomNavigation=findViewById(R.id.bottom_navigation); 
        // BottomNavigationView 쓰라고 했지만 내장된 함수가 소멸됐으므로 그냥 NavigationBarView 사용
        bottomNavigation.setOnItemSelectedListener(
                new NavigationBarView.OnItemSelectedListener(){
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.tab1:
                                Toast.makeText(getApplicationContext(), "첫 번째 탭 선택됨",
                                        Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                        fragment1).commit();
                                return true;

                            case R.id.tab2:
                                Toast.makeText(getApplicationContext(), "두 번째 탭 선택됨",
                                        Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                        fragment2).commit();
                                return true;

                            case R.id.tab3:
                                Toast.makeText(getApplicationContext(), "세 번째 탭 선택됨",
                                        Toast.LENGTH_LONG).show();
                                getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                        fragment3).commit();

                                return true;
                        }
                        return false;

                    }
                }
        );
    }
}