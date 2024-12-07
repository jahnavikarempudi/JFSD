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

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int sid = Integer.parseInt(request.getParameter("T1"));
		String sname = request.getParameter("T2");
		String sdept = request.getParameter("T3");
		String cgpa=request.getParameter("cgpa");
		String program =request.getParameter("program");
		String noOfBacklogs=request.getParameter("noOfBacklogs");
		String dob=request.getParameter("dob");
		String graduationStatus=request.getParameter("graduationStatus");
		String phno=request.getParameter("phno");
		Student S = new Student();
		S.setSid(sid);
		S.setSname(sname);
		S.setSdept(sdept);
		S.setCgpa(cgpa);
		S.setNoOfBacklogs(noOfBacklogs);
		S.setDob(dob);
		S.setGraduationStatus(graduationStatus);
		S.setProgram(program);
		S.setPhno(phno);
		
		
		response.setContentType("text/html");
		String ack="";
		try
		{
			StudentManager SM = new StudentManager();
			ack = SM.updateStudent(S);
		}catch(Exception e)
		{
			ack = e.getMessage();
		}
		RequestDispatcher RD = request.getRequestDispatcher("update.html");
		PrintWriter PW = response.getWriter();
		PW.println(ack);
		RD.include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
