<%@ page language="java" contentType="text/html; charset=UTF8" 
 pageEncoding="UTF-8"%> 
<%@ page import = "java.sql.*" %> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>Insert Data</title> 
</head> 
<body> 
 <h1>Insert Record</h1> 
 <form method="post"> 
 <label for="rollno">Roll Number :- </label> 
 <input type="number" id="rollno" name="rollno" 
required><br><br> 
 
 <label for="name">Name :- </label> 
 <input type="text" id="name" name="name" 
required><br><br> 
 
 <label for="email">Email :- </label> 
 <input type="email" id="email" name="email" 
required><br><br> 
 
 <input type="submit" value="Insert"> 
 </form> 
 
 <% 
 if("POST".equalsIgnoreCase(request.getMethod())) { 
 String rollnoStr = request.getParameter("rollno"); 
 int rollno = Integer.parseInt(rollnoStr);
 String name = request.getParameter("name");
 String email = request.getParameter("email"); 
 try { 
 Class.forName("com.mysql.cj.jdbc.Driver"); 
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useSSL=false","root","P@&&word0911");
 PreparedStatement pstmt = con.prepareStatement("insert into student_data values(?, ?, ?)"); 
 pstmt.setInt(1, rollno); 
 pstmt.setString(2, name); 
 pstmt.setString(3, email); 
 int rowAffected = pstmt.executeUpdate(); 
 if(rowAffected > 0) { 
 out.println("Data Inserted Successfully"); 
 } 
 } 
 catch(Exception e) { 
 e.printStackTrace(); 
 } 
 } 
 %> 
 
</body> 
</html>