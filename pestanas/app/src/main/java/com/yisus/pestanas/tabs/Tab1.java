package com.yisus.pestanas.tabs;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.yisus.pestanas.R;

public class Tab1 extends Fragment {
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
    }

    @Override
    public View onCreateView(LayoutInflater li, ViewGroup vg, Bundle bn) {
        return li.inflate(R.layout.tab1, vg, false);
    }
}