//package com.waitlist.information.system.waitlist;
//import static org.hamcrest.Matchers.equalTo;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class ControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    public void getHello() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/Customer/findAllCustomers/11").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//                //.andExpect(content().string(equalTo('{"id":11,"name":"Nick","email":"nicks@gmail.com","number":"12345678","partySize":7}')));
//    }
//
//}
