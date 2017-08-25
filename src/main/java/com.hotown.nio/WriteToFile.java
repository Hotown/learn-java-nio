package com.hotown.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Hotown on 17/8/25.
 */
public class WriteToFile {
    private static final char message[] = {'H','e','l','l','o'};
    public static void main(String[] args) throws Exception {

        try(FileOutputStream fout = new FileOutputStream("writeandshow.txt")) {
            FileChannel fc = fout.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            for (int i = 0; i < message.length; i++) {
                buffer.put((byte) message[i]);
            }
            buffer.flip();

            fc.write(buffer);
        }
    }
}
