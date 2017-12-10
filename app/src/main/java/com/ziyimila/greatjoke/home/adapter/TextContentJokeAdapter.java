package com.ziyimila.greatjoke.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.ziyimila.greatjoke.http.bean.TextContentJokeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/10.
 */

public class TextContentJokeAdapter extends RecyclerView.Adapter<TextContentJokeAdapter.ViewHolder> {

    private List<TextContentJokeBean> mTextContentJokeLists;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{



        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
