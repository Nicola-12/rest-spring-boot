package br.com.nicola.apigateway.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table( name = "books" )
public class Book
	implements
		Serializable
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY  )
	private Long id;

	private String author;
	private String title;
	private Double price;

	@Column( name = "launch_date", nullable = false )
	private LocalDateTime launchDate;
}
