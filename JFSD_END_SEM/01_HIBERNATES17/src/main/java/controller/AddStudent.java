package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentManager;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public AddStudent() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve student information from the request
        int sid = Integer.parseInt(request.getParameter("sid"));
        String sname = request.getParameter("sname");
        String sdept = request.getParameter("sdept");
        String program = request.getParameter("program");
        String dob = request.getParameter("dob");
        String phno = request.getParameter("phno");
        String graduationStatus = request.getParameter("graduationStatus");
        String cgpa = request.getParameter("cgpa");
        String noOfBacklogs =request.getParameter("noOfBacklogs");
        // Create a new Student object and set its properties
        Student S = new Student();
        S.setSid(sid);
        S.setSname(sname);
        S.setSdept(sdept);
        S.setProgram(program);
        S.setDob(dob);
        S.setPhno(phno);
        S.setGraduationStatus(graduationStatus);
        S.setCgpa(cgpa);
        S.setNoOfBacklogs(noOfBacklogs);
        response.setContentType("text/html");
        String ack = "";
        try {
            StudentManager SM = new StudentManager();
            ack = SM.addStudent(S);
        } catch (Exception e) {
            ack = e.getMessage();
        }

        // Redirect to index.html and include acknowledgment message
        RequestDispatcher RD = request.getRequestDispatcher("index.html");
        PrintWriter PW = response.getWriter();
        PW.println(ack);
        RD.include(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
