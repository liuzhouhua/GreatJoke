package com.ziyimila.greatjoke;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.ziyimila.greatjoke.home.adapter.HomeFragmentPagerAdapter;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar_main);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_main);
        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.tool_bar_home);
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        TextView toolbar_title = (TextView) findViewById(R.id.tool_bar_title);
        toolbar_title.setText("微信");

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_page_main);
        HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_main);
        tabLayout.setupWithViewPager(viewPager);
/*
        RetrofitFactory.getInstance().API().getImageJoke("1","20")
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<ImageJokeBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity<ImageJokeBean> imageJokeBeanBaseEntity) {
                        if(imageJokeBeanBaseEntity.getShowapi_res_code()==0){
                            Gson gson = new Gson();
                            String tr = gson.toJson(imageJokeBeanBaseEntity.getShowapi_res_body().getContentlist().get(0),ImageJokeBean.class);
                            LogUtils.d("成功 :"+tr);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        RetrofitFactory.getInstance().API().getGifJoke("1","20")
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<GifJokeBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseEntity<GifJokeBean> gifJokeBeanBaseEntity) {
                        if(gifJokeBeanBaseEntity.getShowapi_res_code()==0){
                            Gson gson = new Gson();
                            String tr = gson.toJson(gifJokeBeanBaseEntity.getShowapi_res_body().getContentlist().get(0),GifJokeBean.class);
                            LogUtils.d("成功 :"+tr);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
                */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
}
