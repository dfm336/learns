package com.dfm.bio.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author daifengming
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws InterruptedException {
        // Validate syntax
        if ( args.length != 1 ) {
            System.err.println("Usage: " + EchoServer.class.getSimpleName() + " <port>");
            return;
        }
        int port = Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }

    private void start() throws InterruptedException {

        //EchoServerHandler 为 @Sharable，所以我们可以总是使用同样的实例
        final EchoServerHandler echoServerHandler = new EchoServerHandler();
        // 创建  EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();
        // 创建 ServerBootstrap
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(group)
                .channel(NioServerSocketChannel.class) // 指定使用 NIO 的传输 Channel
                .localAddress(new InetSocketAddress(port)) // 设置 socket 地址使用所选的端口
                //当一个新的连接 被接受时，一个新的子 Channel 将会被创建，而 ChannelInitializer 将会把一个 EchoServerHandler 的实例添加到该 Channel 的 ChannelPipeline 中
                .childHandler(new ChannelInitializer<SocketChannel>() { // 添加 EchoServerHandler 到 Channel 的 ChannelPipeline
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline() // 获取 Channel 的 ChannelPipeline
                                .addLast(echoServerHandler); // 添加 EchoServerHandler 到 ChannelPipeline
                    }
                });

        try {
            ChannelFuture future = serverBootstrap.bind().sync();// 异步地绑定服务器；调用 sync() 方法阻塞等待直到绑定完成
            future.channel().closeFuture().sync(); // 获取 Channel 的 CloseFuture，并阻塞当前线程直到它完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            // 关闭 EventLoopGroup，释放所有的资源
            group.shutdownGracefully().sync();
        }
    }
}

