package com.suek.ex42viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends PagerAdapter {

    ArrayList<Integer> items;    //MainActivity 에서 만들어진 대량의 데이터 참조
    LayoutInflater inflater;     //MainActivity 에서 받아오기

    //생성자메소드
    public MyAdapter(ArrayList<Integer> items, LayoutInflater inflater){
        this.items= items;
        this.inflater= inflater;
    }



    //이 아답터가 만들 page 의 총 개수를 리턴(즉, 데이터의 개수)
    @Override
    public int getCount() {
        return items.size();
    }



    //이 아답터가 page.xml 설계도면을 기반으로
    //ViewPage 에 보여질 한 페이지(View 객체)를 만들어내는 작업 메소드가 따로 있어야함
    //ex) ListView 에 사용되는 아답터의 getView 같은 메소드임
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //page.xml 문서를 읽어와서 View 객체로 만들기(부풀리다)
        View page= inflater.inflate(R.layout.page, null);

        //이 페이지 안에있는 ImageView 에 현재번째(position) 이미지를 설정
        ImageView iv= page.findViewById(R.id.iv);
        iv.setImageResource(items.get(position));

        //만들어진 page를 ViewPager 에 첫번째 파라미터:container 에 추가하기
        container.addView(page);

        return page;   //만들어진 페이지 뷰 객체 리턴: 화면에 보여주려고 하는게 아니라 '검증'을 위한것
    }


    //화면에서 더이상 보이지않아 메모리에서 페이지를 제거하라는 메소드
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


    //위에서 만든 instateItem()메소드에서 만들어서 리턴한 page 가 이 메소드의 2번째 파라미터로 전달됨
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;   //뷰 페이저가 보여줄 view 와 위에서 만든 page(바로 위에있는 object) 객체가 같은지를 리턴
    }
}
