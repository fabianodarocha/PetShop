package br.com.tt.petshop.api;


import br.com.tt.petshop.config.ModelMapperConfig;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
//@Import(ModelMapperConfig.class)
public class UnidadeControllerE2ETest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveriaRetornarListaUnidadesVazia() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/unidades"))
                .andExpect(MockMvcResultMatchers.status()
                        .is(200))
                .andExpect(MockMvcResultMatchers.content()
                        .string("[]"));
    }

    @Test
    @Sql("classpath:data.sql")
    public void deveriaRetornarUmaUnidade() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/unidades"))
                .andExpect(MockMvcResultMatchers.status()
                        .is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("id")
                        .value(CoreMatchers.is(1)))

        ;
    }

}
