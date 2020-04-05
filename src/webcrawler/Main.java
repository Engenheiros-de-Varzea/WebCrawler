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
        String request = Request.getRequest("http://www.licitacao.pmmc.com.br/Transparencia/vencimentos2");
        if(!"".equals(request)){
            List<Object> rgfs = JSON.tratarRgfs(JSON.converter(request));
        
            //Segunda rota - Seleciona os salários
            for(Object rgf: rgfs){
                request = Request.getRequest("http://www.licitacao.pmmc.com.br/Transparencia/detalhamento?rgf=" + rgf);
                if(!"".equals(request)){
                    ServidorBean servidor = JSON.tratarServidor(JSON.converter(request), rgf);
                    servidor.setId(new ServidorDAO().getId(servidor));

                    //Include - Com verificação de duplicidade
                    if(servidor.getId() == 0){
                        servidor.setDt_inclusao(new Date());
                        new ServidorDAO().insert(servidor);
                        servidor.setId(new ServidorDAO().getId(servidor));
                    }

                    for(SalarioBean salario: servidor.getSalario()){
                        salario.setId_servidor(servidor.getId());
                        salario.setId(new SalarioDAO().getId(salario));

                        if(salario.getId() == 0){
                            salario.setDt_inclusao(new Date());
                            new SalarioDAO().insert(salario);
                        }
                    }
                }
            }
        }
    }
    
}
