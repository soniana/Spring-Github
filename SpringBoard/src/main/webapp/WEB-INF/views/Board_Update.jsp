<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ����</title>

<style>
	@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
	body {
		font-family : 'Nanum Gothic', sans-serif;
	}
</style>

<script type="text/javascript">
	function check() {
		if (document.form.name.value == "" || document.form.name.value == null) {
			alert("�̸��� �Է��ϼ���");
			document.form.name.focus();
			return;
		} else if (document.form.title.value == "" || document.form.title.value == null) {
			alert("������ �Է��ϼ���");
			document.form.title.focus();
			return;
		} else if (document.form.content.value == "" || document.form.content.value == null) {
			alert("������ �Է��ϼ���");
			document.form.content.focus();
			return;
		} else if (document.form.pass.value == "" || document.form.pass.value == null) {
			alert("��й�ȣ�� �Է��ϼ���");
			document.form.pass.focus();
			return;
		} else if (document.form.pass.value != document.form.password.value) {
			alert("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
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
	<table summary="�� ���� ��ü ���̺�">
		
			<input type="hidden" name="seq" value="${dto.seq }" />
			<input type="hidden" name="password" value="${dto.password }" />
	   		<colgroup>
	   			<col width="20%">
	   			<col width="80%">
	   		</colgroup>
			<table summary="���̺� ����" >
			<caption>�� �����ϱ� [${dto.seq }��] �Խù�</caption>	
	    		<tr>
					<td>�ۼ���</td>
					<td><input type=text name=name size=10 maxlength=8 value="${dto.name }"></td>
				</tr>
	    		<tr>
	     			<td>��й�ȣ</td> 
	     			<td><input type=password name=pass size=15 maxlength=15>���� �ÿ��� ��й�ȣ�� �ʿ��մϴ�</td>
	    		</tr>				
	    		<tr>
	     			<td>�� ��</td>
	     			<td><input type=text name=title value="${dto.title }"></td>
	    		</tr>
	    		<tr>
	     			<td>�� ��</td>
	     			<td><textarea name=content rows="10" cols="100">${dto.content }</textarea></td>
	    		</tr>
	    		<tr>
	     			<td colspan=2><hr size=1></td>
	    		</tr>
	    		<tr>
	     			<td colspan="3"><div align="center">
		     			<input type="button" value="����" onclick="check()">
						<input type="reset" value="�����"> 
		         		<input type="button" value="���" onclick="history.back()"></div>
	     			</td>
	    		</tr> 
			</table>
		 
	</table>
	</form>
</body>
</html>