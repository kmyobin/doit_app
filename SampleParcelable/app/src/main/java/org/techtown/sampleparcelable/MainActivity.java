package org.techtown.sampleparcelable;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_SIMPLE_DATA="data";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(), MenuActivity.class);
                SimpleData data=new SimpleData(100,"Hello Android!");
                intent.putExtra(KEY_SIMPLE_DATA,data);
                _startForResult.launch(intent); // MenuActivity로 객체를 전달함
            }
        });
    }

    ActivityResultLauncher<Intent> _startForResult=registerForActivityResult(

            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==RESULT_OK){
                        Intent intent=result.getData();
                        String name=intent.getStringExtra("data");

                        Toast.makeText(getApplicationContext(),"MenuActivity로 객체 전달",
                                Toast.LENGTH_LONG).show(); // 이거 실행 안됨 왜지
                    }
                }
            }
    );
}