package com.example.demo.api;

import com.example.demo.domain.Adresses;
import com.example.demo.domain.Category;
import com.example.demo.repo.AdressesRepository;
import com.example.demo.repo.CategoryRepository;
import com.example.demo.service.AdressesServiceImpl;
import com.example.demo.service.CategoryServiceImpl;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdressesController.class)
class AdressesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AdressesRepository adressesRepository;

    @MockBean
    private AdressesServiceImpl adressesServiceImpl;

    @MockBean
    private UserDetailsService userDetailsService;

    @MockBean
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @MockBean
    private UserService userService;


    /*
        private Long id;
    private String nameAdress;
    private String lastNameAdress;
    private String streetNumber;
    private String adressPartOne;
    private String adressPartTwo;
    private String zip;
    private String city;
    private  Boolean isInvoiceAdress;
    private  Boolean isDeliveryAdress;*/
    @Test
    @WithMockUser(value = "spring")
    void findAllAdresses() throws Exception {
        List<Adresses> listAdresses=new ArrayList<>();
        listAdresses.add(new Adresses(1L,"Dupont","Martin","12","Avenue De Gaulle", "Bat A","75003","Paris",true,false));
        listAdresses.add(new Adresses(2L,"Dupont","Gerard","12","Avenue De Gaulle", "Bat A","75003","Paris",true,false));
        listAdresses.add(new Adresses(3L,"Dupont","Pierre","12","Avenue De Gaulle", "Bat A","75003","Paris",true,false));

        Mockito.when(adressesRepository.findAll()).thenReturn(listAdresses);
        Mockito.when(adressesServiceImpl.findAllAdresses()).thenReturn(listAdresses);

        String url="/api/adress";

        ResultActions response=mockMvc.perform(get(url)).andExpect(status().isOk());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.size()", CoreMatchers.is(listAdresses.size())));

        response.andDo(print());

    }
}