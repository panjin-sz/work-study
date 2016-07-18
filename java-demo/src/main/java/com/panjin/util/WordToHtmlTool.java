package com.panjin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * 把word的格式转换成HTML格式的文本
 * <p>
 * 注：支持word2003，word2007,并且只包含文本信息
 * @author panjin
 * @version $Id: WordToHtmlTool.java 2016年7月1日 下午4:30:34 $
 */
public final class WordToHtmlTool {
    
    public static final String SLASH = "/";
    
    public static String convert(File file) throws Exception {
        String fileName = file.getName();
        InputStream is = new FileInputStream(file);
        String fileNamePreffix = FileTools.getNameExcludeExpandedName(fileName);
        return  convertWord2003(is, fileNamePreffix) ;
    }

    public static String convert(String dirPath, String fileName) throws Exception {
        String fullPath = dirPath + SLASH + fileName;
        InputStream is = new FileInputStream(fullPath);
        String fileNamePreffix = FileTools.getNameExcludeExpandedName(fileName);
        return convertWord2003(is, fileNamePreffix);
    }

    public static String convertWord2003(InputStream is, String htmlTitle) throws Exception {
        String result = "";
        HWPFDocument wordDocument02003 = new HWPFDocument(is);
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        wordToHtmlConverter.processDocument(wordDocument02003);
        Document htmlDocument = wordToHtmlConverter.getDocument();
        // 增加title
        Element titleNode = htmlDocument.createElement("title");
        titleNode.setTextContent(htmlTitle);
        Node headNode = htmlDocument.getElementsByTagName("head").item(0);
        headNode.appendChild(titleNode);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(out);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "iso-8859-1");
        serializer.setOutputProperty(OutputKeys.INDENT, "false");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        out.close();
        result = new String(out.toByteArray(), "iso-8859-1");

        return result;
    }

    private WordToHtmlTool() {
    }

    public static void main(String[] args) throws Exception {
//        String dirPath = "E:/x协议/最新/现金宝购买前协议 - 带占位";
//        String fileName = "信托相关协议及指令.doc";
//         System.out.println(WordToHtmlTool.convert(dirPath, fileName));
    }
}
