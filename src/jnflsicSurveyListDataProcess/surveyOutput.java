package jnflsicSurveyListDataProcess;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class surveyOutput {
    public static void generateHtml(surveyListDataOrg []s) throws TemplateException, IOException{
        List<surveyListDataOrg> list = Arrays.asList(s);
        Map<String, Object> root = new HashMap<String, Object>();
       //创建fm的配置
        Configuration config = new Configuration();
        //指定默认编码格式 
        config.setDefaultEncoding("UTF-8");
        //设置模版文件的路径
        config.setDirectoryForTemplateLoading(new File("src/template"));
        Template template = config.getTemplate("htmlTemplate.ftl");
        root.put("surveyLists", list);
        root.put("Grade", s[0].getGrade());
        File outFile = new File("D:/" + "html" + 0 + ".html");
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);

                //数据与模板合并（数据+模板=输出）
        template.process(root, out);
        out.flush();
    }
}
