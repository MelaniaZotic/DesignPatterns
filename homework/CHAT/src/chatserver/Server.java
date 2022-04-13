package chatserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

public class Server {

    Socket soc;

    ServerSocket s = null;

    public Server() throws IOException
    {
        try
        {
            s = new ServerSocket(6633);
            while(true)
            {
                soc =s.accept();
                ServerHandle handle = new ServerHandle(soc);
                Thread t1 = new Thread(handle);
                t1.start();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            //should be e.printStackTrace();
        }
        finally
        {
            if(s != null)
            {
                s.close();
            }
        }
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

        try {
            new Server();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}