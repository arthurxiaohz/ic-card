package cn.net.iccard.tx.request;

import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;
import org.apache.mina.util.SessionLog;

public class ClientSessionHandler extends IoHandlerAdapter
{
    private Object msg;
    
    public ClientSessionHandler(Object msg)
    {
        this.msg = msg;
    }


    public void sessionOpened( IoSession session )
    {
        session.write(this.msg);
    }

    public void messageReceived( IoSession session, Object message )
    {
        System.out.println("in messageReceived!");
        Message rm = (Message ) message;        
        SessionLog.debug(session, rm.getMsgBody());
        System.out.println("resmessage is: " + rm.getMsgBody());
        session.write(rm);
    }

    public void exceptionCaught( IoSession session, Throwable cause )
    {
        session.close();
    }
}