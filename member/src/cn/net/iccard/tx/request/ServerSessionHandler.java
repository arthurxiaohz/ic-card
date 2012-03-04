package cn.net.iccard.tx.request;

import org.apache.mina.common.IdleStatus;
import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;
import org.apache.mina.util.SessionLog;

public class ServerSessionHandler extends IoHandlerAdapter
{
    public void sessionOpened( IoSession session )
    {
        // set idle time to 60 seconds
        session.setIdleTime( IdleStatus.BOTH_IDLE, 60 );
        session.setAttribute("times",new Integer(0));
    }

    public void messageReceived( IoSession session, Object message )
    {
        System.out.println("in messageReceived");
        int times = ((Integer)(session.getAttribute("times"))).intValue();
        System.out.println("tiems = " + times);
        // communicate 30 times,then close the session. 
        if (times < 30)
        {
            times++;
            session.setAttribute("times", new Integer(times));           
         Message msg;
         msg = (Message) message;
         msg.setMsgBody("in server side: " + msg.getMsgBody()); 
         System.out.println("begin send msg: " + msg.getMsgBody());
         session.write(msg);
         System.out.println("11111111111111111");
        }
        else
        {
            session.close();
        }
    }

    public void sessionIdle( IoSession session, IdleStatus status )
    {
        SessionLog.info( session, "Disconnecting the idle." );
        System.out.println("22222222222");
        // disconnect an idle client
        session.close();
    }

    public void exceptionCaught( IoSession session, Throwable cause )
    {
        // close the connection on exceptional situation
        session.close();
    }
}

