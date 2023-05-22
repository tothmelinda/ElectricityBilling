package com.electricity.service.impl;

import com.electricity.dto.InvoiceDTO;
import com.electricity.entity.Invoice;
import com.electricity.mapper.InvoiceMapper;
import com.electricity.mapper.UserMapper;
import com.electricity.repository.InvoiceRepository;
import com.electricity.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;

    private InvoiceMapper invoiceMapper;

    private final UserMapper userMapper;

    @Override
    public List<InvoiceDTO> findAll() {
        return invoiceMapper.toDTOs(invoiceRepository.findAll());
    }

    @Override
    public InvoiceDTO getById(Long id) {
        Invoice invoice =  invoiceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Invoice with id %d not found", id)));
        return invoiceMapper.toDTO(invoice);
    }

    @Override
    public InvoiceDTO add(InvoiceDTO invoiceDTO) {
        return invoiceMapper.toDTO(invoiceRepository.save(invoiceMapper.toEntity(invoiceDTO)));
    }

    @Override
    public InvoiceDTO update(Long id, InvoiceDTO invoiceDTO) {
        Invoice oldInvoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Invoice with id %d not found", id)));

        oldInvoice.setUser(userMapper.toEntity(invoiceDTO.getUser()));
        oldInvoice.setDescription(invoiceDTO.getDescription());
        oldInvoice.setTotalAmount(invoiceDTO.getTotalAmount());
        oldInvoice.setDateIssued(invoiceDTO.getDateIssued());
        oldInvoice.setDueDate(invoiceDTO.getDueDate());
        oldInvoice.setPaidDate(invoiceDTO.getPaidDate());
        oldInvoice.setPaymentMethod(invoiceDTO.getPaymentMethod());
        invoiceRepository.save(oldInvoice);

        return invoiceMapper.toDTO(oldInvoice);

    }

    @Override
    public void deleteById(Long id) {
        invoiceRepository.deleteById(id);
    }
}
