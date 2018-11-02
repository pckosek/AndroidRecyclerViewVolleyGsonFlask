package com.example.pckosek.recyclervolley;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.MyViewHolder> {


    /* ------------------------*/
    /*    member variables     */
    private List<RestaurantOrder> restaurantOrderList;

    /* ------------------------*/
    /*    constructor          */
    public OrderItemAdapter(List<RestaurantOrder> restaurantOrderList) {
        this.restaurantOrderList = restaurantOrderList;
    }


    /* ------------------------------------------*/
    /*    LIFECYCLE METHODS                      */

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RestaurantOrder restaurantOrder= restaurantOrderList.get(position);
        holder.tvOrderChoice.setText(restaurantOrder.getChoice());
        holder.tvOrderCost.setText(restaurantOrder.getOrderCostString());
        holder.tvOrderNumber.setText(restaurantOrder.getOrderNumberString());
    }

    /* ------------------------------------------*/
    /*    INTERFACE METHODS                      */

    @Override
    public int getItemCount() {
        return restaurantOrderList.size();
    }

    /* ------------------------------------------*/
    /*    SUPPORT CLASSES                      */

    //   THE [JAVA] CLASS STRUCTURE OF A SINGLE RecyclerView ROW
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvOrderChoice, tvOrderCost, tvOrderNumber;

        public MyViewHolder(View view) {
            super(view);
            tvOrderChoice= (TextView) view.findViewById(R.id.rv_choice);
            tvOrderCost = (TextView) view.findViewById(R.id.rv_cost);
            tvOrderNumber = (TextView) view.findViewById(R.id.rv_number);
        }
    }
}