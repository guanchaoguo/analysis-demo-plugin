package org.elasticsearch.plugin.analysis;


import club.gaiaproject.RockstoneAnalyzer;
import org.apache.lucene.analysis.TokenStream;
import  org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.Test;

public class rockstone {

    @Test
    public void testAnalyzer() throws Exception {
        RockstoneAnalyzer analyzer = new RockstoneAnalyzer();
        TokenStream ts = analyzer.tokenStream("text", "我爱北京 天安门"); // 获取自定义的TokenStream
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class); // 由于属性已近初始化所以直接获取CharTermAttribute的引用
        ts.reset();
        while (ts.incrementToken()) {
            System.out.println(term.toString());
        }
        ts.end();
        ts.close();
    }
}
