package br.com.grupo3.calculadoracasa.modelo;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Entity
public class Casa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    @OneToMany(mappedBy = "casa")
    private List<Comodo> comodos = new ArrayList<>();
    private double tamanho;
    private BigDecimal valor;
    @OneToOne
    private Comodo maiorComodo;
    private double mediaTamanhoComodos;


    public Casa() {
    }

    public Casa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Comodo> getComodos() {
        return comodos;
    }

    public void setComodos(List<Comodo> comodos) {
        this.comodos = comodos;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Comodo getMaiorComodo() {
        return maiorComodo;
    }

    public void setMaiorComodo(Comodo maiorComodo) {
        this.maiorComodo = maiorComodo;
    }

    public double getMediaTamanhoComodos() {
        return mediaTamanhoComodos;
    }

    public void setMediaTamanhoComodos(double mediaTamanhoComodos) {
        this.mediaTamanhoComodos = mediaTamanhoComodos;
    }

    public void atualiza() {
        tamanho = comodos.stream().mapToDouble(e -> e.getLargura() * e.getComprimento()).sum();
        valor = new BigDecimal("800.00").multiply(BigDecimal.valueOf(tamanho));
        comodos.stream().mapToDouble(e -> e.getLargura() * e.getComprimento()).average().ifPresent(e -> mediaTamanhoComodos = e);
        double tamanhoComodo = 0;
        for (Comodo comodo: comodos) {
            double tamanhoComodoAtual = comodo.getLargura() * comodo.getComprimento();
            if (tamanhoComodoAtual > tamanhoComodo){
                tamanhoComodo = tamanhoComodoAtual;
                maiorComodo = comodo;
            }
        }
    }
}
