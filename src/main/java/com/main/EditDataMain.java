package com.main;

import com.Dao.EmpDao;
import com.connection.DBConnect;
import com.entity.Emp;

public class EditDataMain {

    public static void main(String[] args) {

        Emp emp = new Emp();
        emp.setId(101);
        emp.setName("Enrique");
        emp.setAddress("Washington Dc");

        EmpDao dao = new EmpDao(DBConnect.getConn());
        boolean f = dao.editData(emp);
        if(f) {
            System.out.println("Data Edit Successfully");
        } else {
            System.out.println("Something went wrong on server...");
        }
    }
}
