package webcrawler;

import java.io.IOException;

/**
 *
 * @author Paulo Henrique
 */

public class Main {

    public static void main(String[] args) throws IOException {
        Request.getRequest("http://www.licitacao.pmmc.com.br/Transparencia/vencimentos2");
        Request.getRequest("http://www.licitacao.pmmc.com.br/Transparencia/detalhamento?rgf=19675");
    }
    
}
