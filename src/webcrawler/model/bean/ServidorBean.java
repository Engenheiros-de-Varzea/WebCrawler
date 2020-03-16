package webcrawler.model.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Paulo Henrique
 */

public class ServidorBean {
    private int id;
    private int rgf;
    private String nome;
    private String cargo;
    private String regime;
    private List<SalarioBean> salario;
    private Date referencia;

    public ServidorBean() {
        this.rgf = 0;
        this.nome = "";
        this.cargo = "";
        this.regime = "";
        this.salario = new ArrayList<>();
        this.referencia = new Date();
    }
    
    public ServidorBean(int id, int rgf, String nome, String cargo, String regime, List<SalarioBean> salario, Date referencia) {
        this.rgf = rgf;
        this.nome = nome;
        this.cargo = cargo;
        this.regime = regime;
        this.salario = salario;
        this.referencia = referencia;
    }

    public int getRgf() {
        return rgf;
    }

    public void setRgf(int rgf) {
        this.rgf = rgf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public List<SalarioBean> getSalario() {
        return salario;
    }
    
    public void setSalario(List<SalarioBean> salario) {
        this.salario = salario;
    } 

    public Date getReferencia() {
        return referencia;
    }

    public void setReferencia(Date referencia) {
        this.referencia = referencia;
    }
    
}
