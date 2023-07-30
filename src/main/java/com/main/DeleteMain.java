package com.main;

import com.Dao.EmpDao;
import com.connection.DBConnect;

public class DeleteMain {

    public static void main(String[] args) {

        EmpDao dao = new EmpDao(DBConnect.getConn());
        boolean f = dao.deleteData(107);
        if(f) {
            System.out.println("Delete Data Successfully");
        } else {
            System.out.println("Something Went Wrong On Server");
        }
    }
}
