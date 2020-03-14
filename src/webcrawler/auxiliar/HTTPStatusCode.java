package webcrawler.auxiliar;

/**
 *
 * @author Paulo Henrique
 */

public class HTTPStatusCode {

    public static String getMessage(int code) {
        String message = code + " - ";
        switch(code){
            case 100: message += "Essa resposta provisória indica que tudo ocorreu bem até agora e que o cliente deve continuar com a requisição ou ignorar se já concluiu o que gostaria"; break;
            case 101: message += "Esse código é enviado em resposta a um cabeçalho de solicitação Upgrade pelo cliente, e indica o protocolo a que o servidor está alternando."; break;
            case 102: message += "Este código indica que o servidor recebeu e está processando a requisição, mas nenhuma resposta está disponível ainda."; break;
            case 200: message += "Esta requisição foi bem sucedida."; break;
            case 201: message += "A requisição foi bem sucedida e um novo recurso foi criado como resultado."; break;
            case 202: message += "A requisição foi recebida mas nenhuma ação foi tomada sobre ela."; break;
            case 203: message += "Esse código de resposta significa que o conjunto de meta-informações retornadas não é o conjunto exato disponível no servidor de origem, mas coletado de uma cópia local ou de terceiros."; break;
            case 204: message += "Não há conteúdo para enviar para esta solicitação."; break;
            case 205: message += "Esta requisição é enviada após realizada a solicitação."; break;
            case 206: message += "Esta resposta é usada por causa do cabeçalho de intervalo enviado pelo cliente para separar o download em vários fluxos."; break;
            case 207: message += "Usado dentro de um DAV: elemento de resposta propstat para evitar enumerar os membros internos de várias ligações à mesma coleção repetidamente."; break;
            case 208: message += "O servidor cumpriu uma solicitação GET para o recurso e a resposta é uma representação do resultado de uma ou mais manipulações de instância aplicadas à instância atual."; break;
            case 300: message += "A requisição tem mais de uma resposta possível. "; break;
            case 301: message += "Esse código de resposta significa que a URI do recurso requerido mudou."; break;
            case 302: message += "Esse código de resposta significa que a URI do recurso requerido foi mudada temporariamente."; break;
            case 303: message += "O servidor manda essa resposta para instruir ao cliente buscar o recurso requisitado em outra URI com uma requisição GET."; break;
            case 304: message += "Essa resposta é usada para questões de cache. "; break;
            case 305: message += "Foi definida em uma versão anterior da especificação HTTP para indicar que uma resposta deve ser acessada por um proxy."; break;
            case 306: message += "Esse código de resposta não é mais utilizado, encontra-se reservado."; break;
            case 307: message += "O servidor mandou essa resposta direcionando o cliente a buscar o recurso requisitado em outra URI com o mesmo método que foi utilizado na requisição original."; break;
            case 308: message += "Esse código significa que o recurso agora está permanentemente localizado em outra URI, especificada pelo cabeçalho de resposta location."; break;
            case 400: message += "Essa resposta significa que o servidor não entendeu a requisição pois está com uma sintaxe inválida."; break;
            case 401: message += "O cliente deve se autenticar para obter a resposta solicitada."; break;
            case 402: message += "Pagamento requerido."; break;
            case 403: message += "O cliente não tem direitos de acesso ao conteúdo portanto o servidor está rejeitando dar a resposta. "; break;
            case 404: message += "O servidor não pode encontrar o recurso solicitado."; break;
            case 405: message += "O método de solicitação é conhecido pelo servidor, mas foi desativado e não pode ser usado."; break;
            case 406: message += "Essa resposta é enviada quando o servidor da Web após realizar a negociação de conteúdo orientada pelo servidor, não encontra nenhum conteúdo seguindo os critérios fornecidos pelo agente do usuário."; break;
            case 407: message += "Semelhante ao 401 porem é necessário que a autenticação seja feita por um proxy."; break;
            case 408: message += "Esta resposta é enviada por alguns servidores em uma conexão ociosa, mesmo sem qualquer requisição prévia pelo cliente. "; break;
            case 409: message += "Esta resposta será enviada quando uma requisição conflitar com o estado corrente do servidor."; break;
            case 410: message += "Esta resposta será enviada quando o conteúdo requisitado foi deletado do servidor."; break;
            case 411: message += "O servidor rejeitou a requisição porque o campo Content-Length do cabeçalho não está definido e o servidor o requer."; break;
            case 412: message += "O cliente indicou nos seus cabeçalhos pré-condições que o servidor não atende."; break;
            case 413: message += "A entidade requisição é maior do que os limites definidos pelo servidor."; break;
            case 414: message += "A URI requisitada pelo cliente é maior do que o servidor aceita para interpretar."; break;
            case 415: message += "O formato de mídia dos dados requisitados não é suportado pelo servidor, então o servidor rejeita a requisição."; break;
            case 416: message += "O trecho especificado pelo campo Range do cabeçalho na requisição não pode ser preenchido; é possível que o trecho esteja fora do tamanho dos dados da URI alvo."; break;
            case 417: message += "Este código de resposta significa que a expectativa indicada pelo campo Expect do cabeçalho da requisição não pode ser satisfeita pelo servidor."; break;
            case 418: message += "O servidor recusa a tentativa de coar café num bule de chá."; break;
            case 421: message += "A requisição foi direcionada a um servidor inapto a produzir a resposta."; break;
            case 422: message += "A requisição está bem formada mas inabilitada para ser seguida devido a erros semânticos."; break;
            case 423: message += "O recurso sendo acessado está chaveado."; break;
            case 424: message += "A requisição falhou devido a falha em requisição prévia."; break;
            case 426: message += "O servidor se recusa a executar a requisição usando o protocolo corrente mas estará pronto a fazê-lo após o cliente atualizar para um protocolo diferente."; break;
            case 428: message += "O servidor de origem requer que a resposta seja condicional. "; break;
            case 429: message += "O usuário enviou muitas requisições num dado tempo."; break;
            case 431: message += "O servidor não quer processar a requisição porque os campos de cabeçalho são muito grandes."; break;
            case 451: message += "O usuário requisitou um recurso ilegal, tal como uma página censurada por um governo."; break;
            case 500: message += "O servidor encontrou uma situação com a qual não sabe lidar."; break;
            case 501: message += "O método da requisição não é suportado pelo servidor e não pode ser manipulado. "; break;
            case 502: message += "Esta resposta de erro significa que o servidor, ao trabalhar como um gateway a fim de obter uma resposta necessária para manipular a requisição, obteve uma resposta inválida."; break;
            case 503: message += "O servidor não está pronto para manipular a requisição. "; break;
            case 504: message += "Esta resposta de erro é dada quando o servidor está atuando como um gateway e não obtém uma resposta à tempo."; break;
            case 505: message += "A versão HTTP usada na requisição não é suportada pelo servidor."; break;
            case 506: message += "O servidor tem um erro de configuração interno: a negociação transparente de conteúdo para a requisição resulta em uma referência circular."; break;
            case 507: message += "O servidor tem um erro interno de configuração: o recurso variante escolhido está configurado para entrar em negociação transparente de conteúdo com ele mesmo, e portanto não é uma ponta válida no processo de negociação."; break;
            case 508: message += "O servidor detectou um looping infinito ao processar a requisição."; break;
            case 510: message += "Exigem-se extenções posteriores à requisição para o servidor atendê-la."; break;
            case 511: message += "O código de status 511 indica que o cliente precisa se autenticar para ganhar acesso à rede."; break;
            default: message += "Código não encontrado!";
        }
        return message;
    }
    
}
