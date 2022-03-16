package org.techtown.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment; // 왜 이게 자동 추가가 안되지 ㅇㅅㅇ
import androidx.annotation.Nullable;

public class ViewerFragment extends Fragment {
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState){
        ViewGroup rootView=(ViewGroup) inflater.inflate(R.layout.fragment_viewer,
                container, false);
        // fragment_viewer.xml을 container에 올린다.

        imageView=rootView.findViewById(R.id.imageView);
        return rootView;
    }

    public void setImage(int resId){
        imageView.setImageResource(resId); // 액티비티에서 이미지뷰에 이미지 설정 가능
    }
}