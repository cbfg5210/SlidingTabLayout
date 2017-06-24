package com.ue.slidingtablayoutdemo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.ue.slidingtablayout.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {
    private static final String[] TAB_NAMES = new String[]{"微笑", "傻笑", "卖萌"};
    private static final int[] TAB_ICONS = new int[]{R.mipmap.ee_1, R.mipmap.ee_2, R.mipmap.ee_3};

    private ViewPager vpMainPager;
    private SlidingTabLayout slidingTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vpMainPager = (ViewPager) findViewById(R.id.vp_main_pager);
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tab_layout);

        vpMainPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return TestFragment.newInstance(position);
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                String title = TAB_NAMES[position];
                int titleIcon = TAB_ICONS[position];

                SpannableString msp = new SpannableString("  " + title);
                Drawable rightDrawable = getResources().getDrawable(titleIcon);
                rightDrawable.setBounds(0, 0,
                        rightDrawable.getIntrinsicWidth(), rightDrawable.getIntrinsicHeight());
                msp.setSpan(new ImageSpan(rightDrawable, ImageSpan.ALIGN_BOTTOM), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                return msp;
            }
        });

        slidingTabLayout.setOnTabSelectListener(new SlidingTabLayout.OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vpMainPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
        slidingTabLayout.setViewPager(vpMainPager);
    }
}
