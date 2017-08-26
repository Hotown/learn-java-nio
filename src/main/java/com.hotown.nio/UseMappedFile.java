package com.hotown.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Hotown on 17/8/26.
 */
public class UseMappedFile {
    static private final int start = 0;
    static private final int size = 1024;

    public static void main(String[] args) throws Exception {

        try( RandomAccessFile raf = new RandomAccessFile("hello.txt","rw")) {
            FileChannel fc = raf.getChannel();

            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE,
                    start, size);

            mbb.put(0, (byte)97);
            mbb.put(1023, (byte)122);
        }
    }
}
