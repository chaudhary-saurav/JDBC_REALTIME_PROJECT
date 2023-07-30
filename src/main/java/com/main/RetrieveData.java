package com.main;

import com.Dao.EmpDao;
import com.connection.DBConnect;
import com.entity.Emp;

import java.util.List;

public class RetrieveData {

    public static void main(String[] args) {
        EmpDao dao = new EmpDao(DBConnect.getConn());
       /* Emp emp = dao.getInfo(102);
       if(emp == null) {

           System.out.println("User not available...");
       } else {
           System.out.println("Name : " + emp.getName());
           System.out.println("Address : " + emp.getAddress());
           System.out.println("Salary : " + emp.getSalary());
       }*/

        List<Emp> list = dao.getAllData();
        for (Emp ep: list) {
            System.out.println("Name : " + ep.getName());
            System.out.println("Address : " + ep.getAddress());
            System.out.println("Salary : " + ep.getSalary());
            System.out.println("-------------------------------");
        }
    }
}
