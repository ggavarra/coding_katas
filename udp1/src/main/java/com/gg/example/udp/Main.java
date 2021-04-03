package com.gg.example.udp;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import static java.net.InetAddress.getLocalHost;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        DatagramSocket sc= null;
        try {
            sc = new DatagramSocket();
            UdpServer server= new UdpServer(getLocalHost(),8081,sc,"");
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
