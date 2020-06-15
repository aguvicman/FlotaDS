package cl.icap.fullstack.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cl.icap.fullstack.model.dto.ViajeDto;
import cl.icap.fullstack.service.ViajeService;

@Controller 
@RequestMapping(value="/viaje")
public class ViajesController {

	@Autowired
	ViajeService viajeService;
	
	
	@RequestMapping(value="/list")
	public @ResponseBody List<ViajeDto> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		return viajeService.list();
	}

	@RequestMapping(value="/get")
	public @ResponseBody ViajeDto ajaxGet(HttpServletRequest req, HttpServletResponse res) {
	
		return viajeService.get(Integer.parseInt(req.getParameter("viaje_id")));
		
	}
	
	@RequestMapping(value="/insert")
	public @ResponseBody int ajaxInsert(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		
		String requestData;
		try {
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			ViajeDto viajeDto = gson.fromJson(requestData, ViajeDto.class);
			viajeDto = viajeService.insert(viajeDto);
			
			if(viajeDto != null) {
				
				rows=1;
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rows;
			
		}	
		
	
	@RequestMapping(value="/update")
	public @ResponseBody int ajaxUpdate(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		
		String requestData;
		try {
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			ViajeDto viajeDto = gson.fromJson(requestData, ViajeDto.class);
			viajeDto = viajeService.update(viajeDto);
			
			if(viajeDto == null) {
				rows=0;	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			return rows;
			
		}	
		
		
	@RequestMapping(value="/delete")
	public @ResponseBody int ajaxDelete(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		
		try {
			ViajeDto viajeDto = new ViajeDto();
			viajeDto.setViaje_id(Integer.parseInt(req.getParameter("viaje_id")));
			viajeService.delete(viajeDto);
			rows=1;
		} catch (Exception e) {
			e.printStackTrace();
		}
			return rows;
			
		}	
		
		
	
	
	

	
}

