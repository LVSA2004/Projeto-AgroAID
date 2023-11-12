package br.com.fiap.AgroAID.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Getter
@Setter
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName;
    private Double temperature;
    private Integer humidity;

    // Getter para temperature
    public Double getTemperature() {
        return temperature;
    }

    // Setter para temperature
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    // Getter para humidity
    public Integer getHumidity() {
        return humidity;
    }

    // Setter para humidity
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public void setHumidity(Double humidity2) {
    }

    
    
}
