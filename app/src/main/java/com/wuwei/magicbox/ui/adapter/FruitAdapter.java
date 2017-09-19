package com.wuwei.magicbox.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.wuwei.magicbox.entity.Fruit;
import com.wuwei.magicbox.magicbox.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wuwei on 2017/8/23.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {
    private List<Fruit> fruits=new ArrayList<Fruit>();

    public void addFruits(List<Fruit> fruitList){
        if(fruitList!=null){
            this.fruits.addAll(fruitList);
            notifyDataSetChanged();
        }
    }
    @Override
    public FruitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.fruit_item_layout,parent,false);
        //创建一个holder对象
        FruitViewHolder holder=new FruitViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(FruitViewHolder holder, int position) {
       Fruit fruit =fruits.get(position);
        holder.imageView_Fruit.setImageResource(fruit.getImageId());
        holder.textView_Name.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public  static class FruitViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView_Fruit;
        TextView textView_Name;
        public FruitViewHolder(View itemView) {
            super(itemView);
            imageView_Fruit=
                    (ImageView) itemView.findViewById(
                    R.id.imageView_Fruit);
            textView_Name=
                    (TextView) itemView.findViewById(
                    R.id.textView_Fruit);
        }
    }
}
