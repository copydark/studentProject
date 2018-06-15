
package jnflsicSurveyListDataProcess;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class surveyTeacherReport {
    public static void generateWord(surveyReportDataOrg []s) throws TemplateException, IOException{

        for(int i = 0; i<s.length; i++){
            Map<String, Object> root = new HashMap<String, Object>();
           //创建fm的配置
            Configuration config = new Configuration();
            //指定默认编码格式 
            config.setDefaultEncoding("UTF-8");
            //设置模版文件的路径
            config.setDirectoryForTemplateLoading(new File("src/template"));
            Template template = config.getTemplate("teaTemplate.ftl");
            root.put("teacherName", s[i].getTeaccherName());
            root.put("Grade", s[i].getGrade());
            root.put("courseName", s[i].getCourseName());
            int numOfStudent = s[i].getNumOfStudent();
            root.put("numOfStu", numOfStudent);
            int score[] = s[i].getQuestionscore();
            double sum = 0;
            for(int j = 0; j<15; j++){
                root.put("Q"+(j+1), score[j]/(double)numOfStudent);
                sum += score[j]/(double)numOfStudent;
            }
            root.put("sum", sum);
            File outFile = new File("C:\\xampp\\tomcat\\webapps\\ROOT\\"+s[i].getGrade()+"\\word\\"+s[i].getTeaccherName()+s[i].getCourseName()+".doc");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);

                    //数据与模板合并（数据+模板=输出）
            template.process(root, out);
            out.flush();
        }
    }
}
