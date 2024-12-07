package model;
public class Student {
    // name, gender, department, program, date of birth, contact number, graduation status, CGPA, no of backlogs.
    private int sid;
    private String sname;
    private String sdept;
    private String program;
    private String dob;
    private String phno;
    private String graduationStatus;
    private String cgpa;
    private String noOfBacklogs; // Changed to int for numerical value
    // Getters and Setters
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getSdept() {
        return sdept;
    }
    public void setSdept(String sdept) {
        this.sdept = sdept;
    }
    public String getProgram() {
        return program;
    }
    public void setProgram(String program) {
        this.program = program;
    }
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getGraduationStatus() {
        return graduationStatus;
    }

    public void setGraduationStatus(String graduationStatus2) {
        this.graduationStatus = graduationStatus2;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getNoOfBacklogs() {
        return noOfBacklogs;
    }

    public void setNoOfBacklogs(String noOfBacklogs2) {
        this.noOfBacklogs = noOfBacklogs2;
    }
  
    
}
