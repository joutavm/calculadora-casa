package br.com.grupo3.calculadoracasa.controller.form.casaForm;

import br.com.grupo3.calculadoracasa.modelo.Casa;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class CasaForm {


    @NotNull @NotEmpty
    private  String nome;

    @NotEmpty @NotNull
    private  String endereco;

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

    public Casa converter() {
        return new Casa(nome, endereco);
    }
}
