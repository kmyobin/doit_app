package org.techtown.pager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager2 pager; // ViewPager도 소멸

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pager.setCurrentItem(1);
            }
        });


        pager=findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3); // 다음 페이지를 몇개까지 로딩할지

        MyPagerAdapter adapter=new MyPagerAdapter(getSupportFragmentManager(),getLifecycle());
        // lifecycle이 왜 들어가는지는 모르겠는데 일단 넣음

        Fragment1 fragment1=new Fragment1();
        adapter.addItem(fragment1);

        Fragment2 fragment2=new Fragment2();
        adapter.addItem(fragment2);

        Fragment3 fragment3=new Fragment3();
        adapter.addItem(fragment3);

        pager.setAdapter(adapter);
    }


    class MyPagerAdapter extends FragmentStateAdapter{ // FragmentStatePagerAdapter 소멸됨 
        ArrayList<Fragment> items=new ArrayList<Fragment>();

        public MyPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        public void addItem(Fragment item){items.add(item);} 

        @NonNull
        @Override
        public Fragment createFragment(int position) { // getItem 소멸
            return items.get(position);
        }

        @Override
        public int getItemCount() { // getCount 소멸
            return items.size();
        }

        /*@Override
        public CharSequence getPageTitle(int position){
            return "페이지"+position;
        }*/

    }
}