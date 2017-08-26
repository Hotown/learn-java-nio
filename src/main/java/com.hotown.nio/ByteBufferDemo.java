package com.hotown.nio;

import java.nio.ByteBuffer;

/**
 * Created by Hotown on 17/8/26.
 */
public class ByteBufferDemo {
    public static void main(String[] args) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        buffer.put((byte) 'a');
        buffer.put((byte) 'b');

        buffer.flip();

        while (true) {
            if (buffer.remaining() == 0) {
                System.out.println("finish");
                break;
            }
            System.out.println((char) buffer.get());
        }
    }
}
