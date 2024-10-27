package br.com.alura.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double preco;

    private String tipo;

    private LocalDate data;

    private String status;

    @Column(name = "user_id") //JPA e informar qual é o nome do atributo da tabela do banco de dados que o nosso objeto fará o binding.
    private Long userId;

    public void setPreco(Double preco){
        this.preco = preco;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }
    public Double getPreco(){
        return this.preco;
    }

    public String getTipo(){
        return this.tipo;
    }

    public LocalDate getData(){
        return this.data;
    }

    public String getStatus(){
        return this.status;
    }

    public  void setData(LocalDate data){
        this.data = data;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

}
