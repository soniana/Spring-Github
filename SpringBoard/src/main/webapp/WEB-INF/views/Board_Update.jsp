<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 수정</title>

<style>
	@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
	body {
		font-family : 'Nanum Gothic', sans-serif;
	}
</style>

<script type="text/javascript">
	function check() {
		if (document.form.name.value == "" || document.form.name.value == null) {
			alert("이름을 입력하세요");
			document.form.name.focus();
			return;
		} else if (document.form.title.value == "" || document.form.title.value == null) {
			alert("제목을 입력하세요");
			document.form.title.focus();
			return;
		} else if (document.form.content.value == "" || document.form.content.value == null) {
			alert("내용을 입력하세요");
			document.form.content.focus();
			return;
		} else if (document.form.pass.value == "" || document.form.pass.value == null) {
			alert("비밀번호를 입력하세요");
			document.form.pass.focus();
			return;
		} else if (document.form.pass.value != document.form.password.value) {
			alert("비밀번호가 틀렸습니다.");
			document.form.pass.focus();
			return;
		} else {
			document.form.submit();
		}
	}
</script>
</head>

<body>
	<form name="form" method="post" action="boardUpdate.action">
	<table summary="글 수정 전체 테이블">
		
			<input type="hidden" name="seq" value="${dto.seq }" />
			<input type="hidden" name="password" value="${dto.password }" />
	   		<colgroup>
	   			<col width="20%">
	   			<col width="80%">
	   		</colgroup>
			<table summary="테이블 구성" >
			<caption>글 수정하기 [${dto.seq }번] 게시물</caption>	
	    		<tr>
					<td>작성자</td>
					<td><input type=text name=name size=10 maxlength=8 value="${dto.name }"></td>
				</tr>
	    		<tr>
	     			<td>비밀번호</td> 
	     			<td><input type=password name=pass size=15 maxlength=15>수정 시에는 비밀번호가 필요합니다</td>
	    		</tr>				
	    		<tr>
	     			<td>제 목</td>
	     			<td><input type=text name=title value="${dto.title }"></td>
	    		</tr>
	    		<tr>
	     			<td>내 용</td>
	     			<td><textarea name=content rows="10" cols="100">${dto.content }</textarea></td>
	    		</tr>
	    		<tr>
	     			<td colspan=2><hr size=1></td>
	    		</tr>
	    		<tr>
	     			<td colspan="3"><div align="center">
		     			<input type="button" value="수정" onclick="check()">
						<input type="reset" value="재수정"> 
		         		<input type="button" value="목록" onclick="history.back()"></div>
	     			</td>
	    		</tr> 
			</table>
		 
	</table>
	</form>
</body>
</html>