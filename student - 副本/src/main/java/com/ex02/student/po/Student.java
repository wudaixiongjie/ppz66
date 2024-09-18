package com.ex02.student.po;

public class Student {
    private String sno;   // 学号
    private String sname; // 姓名
    private String ssex;  // 性别
    private String snative; // 籍贯
    private int mno;      // 专业编号

    // getter 和 setter 方法
    public String getSno() { return sno; }
    public void setSno(String sno) { this.sno = sno; }
    public String getSname() { return sname; }
    public void setSname(String sname) { this.sname = sname; }
    public String getSsex() { return ssex; }
    public void setSsex(String ssex) { this.ssex = ssex; }
    public String getSnative() { return snative; }
    public void setSnative(String snative) { this.snative = snative; }
    public int getMno() { return mno; }
    public void setMno(int mno) { this.mno = mno; }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", snative='" + snative + '\'' +
                ", mno=" + mno +
                '}';
    }
}
