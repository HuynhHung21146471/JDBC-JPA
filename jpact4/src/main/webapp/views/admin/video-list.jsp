<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<a href="${pageContext.request.contextPath }/admin/video/add">Add
	Video</a>
<table border="1" width="100%">
	<tr>
		<th>STT</th>
		<th>VideoID</th>
		<th>Active</th>
		<th>Description</th>
		<th>Poster</th>
		<th>Title</th>
		<th>Views</th>
		<th>Action</th>
	</tr>

	<c:forEach items="${listvideo}" var="vid" varStatus="STT">
		<tr>
			<td>${STT.index+1 }</td>


			<td>${vid.videoId }</td>

			<td><c:if test="${vid.active ==1 }">
					<span>Hoạt động</span>
				</c:if> <c:if test="${vid.active !=1 }">
					<span>Khóa</span>
				</c:if></td>


			<td>${vid.description }</td>

			<td>
				<c:if test="${vid.poster.substring(0,5) != 'https'}">
					<c:url value="/image?fname=${vid.poster}" var="imgUrl"></c:url>
				</c:if> <c:if test="${vid.poster.substring(0,5) =='https'}">
					<c:url value="${vid.poster}" var="imgUrl"></c:url>
				</c:if> <img height="150" width="200" src="${imgUrl}" />
			</td>


			<td>${vid.title }</td>
			<td>${vid.views }</td>


			<td><a
				href="<c:url value='/admin/video/edit?videoid=${vid.videoId }'/>">Sửa</a>
				| <a
				href="<c:url value='/admin/video/delete?videoid=${vid.videoId }'/>">Xóa</a></td>

		</tr>
	</c:forEach>


</table>
