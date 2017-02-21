package org.ownjoo.service.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTests
{
    @Autowired
    private MockMvc mockMvc;
    private String  badContent  =   "'><script>alert(0);</script><!--";

    @Test
    public void noParamItemShouldReturnDefaultMessage() throws Exception
    {

        this.mockMvc
                .perform(get("/item")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, World!"));
    }

    @Test
    public void paramItemShouldReturnTailoredMessage() throws Exception
    {

        this.mockMvc.perform(get("/item").param("name", "Spring Community"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
    }

    @Test//(expected=javax.validation.ValidationException.class)
    public void paramInvalidInputShouldThrowAnException() throws Exception
    {
        this.mockMvc.perform(get("/item").param("name", this.badContent));
    }
}
