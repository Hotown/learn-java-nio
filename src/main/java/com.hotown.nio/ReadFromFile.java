package com.hotown.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Hotown on 17/8/25.
 */
public class ReadFromFile {
    public static void main(String[] args) throws Exception {
        // 获取通道 try-with-resource
        try(FileInputStream fin = new FileInputStream("readandshow.txt")) {
            FileChannel fc = fin.getChannel();

            // 创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // 建数据从通道读入缓冲区
            fc.read(buffer);

            buffer.flip();

            int i = 0;
            while (buffer.remaining() > 0) {
                byte b = buffer.get();
                System.out.println(i + " = " + (char) b);
                i++;
            }
        }
    }
}
