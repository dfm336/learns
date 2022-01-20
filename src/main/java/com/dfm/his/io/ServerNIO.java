package com.dfm.his.io;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dfm
 * @create 2020-10-08 23:15
 */
public class ServerNIO {

    static byte[] bytes = new byte[1024];

    static List<SocketChannel> list = new ArrayList<>();

    static ByteBuffer byteBuffer = ByteBuffer.allocate(512);//申请内存，可以申请 cpu内存。

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));

            serverSocketChannel.configureBlocking(false);//设置非阻塞

            while (true){
//                System.out.println("waitting! conn");

                SocketChannel accept = serverSocketChannel.accept();


                if(accept == null){
                    Thread.sleep(1000);
                    System.out.println("no connection");
                    //轮询以前的连接
                    for (SocketChannel client:list
                         ) {
                        int read = client.read(byteBuffer);
                        if(read > 0){
                            //flip方法会将缓冲区的当前位置”重置”到缓冲区的开始处.这样可以保证传入的对像被其他方法
                            //置 为 读 模式。
                            byteBuffer.flip();
                            Charset charset = Charset.forName("UTF-8");
                            CharsetDecoder decoder = charset.newDecoder();
                            CharBuffer charBuffer = decoder.decode(byteBuffer);
                            System.out.println(charBuffer.toString());
                        }

                    }
                }else {
                    System.out.println("conected success!!!");
                    accept.configureBlocking(false);//设置  非阻塞
                    list.add(accept);
                    //轮询以前的连接
                    for (SocketChannel client:list
                    ) {
                        int read = client.read(byteBuffer);
                        if(read > 0){
                            byteBuffer.flip();//???????
                            System.out.println(byteBuffer.toString());
                        }

                    }
                }


//                System.out.println("wait data");

            }



        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
