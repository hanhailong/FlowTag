package com.hhl.flowlayoutdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hhl.library.FlowTagLayout;
import com.hhl.library.OnTagClickListener;
import com.hhl.library.OnTagSelectListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FlowTagLayout mColorFlowTagLayout;
    private FlowTagLayout mSizeFlowTagLayout;
    private FlowTagLayout mMobileFlowTagLayout;
    private TagAdapter<String> mSizeTagAdapter;
    private TagAdapter<String> mColorTagAdapter;
    private TagAdapter<String> mMobileTagAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mColorFlowTagLayout = (FlowTagLayout) findViewById(R.id.color_flow_layout);
        mSizeFlowTagLayout = (FlowTagLayout) findViewById(R.id.size_flow_layout);
        mMobileFlowTagLayout = (FlowTagLayout) findViewById(R.id.mobile_flow_layout);

        //颜色
        mColorTagAdapter = new TagAdapter<>(this);
        mColorFlowTagLayout.setAdapter(mColorTagAdapter);
        mColorFlowTagLayout.setOnTagClickListener(new OnTagClickListener() {
            @Override
            public void onItemClick(FlowTagLayout parent, View view, int position) {
                Snackbar.make(view, "颜色:" + parent.getAdapter().getItem(position), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //尺寸
        mSizeTagAdapter = new TagAdapter<>(this);
        mSizeFlowTagLayout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_SINGLE);
        mSizeFlowTagLayout.setAdapter(mSizeTagAdapter);
        mSizeFlowTagLayout.setOnTagSelectListener(new OnTagSelectListener() {
            @Override
            public void onItemSelect(FlowTagLayout parent, List<Integer> selectedList) {
                if (selectedList != null && selectedList.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i : selectedList) {
                        sb.append(parent.getAdapter().getItem(i));
                        sb.append(":");
                    }
                    Snackbar.make(parent, "移动研发:" + sb.toString(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else{
                    Snackbar.make(parent, "没有选择标签", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        //移动研发标签
        mMobileTagAdapter = new TagAdapter<>(this);
        mMobileFlowTagLayout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_MULTI);
        mMobileFlowTagLayout.setAdapter(mMobileTagAdapter);
        mMobileFlowTagLayout.setOnTagSelectListener(new OnTagSelectListener() {
            @Override
            public void onItemSelect(FlowTagLayout parent, List<Integer> selectedList) {
                if (selectedList != null && selectedList.size() > 0) {
                    StringBuilder sb = new StringBuilder();

                    for (int i : selectedList) {
                        sb.append(parent.getAdapter().getItem(i));
                        sb.append(":");
                    }
                    Snackbar.make(parent, "移动研发:" + sb.toString(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }else{
                    Snackbar.make(parent, "没有选择标签", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        initColorData();

        initSizeData();

        initMobileData();

        //清除所有已经被选择的选项
        findViewById(R.id.bt_clear_all)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        mColorFlowTagLayout.clearAllOption();
                        mSizeFlowTagLayout.clearAllOption();
                        mMobileFlowTagLayout.clearAllOption();
                    }
                });
    }

    private void initMobileData() {
        List<String> dataSource = new ArrayList<>();
        dataSource.add("android");
        dataSource.add("安卓");
        dataSource.add("SDK源码");
        dataSource.add("IOS");
        dataSource.add("iPhone");
        dataSource.add("游戏");
        dataSource.add("fragment");
        dataSource.add("viewcontroller");
        dataSource.add("cocoachina");
        dataSource.add("移动研发工程师");
        dataSource.add("移动互联网");
        dataSource.add("高薪+期权");
        mMobileTagAdapter.onlyAddAll(dataSource);
    }

    private void initColorData() {
        List<String> dataSource = new ArrayList<>();
        dataSource.add("红色");
        dataSource.add("黑色");
        dataSource.add("花边色");
        dataSource.add("深蓝色");
        dataSource.add("白色");
        dataSource.add("玫瑰红色");
        dataSource.add("紫黑紫兰色");
        dataSource.add("葡萄红色");
        dataSource.add("屎黄色");
        dataSource.add("绿色");
        dataSource.add("彩虹色");
        dataSource.add("牡丹色");
        mColorTagAdapter.onlyAddAll(dataSource);
    }

    /**
     * 初始化数据
     */
    private void initSizeData() {
        List<String> dataSource = new ArrayList<>();
        dataSource.add("28 (2.1尺)");
        dataSource.add("29 (2.2尺)");
        dataSource.add("30 (2.3尺)");
        dataSource.add("31 (2.4尺)");
        dataSource.add("32 (2.5尺)........");
        dataSource.add("33 (2.6尺)");
        dataSource.add("34 (2.7尺)");
        dataSource.add("35 (2.8尺)");
        dataSource.add("36 (2.9尺)");
        dataSource.add("37 (3.0尺)");
        dataSource.add("38 (3.1尺)");
        dataSource.add("39 (3.2尺)........");
        mSizeTagAdapter.onlyAddAll(dataSource);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
