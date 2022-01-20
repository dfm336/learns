package com.dfm.his.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author dfm
 * @create 2020-10-08 23:26
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8080);

            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();

//            socket.connect(new InetSocketAddress(8080 ));

            socket.getOutputStream().write(str.getBytes());

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
