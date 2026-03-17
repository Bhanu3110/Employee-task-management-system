package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dto.User;
import com.utility.DBUtil;

public class UserDAO {

    public User login(String username, String password) {
        User u = null;
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setUsername(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setRole(rs.getString(5));
            }
        } catch(Exception e) { e.printStackTrace(); }
        return u;
    }
    public int save(User u) {
        int x = 0;

        try {
            Connection con = DBUtil.getConnection();

            String sql = "INSERT INTO users(name,username,password,role) VALUES (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, u.getName());
            ps.setString(2, u.getUsername());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getRole());

            x = ps.executeUpdate();

            System.out.println("Rows inserted: " + x);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return x;
    }
    public List<User> getAllEmployees() {
        List<User> list = new ArrayList<>();
        try{
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE role='EMPLOYEE'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                list.add(u);
            }
        }catch(Exception e){ e.printStackTrace(); }
        return list;
    }

    public int delete(int id) {
        int x = 0;
        try{
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id=?");
            ps.setInt(1, id);
            x = ps.executeUpdate();
        }catch(Exception e){ e.printStackTrace(); }
        return x;
    }

}
