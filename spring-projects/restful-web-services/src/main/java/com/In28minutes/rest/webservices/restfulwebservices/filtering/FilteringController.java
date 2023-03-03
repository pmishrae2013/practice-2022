package com.In28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	@GetMapping("/filtering")
	public MappingJacksonValue getFilteringBean(){
		FilteringBean filteringBean = new FilteringBean("name","email","password");


//		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2"); // properties to be filtered
//		FilterProvider filters = new SimpleFilterProvider().addFilter("FilteringBean",simpleBeanPropertyFilter); //Set the Jackson filter provider to serialize the POJO with.
//		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filteringBean); // Creates a new instance wrapping the given POJO to be serialized.
//		mappingJacksonValue.setFilters(filters);


		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filteringBean); // Creates a new instance wrapping the given POJO to be serialized.
		filterByField(mappingJacksonValue);
		return mappingJacksonValue;
	}

	@GetMapping("filtering-list")
	public MappingJacksonValue getFilteringBeanList(){
		List filteringBeans = Arrays.asList(new FilteringBean("purushottam", "puru@gmail.com","asdfgh"), new FilteringBean("subham","subham@gmail.com","qwerty"));
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(filteringBeans); // Creates a new instance wrapping the given POJO to be serialized.
		filterByField(mappingJacksonValue);
		return mappingJacksonValue;
	}

	private void filterByField(MappingJacksonValue wrapperBean){ // for cleaning the code
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2"); // properties to be filtered
		FilterProvider filters = new SimpleFilterProvider().addFilter("FilteringBean",simpleBeanPropertyFilter); //Set the Jackson filter provider to serialize the POJO with.
		wrapperBean.setFilters(filters);
	}
}
