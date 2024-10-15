<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<form action="${pageContext.request.contextPath }/admin/video/update" method = "post" 
	enctype="mutipart/form-data">
	
	
  <label for="videoid">VideoID:</label><br>
  <input type="text" id="videoid" name="videoid" ><br>
  <label for="active">Active</label><br>
  <input type="text" id="active" name="active" ><br>
  <label for="description">Description</label><br>
  <input type="text" id="description" name="description" ><br>
  
  
  <label for="poster">Poster</label><br>
  <div style="width:100px; height:100px">
  <img alt=poster id="posterss" scr="" height="150" width="200" /> 
  </div>
  <br><br><br>
  
  
  Nhập link: <input type="text" id="images1" name="images1" ><br>
  Hoặc tải file:
  <input type="file" onchange="chooseFile(this)" id="poster" name="poster" ><br><br>

  
  <label for="title">Title</label><br>
  <input type="text" id="title" name="title" ><br><br>
  
  <input type="submit" value="Submit">
</form> 