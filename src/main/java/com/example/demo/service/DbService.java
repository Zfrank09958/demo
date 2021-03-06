package com.example.demo.service;

import com.example.demo.model.ResultVO;
import com.example.demo.util.DbTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class DbService {
    //@Value("${sqlexec.driver}")
    //private String dirverClass;

    // @Value("${sqlexec.url}")
    // private String url;

    // @Value("${sqlexec.username}")
    // private String username;

    // @Value("${sqlexec.password}")
    // private String password;

    public ResultVO execSql(String sqlStr, String url, String username, String password, String databaseType) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        List<Map<String, Object>> allResult = new LinkedList<>();
        String dirverClass = "com.mysql.jdbc.Driver";
        if ("sqlserver".equals(databaseType)) {
            dirverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        }

        try {
            conn = DbTools.getConnections(dirverClass, url, username, password);
            ps = conn.prepareStatement(sqlStr);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Object columnValue = rs.getObject(columnLabel);
                    map.put(columnLabel, columnValue);
                }
                allResult.add(map);
            }
            DbTools.release(rs, ps, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResultVO.success(allResult);
    }
}
