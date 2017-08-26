package com.hotown.nio;

import java.nio.ByteBuffer;

/**
 * Created by Hotown on 17/8/26.
 */
public class ArrayByteBuffer {
    public static void main(String[] args) throws Exception {
        byte array[] = new byte[1024];
        ByteBuffer buffer = ByteBuffer.wrap(array);

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
