package ar.com.cac24103.web.contrallers;

//import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.cac24103.web.domain.Usuario;
import ar.com.cac24103.web.dto.LoginRequestDTO;
import ar.com.cac24103.web.service.UsuarioService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/auth")
public class LoginController extends HttpServlet {

    protected void doPost(
        HttpServletRequest req,
        HttpServletResponse resp
    ) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();

        LoginRequestDTO loginRequestDTO = mapper.readValue(req.getReader(), LoginRequestDTO.class);

        UsuarioService service = new UsuarioService();

        Usuario usuario = service.buscarUsuario(loginRequestDTO.getUsername());

        if (usuario == null) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //401 = NO autorizado
            return;
        }
        if (!loginRequestDTO.getPassword().equals(usuario.getPassword())) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //401 = NO autorizado
            return;
        }

        resp.setStatus(HttpServletResponse.SC_CREATED); //201 Esta autenticado | existe
    }

}
