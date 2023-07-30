package com.Dao;

import com.entity.Emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

    private Connection conn;

    public EmpDao(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean dataInsert(Emp emp) {

        boolean f = false;
        try {

            PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?,?)");
            ps.setInt(1,emp.getId());
            ps.setString(2,emp.getName());
            ps.setString(3,emp.getAddress());
            ps.setString(4,emp.getSalary());

            int result = ps.executeUpdate();
            if(result == 1) {
                f = true;
            }


        } catch(Exception e) {

            e.printStackTrace();
        }

        return f;
    }

    public boolean editData(Emp emp) {

        boolean f = false;

        try {
            PreparedStatement ps = conn.prepareStatement("update employee set name = ?, address = ? where id = ?");
            ps.setString(1,emp.getName());
            ps.setString(2, emp.getAddress());
            ps.setInt(3,emp.getId());

           int result =  ps.executeUpdate();
           if(result == 1) {
               f = true;
           }
        } catch (Exception e) {
           e.printStackTrace();
        }

        return f;

    }

    public boolean deleteData(int id) {

        boolean f = false;

        try {
            PreparedStatement ps = conn.prepareStatement("delete from employee where id = ?");

            ps.setInt(1,id);

            int result =  ps.executeUpdate();
            if(result == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;

    }

    public Emp getInfo(int id) {
        Emp emp = null;

        try{
            PreparedStatement ps = conn.prepareStatement("select * from employee where id = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                emp = new Emp();
                emp.setId(rs.getInt(1));
                emp.setName(rs.getString(2));
                emp.setAddress(rs.getString(3));
                emp.setSalary(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return emp;
    }

    public List<Emp> getAllData() {
        List<Emp> list = new ArrayList<Emp>();
        Emp emp = null;

        try{

            PreparedStatement ps = conn.prepareStatement("select * From employee");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                emp = new Emp();
                emp.setId(rs.getInt(1));
                emp.setName(rs.getString(2));
                emp.setAddress(rs.getString(3));
                emp.setSalary(rs.getString(4));
                list.add(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
