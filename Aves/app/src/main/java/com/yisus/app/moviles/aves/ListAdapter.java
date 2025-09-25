package com.yisus.app.moviles.aves;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public abstract class ListAdapter extends BaseAdapter {
    private final ArrayList<InputList> arrayList;
    private final int R_layout_IdView;
    private final Context context;

    public ListAdapter(Context context, int r_layout_IdView, ArrayList<InputList> arrayList) {
        super();
        this.arrayList = arrayList;
        R_layout_IdView = r_layout_IdView;
        this.context = context;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater vi= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=vi.inflate(R_layout_IdView,null);
        }
        onEntrada(arrayList.get(i),view);
        return view;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    public abstract void onEntrada(Object o,View view);

}
