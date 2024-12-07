<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="model.Student" %>
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JFSD - Student Details</title>
    <style>
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid black;
        }
        th {
            background-color: #f2f2f2;
        }
        button {
            padding: 10px;
            margin: 20px;
        }
        a {
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">Student Details</h2>

    <%
        @SuppressWarnings("unchecked")
        List<Student> slist = (List<Student>) request.getAttribute("studentlist");
        if (slist == null || slist.isEmpty()) {
    %>
        <p style="text-align: center;">No student records found.</p>
    <%
        } else {
    %>
        <table>
            <tr>
                <th>Student ID</th>
                <th>Student Name</th>
                <th>Department</th>
                <th>Program</th>
                <th>Date of Birth</th>
                <th>Contact Number</th>
               <th>Graduation Status</th> 
                <th>CGPA</th>
                <th>Number of Backlogs</th>
            </tr>
            <% for(Student s : slist) { %>
            <tr>
                <td><%= s.getSid() %></td>
                <td><%= s.getSname() %></td>
                <td><%= s.getSdept() %></td>
                <td><%= s.getProgram() %></td>
                <td><%= s.getDob() %></td>
                <td><%= s.getPhno() %></td>
                <td><%= s.getGraduationStatus() %></td>
                <td><%= s.getCgpa() %></td>
                <td><%= s.getNoOfBacklogs() %></td>
            </tr>
            <% } %>
        </table>
    <%
        }
    %>

    <div style="text-align: center;">
        <button><a href="index.html">Back</a></button>
    </div>
</body>
</html>
