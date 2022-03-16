package org.techtown.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 프래그먼트는 뷰가 아니기 때문에 FragmentManager 객체에 있는 findFragmentById 이용
        mainFragment=(MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        menuFragment=new MenuFragment(); // 새로운 객체로 만들어 변수에 할당
    }

    public void onFragmentChanged(int index){ // 어떤 프래그먼트를 보이게 할 것인지
        if(index==0){ // MainFragment
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    menuFragment).commit(); // replace를 이용해 프래그먼트 변경
        }
        // beginTransaction : 시작, commit : 실행
        else if(index==1){ // MenuFragment
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    mainFragment).commit();
        }
    }
}