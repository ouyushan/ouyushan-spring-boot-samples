package org.ouyushan.springboot.jta.atomikos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootJtaAtomikosApplicationTests {

    @Test
    void testDeleteALl(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/deleteAll")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void testCreateAccountAndNotify(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/createAccountAndNotify")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
