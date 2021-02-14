package com.arisoft.addressbook.swinggui;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Aritra Sengupta
 * on 2021-01-29.
 */
public class Launcher {
    public static void main(String[] args) {
        String[] contextPaths = new String[] {"META-INF/applicationContext.xml"};
        new ClassPathXmlApplicationContext(contextPaths);
    }
}
