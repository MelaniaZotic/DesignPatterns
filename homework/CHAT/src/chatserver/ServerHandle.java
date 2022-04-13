package chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandle implements Runnable {

    Socket s1;
    BufferedReader reader;
    PrintWriter write;
    String msg;

    public ServerHandle(Socket s1)
    {
        this.s1 = s1;
    }

    public void run()
    {

        try {
            reader = new BufferedReader(new InputStreamReader(s1.getInputStream()));
            write = new PrintWriter(new OutputStreamWriter(s1.getOutputStream()));

            while((msg = reader.readLine()) != null)
            {
                write.write(msg);
            }
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try {
                s1.close();
                reader.close();
                write.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}