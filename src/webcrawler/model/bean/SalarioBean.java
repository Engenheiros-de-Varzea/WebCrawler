package webcrawler.model.bean;

import java.util.Date;

/**
 *
 * @author Paulo Henrique
 */

public class SalarioBean {
    private int id_lancamento;
    private String descricao;
    private double valor;

    public SalarioBean() {
        this.id_lancamento = 0;
        this.descricao = "";
        this.valor = 0.0;
    }
    
    public SalarioBean(int id_lancamento, String descricao, double valor) {
        this.id_lancamento = id_lancamento;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId_lancamento() {
        return id_lancamento;
    }

    public void setId_lancamento(int id_lancamento) {
        this.id_lancamento = id_lancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
