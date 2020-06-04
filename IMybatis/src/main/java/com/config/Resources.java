package com.config;

import java.io.InputStream;

public class Resources {
    public static  InputStream getInputStreamFromXmlByPath(String path){
        InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(path);
        return  resourceAsStream;
    }
}
