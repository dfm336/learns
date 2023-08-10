package com.dfm.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author daifengming
 */
public class BioDemo {
    /**
     * 服务端 阻塞式 io
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        // 阻塞 , 等待客户端连接， 阻塞到有客户端连接
        Socket clientSocket = serverSocket.accept();
        //字符输入流中读取文本
        BufferedReader in =  new BufferedReader(new InputStreamReader(clientSocket.getInputStream()) );
        //打印对象的格式化的表示到文本输出流。
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String request, response;
        // readLine() 会阻塞。直到读取到换行符或者输入流结束
        while ((request = in.readLine()) != null) {
            if ("Done".equals(request)) {
                break;
            }
            response = processRequest(request);
            out.println(response);
        }
    }

    /**
     * 处理请求
     * @param request
     * @return
     */
    private static String processRequest(String request) {
        System.out.println("服务端接收到请求：" + request);
        return request;
    }
}
