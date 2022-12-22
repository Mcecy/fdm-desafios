package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.dto.ReportDTO;
import com.devsuperior.dsmeta.dto.SummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsmeta.dto.ReportDTO(obj.id, obj.amount, obj.date, obj.seller.name) FROM Sale obj WHERE UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%')) AND obj.date BETWEEN :startDate AND :endDate")
    Page<ReportDTO> getReport(Pageable pageable, String name, LocalDate startDate, LocalDate endDate);

    @Query("SELECT new com.devsuperior.dsmeta.dto.SummaryDTO(obj.seller.name, SUM(obj.amount)) FROM Sale obj WHERE obj.date BETWEEN :startDate AND :endDate GROUP BY obj.seller.name")
    Page<SummaryDTO> getSummary(Pageable pageable, LocalDate startDate, LocalDate endDate);
}
