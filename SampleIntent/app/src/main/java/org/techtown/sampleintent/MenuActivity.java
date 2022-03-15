package org.techtown.sampleintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        
        Button button = findViewById(R.id.button); // 버튼 객체 참조
        if(button!=null) {
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("name", "mike"); // 인텐트 객체 생성 후 name의 값을 부가 데이터로 넣기
                    setResult(RESULT_OK, intent); // 응답 보내기. 인텐트 객체가 파라미터로 전달
                    finish(); // 현재 액티비티 화면에서 없애기
                }
            });
        }
    }
}