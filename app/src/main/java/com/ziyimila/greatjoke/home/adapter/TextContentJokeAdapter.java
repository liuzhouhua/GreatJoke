package com.ziyimila.greatjoke.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ziyimila.greatjoke.R;
import com.ziyimila.greatjoke.http.bean.TextContentJokeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/10.
 */

public class TextContentJokeAdapter extends RecyclerView.Adapter<TextContentJokeAdapter.ViewHolder> {

    private List<TextContentJokeBean> mTextContentJokeLists;

    public TextContentJokeAdapter(List<TextContentJokeBean> mTextContentJokeLists) {
        this.mTextContentJokeLists = mTextContentJokeLists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_joke_text_content_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextContentJokeBean contentJokeBean = mTextContentJokeLists.get(position);
        holder.setmTitle(contentJokeBean.getTitle());
        holder.setmContent(contentJokeBean.getText());
    }

    @Override
    public int getItemCount() {
        return mTextContentJokeLists.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTitle;
        private TextView mContent;
        private ImageView mLikeImage;
        private ImageView mAgree;
        private TextView mAgreeCount;
        private ImageView mNotAgree;
        private TextView mNotAgreeCount;
        private ImageView mShare;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle= (TextView) itemView.findViewById(R.id.text_content_joke_title);
            mContent = (TextView) itemView.findViewById(R.id.text_content_joke_content);
            mLikeImage = (ImageView) itemView.findViewById(R.id.text_content_joke_collect);
            mAgree = (ImageView) itemView.findViewById(R.id.text_content_joke_agree);
            mAgreeCount = (TextView) itemView.findViewById(R.id.text_content_joke_agree_count);
            mNotAgree = (ImageView) itemView.findViewById(R.id.text_content_joke_disagree);
            mNotAgreeCount = (TextView) itemView.findViewById(R.id.text_content_joke_disagree_count);
            mShare = (ImageView) itemView.findViewById(R.id.text_content_joke_share);
        }

        public void setmTitle(String mTitle) {
            this.mTitle.setText(mTitle);
        }

        public void setmContent(String mContent) {
            this.mContent.setText(mContent);
        }
    }

}
