package org.techtown.simplelinearlayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class LayoutCodeActivity extends AppCompatActivity {

    // 자바 소스 코드에서 만들어보는 화면 레이아웃

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainLayout = new LinearLayout(this); // new 연산자로 리니어 레이아웃 생성
        mainLayout.setOrientation(LinearLayout.VERTICAL); // 방향은 수직

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams( // 추가될 뷰들에 설정할 파라미터 : (부모에게 맞춤, 내용물에 맞춤)
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        
        Button button1 = new Button(this); // 버튼 생성
        button1.setText("Button1"); // 버튼에 들어갈 내용물 설정
        button1.setLayoutParams(params); // 아까 설정한 파라미터 적용
        mainLayout.addView(button1); // 레이아웃에 추가
        setContentView(mainLayout); // 새로 만든 레이아웃을 화면에 설정
    }
}