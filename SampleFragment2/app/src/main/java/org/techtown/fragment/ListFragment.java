package org.techtown.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import androidx.appcompat.app.AppCompatActivity;

public class ListFragment extends Fragment {

    public static interface ImageSelectionCallback{
        public void onImageSelected(int position);
    }

    public ImageSelectionCallback callback;

    // 버튼이 눌릴 때마다 액티비티 쪽으로 데이터 전달
    @Override
    public void onAttach(Context context){ // 프래그먼트가 액티비티와 연결될 때
        super.onAttach(context);

        if(context instanceof ImageSelectionCallback){
            callback=(ImageSelectionCallback) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        ViewGroup rootView=(ViewGroup) inflater.inflate(R.layout.fragment_list,
                container, false);
        
        // 버튼이 클릭되면 이미지가 선택됨
        Button button=rootView.findViewById(R.id.button);
        if(button!=null){
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(callback!=null){
                        callback.onImageSelected(0);
                    }
                }
            });
        }

        Button button2=rootView.findViewById(R.id.button2);
        if(button2!=null){
            button2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(callback!=null){
                        callback.onImageSelected(1);
                    }
                }
            });
        }

        Button button3=rootView.findViewById(R.id.button3);
        if(button3!=null){
            button3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(callback!=null){
                        callback.onImageSelected(2);
                    }
                }
            });
        }
        return rootView;
    }
}