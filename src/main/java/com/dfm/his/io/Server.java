package com.dfm.his.io;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dfm
 * @create 2020-10-08 23:15
 */
public class Server {

    static byte[] bytes = new byte[1024];

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(8080));
            while (true){
                System.out.println("waitting! conn");
                //阻塞
                Socket accept = serverSocket.accept();

                System.out.println("conected success!!!");
                System.out.println("wait data");
                //read 也会阻塞  读到了多少字节
                int inputStream = accept.getInputStream().read(bytes);

                System.out.println("data reading success");
                String res = new String(bytes);
                System.out.println(res);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
