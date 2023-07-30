package com.main;

import com.Dao.EmpDao;
import com.connection.DBConnect;
import com.entity.Emp;

import java.sql.Connection;
import java.util.Scanner;

public class InsertDataMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Emp Id");
        int id = sc.nextInt();
        System.out.println("Enter Emp Name");
        String name = sc.next();
        System.out.println("Enter Emp Address");
        String address = sc.next();
        System.out.println("Enter Emp Salary");
        String salary = sc.next();

        Emp emp = new Emp();
        emp.setId(id);
        emp.setName(name);
        emp.setAddress(address);
        emp.setSalary(salary);

        EmpDao dao = new EmpDao(DBConnect.getConn());
        boolean result = dao.dataInsert(emp);
        if(result) {
            System.out.println("Data Insert Successfully");
        } else {
            System.out.println("Something went wrong on server...");
        }
    }
}
