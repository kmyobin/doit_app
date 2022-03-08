package org.techtown.sampleevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    GestureDetector detector; // 제스쳐 디렉터 객체 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView); // 참조

        View view = findViewById(R.id.view); // 맨 첫번째 view
        view.setOnTouchListener(new View.OnTouchListener(){ // 리스너 등록
            @Override
            // 뷰가 터치되었을 때 onTouch 메서드 자동 호출
            public boolean onTouch(View view, MotionEvent motionEvent){
                int action = motionEvent.getAction();
                // motionEvent : 액션 정보, 터치한 곳의 좌표

                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if(action == MotionEvent.ACTION_DOWN){
                    println("손가락 눌림 : "+curX+", "+curY);
                }else if(action == MotionEvent.ACTION_MOVE){
                    println("손가락 움직임 : "+curX+", "+curY);
                }else if(action == MotionEvent.ACTION_UP){
                    println("손가락 뗌 : "+curX+", "+curY);
                }

                return true;
            }
        });

        // 제스쳐 이벤트 : 터치 이벤트 중에서 스크롤 등을 구별한 후 알려주는 이벤트
        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent motionEvent) {
                println("onDown() 호출됨");

                return true;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {
                println("onShowPress() 호출됨");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                println("onSingleTapUp() 호출됨");

                return true;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onScroll() 호출됨 : "+v+", "+v1);

                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                println("onLongPress() 호출됨");
            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                println("onFling() 호출됨 : "+v+", "+v1);

                return true;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent){
                detector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    public void println(String data){
        textView.append(data+"\n");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Toast.makeText(this, "시스템 [BACK] 버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();

            return true;
        }

        return false;
    }
}