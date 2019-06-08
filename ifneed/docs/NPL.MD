README_NPL.MD

Para utilizar a classe de processamento de linguagem natural do google, instancie um objeto da classe npl:

NPL teste = new NPL();

Então, passe a string que você gostaria de analisar como parâmetro para a função sense() da classe NPL.

teste.sense("String que será analisada");

O método irá retornar um boolean, caso true o paciente possui o sintoma e caso false o paciente não possui o sintoma.

Para criação de uma credencial da Google Cloud seguir os passos 1 e 2 do link abaixo:
https://cloud.google.com/natural-language/docs/quickstart-client-libraries