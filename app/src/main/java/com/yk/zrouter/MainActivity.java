package com.yk.zrouter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.yk.myzarouterlibrary.BinViewTools;
import com.yk.zapt_annotation.annotation.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_hello)
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BinViewTools.bind(this);
        textView.setText("Bind textview success");
    }
}