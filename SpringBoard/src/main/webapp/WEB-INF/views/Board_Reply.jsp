<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>답변 쓰기</title>

<style>
	@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
	body {
		font-family : 'Nanum Gothic', sans-serif;
	}
</style>

<script type="text/javascript">
	function check() {
		if(document.post.name.value == "" || document.post.name.value == null) {
			alert("이름을 입력하세요");
			document.post.name.focus();
			return;
		} else if(document.post.title.value == "" || document.post.title.value == null) {
			alert("제목을 입력하세요");
			document.post.title.focus();
			return;
		} else if(document.post.content.value == "" || document.post.content.value == null) {
			alert("내용을 입력하세요");
			document.post.content.focus();
			return;
		} else if(document.post.password.value == "" || document.post.password.value == null) {
			alert("비밀번호를 입력하세요");
			document.post.password.focus();
			return;
		} else {
			document.post.submit();
		}
	}
</script>
</head>

<body>
	<table class="container">
		<tr>
			<td bgcolor=#dcdcdc height=25 align=center>답변 달기</td>
		</tr>
	</table>
	<br>
	<table class="table-bordered">
		<form name="post" method="post" action="boardReply.action" >
			<input type="hidden" name="temp_seq" value="${dto.seq }">
			<tr>
				<td>
					<table border=0 width=100% align=center>
						<tr>
							<td align="center">작성자</td>
							<td><input type=text name=name size=10 maxlength=8></td>
						</tr>
						<tr>
							<td width=10% align="center">제목</td>
							<td width=50%><input type=text name=title size=50 maxlength=30 value="ㄴRE : ${dto.title }"></td>
						</tr>
						<tr>
							<td width=10% align="center">비밀번호</td>
							<td width=70%><input type=password name=password size=15 maxlength=15></td>
						</tr>
						<tr>
							<td width=10% align="center">내용</td>
							<td><textarea name=content rows=10 cols=70> ${dto.content }
								--------------------------------------------------
								댓글 | 
								</textarea>
							</td>
						</tr>
						<tr>
							<td colspan=2><hr size=2></td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<input type="button" value="답변 등록" class="btn" onclick="check()" >
								<input type="button" value="뒤로가기" class="btn" onclick="javascript:history.back()">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</form>
	</table>
</body>
</html>