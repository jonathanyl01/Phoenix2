package com.example.administrator.phoenix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshView mPullToRefresh;
    private ListView mListView;
    private List mList = new ArrayList();
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPullToRefresh = (PullToRefreshView) findViewById(R.id.pull_to_refresh);
        mListView = (ListView) findViewById(R.id.listview);
        initData();
        initAdapter();

        mPullToRefresh.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        mAdapter.clear();
                        loadMore();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                mAdapter.notifyDataSetChanged();

                                mPullToRefresh.setRefreshing(false);

                            }
                        });


                    }
                }).start();

            }
        });
    }

    private void initAdapter() {
        mAdapter = new MyAdapter(this);
        mListView.setAdapter(mAdapter);
        mAdapter.setData(mList);

    }

    private void initData() {

        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);
        mList.add(R.mipmap.ic_launcher);

    }

    private void loadMore() {
        mList.add(R.drawable.image_holder_banner);
        mList.add(R.drawable.image_holder_banner);
        mList.add(R.drawable.image_holder_banner);
        mList.add(R.drawable.image_holder_banner);
        mList.add(R.drawable.image_holder_banner);
        mList.add(R.drawable.image_holder_banner);
        mList.add(R.drawable.image_holder_banner);

    }
}
