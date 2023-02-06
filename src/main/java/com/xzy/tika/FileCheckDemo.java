package com.xzy.tika;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * User: RuzzZZ
 * Date: 2023/1/31
 * Time: 15:03
 */
public class FileCheckDemo {


    public static void main(String[] args) throws TikaException, IOException, SAXException {
        File file = new File("/Users/xmly/Documents/test.aac");
        //File file = new File("/Users/xmly/Downloads/f0.aac");
        //File file = new File("/Users/xmly/Downloads/f1.aac");
        //File file = new File("/Users/xmly/Downloads/f2.aac");
        //File file = new File("/Users/xmly/Documents/周杰伦 - 稻香.pkf");
        String mime = detectMime(file);
        System.out.println(mime);
    }

    public static String detectMime(File f) throws IOException, SAXException, TikaException {
        try (InputStream inputStream = new FileInputStream(f)) {
            ContentHandler contenthandler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            Parser parser = new AutoDetectParser();
            ParseContext context = new ParseContext();
            parser.parse(inputStream, contenthandler, metadata, context);
            return metadata.get(Metadata.CONTENT_TYPE);
        }
    }
}
