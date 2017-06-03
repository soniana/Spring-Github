<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� �б�</title>

<style>
	@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
	body {
		font-family : 'Nanum Gothic', sans-serif;
	}
</style>

<script type="text/javascript">
	function list() {
		document.list.action="boardList.action";
		document.list.submit();
	}
</script>
</head>
<body>
	<!-- <form name="BoardViewForm" method="post"> -->
		<table summary="��ü ���̺� ����" width=600 height=400 cellpadding=5 cellspacing=0>
			<tr>
				<td><div align="center"><h3><b>�� �б�</b></h3></div></td>
			</tr>
			<tr>
				<td colspan=2>
					<table border="1" summary="��� ���̺� ����">
						<tr>
							<td align=center bgcolor=#dddddd width=20%>�ۼ���</td>
							<td bgcolor=#ffffe8 width=30%>${dto.name }</td>
							<td align=center bgcolor=#dddddd width=15%>�ۼ���</td>
							<td bgcolor=#ffffe8 width=50%>${dto.regdate }</td>
						</tr>
						<tr>
							<td align=center bgcolor=#dddddd> E-mail </td>
							<%-- <td bgcolor=#ffffe8 >${dto.email }</td>  --%>
							<td bgcolor=#ffffe8 >�̸��� ������</td> 
							<td align=center bgcolor=#dddddd> Ȩ������ </td>
							<td bgcolor=#ffffe8>Ȩ�������� ��������</td>
							<%-- <td bgcolor=#ffffe8><a href="http://${dto.homepage }" target="_new">http://${dto.homepage }</a></td> --%> 		 						
						</tr>
						<tr>
							<td align=center bgcolor=#dddddd> �� ��</td>
							<td bgcolor=#ffffe8 colspan=3>${dto.title }</td>						
						</tr>
						<tr> 
							<td colspan=4><br>${dto.content }<br></td>
						</tr>
						<tr>
							<td colspan=4 align=right> ��ȸ��  : ${dto.count }</td>
						</tr>						
					</table>
				</td>
			</tr>
			<tr>
				<td align=center colspan=2> 
					<hr size=1>
					<div align="center">
						[ <a href="javascript:list()">���</a> | 
						<a href="boardUpdate.action?seq=${dto.seq }">����</a> |
						<a href="boardReply.action?seq=${dto.seq }">�亯</a> |
						<a href="boardDelete.action?seq=${dto.seq }">����</a>]<br>
					</div>
				</td>			
			</tr>
		</table>
	<form name="list" method="post">
        <input type="hidden" name="seq" value="${dto.seq}">
        <input type="hidden" name="keyField" value="${keyField}">
        <input type="hidden" name="keyWord" value="${keyWord}">		
	</form>
	<!-- </form> -->
</body>
</html>