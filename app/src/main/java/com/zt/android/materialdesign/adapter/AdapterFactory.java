package com.zt.android.materialdesign.adapter;

import android.content.Context;
import android.widget.SimpleAdapter;

import com.zt.android.materialdesign.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tony on 16/10/27.
 */

public class AdapterFactory {
    public static SimpleAdapter generateListStrAdapter(Context context, List<String> data){
        List<Map<String,String>> list=new ArrayList<>();
        for (String str : data) {
            Map<String,String> map=new HashMap<>();
            map.put("Title",str);
            list.add(map);
        }
        return new SimpleAdapter(context,list,R.layout.list_item1,new String[]{"Title"},new int[]{R.id.textView});
    }

    public static List<String> generateListString(int length){
        List<String> strings=new ArrayList<>();
        for (int i = 0; i < length; i++) {
            strings.add("data"+i);
        }
        return strings;
    }
}
