package br.com.everest.auth;

import br.com.everest.auth.model.User;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthServiceApplicationTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void novoUsuario() throws Exception {
        User user = new User();
        user.setNome("teste");
        user.setEmail("teste@teste.com");
        user.setSenha("123");

        Gson gson = new Gson();
        String json = gson.toJson(user);

        mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void login() throws Exception {
        mockMvc.perform(post("/oauth/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .header("authorization", "Basic YXBwOmFwcA==")
                .param("username", "teste@teste.com")
                .param("password", "123d")
                .param("grant_type", "password"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
