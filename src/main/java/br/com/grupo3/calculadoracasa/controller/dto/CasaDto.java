package br.com.grupo3.calculadoracasa.controller.dto;

import br.com.grupo3.calculadoracasa.modelo.Casa;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CasaDto {

    private final Long id;
    private final String nome;
    private final String endereco;
    private final List<ComodoDto> comodos;
    private final double tamanho;
    private final BigDecimal valor;
    private final ComodoDto maiorComodo;
    private final double mediaTamanhoComodos;

    public CasaDto(Casa casa) {
        this.id = casa.getId();
        this.nome = casa.getNome();
        this.endereco = casa.getEndereco();
        this.tamanho = casa.getTamanho();
        this.valor = casa.getValor();
        this.maiorComodo =  obtemMaiorComodo(casa);
        this.mediaTamanhoComodos = casa.getMediaTamanhoComodos();
        comodos = new ArrayList<>();
        comodos.addAll(casa.getComodos().stream().map(ComodoDto::new).collect(Collectors.toList()));
    }

    public static List<CasaDto> converter(List<Casa> casas) {
        return casas.stream().map(CasaDto::new).collect(Collectors.toList());
    }

    private ComodoDto obtemMaiorComodo(Casa casa){
        if (casa.getMaiorComodo() == null) {
            return null;
        }
        return new ComodoDto(casa.getMaiorComodo());

    }
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<ComodoDto> getComodos() {
        return comodos;
    }

    public double getTamanho() {
        return tamanho;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public ComodoDto getMaiorComodo() {
        return maiorComodo;
    }

    public double getMediaTamanhoComodos() {
        return mediaTamanhoComodos;
    }
}
