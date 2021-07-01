package br.com.grupo3.calculadoracasa.controller.dto;

import br.com.grupo3.calculadoracasa.modelo.Casa;
import br.com.grupo3.calculadoracasa.modelo.Comodo;

import java.util.List;
import java.util.stream.Collectors;


public class ComodoDto {
    private Long id;
    private String nomeCasa;
    private String nome;
    private double largura;
    private double comprimento;

    public ComodoDto(){

    }

    public ComodoDto(Comodo comodo) {
        this.id = comodo.getId();
        this.nomeCasa = comodo.getCasa().getNome();
        this.nome = comodo.getNome();
        this.largura = comodo.getLargura();
        this.comprimento = comodo.getComprimento();
    }


    public static List<ComodoDto> converter(List<Comodo> comodos) {
        return comodos.stream().map(ComodoDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNomeCasa() {
        return nomeCasa;
    }

    public String getNome() {
        return nome;
    }

    public double getLargura() {
        return largura;
    }

    public double getComprimento() {
        return comprimento;
    }
}
