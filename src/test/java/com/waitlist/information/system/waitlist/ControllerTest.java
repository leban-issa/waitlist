// package com.waitlist.information.system.waitlist;

// import static org.hamcrest.Matchers.hasSize;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.mockito.BDDMockito.given;
// import static org.mockito.Mockito.*;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.waitlist.information.system.waitlist.controller.CustomerRestController;
// import com.waitlist.information.system.waitlist.controller.RestaurantRestController;
// import com.waitlist.information.system.waitlist.controller.TableRestController;
// import com.waitlist.information.system.waitlist.model.Customer;
// import com.waitlist.information.system.waitlist.model.Restaurant;
// import com.waitlist.information.system.waitlist.model.Table;
// import com.waitlist.information.system.waitlist.repository.CustomerRepository;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

// import org.junit.jupiter.api.Disabled;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.*;
// import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.junit.Ignore;


// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;



// @SpringBootTest
// @AutoConfigureMockMvc
// public class ControllerTest {

//     @Autowired
//     private MockMvc mvc;

//     @Autowired
//     private ObjectMapper mapper;

//     @MockBean
//     CustomerRestController customerRestController;

//     @MockBean
//     RestaurantRestController restaurantRestController;

//     @MockBean
//     TableRestController tableRestController;

//     @MockBean
//     private CustomerRepository customerRepository;

//     @Test
//     public void postRequestAddValidCustomer() throws Exception{
//         Customer customer = new Customer("Bob","bob@gmail.com","416-555-5555","",2);
//         Mockito.when(customerRestController.addCustomer(Mockito.any(Customer.class))).thenReturn(customer);
//         MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/Customer/addCustomer")
//                 .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
//                 .characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(customer));
//         mvc.perform(builder)
//                 .andExpect(status().isOk())
//                 .andExpect(MockMvcResultMatchers.content().string(this.mapper.writeValueAsString(customer)));
//     }

//     @Test
//     public void postRequestAddInvalidCustomer() throws Exception{
//         Customer customer = new Customer("","bob@gmail.com","416-555-5555","",2);
//         String customerJsonString = this.mapper.writeValueAsString(customer);
//         ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/Customer/addCustomer")
//                 .contentType(MediaType.APPLICATION_JSON).content(customerJsonString)).andExpect(status().isBadRequest());
//         assertEquals(MethodArgumentNotValidException.class,
//                 resultActions.andReturn().getResolvedException().getClass());
//         assertTrue(resultActions.andReturn().getResolvedException().getMessage().contains("Name cannot be empty"));

//     }

//     @Test
//     public void getAllCustomers() throws Exception{
//         List<Customer> customerList = new ArrayList<>();
//         Customer customer1 = new Customer("Bob","bob@gmail.com","416-555-5555","2",2);
//         Customer customer2 = new Customer("Joe","joe@gmail.com","416-444-4444","3",2);
//         customerList.add(customer1);
//         customerList.add(customer2);
//         when(customerRestController.getCustomers()).thenReturn(customerList);
//         this.mvc.perform(MockMvcRequestBuilders.get("/Customer/findAllCustomers").contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$", hasSize(2)));
//     }

//     @Test
//     public void getCustomerById() throws Exception{
//         String customerId = "2";
//         Customer customer = new Customer("Bob","bob@gmail.com","416-555-5555","2",2);
//         when(customerRestController.getCustomerById(customerId)).thenReturn(Optional.of(customer));
//                  mvc.perform(MockMvcRequestBuilders.get("/Customer/findAllCustomers/{id}", customerId)
//                  .contentType(MediaType.APPLICATION_JSON))
//                  .andExpect(status().isOk());
//     }

//     @Disabled("work in progress")
//     @Test
//     public void getCustomerByIdReturn404() throws Exception{
//         String customerId = "2";
//         given(customerRestController.getCustomerById(customerId)).willReturn(Optional.empty());
//         mvc.perform(MockMvcRequestBuilders.get("/Customer/findAllCustomers/{id}", customerId)
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isNotFound());

//     }

//     @Test
//     public void deleteCustomer() throws Exception{
//         String customerId = "2";
//         Customer customer = new Customer("Bob","bob@gmail.com","416-555-5555",customerId,2);
//         given(customerRestController.getCustomerById(customerId)).willReturn(Optional.of(customer));
//         doNothing().when(customerRestController).deleteCustomerById(customer.getId());
//         mvc.perform(MockMvcRequestBuilders.delete("/Customer/deleteById/{id}",customerId))
//                 .andExpect(status().isOk());

//     }

//     @Test
//     public void postRequestAddValidRestaurant() throws Exception{
//         Restaurant restaurant = new Restaurant("","Pizza Land","416-555-5555","123 Street","password1" );
//         Mockito.when(restaurantRestController.addRestaurant(Mockito.any(Restaurant.class))).thenReturn(restaurant);
//         MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/Restaurant/addRestaurant")
//                 .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
//                 .characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(restaurant));
//         mvc.perform(builder)
//                 .andExpect(status().isOk())
//                 .andExpect(MockMvcResultMatchers.content().string(this.mapper.writeValueAsString(restaurant)));
//     }

//     @Test
//     public void postRequestAddInvalidRestaurant() throws Exception{
//         Restaurant restaurant = new Restaurant("","","416-555-5555","123 Street", "password1" );
//         String restaurantJsonString = this.mapper.writeValueAsString(restaurant);
//         ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/Restaurant/addRestaurant")
//                 .contentType(MediaType.APPLICATION_JSON).content(restaurantJsonString)).andExpect(status().isBadRequest());
//         assertEquals(MethodArgumentNotValidException.class,
//                 resultActions.andReturn().getResolvedException().getClass());
//         assertTrue(resultActions.andReturn().getResolvedException().getMessage().contains("Name cannot be empty"));

//     }

//     @Test
//     public void getAllRestaurants() throws Exception{
//         List<Restaurant> restaurantList = new ArrayList<>();
//         Restaurant restaurant1 = new Restaurant("2","Pizza Land","416-555-5555","123 Street","password1" );
//         Restaurant restaurant2 = new Restaurant("3","Best Pasta","416-444-4444","255 Street", "password2" );
//         restaurantList.add(restaurant1);
//         restaurantList.add(restaurant2);
//         when(restaurantRestController.getRestaurant()).thenReturn(restaurantList);
//         this.mvc.perform(MockMvcRequestBuilders.get("/Restaurant/findAllRestaurants").contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$", hasSize(2)));
//     }

//     @Test
//     public void getRestaurantById() throws Exception{
//         String restaurantId = "100";
//         Restaurant restaurant = new Restaurant(restaurantId,"Pizza Land","416-555-5555","123 Street","password" );
//         given(restaurantRestController.getRestaurantById(restaurantId)).willReturn(Optional.of(restaurant));
//         mvc.perform(MockMvcRequestBuilders.get("/Restaurant/findAllRestaurants/{id}", restaurantId)
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk());

//     }

//     @Test
//     public void postRequestAddValidTable() throws Exception{
//         Table table = new Table("",4,"Patio");
//         Mockito.when(tableRestController.addTable(Mockito.any(Table.class))).thenReturn(table);
//         MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/Table/addTable")
//                 .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
//                 .characterEncoding("UTF-8").content(this.mapper.writeValueAsBytes(table));
//         mvc.perform(builder)
//                 .andExpect(status().isOk())
//                 .andExpect(MockMvcResultMatchers.content().string(this.mapper.writeValueAsString(table)));
//     }

//     @Test
//     public void postRequestAddInvalidTable() throws Exception{
//         Table table = new Table("2",4,"");
//         String restaurantJsonString = this.mapper.writeValueAsString(table);
//         ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/Table/addTable")
//                 .contentType(MediaType.APPLICATION_JSON).content(restaurantJsonString)).andExpect(status().isBadRequest());
//         assertEquals(MethodArgumentNotValidException.class,
//                 resultActions.andReturn().getResolvedException().getClass());
//         assertTrue(resultActions.andReturn().getResolvedException().getMessage().contains("Location cannot be empty"));

//     }

//     @Test
//     public void getAllTables() throws Exception{
//         List<Table> tableList = new ArrayList<>();
//         Table table1 = new Table("2",4,"Patio");
//         Table table2 = new Table("3",6,"Private Room" );
//         tableList.add(table1);
//         tableList.add(table2);
//         when(tableRestController.getTables()).thenReturn(tableList);
//         this.mvc.perform(MockMvcRequestBuilders.get("/Table/findAllTables").contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$", hasSize(2)));
//     }

//     @Test
//     public void getTablesById() throws Exception{
//         String tableId = "3";
//         Table table = new Table("2",4,"Patio");
//         given(tableRestController.getTableById(tableId)).willReturn(Optional.of(table));
//         mvc.perform(MockMvcRequestBuilders.get("/Table/findAllTables/{id}/", tableId)
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk());
//     }
// }



