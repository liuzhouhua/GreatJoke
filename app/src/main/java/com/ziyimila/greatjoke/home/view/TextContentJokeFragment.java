package com.ziyimila.greatjoke.home.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ziyimila.greatjoke.R;
import com.ziyimila.greatjoke.base.annotation.CreatePresenter;
import com.ziyimila.greatjoke.base.view.BaseFragment;
import com.ziyimila.greatjoke.home.adapter.TextContentJokeAdapter;
import com.ziyimila.greatjoke.home.presenter.JokeRequestPresenter;
import com.ziyimila.greatjoke.http.bean.TextContentJokeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/10.
 */

@CreatePresenter(JokeRequestPresenter.class)
public class TextContentJokeFragment extends BaseFragment<JokeRequestView,JokeRequestPresenter>
        implements JokeRequestView{

    private List<TextContentJokeBean> mLists = new ArrayList<>();
    private TextContentJokeAdapter adapter;

    public static TextContentJokeFragment newInstance(){
        return new TextContentJokeFragment();
    }

    @Override
    protected void initData() {
        getPresenter().getContextJoke();
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new TextContentJokeAdapter(mLists);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_joke;
    }

    @Override
    public void updateData(List<TextContentJokeBean> mList) {
        mLists = mList;
        adapter.notifyDataSetChanged();
    }
}
