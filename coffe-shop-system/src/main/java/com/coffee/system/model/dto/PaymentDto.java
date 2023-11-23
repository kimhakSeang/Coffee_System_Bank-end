package com.coffee.system.model.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PaymentDto {

	private List<Integer> listOrderId;
	private Integer exchangeRatId;
	private Integer discountId;
	private Date paymentDate;
}
