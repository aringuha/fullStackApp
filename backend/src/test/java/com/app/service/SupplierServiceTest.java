package com.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.SupplierAppApplication;
import com.app.model.Supplier;
import com.app.service.SupplierService;

@RunWith(SpringRunner.class)
@WebMvcTest(SupplierAppApplication.class)
public class SupplierServiceTest {
	
	@Mock
	private SupplierService supplierService;
	
	@Before
	public void setup(){
		// With this call to initMocks we tell Mockito to process the annotations
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void findAllTest(){
		// given
		List<Supplier> supplierList = new ArrayList<Supplier>();
		supplierList.add(new Supplier("John", "Doe","123 Street", "Washington D.C.", "123-345-5678"));
		supplierList.add(new Supplier("Mary", "Doe","246 Street", "San Fransisco", "345-567-8912"));

		// when
		when(supplierService.findAll()).thenReturn(supplierList);
		
		// assert
		List<Supplier> result = supplierService.findAll();
		assertEquals(2, result.size());
		
		assertThat(result.get(0).getFirstName()).isEqualTo("John");
		assertThat(result.get(0).getLastName()).isEqualTo("Doe");
        assertThat(result.get(0).getAddress()).isEqualTo("Washington D.C.");
        assertThat(result.get(0).getCity()).isEqualTo("123 Street");
        assertThat(result.get(0).getTelephone()).isEqualTo("123-345-5678");
        
		assertThat(result.get(1).getFirstName()).isEqualTo("Mary");
		assertThat(result.get(1).getLastName()).isEqualTo("Doe");
        assertThat(result.get(1).getAddress()).isEqualTo("San Fransisco");
        assertThat(result.get(1).getCity()).isEqualTo("246 Street");
        assertThat(result.get(1).getTelephone()).isEqualTo("345-567-8912");
	}
	
	@Test
	public void findByIdTest(){
		// given
		Optional<Supplier> supplier = Optional.of(new Supplier("John", "Doe","123 Street", "Washington D.C.", "123-345-5678"));
		
		// when
		when(supplierService.findById(new Long(1))).thenReturn(supplier);
		
		// assert
		Optional<Supplier> result = supplierService.findById(new Long(1));
		assertThat(result.get().getFirstName()).isEqualTo("John");
		assertThat(result.get().getLastName()).isEqualTo("Doe");
        assertThat(result.get().getAddress()).isEqualTo("Washington D.C.");
        assertThat(result.get().getCity()).isEqualTo("123 Street");
        assertThat(result.get().getTelephone()).isEqualTo("123-345-5678");
	}
	
	@Test
    public void saveTest() {
        // given
		Supplier suppplierRequest = new Supplier("John", "Doe","123 Street", "Washington D.C.", "123-345-5678");		
		Supplier supplier = new Supplier("John", "Doe","123 Street", "Washington D.C.", "123-345-5678");
		
        // when
        when(supplierService.save(suppplierRequest)).thenReturn(supplier);

        // assert
        Supplier result = supplierService.save(suppplierRequest);
		assertThat(result.getFirstName()).isEqualTo("John");
		assertThat(result.getLastName()).isEqualTo("Doe");
        assertThat(result.getAddress()).isEqualTo("Washington D.C.");
        assertThat(result.getCity()).isEqualTo("123 Street");
        assertThat(result.getTelephone()).isEqualTo("123-345-5678");
    }
	

}
