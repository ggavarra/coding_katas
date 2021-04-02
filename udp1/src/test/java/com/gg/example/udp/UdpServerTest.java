package com.gg.example.udp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;

public class UdpServerTest {


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    DatagramSocket sc;
    
    @Test
    public void ableToReceiveUdpMessage() throws IOException {
        
        UdpServer server= new UdpServer(InetAddress.getLocalHost(),8081,sc,"TEST");
        server.start();
        doNothing().when(sc).receive(any());
        Mockito.verify(sc,times(1)).receive(any());
    }

}