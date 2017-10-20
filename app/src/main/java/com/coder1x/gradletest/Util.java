package com.coder1x.gradletest;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Author: liuxiao
 * Date: 2017/10/19
 */

public class Util {

    private static final String TAG = Util.class.getName();
    private static Map<String, String> originMap = new HashMap<>();
    private static Map<String, String> newMap = new HashMap<>();

    public static void main(String[] args) {
        doBefore();
    }

    public static void parse() {
        try {
//            String path = "res/values/strings.xml";
//            XmlPullParser parser = Xml.newPullParser();
//            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
//            parser.setInput(new FileReader(new File(path)));
//            parser.

            XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
//            FileReader reader = new FileReader(new File(path));
            StringReader reader = new StringReader(XML_TARGET_STRING);
            parser.setInput(reader);
            int eventType = 0;
            String tagName = null;
            while ((eventType = parser.next()) != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    tagName = parser.getName();
                    System.out.println(tagName);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getText() {
        String path = "/Users/netease/Desktop/aaa.txt";
        XmlSerializer result = Xml.newSerializer();
        try {
            StringWriter writer = new StringWriter();
            result.setOutput(writer);
            result.startTag("aa","resources");
            result.endTag("aa","resources");
            String str = writer.toString();
            System.out.println(str);
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void doBefore() {
        log("before");


    }

    public static void doAfter() {
        log("after");
    }

    private static void log(String content) {
        System.out.println(TAG + ": " + content);
    }

    private static final String XML_TARGET_STRING = "<resources>\n" +
            "    <string name=\"app_name\">GradleTest</string>\n" +
            "    <string name=\"lx\">asdf</string>\n" +
            "</resources>";

}
