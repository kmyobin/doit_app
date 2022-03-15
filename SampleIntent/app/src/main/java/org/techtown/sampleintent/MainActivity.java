package org.techtown.sampleintent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                _startForResult.launch(intent); // ActivityResultLauncher 사용
            }
        });
    }

    ActivityResultLauncher<Intent> _startForResult = registerForActivityResult( // 함수 정의
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData();
                        String name = intent.getStringExtra("name"); // menuActivity.java에서 name 받아옴
                        Toast.makeText(getApplicationContext(), "응답으로 전달된 name : " +
                                name, Toast.LENGTH_LONG).show();
                    }
                }
            }
    );
}