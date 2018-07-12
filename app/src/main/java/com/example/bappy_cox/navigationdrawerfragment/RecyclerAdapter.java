package com.example.bappy_cox.navigationdrawerfragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by BAPPY-COX on 7/3/2018.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.holder>{

    //--initialize global variable--//
    private List<News> employeelist;
    private Context context;


    //--step:2 define constructor--//
    public RecyclerAdapter(List<News> employeelist, Context context) {
        this.employeelist = employeelist;
        this.context = context;
    }

    //---override method--//

    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //--binding data--//
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(holder holder,final int position) {
        Picasso.with(context).load(employeelist.get(position).getImage()).placeholder(R.mipmap.ic_launcher_round).into(holder.empImage);
        holder.empname.setText(employeelist.get(position).getTitle());
        holder.empdesignation.setText(employeelist.get(position).getCategory());
        holder.empdate.setText(employeelist.get(position).getDate());
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               String a = employeelist.get(position).getTitle();
               String b = employeelist.get(position).getImage();
               String c = employeelist.get(position).getCategory();
               String e = employeelist.get(position).getWriter();
               String d = employeelist.get(position).getDate();
               String f = employeelist.get(position).getDetails();

               Intent intent = new Intent(context,DetailsActivity.class);
               intent.putExtra("title",a);
               intent.putExtra("image",b);
               intent.putExtra("category",c);
               intent.putExtra("writer",e);
               intent.putExtra("date",d);
               intent.putExtra("details",f);

               context.startActivity(intent);
           }
       });

    }

    @Override
    public int getItemCount() {
        return employeelist.size();
    }

    //--step 1: initialize a holder clss with viewholder--//

    class holder extends RecyclerView.ViewHolder
    {
        //--initialize variable--//
        ImageView empImage;
        TextView empname;
        TextView empdesignation;
        TextView empdate;




        public holder(View itemView) {
            super(itemView);

            empImage=itemView.findViewById(R.id.profileimage);
            empname=itemView.findViewById(R.id.pname);
            empdesignation=itemView.findViewById(R.id.pdesignation);
            empdate=itemView.findViewById(R.id.pdate);

        }
    }

}