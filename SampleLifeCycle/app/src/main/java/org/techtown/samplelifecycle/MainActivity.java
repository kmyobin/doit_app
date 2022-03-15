package org.techtown.samplelifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput=findViewById(R.id.nameInput);

        Toast.makeText(this, "OnCreate 호출됨", Toast.LENGTH_LONG).show();

        Button button=findViewById(R.id.button);
        if(button!=null){
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent=new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        println("onResume 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        println("onStop 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        println("onDestroy 호출됨");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this,"onPause 호출됨", Toast.LENGTH_LONG).show();
        saveState(); // 현재 입력상자에 입력된 데이터를 저장
        //println("onPause 호출됨");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this,"OnResume 호출됨", Toast.LENGTH_LONG).show();
        restoreState();
        //println("onResume 호출됨");
    }

    public void println(String data){
        Toast.makeText(this,data,Toast.LENGTH_LONG).show();
        Log.d("Main",data);
    }

    protected void restoreState(){ // 설정 정보에 저장된 데이터를 갖고와서 토스트 메세지로 보여줌
        SharedPreferences pref=getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if((pref!=null)&&(pref.contains("name"))){
            String name=pref.getString("name","");
            nameInput.setText(name);
        }
    }

    protected void saveState(){ // 현재 입력상자에 입력된 데이터를 저장한다
        // pref 문자열을 저장소의 이름으로 사용
        SharedPreferences pref=getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if(pref!=null){
            SharedPreferences.Editor editor=pref.edit(); // 데이터를 저장할 수 있는 edit 메서드
            editor.putString("name", nameInput.getText().toString()); // 저장하려는 데이터 설정
            editor.commit(); // 실제로 저장
        }

    }

    protected void clearState(){
        SharedPreferences pref=getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.clear();
        editor.commit();
    }
}