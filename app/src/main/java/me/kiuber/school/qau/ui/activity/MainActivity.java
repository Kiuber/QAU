package me.kiuber.school.qau.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import me.kiuber.school.qau.R;
import me.kiuber.school.qau.adapter.MyPageAdapter;
import me.kiuber.school.qau.ui.fragment.DataFragment;
import me.kiuber.school.qau.ui.fragment.DynamicFragment;
import me.kiuber.school.qau.ui.fragment.FriendFragment;
import me.kiuber.school.qau.ui.fragment.MyFragment;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private ViewPager   mVpContent;
    private RadioGroup  mRgTabs;
    private RadioButton mRbDynamic;
    private RadioButton mRbData;
    private RadioButton mRbFriend;
    private RadioButton mRbMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVpContent = (ViewPager) findViewById(R.id.vp_content);
        mRgTabs = (RadioGroup) findViewById(R.id.rg_tabs);
        mRbDynamic = (RadioButton) findViewById(R.id.rb_dynamic);
        mRbData = (RadioButton) findViewById(R.id.rb_data);
        mRbFriend = (RadioButton) findViewById(R.id.rb_friend);
        mRbMy = (RadioButton) findViewById(R.id.rb_my);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new DynamicFragment());
        fragments.add(new DataFragment());
        fragments.add(new FriendFragment());
        fragments.add(new MyFragment());
        mVpContent.setAdapter(new MyPageAdapter(getSupportFragmentManager(), fragments));
        mRgTabs.setOnCheckedChangeListener(this);
        mVpContent.addOnPageChangeListener(this);
        mRbDynamic.setChecked(true);
        mVpContent.setCurrentItem(0);
        mVpContent.setOffscreenPageLimit(4);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_dynamic:
                mVpContent.setCurrentItem(0);
                break;
            case R.id.rb_data:
                mVpContent.setCurrentItem(1);
                break;
            case R.id.rb_friend:
                mVpContent.setCurrentItem(2);
                break;
            case R.id.rb_my:
                mVpContent.setCurrentItem(3);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == ViewPager.SCROLL_STATE_SETTLING) {
            //滑动已完成
            switch (mVpContent.getCurrentItem()) {
                case 0:
                    mRbDynamic.setChecked(true);
                    break;
                case 1:
                    mRbData.setChecked(true);
                    break;
                case 2:
                    mRbFriend.setChecked(true);
                    break;
                case 3:
                    mRbMy.setChecked(true);
                    break;
            }
        }
    }
}
