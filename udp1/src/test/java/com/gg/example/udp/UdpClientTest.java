package com.gg.example.udp;

import junit.framework.TestCase;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.net.InetAddress;
import java.net.UnknownHostException;
import static org.hamcrest.MatcherAssert.assertThat;

public class UdpClientTest{

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void shouldPublishMessageToUdp1() throws UnknownHostException {
        String testMessage="Publish to UDP";
        UdpClient client= new UdpClient(InetAddress.getLocalHost(),8081,testMessage.getBytes());
        assertThat(client.send(),Matchers.is(Boolean.TRUE));

    }

    
}