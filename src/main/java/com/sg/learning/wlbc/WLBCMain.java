package com.sg.learning.wlbc;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by sg on 2016/8/8.
 */
public class WLBCMain {
    public static void main(String args[]){
        try{
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);
            InetAddress addressIP = InetAddress.getByName("115.239.210.27");
            System.out.println(addressIP.getCanonicalHostName());
        }catch (UnknownHostException ue){
            System.out.println("can't find www.baidu.com");
        }
    }
}
