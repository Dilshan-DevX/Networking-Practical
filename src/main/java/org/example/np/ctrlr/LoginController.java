package org.example.np.ctrlr;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.np.dto.LoginReqDto;
import org.example.np.service.UserService;

@Path("/auth/login")
public class LoginController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response userLogin(LoginReqDto dto ){
        return new UserService().validateUser(dto);
    }
}
