package com.marvhong.baseframe.ui.home.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.marvhong.baseframe.R;
import com.marvhong.baseframe.app.Constants;
import com.marvhong.baseframe.base.activity.BaseActivity;
import com.marvhong.baseframe.base.fragment.BaseFragment;
import com.marvhong.baseframe.mvp.contract.home.MainContract;
import com.marvhong.baseframe.mvp.presenter.home.MainPresenter;
import com.marvhong.baseframe.ui.category.fragment.CategoryFragment;
import com.marvhong.baseframe.ui.discovery.fragment.DiscoveryFragment;
import com.marvhong.baseframe.ui.home.fragment.HomeFragment;
import com.marvhong.baseframe.ui.mine.fragment.MineFragment;
import com.marvhong.baseframe.utils.BottomNavigationViewHelper;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_toolbar_title)
    TextView mTvToolbarTitle;
    @BindView(R.id.fragment_group)
    FrameLayout mFrameLayout;
    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView mBottomNavigationView;

    private List<BaseFragment> mFragments;
    private HomeFragment mHomeFragment;
    private CategoryFragment mCategoryFragment;
    private DiscoveryFragment mDiscoveryFragment;
    private MineFragment mMineFragment;
    private int mLastFgIndex;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowTitleEnabled(false);
        mTvToolbarTitle.setText("首页");
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragments = new ArrayList<>();
        if (savedInstanceState == null) {
            initPager(false, Constants.TYPE_HOME);
        } else {
            mBottomNavigationView.setSelectedItemId(R.id.tab_home);
            initPager(true, Constants.TYPE_MINE);
        }
    }

    @Override
    public void showSwitchHome() {
        if (mBottomNavigationView != null) {
            mBottomNavigationView.setSelectedItemId(R.id.tab_home);
        }
    }

    private void initPager(boolean isRecreate, int position) {
        mHomeFragment = HomeFragment.getInstance(isRecreate, null);
        mFragments.add(mHomeFragment);
        initFragments();
        init();
        switchFragment(position);
    }

    private void initFragments() {
        mCategoryFragment = CategoryFragment.getInstance();
        mDiscoveryFragment = DiscoveryFragment.getInstance();
        mMineFragment = MineFragment.getInstance();
        mFragments.add(mCategoryFragment);
        mFragments.add(mDiscoveryFragment);
        mFragments.add(mMineFragment);
    }

    private void init() {
        mPresenter.setCurrentPage(Constants.TYPE_HOME);
        initBottomNavigationView();
    }

    private void initBottomNavigationView() {
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.tab_home:
                    loadPager(getString(R.string.tab_home), 0,
                        mHomeFragment, Constants.TYPE_HOME);
                    break;
                case R.id.tab_cateogry:
                    loadPager(getString(R.string.tab_category), 1,
                        mCategoryFragment, Constants.TYPE_CATEGORY);
                    break;
                case R.id.tab_discovery:
                    loadPager(getString(R.string.tab_discovery), 2,
                        mDiscoveryFragment, Constants.TYPE_DISCOVERY);
                    break;
                case R.id.tab_mine:
                    loadPager(getString(R.string.tab_mine), 3,
                        mMineFragment, Constants.TYPE_MINE);
                    break;
                default:
                    break;
            }
            return true;
        });
    }

    private void loadPager(String title, int position, BaseFragment mFragment, int pagerType) {
        mTvToolbarTitle.setText(title);
        switchFragment(position);
        mFragment.reload();
        mPresenter.setCurrentPage(pagerType);
    }

    /**
     * 切换fragment
     *
     * @param position 要显示的fragment的下标
     */
    private void switchFragment(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment targetFg = mFragments.get(position);
        Fragment lastFg = mFragments.get(mLastFgIndex);
        mLastFgIndex = position;
        ft.hide(lastFg);
        if (!targetFg.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(targetFg).commit();
            ft.add(R.id.fragment_group, targetFg);
        }
        ft.show(targetFg);
        ft.commitAllowingStateLoss();
    }

    @Override
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            ActivityCompat.finishAfterTransition(this);
        }
    }
}
