/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_study;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kirankumar
 */
public class connectdb {
    
    public static void main(String args[]) 
    {
        String dburl = "jdbc:mysql://localhost:3306/m6db";
        String uname = "kirankumar";
        String pass = "kirankumar";
        
        Connection dbConn = null;
        Statement st = null;
        ResultSet rs = null;
        
        //String query = "select * from serv_item_alias limit 10;";
        System.out.println("Connected to db");
        String query = "select count(distinct po.lsi_id) from lsi_doc_pon po, serv_item_alias se where se.doc_no = po.doc_no;";
        
        try
        {
        
            Class.forName("com.mysql.jdbc.Driver");
            dbConn = DriverManager.getConnection(dburl, uname, pass);
            st = dbConn.prepareStatement(query);
            rs = st.executeQuery(query);
            
            while(rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
                System.out.println("Distinct count:" + rs.getInt(1) );
            }
            dbConn.close();
        }
        catch (Exception e)
        {
        
            System.out.println(e);
            
        }
        
    }
    
}
