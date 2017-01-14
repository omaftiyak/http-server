package com.omaftiyak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    public Request parse(InputStream inputStream) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(inputStream));
        String[] str;
        String sss = buff.readLine();
        str = sss.split(" ");
        if (str[0].compareToIgnoreCase("post") != 0
                && str[0].compareToIgnoreCase("get") != 0
                && str[0].compareToIgnoreCase("put") != 0
                && str[0].compareToIgnoreCase("delete") != 0) {
            throw new HttpException(HttpStatus.SC_BAD_REQUEST);
        }

        Map<String, String> headers = new HashMap<>();
        String[] line;
        while (true) {
            String strLine;
            strLine = buff.readLine();
            if (strLine != null && strLine.compareTo("") == 0) {
                break;
            }
            line = strLine.split(":\\s", 2);
            headers.put(line[0], line[1]);
        }

        return new Request(str[0], str[1], str[2], headers, buff);
    }

}
