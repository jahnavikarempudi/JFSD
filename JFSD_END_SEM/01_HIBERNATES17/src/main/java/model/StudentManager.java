package model;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jakarta.persistence.TypedQuery;
public class StudentManager {   
    // Method to add a new student
    public String addStudent(Student S) throws Exception {
        SessionFactory SF = new Configuration().configure().buildSessionFactory();
        Session SES = SF.openSession();      
        SES.getTransaction().begin();
        SES.persist(S);  // INSERT operation
        SES.getTransaction().commit();        
        SES.close();
        SF.close();        
        return "Student data has been saved successfully";
    }
    // Method to update existing student details
    public String updateStudent(Student S) throws Exception {
        SessionFactory SF = new Configuration().configure().buildSessionFactory();
        Session SES = SF.openSession();    
        SES.getTransaction().begin();
        Student tmp = SES.find(Student.class, S.getSid());     
        // Updating all fields from the Student class
        tmp.setSname(S.getSname());
        tmp.setSdept(S.getSdept());
        tmp.setProgram(S.getProgram());
        tmp.setDob(S.getDob());
        tmp.setPhno(S.getPhno());
        tmp.setGraduationStatus(S.getGraduationStatus());
        tmp.setCgpa(S.getCgpa());
        tmp.setNoOfBacklogs(S.getNoOfBacklogs());        
        SES.merge(tmp);  // UPDATE operation
        SES.getTransaction().commit();       
        SES.close();
        SF.close();        
        return "Student data has been updated successfully";
    }
    // Method to delete a student record
    public String deleteStudent(int sid) throws Exception {
        SessionFactory SF = new Configuration().configure().buildSessionFactory();
        Session SES = SF.openSession();       
        SES.getTransaction().begin();
        Student tmp = SES.find(Student.class, sid);
        if (tmp != null) {
            SES.remove(tmp);  // DELETE operation
        }
        SES.getTransaction().commit();
        
        SES.close();
        SF.close();
        
        return "Student data has been deleted successfully";
    }

    // Method to fetch all student records
    public List<Student> readStudents() throws Exception {
        List<Student> slist = null;
        
        SessionFactory SF = new Configuration().configure().buildSessionFactory();
        Session SES = SF.openSession();
        
        SES.getTransaction().begin();
        TypedQuery<Student> qry = SES.createQuery("select c from Student c", Student.class);
        slist = qry.getResultList();
        SES.getTransaction().commit();
        
        SES.close();
        SF.close();
        
        return slist;
    }
}
