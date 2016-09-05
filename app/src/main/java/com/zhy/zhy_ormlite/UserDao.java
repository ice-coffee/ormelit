package com.zhy.zhy_ormlite;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.zhy.zhy_ormlite.bean.User;

import java.sql.SQLException;
import java.util.List;

/**
 * 数据库的链接和关闭, User表的操作
 */
public class UserDao
{
    private DatabaseHelper databaseHelper;
    private Dao userDao;

    /**
     * 数据库连接, 并创建DAO
     * @param context
     */
    public UserDao(Context context)
    {
        databaseHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);

        try
        {
            userDao = databaseHelper.getDao();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * 添加数据到表
     * @param user
     */
    public void addUser(User user)
    {
        try
        {
            userDao.create(user);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 查询表中所有数据
     * @return
     */
    public List<User> queryAllUser()
    {
        List<User> userList = null;
        try
        {
            userList = userDao.queryForAll();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return userList;
    }

    /**
     * 根据ID更新内容
     * @param id
     */
    public void updateUserById(int id)
    {
        try
        {
            UpdateBuilder updateBuilder = userDao.updateBuilder();
            updateBuilder.updateColumnValue("name", "haha");
            updateBuilder.where().eq("id", id);
            updateBuilder.update();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 根据ID更新内容
     * @param id
     */
    public void deleteUserById(int id)
    {
        try
        {
            DeleteBuilder deleteBuilder = userDao.deleteBuilder();
            deleteBuilder.where().eq("id", id);
            deleteBuilder.delete();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 断开数据库连接,并清理缓存
     */
    public void destoryHelper()
    {
        if (databaseHelper != null)
        {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }
}
