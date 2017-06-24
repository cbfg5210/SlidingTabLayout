package com.ue.slidingtablayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hawk on 2017/6/24.
 */

public class TestFragment extends Fragment {
    private static final String ARG_INDEX = "arg_index";
    private int index;

    public static TestFragment newInstance(int index) {
        TestFragment testFragment = new TestFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARG_INDEX, index);
        testFragment.setArguments(arguments);
        return testFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            index = arguments.getInt(ARG_INDEX);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layoutView = inflater.inflate(R.layout.fragment_test, null);
        TextView tv_fragment_text = (TextView) layoutView.findViewById(R.id.tv_fragment_text);
        tv_fragment_text.setText("This is fragment" + index);

        return layoutView;
    }
}
