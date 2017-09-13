package com.wuwei.magicbox.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.wuwei.magicbox.entity.Fruit;
import com.wuwei.magicbox.magicbox.R;
import com.wuwei.magicbox.ui.MainActivity;
import com.wuwei.magicbox.ui.detector.RecyclerViewScrollDetector;
import com.wuwei.magicbox.ui.adapter.FruitAdapter;
import com.wuwei.magicbox.ui.detector.ViewScrollDetector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wuwei on 2017/9/5.
 */

public class Fragment01 extends Fragment {

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    private List<Fruit> fruits = new ArrayList<>();
    private FruitAdapter adapter;

    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01, null);

        ButterKnife.bind(this, view);

        mainActivity = (MainActivity) getActivity();

        refreshLayout.setColorSchemeResources(R.color.colorPrimary,
                R.color.colorAccent,
                R.color.yellow);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });


        // 测试列表，滑动效果

        initialFruits();

        adapter = new FruitAdapter();
        final StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.addFruits(fruits);


//        recyclerView.setOnTouchListener(new ViewScrollDetector() {
//            @Override
//            public void onScrollingUp() {
//                mainActivity.setBottomVisibility(false);
//            }
//
//            @Override
//            public void onScrollingDown() {
//                mainActivity.setBottomVisibility(true);
//            }
//        });

        return view;
    }

    private void initialFruits() {
        for(int i=0;i<2;i++){
            Fruit apple=new Fruit(getFruitsName("apple"),R.drawable.apple_pic);
            fruits.add(apple);
            Fruit banaba=new Fruit(getFruitsName("banana"),R.drawable.banana_pic);
            fruits.add(banaba);
            Fruit pear=new Fruit(getFruitsName("pear"),R.drawable.pear_pic);
            fruits.add(pear);
            Fruit watermalon=new Fruit(getFruitsName("watermalon"),R.drawable.watermelon_pic);
            fruits.add(watermalon);
            Fruit pineapple=new Fruit(getFruitsName("pineapple"),R.drawable.pineapple_pic);
            fruits.add(pineapple);
            Fruit cherry=new Fruit(getFruitsName("cherry"),R.drawable.cherry_pic);
            fruits.add(cherry);
            Fruit grape=new Fruit(getFruitsName("grape"),R.drawable.grape_pic);
            fruits.add(grape);
        }

    }

    private String getFruitsName(String name){
        Random random=new Random();
        //生成随机数据的长度
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }

}
