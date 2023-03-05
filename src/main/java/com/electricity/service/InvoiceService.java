package com.electricity.service;

import com.electricity.dto.InvoiceDTO;

import java.util.List;

public interface InvoiceService {

    List<InvoiceDTO> findAll();

    InvoiceDTO getById(Long id);

    InvoiceDTO add(InvoiceDTO invoiceDTO);

    InvoiceDTO update(Long id, InvoiceDTO invoiceDTO);

    void deleteById(Long id);
}
