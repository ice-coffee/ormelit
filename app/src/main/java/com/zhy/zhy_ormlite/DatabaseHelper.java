package com.zhy.zhy_ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.zhy.zhy_ormlite.bean.User;

import java.sql.SQLException;

/**
 * DatabaseHelper用于创建和升级数据库, 也通常为其他类提供DAOs
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper
{
    //数据库名
    private static final String DATABASE_NAME = "helloAndroid.db";
    // 当前数据库版本号
    private static final int DATABASE_VERSION = 1;

    // 用于操作SimpleData表的DAO
    private Dao<User, Integer> userDao = null;

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    /**
     * 数据库第一次创建的时候会调用onCreate(), 在这里调用创建表的语句
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource)
    {
        try
        {
            //创建SimpleData表
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 数据库更新时调用onUpgrade(), 修改DATABASE_VERSION 字段的值
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion)
    {
//        try
//        {
//            switch (oldVersion)
//            {
//                case 1:
//                    // 当前版本号大于1时调用以下更新语句
//
//                case 2:
//                    // 当前版本号大于2时调用以下更新语句
//
//                    break;
//            }
//        }catch (SQLException e)
//        {
//            e.printStackTrace();
//        }
    }

    /**
     * 返回数据库SimpleData表的操作对象(DAO)
     */
    public Dao<User, Integer> getDao() throws SQLException {
        if (userDao == null) {
            userDao = getDao(User.class);
        }
        return userDao;
    }

    /**
     * 关闭数据库连接并清理缓存
     */
    @Override
    public void close()
    {
        super.close();
        userDao = null;
    }
}