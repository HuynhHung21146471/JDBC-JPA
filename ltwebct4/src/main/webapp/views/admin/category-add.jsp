<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<form action="${pageContext.request.contextPath }/admin/category/insert" method = "post" 
	enctype="mutipart/form-data">
  <label for="categoryname">Category Name:</label><br>
  <input type="text" id="categoryname" name="categoryname" ><br>
  <label for="images">Images</label><br>
  <div style="width:100px; height:100px">
  <img alt="images" id="imagess" scr="" height="150" width="200" /> 
  </div>
  
  
  Nhập link: <input type="text" id="images1" name="images1" ><br>
  Hoặc tải file:
  <input type="file" onchange="chooseFile(this)" id="images" name="images" ><br><br>
  <label for="status">Status</label><br>
  <input type="text" id="status" name="status" ><br><br>
  <input type="submit" value="Submit">
</form> 