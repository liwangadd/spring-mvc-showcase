package com.liwang.sample.mvc.async;

import com.liwang.sample.mvc.AbstractContextControllerTests;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Nikolas on 2015/10/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CallableControllerTests extends AbstractContextControllerTests {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void responseBody() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/async/callable/response-body"))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult("Callable result"))
                .andReturn();
        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(content().string("Callable result"));
    }

    @Test
    public void view() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/async/callable/view"))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult("views/html"))
                .andReturn();
        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/WEB-INF/views/views/html.jsp"))
                .andExpect(model().attribute("foo", "bar"))
                .andExpect(model().attribute("fruit", "apple"));
    }

    @Test
    public void exception() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/async/callable/exception"))
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(IllegalStateException.class)))
                .andReturn();

        this.mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(content().string("Handled exception: Callable error"));
    }

}
