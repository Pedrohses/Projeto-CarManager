package api.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Table(name = "todo_item")
public abstract class Veiculo {

    @Column(name = "id")
    @JsonProperty("id")
    @Id
    private long id;

    @Column(name = "modelo")
    @JsonProperty("modelo")
    private String modelo;

    @Column(name = "marca")
    @JsonProperty("marca")
    private String marca;

    @Column(name = "ano")
    @JsonProperty("ano")
    private int ano;

    @Column(name = "cor")
    @JsonProperty("cor")
    private String cor;

    @Column(name = "preco")
    @JsonProperty("preco")
    private double preco;

    @Column(name = "estado")
    @JsonProperty("estado")
    private String estado;

    @Column(name = "placa")
    @JsonProperty("placa")
    private String placa;

}
