package org.ouyushan.springboot.io.email;

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
class SpringBootIoEmailApplicationTests {

    @Test
    public void testSimpleSender(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/simpleSender")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    public void testHtmlSender(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/htmlSender")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testAttachSender(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/attachSender")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testInnerAttachSender(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/innerAttachSender")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
