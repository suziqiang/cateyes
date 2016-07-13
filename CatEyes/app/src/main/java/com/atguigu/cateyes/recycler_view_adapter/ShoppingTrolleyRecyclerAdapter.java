package com.atguigu.cateyes.recycler_view_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.Untils.CartProvider;
import com.atguigu.cateyes.Untils.NumberAddSubView;
import com.atguigu.cateyes.bean.ShoppingCartBean;

import org.xutils.x;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/7/5 0005.
 */
public class ShoppingTrolleyRecyclerAdapter extends RecyclerView.Adapter<ShoppingTrolleyRecyclerAdapter.MyViewHolder> {


    private  CheckBox checkbox_total_price;
    private  TextView tv_total_price;
    private  Context context;
    private  List<ShoppingCartBean> data;
    private ShoppingCartBean shoppingCartBean;
    private View itemView;
    private CartProvider cartProvider;

    public ShoppingTrolleyRecyclerAdapter(Context context, final List<ShoppingCartBean> data, final CheckBox checkbox_total_price, TextView tv_total_price) {
        this.context=context;
        this.data=data;
        this.checkbox_total_price=checkbox_total_price;
        this.tv_total_price=tv_total_price;
        cartProvider=new CartProvider(context);
        showTotalPrice();

        checkAll_none();
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ShoppingCartBean shoppingCartBean = data.get(position);
                shoppingCartBean.setIschecked(!shoppingCartBean.ischecked());
                notifyItemChanged(position);
                //2.校验全选按钮的状态
                checkAll_none();
                //3.显示总价格
                showTotalPrice();
            }
        });
        //设置CheckBox的点击事件
        checkbox_total_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //1. 得到状态，如果是选中，就把所有数据设置勾选；如果状态是非勾选，设置全部为不选择
                all_none(checkbox_total_price.isChecked());

                //2.显示总价格
                showTotalPrice();
            }
        });

     }

    /**
     * 全选和非全选
     * @param ischeck
     */
    public void all_none(boolean ischeck) {
        if(data!= null && data.size() >0){
            for(int i=0;i<data.size();i++){
                ShoppingCartBean shoppingCartBean = data.get(i);
                shoppingCartBean.setIschecked(ischeck);
                notifyItemChanged(i);
            }

            if(data.size()>0){
                checkbox_total_price.setVisibility(View.VISIBLE);
            }else{
                checkbox_total_price.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 全选和非全选
     */
    public void checkAll_none() {
        if(data != null && data.size() >0){

            int number = 0;

            for (int i=0;i<data.size();i++){

                ShoppingCartBean shoppingCartBean = data.get(i);

                if(!shoppingCartBean.ischecked()){//只要有一个不被选中，就设置全选为非勾选状态
                    //没选择的
                    checkbox_total_price.setChecked(false);
                }else{
                    //选中的
                    number += 1;
                }
            }

            if(number ==data.size()){
                checkbox_total_price.setChecked(true);
            }

            if(data.size()>0){
                checkbox_total_price.setVisibility(View.VISIBLE);
            }else{
                checkbox_total_price.setVisibility(View.GONE);
            }

        }
    }

    /*设置下面的总价格*/
    private void showTotalPrice() {

        if(tv_total_price!=null){
            tv_total_price.setText(getTotalPrice() + "");
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         itemView = LayoutInflater.from(context).inflate(R.layout.item_govaffair_pager, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

         shoppingCartBean = data.get(position);
        x.image().bind(holder.iv_icon, shoppingCartBean.getBuyPic());
        holder.tv_name.setText(shoppingCartBean.getTitle());
        holder.tv_price.setText(shoppingCartBean.getPrice() + "");
        holder.number_add_sub_view.setValue(shoppingCartBean.getCount());
       holder.checkbox.setChecked(data.get(position).ischecked());

       /*给+-按钮设置监听*/
        holder.number_add_sub_view.setOnButtonClickListener(new MyOnButtonClickListener());
    }

    public void deleteData() {
        if (data != null && data.size() > 0) {
            for (Iterator iterator = data.iterator(); iterator.hasNext();) {
                ShoppingCartBean cart = (ShoppingCartBean) iterator.next();
               if(cart.ischecked()){
                   int position = data.indexOf(cart);
                   cartProvider.delete(cart);
                    iterator.remove();//移除数据
                    notifyItemRemoved(position);
               }
            }
            if(data.size()>0){
                checkbox_total_price.setVisibility(View.VISIBLE);
            }else{
                checkbox_total_price.setVisibility(View.GONE);
            }

        }
    }
/*    *//**
     * 删除选中的数据，并且刷新
     *//*
    public void deleteData() {
        if(datas != null && datas.size() >0){

            for(Iterator iterator = datas.iterator();iterator.hasNext();){
                ShoppingCart cart = (ShoppingCart) iterator.next();
                if(cart.isCheck()){
                    int position = datas.indexOf(cart);
                    iterator.remove();//移除数据
                    cartProvider.delete(cart);
                    notifyItemRemoved(position);//当移除的时候用这个刷新
                }
            }

            if(datas.size()>0){
                checkbox_all.setVisibility(View.VISIBLE);
            }else{
                checkbox_all.setVisibility(View.GONE);
            }
        }
    }*/

    class MyViewHolder extends RecyclerView.ViewHolder{
        private CheckBox checkbox;
        private ImageView iv_icon;
        private TextView tv_name;
        private TextView tv_price;
        private NumberAddSubView number_add_sub_view;

        public MyViewHolder(View itemView) {
            super(itemView);
            checkbox= (CheckBox) itemView.findViewById(R.id.checkbox);
            iv_icon= (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);
            tv_price= (TextView) itemView.findViewById(R.id.tv_price);
            number_add_sub_view= (NumberAddSubView) itemView.findViewById(R.id.number_add_sub_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onitemclicklistener!=null){
                        onitemclicklistener.onItemClick(v,getLayoutPosition());
                    }
                }
            });

        }
    }

    private class MyOnButtonClickListener implements NumberAddSubView.OnButtonClickListener {
        @Override
        public void onSubButton(View view, int value) {
            shoppingCartBean.setCount(value);
            cartProvider.update(shoppingCartBean);
            showTotalPrice();
        }



        @Override
        public void onAddButton(View view, int value) {
            shoppingCartBean.setCount(value);
            cartProvider.update(shoppingCartBean);
            showTotalPrice();
        }
    }
    /*得到总价格*/
     public  float getTotalPrice() {
        float totalPrice=0;

        if(data!=null&&data.size()>0){

            for(int x=0;x<data.size();x++){
                ShoppingCartBean shoppingCartBean = data.get(x);
                //只是计算勾选的产品
                if(shoppingCartBean.ischecked()){
                    totalPrice=totalPrice+shoppingCartBean.getCount() * shoppingCartBean.getPrice();
                }


            }
        }
        return totalPrice;
    }
    private OnItemClickListener onitemclicklistener;
    /*设置点击莫一条的接口*/
    public interface  OnItemClickListener{
        /**
         * 当某一条被点击的时候回调这个方法
         * @param view
         * @param position
         */
        public void onItemClick(View view,int position);
    }
    public void  setOnItemClickListener(OnItemClickListener l){
        this.onitemclicklistener=l;

    }
}
