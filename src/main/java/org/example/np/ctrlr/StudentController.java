package org.example.np.ctrlr;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.np.entity.Student;
import org.example.np.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

@Path("/student")
public class StudentController {
    @GET
    @Path("/get-all")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStudent(){
        try(Session hibernate = HibernateUtil.getSessionFactory().openSession()){
            List<Student> studentList = hibernate.createQuery("FROM Student s",Student.class).getResultList();

            return Response.ok().entity(studentList).build();
        }
    }
}
