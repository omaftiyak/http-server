package com.omaftiyak.parsers;


import com.omaftiyak.BadResponse;
import com.omaftiyak.HttpException;
import com.omaftiyak.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    // todo make it private

    BadResponse br;


    public Request parse(Socket s) throws IOException {
        //todo викидувати 404
        BufferedReader buff = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String[] str = new String[3];
        try {
            String sss = buff.readLine();
            str = sss.split(" ");
        } catch (IOException e1) {
            e1 = new HttpException(404, "Invalid first line.");
            br = new BadResponse((HttpException) e1);
            br.showBadResponse(s);
        }
      if (str[0].compareToIgnoreCase("post") != 0
                && str[0].compareToIgnoreCase("get") != 0
                && str[0].compareToIgnoreCase("put") != 0
                && str[0].compareToIgnoreCase("delete") != 0) {
            HttpException e = new HttpException(404, "Invalid method's name");
            br = new BadResponse(e);
            br.showBadResponse(s);
        }

        Map<String, String> headers = new HashMap<>();
        String[] line;
        while (true) {

            String strLine = null;
            try {
                strLine = buff.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (strLine != null && strLine.compareTo("") == 0) {
                break;
            }
            line = strLine.split(":\\s", 2);
            headers.put(line[0], line[1]);
        }

        return new Request(str[0], str[1], str[2], headers, buff);
    }

}
