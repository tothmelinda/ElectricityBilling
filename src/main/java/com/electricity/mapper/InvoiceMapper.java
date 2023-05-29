package com.electricity.mapper;

import com.electricity.dto.InvoiceDTO;
import com.electricity.entity.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper extends GeneralMapper<InvoiceDTO, Invoice>  {

}
