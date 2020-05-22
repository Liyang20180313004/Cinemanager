package xyz.changzhen.cinemanager.utils;

import android.widget.SearchView;

/**
 * @author zhen
 */
public class ViewUtils {

    /**
     * 搜索监听， 用于远程数据的搜索，回车发起搜索
     */
    public static abstract class AbstractNetQueryListener implements SearchView.OnQueryTextListener {

        @Override
        public boolean onQueryTextSubmit(String query) {
            return handleQuery(query);
        }

        /**
         * 处理搜索逻辑
         * @param keyword 搜索关键字
         * @return 完成则返回true
         */
        public abstract boolean handleQuery(String keyword);

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    }

    public abstract static class AbstractLoaclQueryListener implements SearchView.OnQueryTextListener {

        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        /**
         * 处理搜索逻辑
         * @param keyword 搜索关键字
         * @return 完成则返回true
         */
        public abstract boolean handleQuery(String keyword);

        @Override
        public boolean onQueryTextChange(String newText) {
            handleQuery(newText);
            return false;
        }
    }

}
