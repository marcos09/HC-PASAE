package ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadIngresosDiagnosticoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.CantidadPrescripcionesMedicamentoDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.PrescripcionDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.dto.SeguimientosPromedioInternacionDTO;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.repository.ChartRepository;
import ar.edu.unlp.pasae.pasaetrabajofinalbackend.services.ChartService;

@Service
public class ChartServiceImpl implements ChartService{
	
	@Autowired
	private ChartRepository chartRepository;

	public ChartRepository getChartRepository() {
		return chartRepository;
	}

	public void setChartRepository(ChartRepository chartRepository) {
		this.chartRepository = chartRepository;
	}

	@Override
	public Set<SeguimientosPromedioInternacionDTO> avgSeguimientos() {
		return this.getChartRepository().avgSeguimientosInternacion();
	}

	@Override
	public boolean existsById(Long id) {
		return false;
	}
	
	@Override
	public Set<CantidadIngresosDiagnosticoDTO> getCountDiagnosticoSintomatico() {
		return this.getChartRepository().cantidadIngresosPorDiagnosticoSintomatico();
	}

	@Override
	public Set<CantidadIngresosDiagnosticoDTO> getCountDiagnosticoPresuntivo() {
		return this.getChartRepository().cantidadIngresosPorDiagnosticoPresuntivo();
	}

	@Override
	public List<PrescripcionDTO> listEndPrescriptionForHistory(Long id) {
		this.getChartRepository();
		return null;
	}

	@Override
	public Set<CantidadPrescripcionesMedicamentoDTO> cantidadPrescripcionesMedicamento() {
		return this.getChartRepository().cantidadPrescripcionesPorMedicamento();
	}

	@Override
	public Long cantidadTotalPacientesAtendidos() {
		return this.getChartRepository().cantidadTotalPacientesAtendidos();
	}

	@Override
	public Long cantidadInternacionesRealizadas() {
		return this.getChartRepository().cantidadInternacionesRealizadas();
	}

	@Override
	public Long cantidadInternadosActualmente() {
		return this.getChartRepository().cantidadInternadosActualmente();
	}


	
}
