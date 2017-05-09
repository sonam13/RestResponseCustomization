package com.tcs.restResponseCustomisation.Service;

import java.io.IOException;

import org.json.JSONException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tcs.restResponseCustomisation.Request.Request;


public interface RestResponseCustomisationService {

	public void generateCustomResponse(Request request) throws JSONException, JsonGenerationException, JsonMappingException, IOException;

	//public void generateCustomResponse(String string, Request request) throws JSONException;

}