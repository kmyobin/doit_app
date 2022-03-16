package org.techtown.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main,
                container, false);
        // rootView는 메인 프래그먼트 안에 있음

        Button button = rootView.findViewById(R.id.button); // fragment_main.xml에 있는 버튼 참조
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity activity = (MainActivity) getActivity(); // 프래그먼트가 올라가 있는 액티비티가 어떤 것인지 알 수 있음
                    activity.onFragmentChanged(0); // 프래그먼트 매니저를 이용해 프래그먼트 전환
                }
            });
        }
        return rootView;
    }
}