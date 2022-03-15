package org.techtown.samplelayoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        container = findViewById(R.id.container); // 안쪽 레이아웃 참조

        Button button = findViewById(R.id.button2);
        if(button!=null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // getSystemService 함수를 사용해 LayoutInflater 객체 참조
                    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    inflater.inflate(R.layout.sub1, container, true); // inflate 함수로 sub1.xml과 container 객체 전달
                    // 객체화 완료 //
                    // 이제 findViewById로 참조 가능
                    // 부분 레이아웃은 container 객체에 설정됨
                    CheckBox checkBox = container.findViewById(R.id.checkBox);
                    checkBox.setText("로딩되었어요.");
                }
            });
        }
    }
}