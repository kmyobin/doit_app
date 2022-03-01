package org.techtown.hello;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onButton1Clicked(View v){ // 버튼이 눌렸을 때 
        Toast.makeText(this, "확인1 버튼이 눌렸어요.", Toast.LENGTH_LONG).show(); // toast : 작고 간단한 메시지를 잠깐 보여줌
    }

    public void onButton2Clicked(View v){
        Intent myIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com")); // naver 연결
        startActivity(myIntent);
    }

    public void onButton3Clicked(View v){
        Intent myIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-1000-1000")); // 전화 연결
        startActivity(myIntent);
    }
}