package com.dao;
import java.sql.*;
import java.util.*;
import com.dto.Task;
import com.utility.DBUtil;

public class TaskDAO {

    public int save(Task t) {
        int x = 0;
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO tasks(title,description,assigned_to,status,due_date) VALUES (?,?,?,?,?)"
            );
            ps.setString(1, t.getTitle());
            ps.setString(2, t.getDescription());
            ps.setInt(3, t.getAssignedTo());
            ps.setString(4, t.getStatus());
            ps.setString(5, t.getDueDate());
            x = ps.executeUpdate();
        } catch(Exception e){ e.printStackTrace(); }
        return x;
    }

    public List<Task> getAll() {
        List<Task> list = new ArrayList<>();
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tasks");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Task t = new Task();
                t.setId(rs.getInt("id"));
                t.setTitle(rs.getString("title"));
                t.setDescription(rs.getString("description"));
                t.setAssignedTo(rs.getInt("assigned_to"));
                t.setStatus(rs.getString("status"));
                t.setDueDate(rs.getString("due_date"));
                list.add(t);
            }
        } catch(Exception e){ e.printStackTrace(); }
        return list;
    }

    public Task getById(int id){
        Task t = null;
        try{
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tasks WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                t = new Task();
                t.setId(rs.getInt("id"));
                t.setTitle(rs.getString("title"));
                t.setDescription(rs.getString("description"));
                t.setAssignedTo(rs.getInt("assigned_to"));
                t.setStatus(rs.getString("status"));
                t.setDueDate(rs.getString("due_date"));
            }
        }catch(Exception e){ e.printStackTrace(); }
        return t;
    }

    public int update(Task t){
        int x = 0;
        try{
            Connection con =DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE tasks SET title=?, description=?, assigned_to=?, status=?, due_date=? WHERE id=?"
            );
            ps.setString(1, t.getTitle());
            ps.setString(2, t.getDescription());
            ps.setInt(3, t.getAssignedTo());
            ps.setString(4, t.getStatus());
            ps.setString(5, t.getDueDate());
            ps.setInt(6, t.getId());
            x = ps.executeUpdate();
        }catch(Exception e){ e.printStackTrace(); }
        return x;
    }

    public int updateStatus(int id, String status){
        int x = 0;
        try{
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE tasks SET status=? WHERE id=?");
            ps.setString(1, status);
            ps.setInt(2, id);
            x = ps.executeUpdate();
        }catch(Exception e){ e.printStackTrace(); }
        return x;
    }

    public int delete(int id){
        int x = 0;
        try{
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM tasks WHERE id=?");
            ps.setInt(1, id);
            x = ps.executeUpdate();
        }catch(Exception e){ e.printStackTrace(); }
        return x;
    }

    public List<Task> getTasksForEmployee(int empId){
        List<Task> list = new ArrayList<>();
        try{
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM tasks WHERE assigned_to=?");
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Task t = new Task();
                t.setId(rs.getInt("id"));
                t.setTitle(rs.getString("title"));
                t.setDescription(rs.getString("description"));
                t.setAssignedTo(rs.getInt("assigned_to"));
                t.setStatus(rs.getString("status"));
                t.setDueDate(rs.getString("due_date"));
                list.add(t);
            }
        }catch(Exception e){ e.printStackTrace(); }
        return list;
    }
}

