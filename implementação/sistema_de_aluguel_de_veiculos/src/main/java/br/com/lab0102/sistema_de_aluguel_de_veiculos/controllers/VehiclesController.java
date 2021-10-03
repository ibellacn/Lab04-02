package br.com.lab0102.sistema_de_aluguel_de_veiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.lab0102.sistema_de_aluguel_de_veiculos.models.VehiclesModel;
import br.com.lab0102.sistema_de_aluguel_de_veiculos.repositories.VehiclesRepository;

@Controller
@RequestMapping("/")
public class VehiclesController {
	
	@RequestMapping(value = {"/", "/lista-de-veiculos"}, method = RequestMethod.GET)
	public ModelAndView listVehicles() {
		ModelAndView modelAndView = new ModelAndView();
		List<VehiclesModel> listVehicles = (List<Vehicle>)vehiclesRepository.findAll();
		modelAndView.setViewName("listUserVehicles");
		modelAndView.addObject("registration", listVehicles);
		return modelAndView
	}

	@RequestMapping(value = {"/veiculos"}, method = RequestMethod.GET)
	public ModelAndView formVehicles() {
		ModelAndView modelAndView = new ModelAndView();
		VehiclesModel vehicle = new VehiclesModel();
		modelAndView.setViewName("formVehicles");
		modelAndView.addObject("newRegistration", vehicle);
		return modelAndView;
	}
	
	@RequestMapping(value = {"/editar/{id}"}, method = RequestMethod.GET)
	public ModelAndView alter(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		VehiclesModel vehicle = vehiclesRepository.findById(id).get();
		modelAndView.setViewName("formVehicles");
		modelAndView.addObject("newRegistration", vehicle);
		return modelAndView;
	}
	
	@RequestMapping(value = {"/excluir/{id}"}, method = RequestMethod.GET)
	public ModelAndView excluide(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		VehiclesModel vehicle = vehiclesRepository.findById(id).get();
		vehiclesRepository.delete(vehicle);
		return listVehicles();
	}
	
	@RequestMapping(value = {"/salvar"}, method = RequestMethod.POST)
	public ModelAndView save(VehiclesModel vehicle) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			vehiclesRepository.save(vehicle);
			return listVehicles();
			
		} catch (Exception ex) {
			modelAndView.setViewName("formVehicles");
			System.out.println(ex);
		}
		return modelAndView;
	}
}
