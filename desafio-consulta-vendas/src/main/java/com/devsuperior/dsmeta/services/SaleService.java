package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.ReportDTO;
import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<ReportDTO> getReport(Pageable pageable, String name, String start, String end) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate endDate;
		LocalDate startDate;
		try {
			endDate = LocalDate.parse(end, dtf);
		} catch (DateTimeParseException e) {
			endDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		}

		try {
			startDate = LocalDate.parse(start, dtf);
		} catch (DateTimeParseException e) {
			startDate = endDate.minusYears(1L);
		}

		return repository.getReport(pageable, name, startDate, endDate);
	}

	public Page<SummaryDTO> getSummary(Pageable pageable, String start, String end) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate endDate;
		LocalDate startDate;
		try {
			endDate = LocalDate.parse(end, dtf);
		} catch (DateTimeParseException e) {
			endDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		}

		try {
			startDate = LocalDate.parse(start, dtf);
		} catch (DateTimeParseException e) {
			startDate = endDate.minusYears(1L);
		}

		return repository.getSummary(pageable, startDate, endDate);
	}
}
