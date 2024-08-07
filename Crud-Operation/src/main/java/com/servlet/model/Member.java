package com.servlet.model;

public class Member {
private int memberID;
private String memberName;
private String memberType;
private String memberEmail;
private String memberMobile;

public int getMemberID() { return memberID;}
public void setMemberID(int memberID) {
  this.memberID = memberID;
}

public String getMemberName() { return memberName;}
public void setMemberName(String memberName) {
  this.memberName = memberName;
}

public String getMemberType() { return memberType;}
public void setMemberType(String memberType) {
  this.memberType = memberType;
}
public String getMemberEmail() { return memberType;}
public void setMemberEmail(String memberEmail) {
  this.memberEmail = memberEmail;
}
public String getMemberMobile() { return memberMobile;}
public void setMemberMobile(String memberMobile) {
  this.memberMobile = memberMobile;
}
}
