package matheuslino.com.simples;

import java.io.Serializable;

/**
 * Created by mathe on 21/03/2017.
 */

public class Aluno implements Serializable {

    private Integer matricula;
    private String nome;
    private Double renda;

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }
}
