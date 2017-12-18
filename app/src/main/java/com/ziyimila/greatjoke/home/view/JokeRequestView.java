package com.ziyimila.greatjoke.home.view;

import com.ziyimila.greatjoke.base.view.IBaseView;
import com.ziyimila.greatjoke.http.bean.TextContentJokeBean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/18.
 */

public interface JokeRequestView extends IBaseView{
    void updateData(List<TextContentJokeBean> mList);
}
