package com.hotown.nio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Hotown on 17/8/26.
 */
public class CopyFile {
    public static void main(String[] args) throws Exception {
        try (FileInputStream fin = new FileInputStream("hello.txt");
             FileOutputStream fout = new FileOutputStream("hello_copy.txt")) {

            FileChannel fcin = fin.getChannel();
            FileChannel fcout = fout.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (true) {
                // 重设缓冲区，使其可以接受读入的数据
                buffer.clear();

                int r = fcin.read(buffer);

                if (r == -1) {
                    break;
                }
                // 让缓冲区可以将新都如的数据写入另一个通道
                buffer.flip();

                fcout.write(buffer);
            }
        }
    }
}
