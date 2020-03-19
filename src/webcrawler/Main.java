package webcrawler;

import webcrawler.control.Request;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import webcrawler.control.JSON;
import webcrawler.model.bean.SalarioBean;
import webcrawler.model.bean.ServidorBean;
import webcrawler.model.dao.SalarioDAO;
import webcrawler.model.dao.ServidorDAO;

/**
 *
 * @author Paulo Henrique
 */

public class Main {

    public static void main(String[] args) throws IOException {
        //Primeira rota - Seleciona os RGF's
        String url = "http://www.licitacao.pmmc.com.br/Transparencia/vencimentos2";
        List<Object> rgfs = JSON.tratarRgfs(JSON.converter(Request.getRequest(url)));
        
        //Segunda rota - Seleciona os salários
        List<ServidorBean> servidores = new ArrayList<>();
        for(Object rgf: rgfs){
            url = "http://www.licitacao.pmmc.com.br/Transparencia/detalhamento?rgf=" + rgf;
            servidores.add(JSON.tratarServidor(JSON.converter(Request.getRequest(url)), rgf));
        }
        
        //Include - Sem verificação de duplicidade
        for(ServidorBean servidor: servidores){
            servidor.setDt_inclusao(new Date());
            new ServidorDAO().insert(servidor);
            int id_servidor = new ServidorDAO().getLastId();
            for(SalarioBean salario: servidor.getSalario()){
                salario.setId_servidor(id_servidor);
                salario.setDt_inclusao(new Date());
                new SalarioDAO().insert(salario);
            }
        }
    }
    
}
