package com.zhy.zhy_ormlite.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Bean类
 */

//标明这是数据库中的一张表, 表名为note
@DatabaseTable(tableName = "User")
public class User
{
    //generatedId 表示id为主键且自动生成
    @DatabaseField(generatedId = true)
    private int id;

    //columnName的值为该字段在数据中的列名
    @DatabaseField(columnName = "name")
    private String name;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
