package ar.edu.unlp.pasae.pasaetrabajofinalbackend.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadIngresosDiagnosticoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadPorMesDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadPrescripcionesMedicamentoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.ChartService;


@RestController
@CrossOrigin
@RequestMapping("/reportes")
public class ChartController {

	@Autowired
	private ChartService chartService;
	
	
	public ChartService getChartService() {
		return chartService;
	}

	public void setChartService(ChartService chartService) {
		this.chartService = chartService;
	}

	@GetMapping(path = "/cantidadIndicacionesMedicamento", produces = "application/json")
	public Set<CantidadPrescripcionesMedicamentoDTO> countPrescriptions() {
		return this.getChartService().cantidadPrescripcionesMedicamento();
	}

	@GetMapping(path = "/cantidadPacientesDiagnosticoPresuntivo", produces = "application/json")
	public Set<CantidadIngresosDiagnosticoDTO> cantidadPacientesDiagnosticoPresuntivo() {
		return this.getChartService().getCountDiagnosticoPresuntivo();
	}

	@GetMapping(path = "/cantidadPacientesDiagnosticoSintomatico", produces = "application/json")
	public Set<CantidadIngresosDiagnosticoDTO> cantidadPacientesDiagnosticoSintomatico() {
		return this.getChartService().getCountDiagnosticoSintomatico();
	}
	
	@GetMapping(path = "/cantidadPacientesAtendidos", produces = "application/json")
	public Long cantidadTotalPacientesAtendidos() {
		return this.getChartService().cantidadInternacionesRealizadas();
		
	}
	
	@GetMapping(path = "/cantidadInternaciones", produces = "application/json")
	public Long cantidadInternaciones() {
		return this.getChartService().cantidadTotalPacientesAtendidos();
	}
	
	// Promedio de seguimientos por internacion
	@GetMapping(path = "/avgSeguimientos")
	public Long avgSeguimientos() {
		return this.getChartService().avgSeguimientos();

	}
	
	// Promedio de seguimientos por internacion
	@GetMapping(path = "/cantidadInternados")
	public Long cantidadInternados() {
		return this.getChartService().cantidadInternadosActualmente();

	}
	
	@GetMapping(path = "/EgresosMesCantidad")
	public List<CantidadPorMesDTO> cantidadEgresosPorMes() {
		return this.getChartService().cantidadEgresosPorMes();
	}	

	@GetMapping(path = "/IngresosMesCantidad")
	public List<CantidadPorMesDTO> cantidadIngresosPorMes() {
		return this.getChartService().cantidadIngresosPorMes();
	}	
	
	@GetMapping(path = "/SeguimientosMesCantidad")
	public List<CantidadPorMesDTO> cantidadSeguimientosPorMes() {
		return this.getChartService().cantidadSeguimientosPorMes();
	}	


}
