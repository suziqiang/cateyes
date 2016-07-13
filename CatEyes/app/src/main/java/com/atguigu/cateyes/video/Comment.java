package com.atguigu.cateyes.video;

import android.content.Context;
import android.view.View;

import com.atguigu.cateyes.R;
import com.atguigu.cateyes.country_movie_base_page.CountryMoveBase;

/**
 * Created by Administrator on 2016/7/3 0003.
 */
public class Comment extends CountryMoveBase {
    public Comment(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View commentView = View.inflate(context, R.layout.comment, null);
        return commentView;
    }
}
