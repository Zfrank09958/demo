package com.example.demo.util;

import java.sql.*;

public class DbTools {
    public static Connection getConnections(String driverClass, String jdbcUrl, String usr, String password) {
        Connection conn = null;
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(jdbcUrl, usr, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void release(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePsConn(ps, conn);
        }

    }

    private static void closePsConn(PreparedStatement ps, Connection conn) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
