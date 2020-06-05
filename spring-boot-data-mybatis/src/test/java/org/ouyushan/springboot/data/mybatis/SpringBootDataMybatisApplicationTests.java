package org.ouyushan.springboot.data.mybatis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.ouyushan.springboot.data.mybatis.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootDataMybatisApplicationTests {

    /**
     * 根据ID查询
     */
    @Test
    public void testSelectById(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/getUser/{1}", 1))
                .andDo(MockMvcResultHandlers.print()) //方法用于 打印请求、响应及其他相关信息
                .andExpect(status().isOk())
                .andExpect(content().json(("{\"id\":1,\"userName\":\"admin\",\"password\":\"123\",\"age\":28}")));
    }

    /**
     * 查询用户列表
     */
    @Test
    public void testSelectAll(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/getUsers"))
                .andDo(MockMvcResultHandlers.print())
                //.andDo(print())
                .andExpect(status().isOk());
    }


    /**
     * 添加用户
     *
     * @throws Exception
     */
    @Test
    public void testAddUser(@Autowired MockMvc mockMvc) throws Exception {

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("mybatis");
        userInfo.setPassword("mybatis");
        userInfo.setAge(25);

        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(userInfo);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(userJson))

                .andDo(MockMvcResultHandlers.print())
                // .andDo(print())
                .andExpect(status().isOk());
    }


    /**
     * 更新用户
     *
     * @throws Exception
     */
    @Test
    public void testUpdateUser(@Autowired MockMvc mockMvc) throws Exception {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(9L);
        userInfo.setUserName("mockMvc1");
        userInfo.setPassword("mockmvc1");
        userInfo.setAge(28);

        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(userInfo);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/user/updateUser")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(userJson))

                .andDo(MockMvcResultHandlers.print())
                // .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * 删除
     *
     * @throws Exception
     */
    @Test
    public void testDeleteUser(@Autowired MockMvc mockMvc) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/user/delete/{id}", 9))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

}
