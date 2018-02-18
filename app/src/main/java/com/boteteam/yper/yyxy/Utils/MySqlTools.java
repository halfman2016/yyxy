package com.boteteam.yper.yyxy.Utils;



import com.boteteam.yper.yyxy.Module.Log;
import com.boteteam.yper.yyxy.Module.LogAction;
import com.boteteam.yper.yyxy.MyApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by Feng on 2017/6/15.
 */

public class MySqlTools {
    private String dbDriver="com.mysql.jdbc.Driver";
    //database?useUnicode=true&amp;characterEncoding=UTF-8
    private String dbUrl;//根据实际情况变化
    private String dbUser="root";
    private String dbPass="123456";
    private Connection conn=null;
    private String mode;  // test release 2种模式

    public MySqlTools() {
        final MyApplication myApplication = MyApplication.getInstance();
        mode = myApplication.getMode();
        if (mode == "test") {
            dbUrl = "jdbc:mysql://10.0.2.2:3306/lizhiyyxy?useUnicode=true&amp;characterEncoding=UTF-8";//根据实际情况变化

        } else if (mode == "release") {
            dbUrl = "jdbc:mysql://boteteam.com:3306/lizhiyyxy?useUnicode=true&amp;characterEncoding=UTF-8";//根据实际情况变化
        }
    }

    public Connection getConn()
    {

        try
        {
            Class.forName(dbDriver);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);//注意是三个参数
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConn(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int insertLoginNameDate(Log log)
    {
        int i=0;
        String sql="insert into loginlog(lid,stime,etime,duringtime,lname,uuid,gradeclassname,usertype) values(?,?,?,?,?,?,?,?)";

        try{

            PreparedStatement preStmt =conn.prepareStatement(sql);
            preStmt.setString(1,log.getLid());
            preStmt.setTimestamp(2,log.getStime());
            preStmt.setTimestamp(3,log.getEtime());
            preStmt.setLong(4,log.getDtime());
            preStmt.setString(5,log.getLname());
            preStmt.setString(6,log.getUuid().toString());
            preStmt.setString(7,log.getgradeClassName());
            preStmt.setString(8,"教师");

            i=preStmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return i;//返回影响的行数，1为执行成功
    }

    public  int insertActionLog(LogAction logAction)
    {
        int i=0;
        String sql="insert into actionlog(actioname,actiontime,actionpeoplename,actionpeopleid,actiongradeclassname,usertype) values(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,logAction.getActionname());
            preparedStatement.setTimestamp(2,logAction.getActiontime());
            preparedStatement.setString(3,logAction.getActionpeoplename());
            preparedStatement.setString(4,logAction.getActionpeopleid());
            preparedStatement.setString(5,logAction.getActiongradeclassname());
            preparedStatement.setString(6,"教师");
            i=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  i;
    }

    public int insertAssignMent() {
        int i = 0;
        String sql = "insert into assignment(assignteaname) values(?)";
        try {
            if (conn == null) return 0;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "test");
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }



}
