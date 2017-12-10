package com.ziyimila.greatjoke.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ziyimila.greatjoke.R;
import com.ziyimila.greatjoke.base.view.BaseFragment;

/**
 * Created by Administrator on 2017/12/10.
 */

public class TextContentJokeFragment extends BaseFragment {
    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_joke;
    }
}
