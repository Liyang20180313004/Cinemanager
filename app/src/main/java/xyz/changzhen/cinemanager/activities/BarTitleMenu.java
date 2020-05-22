package xyz.changzhen.cinemanager.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import org.w3c.dom.Text;

import xyz.changzhen.cinemanager.R;
import xyz.changzhen.cinemanager.models.Cinema;

/**
 * 自定义带菜单的标题栏
 * @author zhen
 */
class BarTitleMenu implements View.OnClickListener {

    private static final String EXTRA_ADD_ITEM = "extraAddItem";
    private Activity mActivity;
    private String mTitle;
    private View mDialog;
    private SearchView mSearch;
    private View mLayoutMenu;
    private TextView mTvTitle;

    BarTitleMenu(Activity activity, String title, View dialog) {
        mActivity = activity;
        mTitle = title;
        mDialog = dialog;
    }

    /**
     * 配置菜单条目、标题、搜索框，各类监听器
     */
    void config() {
        mLayoutMenu = mActivity.findViewById(R.id.bar_title_layout_menu);
        mLayoutMenu.setVisibility(View.GONE);
        mActivity.findViewById(R.id.bar_title_img_menu).setOnClickListener(this);
        mActivity.findViewById(R.id.bar_title_tv_view_order).setOnClickListener(this);
        mActivity.findViewById(R.id.bar_title_tv_add_order).setOnClickListener(this);
        mActivity.findViewById(R.id.bar_title_tv_view_cinema).setOnClickListener(this);
        mActivity.findViewById(R.id.bar_title_tv_add_cinema).setOnClickListener(this);
        mActivity.findViewById(R.id.bar_title_tv_exit).setOnClickListener(this);

        mTvTitle = mActivity.findViewById(R.id.bar_title_tv_title);
        mTvTitle.setText(mTitle);

        mSearch = mActivity.findViewById(R.id.bar_title_search);
    }

    void setSearchListener(SearchView.OnQueryTextListener listener) {
        mSearch.setOnQueryTextListener(listener);
    }

    @Override
    public void onClick(View v) {
        // self:是否当前的activity（订单是MainActivity, 影院是CinemaActivity）

        boolean self;
        switch (v.getId()) {
            case R.id.bar_title_img_menu:
                int visible = mLayoutMenu.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE;
                mLayoutMenu.setVisibility(visible);
                break;
            case R.id.bar_title_tv_view_order:
                self = mActivity instanceof MainActivity;
                if (self) {
                    mTvTitle.setText(mTitle);
                } else {
                    mActivity.startActivity(new Intent(mActivity, MainActivity.class));
                    mActivity.finish();
                }
                break;
            case R.id.bar_title_tv_add_order:
                self = mActivity instanceof MainActivity;
                if (self) {
                    mTvTitle.setText(mTitle);
                    mDialog.setVisibility(View.VISIBLE);
                } else {
                    Intent intent = new Intent(mActivity, MainActivity.class);
                    intent.putExtra(EXTRA_ADD_ITEM, true);
                    mActivity.startActivity(intent);
                    mActivity.finish();
                }
                break;
            case R.id.bar_title_tv_view_cinema:
                self = mActivity instanceof CinemaActivity;
                if (self) {
                    mTvTitle.setText(mTitle);
                } else {
                    mActivity.startActivity(new Intent(mActivity, CinemaActivity.class));
                    mActivity.finish();
                }
                break;
            case R.id.bar_title_tv_add_cinema:
                self = mActivity instanceof CinemaActivity;
                if (self) {
                    mTvTitle.setText(mTitle);
                    mDialog.setVisibility(View.VISIBLE);
                } else {
                    Intent intent = new Intent(mActivity, CinemaActivity.class);
                    intent.putExtra(EXTRA_ADD_ITEM, true);
                    mActivity.startActivity(intent);
                    mActivity.finish();
                }
                break;
            case R.id.bar_title_tv_exit:
                System.exit(0);
                break;
        }
    }
}
