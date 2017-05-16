package br.com.everest.tarefa;

import br.com.everest.tarefa.enumeration.Status;
import br.com.everest.tarefa.model.Tarefa;
import br.com.everest.tarefa.service.TarefaService;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TarefaServiceApplicationTests {

	@Autowired private WebApplicationContext context;
	@Autowired private TarefaService tarefaService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.build();
	}

	@Test
	public void crud() throws Exception {
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("teste");
		tarefa.setStatus(Status.PENDENTE);

		tarefa = tarefaService.save(tarefa);
		Assert.assertNotNull(tarefa);

		Assert.assertTrue(tarefaService.findAll().size() > 0);

		Assert.assertTrue(tarefaService.findLast().size() > 0);

		Assert.assertNotNull(tarefaService.findOne(tarefa.getId()));
	}
}
