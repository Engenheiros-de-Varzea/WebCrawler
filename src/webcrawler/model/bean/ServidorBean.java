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
    private Date dt_inclusao;

    public ServidorBean() {
        this.id = 0;
        this.rgf = 0;
        this.nome = "";
        this.cargo = "";
        this.regime = "";
        this.salario = new ArrayList<>();
        this.dt_inclusao = new Date();
    }
    
    public ServidorBean(int id, int rgf, String nome, String cargo, String regime, List<SalarioBean> salario, Date dt_inclusao) {
        this.id = id;
        this.rgf = rgf;
        this.nome = nome;
        this.cargo = cargo;
        this.regime = regime;
        this.salario = salario;
        this.dt_inclusao = dt_inclusao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDt_inclusao() {
        return dt_inclusao;
    }

    public void setDt_inclusao(Date dt_inclusao) {
        this.dt_inclusao = dt_inclusao;
    }
    
}
