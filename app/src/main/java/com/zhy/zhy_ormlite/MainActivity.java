package com.zhy.zhy_ormlite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.zhy.zhy_ormlite.bean.User;

import java.util.List;
import java.util.Random;

/**
 * Created by mzp on 2016/9/1.
 */
public class MainActivity extends Activity
{
    private UserDao userDao;

    private List<User> userList;

    private ListView lv_user;

    private TextView tv_users;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_user = (ListView) findViewById(R.id.lv_user);
        tv_users = (TextView) findViewById(R.id.tv_users);

        userDao = new UserDao(this);
    }

    public void addUser(View view)
    {
        if (null != userDao)
        {
            Random random = new Random();
            int current = random.nextInt(100);

            User user = new User();
            user.setName("name" + current);

            userDao.addUser(user);
        }
    }

    public void queryUser(View view)
    {
        StringBuffer noteStr = new StringBuffer();

        if (null != userDao)
        {
            userList = userDao.queryAllUser();

            for (User user : userList)
            {
                noteStr.append(user.getName());
            }

            tv_users.setText(noteStr);
        }
    }

    public void updateUser(View view)
    {
        if (null != userDao)
        {
            userDao.updateUserById(1);
        }
    }

    public void deleteUser(View view)
    {
        if (null != userDao)
        {
            userDao.deleteUserById(1);
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        if (null != userDao)
        {
            userDao.destoryHelper();
        }
    }
}
