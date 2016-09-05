package com.zhy.zhy_ormlite;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by mzp on 2016/9/2.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil
{
    public static void main(String[] args) throws SQLException, IOException
    {
        writeConfigFile("ormlite_config.txt");
    }
}
