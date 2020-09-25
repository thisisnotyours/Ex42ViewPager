package com.suek.ex42viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> items= new ArrayList<>();   //이미지 저장소가 R 에 위치함. 그래서 인트형
    MyAdapter adapter;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터들 추가
        items.add(new Integer(R.drawable.gametitle_01));
        items.add(new Integer(R.drawable.gametitle_02));
        items.add(new Integer(R.drawable.gametitle_03));
        items.add(new Integer(R.drawable.gametitle_04));
        items.add(new Integer(R.drawable.gametitle_05));
        items.add(new Integer(R.drawable.gametitle_06));
        items.add(new Integer(R.drawable.gametitle_07));
        items.add(new Integer(R.drawable.gametitle_08));
        items.add(new Integer(R.drawable.gametitle_09));
        items.add(new Integer(R.drawable.gametitle_10));

        //어답터 객체생성
        adapter= new MyAdapter(items, getLayoutInflater());

        //ViewPager 에 아답터 설정
        pager= findViewById(R.id.pager);
        pager.setAdapter(adapter);

    }


    public void clickPrev(View view) {
        //현재 뷰페이저의 page 번호 얻어오기
        int index= pager.getCurrentItem();
        //특정페이지로 이동
        pager.setCurrentItem(index - 1, false);   //이전페이지
    }

    public void clickNext(View view) {
        int index= pager.getCurrentItem();
        pager.setCurrentItem(index + 1, false);   //다음페이지  
    }



}//MainActivity
