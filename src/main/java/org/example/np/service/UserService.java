package org.example.np.service;

import jakarta.ws.rs.core.Response;
import org.example.np.dto.LoginReqDto;
import org.example.np.dto.TokenDto;
import org.example.np.entity.User;
import org.example.np.util.HibernateUtil;
import org.example.np.util.JwtUtil;
import org.hibernate.Session;

public class UserService {
    public Response validateUser(LoginReqDto dto){
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.createQuery("FROM User u WHERE u.email = :email AND u.password = :password", User.class)
                .setParameter("email", dto.getEmail())
                .setParameter("password", dto.getPassword())
                .getSingleResultOrNull();
        session.close();
        if (user == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        TokenDto tokenDto = new TokenDto();
        tokenDto.setAccessToken(JwtUtil.genarateToken(user.getEmail()));
        tokenDto.setRefreshToken(JwtUtil.genarateRefreshToken(user.getEmail()));
        return Response.status(Response.Status.OK).entity(tokenDto).build();
    }
}
