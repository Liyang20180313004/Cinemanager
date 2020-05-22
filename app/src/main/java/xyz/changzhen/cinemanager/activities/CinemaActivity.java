package xyz.changzhen.cinemanager.activities;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import xyz.changzhen.cinemanager.R;

/**
 * @author zhen
 */
public class CinemaActivity extends AppCompatActivity {

    private View mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_cinemas);

        initViews();

        BarTitleMenu menu = new BarTitleMenu(this, "影院列表", mDialog);
        menu.config();
        menu.setSearchListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    /**
     * 初始化视图组件
     */
    private void initViews() {
        mDialog = findViewById(R.id.activity_cinema_content_add);
    }

}