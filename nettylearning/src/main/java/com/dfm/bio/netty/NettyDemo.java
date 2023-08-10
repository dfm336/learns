package com.dfm.bio.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @author daifengming
 */
public class NettyDemo {

    /**
     * 异步地建立连接
     */
    public void asyncConnect() {
        Channel channel = null;
        // Does not block
        ChannelFuture connectFuture = channel.connect(new InetSocketAddress("192.168.10.76", 25));

        // Register a listener to be notified when the operation completes or fails
        connectFuture.addListener((ChannelFuture future) -> {
            if (future.isSuccess()) {
                System.out.println("Connection established");
                 // Do something else

                // 使用 该 buffer 来持有数据
                ByteBuf buffer = Unpooled.copiedBuffer("Hello", Charset.defaultCharset());

                // 异步地发送数据
                ChannelFuture wf = future.channel().writeAndFlush(buffer);

            } else {
                // 发生错误，访问 Throwable 对象
                System.err.println("Connection attempt failed");
                future.cause().printStackTrace();
            }
        });
    }
}
