package org.techtown.sampleframelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;

    int imageIndex=0; // 다음에 어떤 이미지를 가리킬건지

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView); // xml 레이아웃에 있는 두 개의 이미지뷰를 findViewById로 찾은 후 변수에 넣어줌
        imageView2 = findViewById(R.id.imageView2);
    }

    public void onButton1Clicked(View v){
        changeImage();
    }

    private void changeImage(){
        if(imageIndex == 0){
            imageView.setVisibility(View.VISIBLE); // 첫번째 이미지뷰가 보이게 설정
            imageView2.setVisibility(View.INVISIBLE);

            imageIndex = 1; // 다음에 클릭하면 두번째 이미지가 보이게
        }

        else if(imageIndex == 1){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE); // 두번째 이미지뷰가 보이게 설정

            imageIndex = 0; // 다음에 클릭하면 첫번째 이미지가 보이게
        }
    }
}