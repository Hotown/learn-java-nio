package com.hotown.nio;

import java.nio.ByteBuffer;

/**
 * Created by Hotown on 17/8/26.
 */
public class TypesInByteBuffer {
    public static void main(String[] args) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.putInt(30);
        buffer.putLong(700000000L);
        buffer.putDouble(Math.PI);

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getDouble());
        System.out.println(buffer.getLong());
    }
}
