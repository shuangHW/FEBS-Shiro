package cc.mrbird.febs.system.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;


/**
 * mockMvc.perform执行一个请求
 * MockMvcRequestBuilders.get(“/user/1”)构造一个请求，Post请求就用.post方法
 * contentType(MediaType.APPLICATION_JSON_UTF8)代表发送端发送的数据格式是application/json;charset=UTF-8
 * accept(MediaType.APPLICATION_JSON_UTF8)代表客户端希望接受的数据类型为application/json;charset=UTF-8
 * session(session)注入一个session，这样拦截器才可以通过
 * ResultActions.andExpect添加执行完成后的断言
 * ResultActions.andExpect(MockMvcResultMatchers.status().isOk())方法看请求的状态响应码是否为200如果不是则抛异常，测试不通过
 * andExpect(MockMvcResultMatchers.jsonPath(“$.author”).value(“嘟嘟MD独立博客”))这里jsonPath用来获取author字段比对是否为嘟嘟MD独立博客,不是就测试不通过
 * ResultActions.andDo添加一个结果处理器，表示要对结果做点什么事情，比如此处使用MockMvcResultHandlers.print()输出整个响应结果信息
 */


@RunWith(SpringRunner.class)
@SpringBootTest
class DeptControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    private MockHttpSession session;


    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();
        //User user =new User("root","root");
        //session.setAttribute("user",user); //拦截器那边会判断用户是否登录，所以这里注入一个用户
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDeptTree() {
    }

    @Test
    void getDeptTree1() {
    }

    @Test
    void addDept() throws Exception{
        String json="{\"deptId\":\"123123\",\"parentId\":\"1\",\"deptName\":\"SD\",\"orderNum\":\"999\"}";
        mvc.perform(MockMvcRequestBuilders.post("/learn/add")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .content(json.getBytes()) //传json参数
                .session(session))
                //
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deleteDepts() {
    }

    @Test
    void updateDept() {
    }

    @Test
    void export() {
    }
}