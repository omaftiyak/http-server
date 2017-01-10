package com.omaftiyak;


import java.io.Closeable;
import java.io.IOException;

public class IOUtils {
    static void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
