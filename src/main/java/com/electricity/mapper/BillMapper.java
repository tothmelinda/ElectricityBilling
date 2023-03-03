package com.electricity.mapper;

import com.electricity.dto.BillDTO;
import com.electricity.entity.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper extends GeneralMapper<BillDTO, Bill>  {

}
