<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="../js/jquer.js" type="text/javascript" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Grade ${Grade} Teacher Survey</title>
</head>

<body>
<h2>Grade ${Grade} Survey</h2>
<table width="915" border="1">
  <tr>
    <th width="265" scope="col">问题/Question</th>

    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >

        <th width="634" scope="col" name="Point${idNum}_0">
                <p>TeacherID:${itemlist.teacherID?c} Teacher Name: ${itemlist.teacherName}<br/>
                Course Name: ${itemlist.courseName} Course Area: ${itemlist.courseArea}</p>
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
              <input name="Point${idNum}_1" type="radio"  value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>2. 教学进度适当 </p>
    <p>The instructor paces lessons appropriately</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
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
              <input name="Point${idNum}_2" type="radio" id="Point_5_1" value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>3. 本学科知识丰富 </p>
    <p>The instructor is knowledgeable about the subject</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
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
              <input name="Point${idNum}_3" type="radio" id="Point_5_1" value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>4. 教学有热情 </p>
    <p>The instructor is enthusiastic about his/her subject</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
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
              <input name="Point${idNum}_4" type="radio" id="Point_5_1" value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>5. 教学方法富于启发性，强调互动 </p>
    <p>The way of teaching is inspiring</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
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
              <input name="Point${idNum}_5" type="radio" id="Point_5_1" value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>6. 有效设疑引发学生思考 </p>
    <p>The instructor asks questions that make me think</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
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
              <input name="Point${idNum}_6" type="radio" id="Point_5_1" value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>7. 有效管理课堂 </p>
    <p>The instructor manages the class effectively</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
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
              <input name="Point${idNum}_7" type="radio" id="Point_5_1" value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>8. 课堂语言（AL/AP课程60%/80%英文，英语100%英文，中国课程语言为中文）</p>
    <p>Language of instruction (Chinese for national courses, 60%/ 80% in English for AL/AP curriculum)</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
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
              <input name="Point${idNum}_8" type="radio" id="Point_5_1" value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>9. 课前3-5分钟学生展示</p>
    <p> 3-5 minutes for students&rsquo; presentations at the beginning of each class</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
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
              <input name="Point${idNum}_9" type="radio" id="Point_5_1" value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>10. 作业量适当</p>
    <p> Assignments are reasonable in amount</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
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
              <input name="Point${idNum}_10" type="radio" id="Point_5_1" value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>11. 作业有挑战性激发思考 </p>
    <p>Assignments are challenging and make me think</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
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
              <input name="Point${idNum}_11" type="radio" id="Point_5_1" value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>12. 讲评作业及时</p>
    <p> The instructor comments on my assignments in time</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
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
              <input name="Point${idNum}_12" type="radio" id="Point_5_1" value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>13. 尊重并公平对待学生 </p>
    <p>The instructor treats students with respect</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
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
              <input name="Point${idNum}_13" type="radio" id="Point_5_1" value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>14. 课后辅导学生 </p>
    <p>The instructor is available to help students after class</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
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
              <input name="Point${idNum}_14" type="radio" id="Point_5_1" value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th scope="row"><p>15. 关心学生 </p>
    <p>The instructor cares about his/her students</p></th>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
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
              <input name="Point${idNum}_15" type="radio" id="Point_5_1" value = "0" checked="checked">
              <label for="checkbox">跳过</label>
        </td>
    </#list>
  </tr>
  <tr>
    <th colspan="2" align="left" scope="row"><p>
  <label for="Comment_Good_1">你最喜欢的老师:</label>
  <select id = "goodcomList1">
    <option value="0">请选择</option>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
	    <option value="${itemlist.teacherID?c};${itemlist.courseName}">${itemlist.teacherName}: ${itemlist.courseName}</option>
    </#list>
  </select>
  <br>
  <label for="Comment_Good_1">Comments：<br>
  </label>
  <textarea cols="80" rows="12" id="GoodCommentText1" disabled="disabled"></textarea>

</p>
<p>
  <label for="Comment_Good_2">你最喜欢的老师:</label>
  <select id = "goodcomList2">
    <option value="0">请选择</option>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
	    <option value="${itemlist.teacherID?c};${itemlist.courseName}">${itemlist.teacherName}: ${itemlist.courseName}</option>
    </#list>
  </select>
  <br>
  <label for="Comment_Good_2">Comments：<br>
  </label>
  <textarea cols="80" rows="12" id="GoodCommentText2" disabled="disabled"></textarea>
  <br>
  
  
  
  

  <label for="Comment_Bad">你最不喜欢的老师:</label>
  <select id ="badcomList" value="0">
    <option value="0">请选择</option>
    <#assign idNum = 0 >
    <#list surveyLists as itemlist>
    <#assign idNum = idNum+1 >
	    <option value="${itemlist.teacherID?c};${itemlist.courseName}">${itemlist.teacherName}: ${itemlist.courseName}</option>
    </#list>
  </select>
  <br>
  <label for="Comment_Bad">Comments：</label>
</p>
<p>  
  
  <textarea name="textarea" cols="80" rows="12" id="BadCommentText" disabled="disabled"></textarea>
</p>
<p>
  <label for="SchoolComment">学校意见:</label>
<p>  
	<textarea name="textarea" cols="80" rows="12" id="SchoolCommentText"></textarea>
  </p></th>
  </tr>
  <tr>
    <th colspan="2" align="right" scope="row">
      <input type="submit" name="submit" id="submit" value="Submit" />
</th>
  </tr>
</table>
</body>
</html>
	<script>
	var teacherIDList = new Array();
	var namelist = new Array();
	var questionSet = new Array(); 
	var courseList = new Array();
	var count = new Array();
	
        <#assign idNum = 0 >
        <#list surveyLists as itemlist>
			teacherIDList[${idNum}] = ${itemlist.teacherID?c};
            namelist[${idNum}] = "${itemlist.teacherName}";
			courseList[${idNum}] = "${itemlist.courseName}";
			<#assign idNum = idNum+1 >
		</#list>
	//console.log(namelist[0]);

	$(function () {
            $("#submit").click(function () {
				<#assign idNum = 1 >
				<#list surveyLists as itemlist>

					<#list 1..15 as t>
						questionSet[${t}-1] = $('input:radio[name=Point${idNum}_${t}]:checked').val();
						if(questionSet[${t}-1]!=0){
							count[${idNum}-1] = 1;
						}else{
							count[${idNum}-1] = 0;
						}
					</#list>
					<#assign idNum = idNum+1 >
				</#list>
				submitData();
			})
	});
		
		function submitData(){
			var nameStrList = namelist.join("-");
			var questionStrList = questionSet.join("-");
			var teacherIDStrL = teacherIDList.join("-");
			var courseStrList = courseList.join("-");
			var countStrList = count.join("-");
			var url="http://localhost:8088/data_process.jsp";
			console.log(url);
			console.log(count[0]);
			$.ajax({
				url: url,
				type: 'POST',
				async: false,
				data: {
					"nameStrL" : nameStrList,
					"questionStrL" : questionStrList,
					"teacherIDStrL" : teacherIDStrL,
					"Grade" : ${Grade},
					"courseL" : courseStrList,
					"countStrL" : countStrList
				},
				success: function(data){

				},
				error: function(data){
					alert("系统异常！");
				}
			});
		}		
      </script>
