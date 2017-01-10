package com.omaftiyak.parsers;


import java.util.List;

public class RequestValidator {

    public void validate(List<String> parts) throws Exception {
        if (parts.size()<2){
            throw new Exception("Invalid count parameters");
        }
        String []start=parts.get(0).split("\\s");
       if (start.length!=3) {
       throw new Exception("Invalid start line.");
       }

       }
    }

