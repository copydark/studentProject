<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Grade ${Grade} </title>
</head>

<body>
<h2>Grade ${Grade} Survey</h2>
<table width="915" border="1">
  <tr>
    <th width="265" scope="col">问题/Question</th>

    <#list surveyLists as itemlist>

        <th width="634" scope="col">
                TeacherID:${itemlist.teacherID} Teacher Name: ${itemlist.teacherName}<br/>
                Course Name: ${itemlist.courseName} Course Area: ${itemlist.courseArea}
        </th>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>1. 教学准备充分 </p>
    <p>The class is well prepared</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
        <td>  
              <input type="radio" name="Point${idNum}_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_1"  value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_1"  value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_1"  value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point${idNum}_1"  value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>2. 教学进度适当 </p>
    <p>The instructor paces lessons appropriately</p></th>
    <#list surveyLists as itemlist>
        <td>  
              <input type="radio" name="Point${idNum}_2" id="Point_5_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_2" id="Point_5_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_2" id="Point_5_1" value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_2" id="Point_5_1" value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_2" id="Point_5_1" value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point${idNum}_2" id="Point_5_1" value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>3. 本学科知识丰富 </p>
    <p>The instructor is knowledgeable about the subject</p></th>
    <#list surveyLists as itemlist>
        <td>  
              <input type="radio" name="Point${idNum}_3" id="Point_5_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_3" id="Point_5_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_3" id="Point_5_1" value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_3" id="Point_5_1" value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_3" id="Point_5_1" value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point${idNum}_3" id="Point_5_1" value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>4. 教学有热情 </p>
    <p>The instructor is enthusiastic about his/her subject</p></th>
    <#list surveyLists as itemlist>
        <td>  
              <input type="radio" name="Point${idNum}_4" id="Point_5_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_4" id="Point_5_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_4" id="Point_5_1" value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_4" id="Point_5_1" value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_4" id="Point_5_1" value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point${idNum}_4" id="Point_5_1" value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>5. 教学方法富于启发性，强调互动 </p>
    <p>The way of teaching is inspiring</p></th>
    <#list surveyLists as itemlist>
        <td>  
              <input type="radio" name="Point${idNum}_5" id="Point_5_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_5" id="Point_5_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_5" id="Point_5_1" value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_5" id="Point_5_1" value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_5" id="Point_5_1" value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point${idNum}_5" id="Point_5_1" value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>6. 有效设疑引发学生思考 </p>
    <p>The instructor asks questions that make me think</p></th>
    <#list surveyLists as itemlist>
        <td>  
              <input type="radio" name="Point${idNum}_6" id="Point_5_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_6" id="Point_5_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_6" id="Point_5_1" value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_6" id="Point_5_1" value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_6" id="Point_5_1" value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point_1" id="Point_5_1" value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>7. 有效管理课堂 </p>
    <p>The instructor manages the class effectively</p></th>
    <#list surveyLists as itemlist>
        <td>  
              <input type="radio" name="Point${idNum}_7" id="Point_5_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_7" id="Point_5_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_7" id="Point_5_1" value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_7" id="Point_5_1" value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_7" id="Point_5_1" value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point${idNum}_7" id="Point_5_1" value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>8. 课堂语言（AL/AP课程60%/80%英文，英语100%英文，中国课程语言为中文）</p>
    <p>Language of instruction (Chinese for national courses, 60%/ 80% in English for AL/AP curriculum)</p></th>
    <#list surveyLists as itemlist>
        <td>  
              <input type="radio" name="Point${idNum}_8" id="Point_5_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_8" id="Point_5_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_8" id="Point_5_1" value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_8" id="Point_5_1" value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_8" id="Point_5_1" value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point${idNum}_8" id="Point_5_1" value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>9. 课前3-5分钟学生展示</p>
    <p> 3-5 minutes for students&rsquo; presentations at the beginning of each class</p></th>
    <#list surveyLists as itemlist>
        <td>  
              <input type="radio" name="Point${idNum}_9" id="Point_5_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_9" id="Point_5_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_9" id="Point_5_1" value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_9" id="Point_5_1" value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_9" id="Point_5_1" value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point${idNum}_9" id="Point_5_1" value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>10. 作业量适当</p>
    <p> Assignments are reasonable in amount</p></th>
    <#list surveyLists as itemlist>
        <td>  
              <input type="radio" name="Point${idNum}_10" id="Point_5_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_10" id="Point_5_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_10" id="Point_5_1" value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_10" id="Point_5_1" value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_10" id="Point_5_1" value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point${idNum}_10" id="Point_5_1" value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>11. 作业有挑战性激发思考 </p>
    <p>Assignments are challenging and make me think</p></th>
    <#list surveyLists as itemlist>
        <td>  
              <input type="radio" name="Point${idNum}_11" id="Point_5_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_11" id="Point_5_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_11" id="Point_5_1" value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_11" id="Point_5_1" value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_11" id="Point_5_1" value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point${idNum}_11" id="Point_5_1" value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>12. 讲评作业及时</p>
    <p> The instructor comments on my assignments in time</p></th>
    <#list surveyLists as itemlist>
        <td>  
              <input type="radio" name="Point${idNum}_12" id="Point_5_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_12" id="Point_5_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_12" id="Point_5_1" value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_12" id="Point_5_1" value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_12" id="Point_5_1" value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point${idNum}_12" id="Point_5_1" value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>13. 尊重并公平对待学生 </p>
    <p>The instructor treats students with respect</p></th>
    <#list surveyLists as itemlist>
        <td>  
              <input type="radio" name="Point${idNum}_13" id="Point_5_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_13" id="Point_5_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_13" id="Point_5_1" value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_13" id="Point_5_1" value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_13" id="Point_5_1" value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point${idNum}_13" id="Point_5_1" value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>14. 课后辅导学生 </p>
    <p>The instructor is available to help students after class</p></th>
    <#list surveyLists as itemlist>
        <td>  
              <input type="radio" name="Point${idNum}_14" id="Point_5_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_14" id="Point_5_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_14" id="Point_5_1" value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_14" id="Point_5_1" value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_14" id="Point_5_1" value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point${idNum}_14" id="Point_5_1" value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>15. 关心学生 </p>
    <p>The instructor cares about his/her students</p></th>
    <#list surveyLists as itemlist>
        <td>  
              <input type="radio" name="Point${idNum}_15" id="Point_5_1" value = "5">
              <label for="checkbox">五分</label>
              <input type="radio" name="Point${idNum}_15" id="Point_5_1" value = "4">
              <label for="checkbox">四分</label>
              <input type="radio" name="Point${idNum}_15" id="Point_5_1" value = "3">
              <label for="checkbox">三分</label>
              <input type="radio" name="Point${idNum}_15" id="Point_5_1" value = "2">
              <label for="checkbox">二分</label>
              <input type="radio" name="Point${idNum}_15" id="Point_5_1" value = "1">
              <label for="checkbox">一分</label>
              <input type="radio" name="Point${idNum}_15" id="Point_5_1" value = "0">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
</table>
</body>
</html>
