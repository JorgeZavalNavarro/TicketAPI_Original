package com.enlacetpe.ticketapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enlacetpe.ticketapi.request.CategoryRequest;
import com.enlacetpe.ticketapi.response.CACategoryList;
import com.enlacetpe.ticketapi.service.CMDB.CategoryManager;
import com.enlacetpe.ticketapi.util.ActivityLogger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="category")
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	private CategoryManager categoryManager;
	
	@RequestMapping(value = "/byType", method = RequestMethod.POST)
	@ApiOperation(value = "Recupera las categorias dependiendo el tenat", notes = "Recupera las categorias dependiendo el tenant")
	public ResponseEntity<CACategoryList> getCategoryByTenant(@Valid @RequestBody CategoryRequest request) {
		ActivityLogger.logMethod("getCategoryByTenant");
		CACategoryList categorias = categoryManager.getCategoryByType2(request);
		return new ResponseEntity<CACategoryList>(categorias, HttpStatus.OK);		
	}

}
