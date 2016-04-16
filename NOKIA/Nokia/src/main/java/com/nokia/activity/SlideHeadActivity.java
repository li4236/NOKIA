package com.nokia.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.nokia.R;
import com.nokia.view.CustomScrollView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by li4236 on 16/4/16.
 * 滑动头部
 */
public class SlideHeadActivity extends AppCompatActivity implements CustomScrollView.OnScrollListener {


    @Bind(R.id.slideScroll)
    CustomScrollView slideScroll;
    @Bind(R.id.headLayout)
    LinearLayout headLayout;
    @Bind(R.id.firstIv)
    ImageView firstIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_slide_main);

        ButterKnife.bind(this);

        slideScroll.setOnScrollListener(this);

        initview();
    }

    private void initview() {

        //初始化头部的为透明

        headLayout.getBackground().setAlpha(0);
    }


    @Override
    public void onScroll(int scrollY) {

        //当滑动红色的时候，头部的就变成不透明的

        int height = 0;
        if (scrollY <= 0)//滑动scollview scrolly往上滑的时候回变成负值
        {
            height = 0;
        }else
        {
            height = headLayout.getHeight() + scrollY;
        }

        float ratio = Math.min((float) height/firstIv.getHeight(),1.0f);

        headLayout.getBackground().setAlpha((int)(ratio * 0xFF));


    }
}
