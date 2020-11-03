package com.example.gmail;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    int layoutToBeInflated;
    List<database.DbRecord> dbList;

    public CustomBaseAdapter(Context context, List<database.DbRecord> databaselist, int resourse){
        this.context=context;
        this.dbList=databaselist;
        layoutToBeInflated=resourse;
    }


    @Override
    public int getCount() {
        return dbList.size();
    }

    @Override
    public Object getItem(int position) {
        return dbList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater inflater =((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(layoutToBeInflated,null);
            viewHolder = new ViewHolder();
            viewHolder.textTitle = convertView.findViewById(R.id.textTitle);
            viewHolder.textDes = convertView.findViewById(R.id.textdes);
            viewHolder.textTime = convertView.findViewById(R.id.textTime);
            viewHolder.image1 = convertView.findViewById(R.id.Image1);
            viewHolder.image2 = convertView.findViewById(R.id.Image2);

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        database.DbRecord dbRec = (database.DbRecord) getItem(position);
        viewHolder.textTitle.setText(dbRec.title);
        viewHolder.textDes.setText(dbRec.description);
        viewHolder.textTime.setText(dbRec.time);
        viewHolder.image1.setImageResource(dbRec.Image);
        viewHolder.image2.setImageResource(R.drawable.image1);

        return convertView;

    }
    public class ViewHolder{
        TextView textTitle;
        TextView textDes;
        TextView textTime;
        ImageView image1;
        ImageView image2;
    }
}
