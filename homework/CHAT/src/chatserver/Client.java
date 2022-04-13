package chatserver;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

public class Client implements ActionListener
{
    JTextArea textArea;
    private JFrame frmChatWindow;
    private JTextArea textArea_1;
    JTextField username;

    JButton submit;
    JFrame j;
    JFrame jf;
    BufferedReader reader;
    PrintWriter write;
    String msg;
    Socket s;

    public Client() throws Exception, IOException
    {
        try
        {
            s = new Socket("localhost", 6633);
            reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            write = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));

            j = new JFrame("PLAIN");
            j.setBounds(500, 150, 300, 400);

            JPanel panel = new JPanel();
            j.add(panel);
            GridBagLayout gb = new GridBagLayout();
            panel.setLayout(gb);

            GridBagConstraints c = new GridBagConstraints();

            JLabel label = new JLabel("User Name");
            c.gridx = 0;
            c.gridy = 0;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.anchor = GridBagConstraints.NORTHWEST;
            c.ipadx = 5;
            c.ipady = 5;

            c.insets = new Insets(7, 7, 7, 7);

            panel.add(label, c);

            username = new JTextField(10);

            c.gridx = 1;
            c.gridy = 0;

            c.fill = GridBagConstraints.HORIZONTAL;
            c.anchor = GridBagConstraints.WEST;
            c.ipadx = 5;
            c.insets = new Insets(7, 7, 7, 7);

            panel.add(username, c);

            JLabel password = new JLabel("Password");
            c.gridx = 0;
            c.gridy = 1;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.anchor = GridBagConstraints.WEST;
            c.ipadx = 5;
            c.insets = new Insets(7, 7, 7, 7);

            panel.add(password, c);

            JPasswordField pass = new JPasswordField(10);
            c.gridx = 1;
            c.gridy = 1;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.anchor = GridBagConstraints.WEST;
            c.insets = new Insets(7, 7, 7, 7);

            panel.add(pass, c);

            submit = new JButton("Submit");
            c.gridx = 1;
            c.gridy = 6;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.anchor = GridBagConstraints.WEST;
            c.insets = new Insets(7, 7, 7, 7);

            panel.add(submit, c);

            submit.addActionListener(this);
            j.setVisible(true);
            j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            while ((msg = reader.readLine()) != null)
            {
                display(msg);
            }
        }

        catch (Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            s.close();
            reader.close();
            write.close();
        }
    }

    private void display(String msg2)
    {
        textArea_1.append("Server" + ": " + msg2);
    }

    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
        j.dispose();
        frmChatWindow = new JFrame();
        frmChatWindow.setResizable(false);
        frmChatWindow.setTitle("Chat Window");
        frmChatWindow.setBounds(100, 100, 316, 300);
        frmChatWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SpringLayout springLayout = new SpringLayout();
        frmChatWindow.getContentPane().setLayout(springLayout);

        textArea = new JTextArea();
        springLayout.putConstraint(SpringLayout.WEST, textArea, 10, SpringLayout.WEST, frmChatWindow.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, textArea, 31, SpringLayout.SOUTH, frmChatWindow.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, textArea, 229, SpringLayout.WEST, frmChatWindow.getContentPane());
        textArea.setLineWrap(true);
        frmChatWindow.getContentPane().add(textArea);

        JButton btnNewButton = new JButton("Send");
        springLayout.putConstraint(SpringLayout.NORTH, textArea, 0, SpringLayout.NORTH, btnNewButton);
        springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -58, SpringLayout.SOUTH, frmChatWindow.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, frmChatWindow.getContentPane());
        frmChatWindow.getContentPane().add(btnNewButton);

        JButton btnLogout = new JButton("Logout");
        springLayout.putConstraint(SpringLayout.NORTH, btnLogout, 10, SpringLayout.NORTH, frmChatWindow.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, btnLogout, -10, SpringLayout.EAST, frmChatWindow.getContentPane());
        frmChatWindow.getContentPane().add(btnLogout);

        textArea_1 = new JTextArea();
        textArea_1.setEditable(false);
        textArea_1.append(null);
        springLayout.putConstraint(SpringLayout.NORTH, textArea_1, 24, SpringLayout.NORTH, frmChatWindow.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, textArea_1, 10, SpringLayout.WEST, frmChatWindow.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, textArea_1, -19, SpringLayout.NORTH, textArea);
        springLayout.putConstraint(SpringLayout.EAST, textArea_1, -6, SpringLayout.WEST, btnLogout);
        frmChatWindow.getContentPane().add(textArea_1);

        btnLogout.addActionListener(new Test2());
        btnNewButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                String s = new String();
                s = textArea.getText();
                sendmsg(s);
                getwrite();
            }
        });
        frmChatWindow.setVisible(true);
    }

    private void getwrite()
    {
        write.write(username.getText());
    }

    public void sendmsg(String g)
    {
        textArea_1.append(username.getText() + " " + ": " + g + "\n");
    }

    class Test2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            frmChatWindow.dispose();
            j.setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    new Client();
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                catch (Exception e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}