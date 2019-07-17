/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sshclient;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.BufferedReader;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 *
 * @author kirankumar
 */
public class Sshclient {
    private static Object connection;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
     JSch jsch = new JSch();
        Session session = null;
        String command = "cd /home/kirankumar/Desktop/; ls -ltrh";
        try
        {
            session = jsch.getSession("kirankumar","192.168.9.100");
            Thread.sleep(5000);
            session.setPassword("kirankumar");
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            
            System.out.println("Connected to Kirankumar");
            ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
            channelExec.setCommand(command);
            channelExec.setInputStream(null);
            channelExec.setErrStream(System.err);
            InputStream in = channelExec.getInputStream();
            channelExec.connect();
            byte[] tmp = new byte[1024];
            StringBuffer sb = new StringBuffer();
            while (true)
            {
                while(in.available()>0)
                {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    sb.append(new String(tmp, 0, i));
                    System.out.println(new String(tmp, 0, i));
                }
                if (channelExec.isClosed()) {
                    System.out.println("exit-status: " + channelExec.getExitStatus());
                    break;
                }
                try
                {
                    Thread.sleep(1000);
                }
                catch (Exception ee)
                {
                }
            }
            channelExec.disconnect();
            session.disconnect();
            Files.write(Paths.get("/home/kirankumar/Desktop/kiran_check_lat.txt"), Collections.singleton(sb.toString()));
            System.out.println("Completed");
            //Channel channel1 = session.openChannel("exec");
            //channel1.setCommand(command);
            //channel1.setInputStream();
            
        }
        catch (JSchException e)
        {
            e.printStackTrace(System.out);
        }
    }
    
    }
    

