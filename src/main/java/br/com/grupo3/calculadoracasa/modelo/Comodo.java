package br.com.grupo3.calculadoracasa.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Comodo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Casa casa;
    private String nome;
    private double largura;
    private double comprimento;

    public Comodo(Casa casa, String nome, double largura, double comprimento) {
        this.casa = casa;
        this.nome = nome;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public Comodo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comodo comodo = (Comodo) o;

        if (Double.compare(comodo.largura, largura) != 0) return false;
        if (Double.compare(comodo.comprimento, comprimento) != 0) return false;
        if (!Objects.equals(id, comodo.id)) return false;
        if (!Objects.equals(casa, comodo.casa)) return false;
        return Objects.equals(nome, comodo.nome);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (casa != null ? casa.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        temp = Double.doubleToLongBits(largura);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(comprimento);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
