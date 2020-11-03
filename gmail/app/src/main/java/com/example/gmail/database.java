package com.example.gmail;

import android.telephony.ims.RcsUceAdapter;

import java.util.ArrayList;
import java.util.List;

public class database {
    public String[] title ={"Title 1","Title 2","Title 3","Title 4","Title 5","Title 6","Title 7","Title 8","Title 9","Title 10","Title 11","Title 12","Title 13","Title 14","Title 15"};
    public String[] description = {"Đây là mô tả nội dung cho tiêu đề 1",
            "Đây là mô tả nội dung cho tiêu đề 2",
            "Đây là mô tả nội dung cho tiêu đề 3",
            "Đây là mô tả nội dung cho tiêu đề 4",
            "Đây là mô tả nội dung cho tiêu đề 5",
            "Đây là mô tả nội dung cho tiêu đề 6",
            "Đây là mô tả nội dung cho tiêu đề 7",
            "Đây là mô tả nội dung cho tiêu đề 8",
            "Đây là mô tả nội dung cho tiêu đề 9",
            "Đây là mô tả nội dung cho tiêu đề 10",
            "Đây là mô tả nội dung cho tiêu đề 11",
            "Đây là mô tả nội dung cho tiêu đề 12",
            "Đây là mô tả nội dung cho tiêu đề 13",
            "Đây là mô tả nội dung cho tiêu đề 14",
            "Đây là mô tả nội dung cho tiêu đề 15"};
    public String[] time = {"9:46 AM","8:30 PM","8:30 PM","8:30 PM","8:30 PM","8:30 PM","8:30 PM","8:30 PM","8:30 PM","8:30 PM","8:30 PM","8:30 PM","8:30 PM","8:30 PM","8:30 PM"};
    public Integer[] Image={
            R.drawable.thumb1,
            R.drawable.thumb2,
            R.drawable.thumb3,
            R.drawable.thumb4,
            R.drawable.thumb5,
            R.drawable.thumb6,
            R.drawable.thumb7,
            R.drawable.thumb8,
            R.drawable.thumb9,
            R.drawable.thumb10,
            R.drawable.thumb11,
            R.drawable.thumb12,
            R.drawable.thumb13,
            R.drawable.thumb14,
            R.drawable.thumb15};

    public class DbRecord {
        public String title;
        public String description;
        public String time;
        public Integer Image;

        public DbRecord(String title,String description,String time,Integer Image){
            this.title=title;
            this.description=description;
            this.time=time;
            this.Image=Image;
        }}
        public ArrayList<DbRecord> dbList = new ArrayList<DbRecord>();

        public database(){
            for (int i = 0; i < title.length ; i++) {
                dbList.add(new DbRecord(title[i],description[i],time[i],Image[i]));
            }
        }

}
