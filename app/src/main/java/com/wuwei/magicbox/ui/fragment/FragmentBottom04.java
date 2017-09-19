package com.wuwei.magicbox.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.wuwei.magicbox.magicbox.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wuwei on 2017/9/13.
 */

public class FragmentBottom04 extends Fragment {

    @BindView(R.id.btn_me_login)
    Button mBtnlogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bottom04, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick({R.id.btn_me_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_me_login:
                Toast.makeText(getActivity(), "nihao", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
