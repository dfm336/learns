package com.dfm.bio.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author daifengming
 */
public class ConnectHandler extends ChannelInboundHandlerAdapter {
    /**
     *  当一个连接已经建立时，channelActive(ChannelHandlerContext)将会被调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client " + ctx.channel().remoteAddress() + " connected");
        super.channelActive(ctx);
    }
}
