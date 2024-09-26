package br.com.nicola.apigateway.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonPropertyOrder( { "id", "author", "title", "price", "launch_date" } )
@AllArgsConstructor
@NoArgsConstructor
public class BookVO
	extends
		RepresentationModel<BookVO>
	implements
		Serializable
{

	@JsonProperty( "id" )
	private Long key;

	private String author;
	private String title;
	private Double price;

	@JsonProperty( "launch_date" )
	private LocalDateTime launchDate;
}
