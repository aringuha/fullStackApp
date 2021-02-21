package com.app.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.app.SupplierAppApplication;
import com.app.controller.SupplierController;
import com.app.model.Supplier;
import com.app.service.SupplierService;
import com.app.utils.Utils;

@RunWith(SpringRunner.class)
@WebMvcTest(SupplierAppApplication.class)
public class SupplierControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private SupplierService supplierService;

	@MockBean
	private SupplierController supplierController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(supplierController).build();
	}
	
	/*
	@Test
	public void findAllUrlTest() throws Exception {
		// given
		List<Supplier> supplierList = new ArrayList<Supplier>();
		supplierList.add(new Supplier("John", "Doe","123 Street", "Washington D.C.", "123-345-5678"));
		supplierList.add(new Supplier("Mary", "Doe","246 Street", "San Fransisco", "345-567-8912"));

		// when
		when(supplierService.findAll()).thenReturn(supplierList);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/suppliers")
				.contentType(MediaType.APPLICATION_JSON).content(Utils.asJsonString(supplierList)))
				.andExpect(status().is2xxSuccessful())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].firstName", is("John")))
				.andExpect(jsonPath("$[0].lastName", is("Doe")))
				.andExpect(jsonPath("$[0].address", is("Washington D.C.")))
				.andExpect(jsonPath("$[0].city", is("123 Street")))
				.andExpect(jsonPath("$[0].telephone", is("123-345-5678")))
				.andExpect(jsonPath("$[0].length", is(150)))			
				
				.andExpect(jsonPath("$[1].firstName", is("Mary")))
				.andExpect(jsonPath("$[1].lastName", is("Doe")))
				.andExpect(jsonPath("$[1].address", is("San Fransisco")))
				.andExpect(jsonPath("$[1].city", is("246 Street")))
				.andExpect(jsonPath("$[1].telephone", is("345-567-8912")));
		verify(supplierService, times(1)).findAll();
		verifyNoMoreInteractions(supplierService);
	}

	@Test
	public void findByIdUrlTest() throws Exception {
		Optional<Supplier> supplier = Optional.of(new Supplier("John", "Doe","123 Street", "Washington D.C.", "123-345-5678"));
		when(supplierService.findById(new Long(1))).thenReturn(supplier);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/suppliers", 1)
				.contentType(MediaType.APPLICATION_JSON).content(Utils.asJsonString(supplier)))		
				.andExpect(status().is2xxSuccessful())
				.andExpect(jsonPath("$[0].firstName", is("John")))
				.andExpect(jsonPath("$[0].lastName", is("Doe")))
				.andExpect(jsonPath("$[0].address", is("Washington D.C.")))
				.andExpect(jsonPath("$[0].city", is("123 Street")))
				.andExpect(jsonPath("$[0].telephone", is("123-345-5678")));
		verify(supplierService, times(1)).findById(new Long(1));
		verifyNoMoreInteractions(supplierService);
	}
	*/
	
	@Test
	public void saveUrlTest() throws Exception {
		Supplier supplierRequest = new Supplier("John", "Doe","123 Street", "Washington D.C.", "123-345-5678");
		Supplier supplier = new Supplier("John", "Doe","246 Street", "Washington D.C.", "123-345-5678");
		when(supplierService.save(supplierRequest)).thenReturn(supplier);
		mockMvc.perform(
				post("/api/v1/suppliers").contentType(MediaType.APPLICATION_JSON).content(Utils.asJsonString(supplier)))
				.andExpect(status().is2xxSuccessful());
	}
	
    @Test
    public void findAllMethodTest() throws Exception {
     	List<Supplier> supplierList = new ArrayList<Supplier>();
     	supplierList.add(new Supplier("John", "Doe","123 Street", "Washington D.C.", "123-345-5678"));
     	supplierList.add(new Supplier("Mary", "Doe","246 Street", "San Fransisco", "345-567-8912"));
     	when(supplierService.findAll()).thenReturn(supplierList);
		mockMvc.perform(
				get("/api/v1/suppliers").contentType(MediaType.APPLICATION_JSON).content(Utils.asJsonString(supplierList)))
				.andExpect(status().is2xxSuccessful());
    }
    
    @Test
    public void findByIdMethodTest() throws Exception {
		Optional<Supplier> supplier = Optional.of(new Supplier("John", "Doe","123 Street", "Washington D.C.", "123-345-5678"));
		when(supplierService.findById(new Long(1))).thenReturn(supplier);
		mockMvc.perform(
				get("/api/v1/suppliers", 1).contentType(MediaType.APPLICATION_JSON).content(Utils.asJsonString(supplier)))
				.andExpect(status().is2xxSuccessful());
    }

}
