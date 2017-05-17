package me.kiuber.school.qau.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.kiuber.school.qau.R;

/**
 * Created 2017/5/17 0017 19:35
 * Author Kiuber
 * Description
 */

public class DataFragment extends Fragment {
    View view = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_data, null);
        return view;
    }
}
