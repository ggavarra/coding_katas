package com.gg.example.udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {

    private final InetAddress address;
    private final Integer port;
    private boolean running;
    private byte[] data = new byte[1024];
    private final DatagramSocket sc;
    private DatagramPacket packet;
    private final String env;
    
    

    public UdpServer(InetAddress address, Integer port, DatagramSocket sc,String env) {
        this.address = address;
        this.port = port;
        this.sc = sc;
        this.env= env;
    }
    
    public void start() throws IOException {
        running=true;
        run();
    }

    public void stop() throws IOException {
        running=false;
    }

    public void run() throws IOException {
        
        while (running) {
            receivePackets();
            if("TEST".equals(env)){
                break;
            }
        }
    }

    
    private void receivePackets() throws IOException {
        packet = new DatagramPacket(data, 0, data.length, this.address,this.port);
        sc.receive(packet);
    }

}
    
