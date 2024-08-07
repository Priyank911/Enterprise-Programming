package com.servlet.handler;

import java.sql.*;
import java.util.*;

import com.servlet.model.Member;

public class MemberDAOHandler {
public static Connection connectionDB() {
	Connection conn = null;
	try {
		Class.forName("com.mysql.cj.Driver");
		String mysqlUrl = "jdbc://localhost:3306/classicmodels?useSSL= false";
		conn = DriverManager.getConnection(mysqlUrl, "root","P@&&word0911");
	}catch(Exception e) {
		System.out.print("Error: "+ e.getMessage());
	}
	return conn;
}
public static int addMember(Member member) throws SQLException {
	int result= 0;
	try {
		Connection conn = MemberDAOHandler.connectionDB();
		String sqlstr = "insert into Member (Membername, MemberType," + "MemberEmail, MemberMobile) values(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sqlstr);
		pstmt.setString(1, member.getMemberName());
		pstmt.setString(2, member.getMemberType());
		pstmt.setString(3, member.getMemberEmail());
		pstmt.setString(4, member.getMemberMobile());
		result = pstmt.executeUpdate();
		conn.close();
		
	}catch(Exception e) {
		System.out.print("Error: " + e.getMessage());
	}
	return result;
}
public static int updateMember (Member member) throws SQLException{
	int result = 0;
	try {
		Connection conn = MemberDAOHandler.connectionDB();
		String sqlstr = "update Member set Membername = ?," + "MemberType = ?, MemberEmail= ?, MemberMobile=?" + "where MemberID = ?";
		PreparedStatement pstmt = conn.prepareStatement(sqlstr);
		pstmt.setString(1, member.getMemberName());
		pstmt.setString(2, member.getMemberType());
		pstmt.setString(3, member.getMemberEmail());
		pstmt.setString(4, member.getMemberMobile());
		pstmt.setInt(5, member.getMemberID());
		result = pstmt.executeUpdate();
		conn.close();
		
	}catch(Exception e) {
		System.out.print("Error: "+ e.getMessage());
	}
	return result;
	
}
public static int deleteMember (int memberid) throws SQLException{
	int result = 0;
	try {
		Connection conn = MemberDAOHandler.connectionDB();
		String sqlstr = "delete from Member where MemberID=?";
		PreparedStatement pstmt = conn.prepareStatement(sqlstr);
		pstmt.setInt(1, memberid);
		result = pstmt.executeUpdate();
		conn.close();
		
	}catch(Exception e) {
		System.out.print("Error: "+ e.getMessage());
	}
	return result;
}
public static Member getMemberbyID (int memberID) throws SQLException{
	Member member = new Member();
		Connection conn = MemberDAOHandler.connectionDB();
		String sqlstr = "select from Member where MemberID=?";
		PreparedStatement pstmt = conn.prepareStatement(sqlstr);
		pstmt.setInt(1, memberID);
		ResultSet result = pstmt.executeQuery();
		if(result.next()) {
			member.setMemberID(result.getInt(1));
			member.setMemberName(result.getString(2));
			member.setMemberType(result.getString(3));
			member.setMemberMobile(result.getString(4));
		}
		conn.close();
		return member;
	}
public static List<Member>getAllMembers() throws SQLException{
    List<Member>members=new ArrayList<Member>();
    
    Connection conn= MemberDAOHandler.connectionDB();
    String sqlstr = "select * from Member";
    PreparedStatement pstmt = conn.prepareStatement(sqlstr);
    ResultSet result = pstmt.executeQuery();
    
    while(result.next()) {
      Member member=new Member();
      
      member.setMemberID(result.getInt(1));
      member.setMemberName(result.getString(2));
      member.setMemberType(result.getString(3));
      member.setMemberEmail(result.getString(4));
      member.setMemberMobile(result.getString(5));
      members.add(member);
}
    conn.close();
    return members;
}
}
