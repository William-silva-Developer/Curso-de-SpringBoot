package com.carros.car.damain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.EqualsAndHashCode;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;
//import lombok.ToString;

@Entity(name = "carro")
@Getter @Setter
@Data
/*@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor*/
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
	
	private String tipo;
	
	

	
	
	

}
