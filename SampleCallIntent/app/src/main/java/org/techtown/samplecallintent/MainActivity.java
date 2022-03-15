package org.techtown.samplecallintent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 뷰 객체 참조

        editText = findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String data = editText.getText().toString(); // 입력상자에 입력된 전화번호 확인

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data)); // 전화걸기 화면을 보여줄 인텐트 객체 생성
                startActivity(intent); // 액티비티 띄우기
            }
        });
        
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                // 컴포넌트 이름을 지정할 수 있는 객체 생성
                ComponentName name = new ComponentName("org.techtown.samplecallintent",
                        "org.techtown.samplecallintent.MenuActivity");
                intent.setComponent(name); // 인텐트 객체에 컴포넌트 지정
                _startForResult.launch(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> _startForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>(){
                @Override
                public void onActivityResult(ActivityResult result){
                    if(result.getResultCode()==RESULT_OK){
                        /*Intent intent = result.getData();
                        String name= intent.getStringExtra("name");
                        Toast.makeText(getApplicationContext(), "응답으로 전달된 name : "+ // 전달된 name이 없음
                                name, Toast.LENGTH_LONG).show();*/
                    }
                }
            }
    );
}