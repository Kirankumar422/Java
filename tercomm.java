/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author kirankumar
 */
public class tercomm {
 
    public static void main(String[] args) throws IOException
    {
        String s = null;
        try
        {
            Process p;
            p = Runtime.getRuntime().exec("hostname -i");
            BufferedReader stdInput = new BufferedReader(new InputStreamReader
            (p.getInputStream()));
            System.out.println("The output is: \n");
            while((s = stdInput.readLine()) != null)
            {
                System.out.println(s);
                
            }
        }
        catch(IOException e)
        {
            System.out.println("Something went wrong");
        }
    }
}
