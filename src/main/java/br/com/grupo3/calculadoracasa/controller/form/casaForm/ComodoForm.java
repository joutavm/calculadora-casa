package br.com.grupo3.calculadoracasa.controller.form.casaForm;

import br.com.grupo3.calculadoracasa.modelo.Casa;
import br.com.grupo3.calculadoracasa.modelo.Comodo;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class ComodoForm {

    @NotNull @NotEmpty
    private String nome;
    @NotNull
    private double largura;
    @NotNull
    private double comprimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public Comodo converter(Casa casa) {
        return new Comodo(casa, nome, largura, comprimento);
    }


    public Comodo adicionarComodo(Casa casa){
        casa.atualiza();
        return converter(casa);
    }
}
