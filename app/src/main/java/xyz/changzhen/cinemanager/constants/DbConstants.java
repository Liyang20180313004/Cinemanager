package xyz.changzhen.cinemanager.constants;

import android.app.Application;

import net.lzzy.sqllib.DbPackager;

import xyz.changzhen.cinemanager.R;
import xyz.changzhen.cinemanager.utils.AppUtils;

/**
 * @author zhen
 */
public final class DbConstants {

    private DbConstants() {
    }

    /**
     * 数据库文件名
     */
    private static final String DB_NAME = "cinema.db";
    /**
     * 数据库版本号，db架构需要升级时请修改为比当前版本号更大的版本号
     */
    private static final int DB_VERSION = 1;
    /**
     * 打包数据库信息，包括名称、版本号、需要持久化的类名、自动生成的sql语句等
     */
    public static DbPackager packager;
    static {
        // 其他相关数据
        packager = DbPackager.getInstance(AppUtils.getContext(), DB_NAME, DB_VERSION, R.raw.models);
    }

}
