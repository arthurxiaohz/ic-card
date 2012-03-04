package cn.net.iccard.tx.request;

import java.net.InetSocketAddress;

import org.apache.mina.common.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.transport.socket.nio.SocketAcceptor;
import org.apache.mina.transport.socket.nio.SocketAcceptorConfig;

public class Server
{
    private static final int SERVER_PORT = 8080;

    public static void main( String[] args ) throws Throwable
    {
        IoAcceptor acceptor = new SocketAcceptor();
        
        // Prepare the service configuration.
        SocketAcceptorConfig cfg = new SocketAcceptorConfig();
        cfg.setReuseAddress( true );

        cfg.getFilterChain().addLast(
                    "codec",
                    new ProtocolCodecFilter( new ObjectSerializationCodecFactory() ) );
        //cfg.getFilterChain().addLast( "logger", new LoggingFilter() );

        acceptor.bind(
                new InetSocketAddress( SERVER_PORT ),
                new ServerSessionHandler( ), cfg );

        System.out.println( "The server Listening on port " + SERVER_PORT );
    }
}
