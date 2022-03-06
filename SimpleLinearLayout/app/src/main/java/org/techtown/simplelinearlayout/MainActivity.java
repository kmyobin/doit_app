package org.techtown.simplelinearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // activity_main.xml 파일을 파라미터로 전달하면 두 개의 파일이 연결되어 하나의 화면을 구성
    }
}