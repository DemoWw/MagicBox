package com.wuwei.magicbox.ui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

import com.wuwei.magicbox.magicbox.R;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.text)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView.setText("123456");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00ff00")));

        // TODO: table layout...

    }

    @Override
    protected void init() {

    }
}
