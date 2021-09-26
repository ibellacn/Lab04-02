package br.com.lab0102.sistema_de_aluguel_de_veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.lab0102.sistema_de_aluguel_de_veiculos.model.VehiclesModel;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.repositories.VehiclesRepository;

@Controller
@RequestMapping("/")
public class VehiclesController {
	
	@Autowired
	private VehiclesRepository vehiclesRepository;

	@RequestMapping(value = {"/veiculos"}, method = RequestMethod.GET)
	public ModelAndView formVehicles() {
		ModelAndView modelAndView = new ModelAndView();
		VehiclesModel vehicle = new VehiclesModel();
		modelAndView.setViewName("formVehicles");
		modelAndView.addObject("newRegistration", vehicle);
		return modelAndView;
	}
	
	@RequestMapping(value = {"/lista-de-veiculos"}, method = RequestMethod.POST)
	public ModelAndView save(VehiclesModel vehicle) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listUserVehicles");
		try {
			vehiclesRepository.save(vehicle);
			modelAndView.setViewName("listUserVehicles");
		} catch (Exception ex) {
			modelAndView.setViewName("formVehicles");
			System.out.println(ex);
		}
		return modelAndView;
	}
}
