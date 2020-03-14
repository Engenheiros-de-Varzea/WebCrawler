package webcrawler;

import webcrawler.control.Request;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import webcrawler.control.JSON;
import webcrawler.model.bean.ServidorBean;

/**
 *
 * @author Paulo Henrique
 */

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "http://www.licitacao.pmmc.com.br/Transparencia/vencimentos2";
        List<Object> rgfs = JSON.tratarRgfs(JSON.converter(Request.getRequest(url)));
        
        List<ServidorBean> servidores = new ArrayList<>();
        for(Object rgf: rgfs){
            url = "http://www.licitacao.pmmc.com.br/Transparencia/detalhamento?rgf=" + rgf;
            servidores.add(JSON.tratarServidor(JSON.converter(Request.getRequest(url)), rgf));
        }
        
        //INSERT servidores
    }
    
}
