/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverchat;
import java.io.*;
import java.net.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author yabok
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    static Server instance = null; //singleton
    ArrayList<ServerThread> threads = new ArrayList<>();
    private String codeRoom = "";
//    public static float summ=0;
    public Server() {
        instance = this;
    }
    
    
    
    public static Server getInstance()
    {
        if (instance == null)
            return instance = new Server();
        return instance;
    }

    public ArrayList<ServerThread> getThreads() {
        return threads;
    }

    public void setThreads(ArrayList<ServerThread> threads) {
        threads = threads;
    }

    public String getCodeRoom() {
        return codeRoom;
    }

    public void setCodeRoom(String codeRoom) {
        this.codeRoom = codeRoom;
    }
    
    
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        // TODO code application logic here
        int PORT = 9090;
        if (args.length == 0)
        {
            System.out.println("java -jar server.jar <port> to select port\n Default port: 9090");
        }
        else PORT = Integer.valueOf(args[0].trim());
        ServerSocket serverSocket = new ServerSocket(PORT);
        MainFrame main=new MainFrame();
        main.setVisible(true);
        while (true)
        {
            Socket socket = serverSocket.accept();
            if (Server.getInstance().getThreads().size() == 0)
                Server.getInstance().setCodeRoom(getRandomString());
            ServerThread serverThread = new ServerThread(socket);
            Server.getInstance().getThreads().add(serverThread);
            serverThread.start();
            System.out.println("Ip: "+ socket.getInetAddress() + " join.");
//            summ=Float.sum(summ,ServerThread.sum);
//            System.out.println("sum" + Float.toString(summ));
        }
    }
    
    public static String getRandomString()
    {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String passwd = new String();
        Random rand = new Random();
        int n = rand.nextInt();
        if (n < 0)
                n *= -1;
        n %= 12;
        if (n < 7)
                n += 7;
        while(n >= 0)
        {
                passwd += alphabet.charAt(rand.nextInt(alphabet.length()));
                n--;
        }
        return passwd;
    }
    
}
