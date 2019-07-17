/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_study;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.ByteArrayInputStream;

/**
 *
 * @author kirankumar
 */
public class sshclient {
    
    public static void main(String[] args) throws JSchException
    {
        String host = "192.168.9.97";
        String user = "premalatha";
        String password = "premalatha";
        String command = "cd /home/premalatha";
        //String knownHostPublicKey = "192.168.9.97 ecdsa-sha2-nistp256 AAAAE2VjZHNhLXNoYTItbmlzdHAyNTYAAAAIbmlzdHAyNTYAAABBBMwBCCnuJL2ljSFwY9Q1eudry3yKIzLcFHZSdY059CtjYs9rwPbmPzNY+v61/OZ/JFl89L/X68Btz7LDR6apIps=";
        try
        {
            java.util.Properties config = new java.util.Properties();
            config.put("StringHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session;
            session = jsch.getSession(user,host,22);
            session.setPassword(password);
            session.setConfig(config);
            /*session.setKnow(new ByteArrayInputStream(knownHostPublicKey.getBytes()));*/
            session.connect();
            System.out.println("Connected to "+user);
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
