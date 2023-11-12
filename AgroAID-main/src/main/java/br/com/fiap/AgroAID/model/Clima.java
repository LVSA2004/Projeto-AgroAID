package br.com.fiap.AgroAID.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
public class Clima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cidade;
    private Double temperature;
    private Double tempMin;
    private Double tempMax;
    private Double humidity;
    private Double speed;
    private Double degree;

}
