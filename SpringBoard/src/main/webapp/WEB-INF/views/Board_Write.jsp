<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�۾���</title>

<style>
	@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
	body {
		font-family : 'Nanum Gothic', sans-serif;
	}
</style>

<script type="text/javascript">
	function check() {
		if (document.post.name.value == "" || document.post.name.value == null) {
			alert("�̸��� �Է��ϼ���");
			document.post.name.focus();
			return;
		}else if (document.post.title.value == "" || document.post.title.value == null) {
			alert("������ �Է��ϼ���");
			document.post.title.focus();
			return;
		}else if (document.post.content.value == "" || document.post.content.value == null) {
			alert("������ �Է��ϼ���");
			document.post.content.focus();
			return;
		}else if (document.post.password.value == "" || document.post.password.value == null) {
			alert("��й�ȣ�� �Է��ϼ���");
			document.post.password.focus();
			return;
		}else {
			document.post.submit();
		}
	}
</script>
</head>

<body>
	<form name="post" method="post" action="boardWrite.action">
	<table summary="�۾��� ��ü ���̺�">
		
			<colgroup>
				<col width="20%">
				<col width="80%0">
			</colgroup>
		<table summary="���̺� ����" >
		<caption>�Խ��� �۾���</caption>
			<tr>
				<td>�ۼ���</td>
				<td><input type=text name=name size=10 maxlength=8></td>
			</tr>
			<tr>
				<td>����</td>
				<td><input type=text name=title></td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input type=password name=password size=15 maxlength=15></td>
			</tr>						
			<tr>
				<td>����</td>
				<td><textarea name=content rows="10" cols="100"></textarea></td>
			</tr>
			<tr>
				<td colspan=2><hr size=1></td>
			</tr>						
			<tr>
				<td colspan="3">
					<div align="center">
						<input type="submit" value="���" onclick="check()">
						<input type="button" value="���" onclick="history.back()">
					</div>
				</td>
			</tr>
		</table>
		
	</table>
	</form>
</body>
</html>