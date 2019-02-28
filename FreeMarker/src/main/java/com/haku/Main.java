package com.haku;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException, TemplateException {
        //配置版本
        Configuration conf = new Configuration(Configuration.VERSION_2_3_23);
        //设置模版目录
        conf.setDirectoryForTemplateLoading(new
                File("E:\\ideaWorkspace\\Big Data\\FreeMarker\\src\\main\\java\\com\\haku"));
        //设置生成页面的编码方式
        conf.setDefaultEncoding("utf-8");
        //指定模版，获得模板对象
        Template template = conf.getTemplate("index.ftl");
        //存入数据
        Map<String, Object> datas = new HashMap<String, Object>();
        datas.put("name", "中国");

        boolean b = false;
        datas.put("b", b);

        datas.put("isNull", null);
        //生成静态页面
        template.process(datas, new FileWriter("E:\\ideaWorkspace\\Big Data\\FreeMarker\\src\\main\\java\\com\\haku\\index.html"));
    }
}
