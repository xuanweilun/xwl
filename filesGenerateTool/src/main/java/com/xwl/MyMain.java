package com.xwl;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MyMain {
    public static void main(String[] args) {
//        SpringApplication.run(MyMain.class);
//        System.out.println("xuanweilun".substring(5));
//        List<String> chkList = new ArrayList<>();
//        chkList.add("name.chk");
//        System.out.println(chkList.contains("name.chk"));
//
//        URL resource = Thread.currentThread().getContextClassLoader().getResource("");
//        System.out.println(resource);
//
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(System.getProperty("java.class.path"));
//        String url02 = "我叫{0},今年{1}岁。";
//        String name = "小明";
//        String age = "28";
//        url02 = MessageFormat.format(url02,name,age);
//
//        System.out.println(url02);
//        String passphrase = "123456789ab";
//        int phoneCount = 7;
//        int shareCount = 4;
//        String phonePhrase = passphrase.substring(0,phoneCount);
//        String substring = passphrase.substring(phoneCount, phoneCount + shareCount);
//        System.out.println("phonePhrase = " + phonePhrase);
//        System.out.println("substring = " + substring);
//        System.out.println("abc【{featureCode}】".substring("abc【{featureCode}】".indexOf("{featureCode}")));
//        String value = "abc【{featureCode}】cde【{shareCode}】";
//        value = value.replace("{featureCode}",".*").replace("{shareCode}",".*");
//        System.out.println(value);
//        System.out.println("abc【woaini】cde【哈哈】".matches(value));
//        System.out.println("");
//        System.out.println(getPhraseTemplates("abc【woffff",6));
//        System.out.println("0".equals(null));

//        String pat = ".*【.*】.*【.*】.*";
//        String value = "复制【fdsaiosdnbg】去获取【】";
//        System.out.println(value.matches(pat));

//        System.out.println(null + "0");
    }

    private static String getPhraseTemplates(String passphraseInput,int phraseCount) {
        String allWordPattern = ".*";
        String featureCode = "{featureCode}";
        String shareCode = "{shareCode}";
        String template = "abc【{featureCode}】cde【{shareCode}】";
        String templatePattern = template
                .replace(featureCode,allWordPattern)
                .replace(shareCode,allWordPattern);
        boolean matches = passphraseInput.matches(templatePattern);
        System.out.println(matches);
        int featureCodeIndex = template.indexOf(featureCode);
        System.out.println("template = " + passphraseInput.length());
        System.out.println(featureCodeIndex + phraseCount);
       if(passphraseInput.length() < (featureCodeIndex + phraseCount)){
           System.out.println("c擦放大");
           return null;
        }
        return passphraseInput.substring(featureCodeIndex,featureCodeIndex + phraseCount);
    }
}
