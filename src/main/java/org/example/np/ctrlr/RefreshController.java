package org.example.np.ctrlr;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.np.dto.TokenDto;
import org.example.np.util.JwtUtil;

@Path("/auth/refresh")
public class RefreshController {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response reNewAccessToken(TokenDto dto){
        try {
            String email = JwtUtil.validateToken(dto.getRefreshToken());
            String accessToken = JwtUtil.genarateToken(email);
            TokenDto tokenDto = new TokenDto();
            tokenDto.setAccessToken(accessToken);
            tokenDto.setRefreshToken(dto.getRefreshToken());
            return Response.ok().entity(tokenDto).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
