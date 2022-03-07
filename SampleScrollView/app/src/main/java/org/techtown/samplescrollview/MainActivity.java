package org.techtown.samplescrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    ImageView imageView;
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 연결
        scrollView = findViewById(R.id.scrollView); // 레이아웃에 정의된 뷰 객체 참조
        imageView = findViewById(R.id.imageView);
        scrollView.setHorizontalScrollBarEnabled(true); // 수평 스크롤바 사용 기능 설정

        Resources res = getResources(); // 리소스의 image01 참조
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView.setImageDrawable(bitmap); // 이미지 리소스와 이미지 크기 설정
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
    }

    public void onButton1Clicked(View v){
        changeImage();
    }

    private void changeImage(){
        Resources res = getResources(); // 일단 리소스 가져오고
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02); // 이번엔 image02 참조
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
    }
}