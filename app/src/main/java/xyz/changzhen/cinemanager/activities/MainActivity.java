package xyz.changzhen.cinemanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.SearchView;

import xyz.changzhen.cinemanager.R;
import xyz.changzhen.cinemanager.utils.ViewUtils;

/**
 * @author zhen
 */
public class MainActivity extends AppCompatActivity {

    private View mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initViews();

        BarTitleMenu menu = new BarTitleMenu(this, "我的订单", mDialog);
        menu.config();
        menu.setSearchListener(new ViewUtils.AbstractLoaclQueryListener() {
            @Override
            public boolean handleQuery(String keyword) {
                return false;
            }
        });

    }

    /**
     * 初始化视图组件
     */
    private void initViews() {
        mDialog = findViewById(R.id.activity_main_content_add);
    }
}
