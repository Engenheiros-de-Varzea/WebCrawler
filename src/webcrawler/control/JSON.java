package webcrawler.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import webcrawler.model.bean.SalarioBean;
import webcrawler.model.bean.ServidorBean;

/**
 *
 * @author Paulo Henrique
 */

public class JSON {
    
    public static JSONObject converter(String texto){
        JSONObject json = new JSONObject();
        try {
            json = (JSONObject) new JSONParser().parse(texto);
        } catch (ParseException ex) {
            System.out.println("Exception: " + ex.getMessage());
            System.out.println("Erro ao converter o JSON de String para JSONObject.\n");
        }
        return json;
    }
    
    public static List<Object> tratarRgfs(JSONObject json){
        List<Object> rgfs = new ArrayList<>();
        JSONArray servidores = (JSONArray) json.get("servidores");
        
        servidores.forEach((servidor) -> {
            rgfs.add(((JSONObject) servidor).get("rgf"));
        });
        
        return rgfs;
    }
    
    public static ServidorBean tratarServidor(JSONObject json, Object rgf){
        ServidorBean servidor = new ServidorBean();
        servidor.setRgf(Integer.parseInt(rgf.toString()));
        servidor.setNome(json.get("nome").toString());
        servidor.setCargo(json.get("cargo").toString());
        servidor.setRegime(json.get("regime").toString());
        String referencia = json.get("referencia").toString();
        
        List<SalarioBean> salarios = new ArrayList<>();
        String[][] tipos_lancamento = {{"rendimentos", "1"},{"descontos", "2"},{"outros","2"}};
        for(String[] tipo_lancamento: tipos_lancamento){
            JSONArray lancamentos = (JSONArray) json.get(tipo_lancamento[0]);
            if(lancamentos != null) for(Object lancamento: lancamentos) {
                SalarioBean salario = new SalarioBean();
                salario.setId_lancamento(Integer.parseInt(tipo_lancamento[1]));
                try {
                    salario.setReferencia(new SimpleDateFormat("MMM/yyyy", new Locale("pt", "BR")).parse(referencia));
                } catch (java.text.ParseException ex) {
                    System.out.println("Exception: " + ex.getMessage());
                    System.out.println("Erro ao converter a data de String para Date.\n");
                }
                salario.setDescricao(((JSONObject) lancamento).get("nome").toString());
                salario.setValor(Double.parseDouble( ((JSONObject) lancamento).get("valor").toString().replace(".", "").replace(",", ".") ));
                salarios.add(salario);
            }
        }
        servidor.setSalario(salarios);
        
        return servidor;
    }
    
}
