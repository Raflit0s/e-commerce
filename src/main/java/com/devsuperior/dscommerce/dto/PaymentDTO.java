package com.devsuperior.dscommerce.dto;

import java.time.Instant;

import com.devsuperior.dscommerce.entities.Payment;

public class PaymentDTO {

	private Long id;
	private Instant moment;
	
	public PaymentDTO() {
		
	}
	
	public PaymentDTO(Long id, Instant moment) {
		super();
		this.id = id;
		this.moment = moment;
	}
	
	public PaymentDTO(Payment entity) {
		super();
		id = entity.getId();
		moment = entity.getMoment();
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}
}
