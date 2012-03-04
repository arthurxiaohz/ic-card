package cn.net.iccard.tx.request;

import java.net.InetSocketAddress;

import org.apache.mina.common.ConnectFuture;
import org.apache.mina.common.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.SocketConnector;
import org.apache.mina.transport.socket.nio.SocketConnectorConfig;

public class Client
{
    private static final String HOSTNAME = "localhost";
    private static final int PORT = 8080;
    private static final int CONNECT_TIMEOUT = 30; // seconds


    public static void main( String[] args ) throws Throwable
    {
        SocketConnector connector = new SocketConnector();        
        // Configure the service.
        SocketConnectorConfig cfg = new SocketConnectorConfig();
        cfg.setConnectTimeout( CONNECT_TIMEOUT );
          cfg.getFilterChain().addLast(
                    "codec",
                    new ProtocolCodecFilter( new ObjectSerializationCodecFactory() ) );

        //cfg.getFilterChain().addLast( "logger", new LoggingFilter() );
        
        IoSession session;
        Message msg = new Message(0,1,"hello");
        ConnectFuture future =  connector.connect(new InetSocketAddress( HOSTNAME, PORT ),
                        new ClientSessionHandler(msg), cfg );
        
        future.join();
        
        
        
        

    }
}