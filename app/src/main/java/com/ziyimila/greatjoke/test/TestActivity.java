package com.ziyimila.greatjoke.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ziyimila.greatjoke.R;
import com.ziyimila.greatjoke.Utils.LogUtils;
import com.ziyimila.greatjoke.base.annotation.CreatePresenter;
import com.ziyimila.greatjoke.base.view.BaseActivity;

/**
 * Created by lzh27651 on 2017/12/8.
 */

@CreatePresenter(RequestPresenter.class)
public class TestActivity extends BaseActivity<RequestView,RequestPresenter> implements RequestView {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = (TextView) findViewById(R.id.text);
        Button button = (Button) findViewById(R.id.button);

        //设置自己的Presenter工厂，如果你想自定义的话
        //如果要设置自己的Presenter创建工厂
        //必须在调用onResume方法和getMvpPresenter方法之前设置
        //setPresenterFactory(xxx);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().getContextJoke();
            }
        });

        if(savedInstanceState!=null){
            LogUtils.i("TestActivity onCreate 测试 = "+savedInstanceState.getString("test1"));
        }
    }


    @Override
    public void showText(String message) {
        textView.setText(message);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtils.i("TestActivity onSaveInstanceState 测试");
        outState.putString("test1","test_save1");
    }
}
