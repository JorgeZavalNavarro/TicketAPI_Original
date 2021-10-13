package com.enlacetpe.ticketapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enlacetpe.ticketapi.request.DecodeBase64Request;
import com.enlacetpe.ticketapi.request.EncodeBase64Request;
import com.enlacetpe.ticketapi.request.LoadFileRequest;
import com.enlacetpe.ticketapi.response.CAResponse;
import com.enlacetpe.ticketapi.service.serviceDesk.FileManager;
import com.enlacetpe.ticketapi.util.ActivityLogger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/file")
@Api(value="file")
public class FileController {
	
//	@Autowired
//	private FileManager fileManager;
//
//	@RequestMapping(value = "/loadFile", method = RequestMethod.POST)
//	@ApiOperation(value = "Carga un archivo para un ticket", notes = "Carga un archivo para un ticket")
//	public ResponseEntity<CAResponse> loadFile(@RequestBody LoadFileRequest request) {
//		ActivityLogger.logMethod("loadFile");
//		CAResponse response = fileManager.loadFile(request);
//		return new ResponseEntity<CAResponse>(response, HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/encodeBase64", method = RequestMethod.POST)
//	@ApiOperation(value = "Encode a file to base 64", notes = "Encode a file to base 64")
//	public ResponseEntity<String> encodeBase64(@RequestBody EncodeBase64Request request) {
//		ActivityLogger.logMethod("encodeBase64");
//		String response = fileManager.encoder(request);
//		return new ResponseEntity<String>(response, HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/decodeBase64", method = RequestMethod.POST)
//	@ApiOperation(value = "Encode a file to base 64", notes = "Encode a file to base 64")
//	public ResponseEntity<String> decodeBase64(@RequestBody DecodeBase64Request request) {
//		ActivityLogger.logMethod("decodeBase64");
//		String mensaje = "No se guardo la imagen";
//		boolean exito = fileManager.decoder(request);
//		if (exito) {
//			mensaje = "imagen guardada";
//		}
//		return new ResponseEntity<String>(mensaje, HttpStatus.OK);
//	}
}
