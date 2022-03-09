package org.techtown.sampletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onButton1Clicked(View v){
        LayoutInflater inflater = getLayoutInflater(); // 레이아웃 인플레이터 객체 참조
        // 토스트는 첫화면에 딱 떠야되는게 아니므로 setContentView를 쓰지 않음. 대신 메모리에 직접 객체화하는 LayoutInflater 사용
        
        View layout = inflater.inflate( // 토스트를 위한 레이아웃 인플레이션
                R.layout.toastborder,
                (ViewGroup) findViewById(R.id.toast_layout_root)
        );

        TextView text = layout.findViewById(R.id.text); // 토스트 객체 생성

        Toast toast = new Toast(this); // 토스트 객체 생성
        
        text.setText("모양 바꾼 토스트");
        toast.setGravity(Gravity.CENTER, 0, -100);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public void onButton2Clicked(View v){
        Snackbar.make(v, "스낵바입니다.", Snackbar.LENGTH_LONG).show();
    }
}