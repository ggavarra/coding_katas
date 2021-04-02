package com.gg.example.udp;

import java.io.IOException;
import java.net.*;

public class UdpClient {

    private final InetAddress address;
    private final Integer port;
    private final byte[] data;

    public UdpClient(InetAddress address, Integer port, byte[] data) {
        this.address = address;
        this.port = port;
        this.data = data;
    }
    
    public boolean send(){
        boolean messageSent=false;
        try {
            DatagramSocket socket=new DatagramSocket();
            DatagramPacket packet= new DatagramPacket(data,0, data.length,address,port);
            socket.send(packet);
            messageSent=true;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return messageSent;
    }
    
    
}
