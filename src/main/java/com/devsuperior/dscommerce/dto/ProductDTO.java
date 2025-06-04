package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Product;

import jakarta.validation.constraints.*;

public class ProductDTO {

	private Long id;
	
	@Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres")
	@NotBlank(message = "Campo Requerido")
	private String name;
	
	@Size(min = 10, message = "Descrição precisa ter no mínimo 10 caracteres")
	@NotBlank(message = "Campo Requerido")
	private String description;
	
	@Positive(message = "O preço deve ser positivo")
	private Double price;
	private String imgUrl;
	
	public ProductDTO() {
		
	}

	public ProductDTO(Product entity) {
		super();
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
	}
	
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Double getPrice() {
		return price;
	}
	public String getImgUrl() {
		return imgUrl;
	}
}
