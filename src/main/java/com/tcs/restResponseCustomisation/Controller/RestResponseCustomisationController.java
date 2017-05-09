package com.tcs.restResponseCustomisation.Controller;

import java.io.File;
import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tcs.restResponseCustomisation.Request.Request;
import com.tcs.restResponseCustomisation.Service.RestResponseCustomisationService;

@Controller
public class RestResponseCustomisationController {
	
	@Autowired 
	RestResponseCustomisationService restCodeGenerationService;
	
	@RequestMapping(value = "/restResponseCustomization", method = RequestMethod.POST)
	public @ResponseBody String getClients(@RequestBody Request request) throws JSONException, IOException {
		String msg=null;
		try
		{
			System.out.println(request.getServiceResponse().toString());
			String filePath=request.getServicePath();
			File f = new File(filePath);
			new File(filePath+ File.separator+"pojoResponse").mkdirs();
			restCodeGenerationService.generateCustomResponse(request);
			msg= "Code optimisation successfull";
		}
		catch(Exception e){
			e.printStackTrace();
			msg="Exception occurred while customising response";
		}
		return msg;
	}
}
