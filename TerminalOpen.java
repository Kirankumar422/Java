/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_study;
import java.io.*;

/**
 *
 * @author kirankumar
 */
public class TerminalOpen {
    public static void main(String args[]) throws IOException
            
    {
       
       String command[] = {"/usr/bin/xterm","ps -aef"};
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec(command[0]);
        Runtime rt1 = Runtime.getRuntime();
        Process pr1 = rt1.exec(command[1]);
        //BufferedReader stdInput = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        //System.out.println("The output is below:\n");
        //while ((s = stdInput.readLine()) != null)
        //{
          //  System.out.println(s);
        //}
    }
}
