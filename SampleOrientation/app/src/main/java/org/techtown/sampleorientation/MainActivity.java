package org.techtown.sampleorientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String name;

    EditText editText;
    TextView textView2; // 가로방향에 textView에 뜨게 할거임

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToast("onCreate 호출됨");

        editText = findViewById(R.id.editText);
        textView2 = findViewById(R.id.textView3);

        Button button = findViewById(R.id.button);
        if(button != null){
            button.setOnClickListener(new View.OnClickListener(){ // onClickListener 객체를 설정하면 버튼을 클릭했을 때 onClick이 실행됨
                @Override
                public void onClick(View view){
                    if(editText != null){
                        name = editText.getText().toString(); // 버튼을 클릭했을 때 사용자가 입력한 값은 name에 할당
                        showToast("입력된 값을 변수에 저장했습니다 : "+name);
                    }
                }
            });
        }

        if(savedInstanceState != null){ // 이 화면이 초기화될 때 name 변수의 값 복원
            if(textView2 != null){
                name = savedInstanceState.getString("name");
                textView2.setText(name);

                showToast("값을 복원했습니다 : "+name);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        showToast("onStart 호출됨");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        
        outState.putString("name", name); // name 변수의 값 bundle에 저장
    }

    @Override
    protected void onStop() {
        super.onStop();

        showToast("onStop 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        showToast("onDestroy 호출됨");
    }

    public void showToast(String data){
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}