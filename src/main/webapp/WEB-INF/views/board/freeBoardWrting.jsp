<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%request.setCharacterEncoding("utf-8"); %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글내용</title>
<style type="text/css">
#menu{
position:absolute;
top:140px;
left:5%;
width: 15%;
height: 800px;
background-color: #e6e6e6;
font-size: 30px;

}
.wrting{
text-align:right;
position: absolute;
right:60px;
top:50px;
}
#boardmain{
position:relative;
top:52px;
left:14.8%;
width:88%;
height:800px;
text-align:"center";
background-color: white;

}
.comment{
width: 90%;
margin:auto;
border-bottom: 1px solid gray;
margin:auto;
}
.td{
border: 1px solid gray;
border-top::none;
}
.mn{
text-decoration: none;
height: 80px;

}
#boardtable{
border: 1px solid gray;
width: 90%;
margin:auto;

}
#boardhead{
padding-top:30px;
text-align: left;
padding-left:6%;
width: 70%;
height: 60px;
}
td{
height:35px;
}
#page{
font-size: 25px;
padding:10px;
padding-top:20px;
}
#boardmenu{
height: 50px;
background-color: #e6e6e6;
}
#title{
color: inherit;
}
#board_content{
height: 350px;
}
textarea {
	border:0;
}
textarea:focus{
outline: none;
}
.file{
  width: 100%;
  padding: 0;
  border-width: 0;
}
</style>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
</head>
<body>
 <header class="masthead">
 <div class="container">

 <div id="menu">
 <br>
 <a href ="${pageContext.request.contextPath}/board/freeboard.do" class="mn">자유게시판</a><br>
 <a href ="${pageContext.request.contextPath}/board/qnaBoard.do" class="mn">QnA</a><br>
 <a href ="${pageContext.request.contextPath}/board/noticeBoard.do" class="mn">공지사항</a><br>
 </div>
  <br>
 <div id="boardmain">
 <div id="boardhead">
 조회수: 99
   </div>
   <div class="wrting">
   <input type="submit" value="올리기" >
   </div>
  <br>
  <table id="boardtable">
  <tr id="boardmenu">
  <td width="10%" class="td">제목</td>
  <td id="board_title" width="60%" class="td">테스트 글 입니다.</td>
  </tr>
    <tr> 
  <td colspan="2" width="85%" class="td">내용</td>
  </tr>
   <tr> 
 <td colspan="2" id="board_content" class="td"><textarea rows="20" cols="100%" style="resize:none;" ></textarea></td>
  </tr>
  <tr>
  <td width="10%" class="td">이미지 첨부</td>
  <td colspan="2" width="85%" class="td"><input type="file" class="file">
 
  </table>

 </div>
 </div>
 </header>
</body>
</html>