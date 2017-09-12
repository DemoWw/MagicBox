package com.wuwei.magicbox.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.wuwei.magicbox.magicbox.R;
import com.wuwei.magicbox.ui.MainActivity;

import butterknife.BindView;

/**
 * Created by tarena on 2017/9/5.
 */

public class Fragment02 extends Fragment {
    @BindView(R.id.btn_test)
    Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment02, container, false);

        //MainActivity mainActivity = (MainActivity) getActivity();
        //mainActivity.btnClick(null);

        return view;
    }


}
