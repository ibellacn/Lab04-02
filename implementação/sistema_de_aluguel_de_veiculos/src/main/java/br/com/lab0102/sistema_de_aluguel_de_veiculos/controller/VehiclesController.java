package br.com.lab0102.sistema_de_aluguel_de_veiculos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class VehiclesController {

	@RequestMapping(value = {"/veiculos"}, method = RequestMethod.GET)
	public ModelAndView formVehicles() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("formVehicles");
		return modelAndView;
	}
}
