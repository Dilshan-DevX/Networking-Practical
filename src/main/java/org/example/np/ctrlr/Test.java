package org.example.np.ctrlr;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.np.entity.Student;
import org.example.np.util.HibernateUtil;
import org.example.np.util.JwtUtil;
import org.hibernate.Session;

import java.util.List;

@Path("/test")
public class Test {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(){

        return Response.ok(JwtUtil.genarateToken("john.doe@example.com")).build();
    }

    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> fromStudents = session.createQuery("FROM Student", Student.class).getResultList();
        session.clear();
        return Response.ok().entity(fromStudents).build();
    }
}
