package webcrawler.model.bean;

import java.util.Date;

/**
 *
 * @author Paulo Henrique
 */

public class SalarioBean {
    private int id;
    private int id_servidor;
    private int id_lancamento;
    private Date referencia;
    private String descricao;
    private double valor;
    private Date dt_inclusao;

    public SalarioBean() {
        this.id = 0;
        this.id_servidor = 0;
        this.id_lancamento = 0;
        this.referencia = new Date();
        this.descricao = "";
        this.valor = 0.0;
        this.dt_inclusao = new Date();
    }
    
    public SalarioBean(int id, int id_servidor, int id_lancamento, Date referencia, String descricao, double valor, Date dt_inclusao) {
        this.id = id;
        this.id_servidor = id_servidor;
        this.id_lancamento = id_lancamento;
        this.referencia = referencia;
        this.descricao = descricao;
        this.valor = valor;
        this.dt_inclusao = dt_inclusao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_servidor() {
        return id_servidor;
    }

    public void setId_servidor(int id_servidor) {
        this.id_servidor = id_servidor;
    }

    public int getId_lancamento() {
        return id_lancamento;
    }

    public void setId_lancamento(int id_lancamento) {
        this.id_lancamento = id_lancamento;
    }

    public Date getReferencia() {
        return referencia;
    }

    public void setReferencia(Date referencia) {
        this.referencia = referencia;
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

    public Date getDt_inclusao() {
        return dt_inclusao;
    }

    public void setDt_inclusao(Date dt_inclusao) {
        this.dt_inclusao = dt_inclusao;
    }

    
    
}
