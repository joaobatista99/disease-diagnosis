# Componente `IHTTPRequest`

Campo | Valor
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | João Batista, Gabriel Braga, Gabriel Teston, Paulo Pacitti, Leonardo Picoli, Lucca Jordão
Objetivo | Fazer requisições por métodos HTTP (`GET, POST, PUT, DELETE`), por exemplo para APIs Rest.
Interface | `IHTTPRequest`

```java
public interface IHTTPRequest {
  // faz uma request numa API Rest por HTTP;
  public String request(String method, String url, String headers, String body, String auth);
  //traduzir um Gson para String;
  public String gsonToStr (Gson gson);
}
```

### Interface `IHTTPRequest`
Interface capaz de se comunicar a partir de métodos HTTP.

Método | Objetivo
-------| --------
`public Gson request(String method, String url, String headers, String body, String auth)` |  faz uma request numa API Rest por HTTP e retorna a resposta;
`public String gsonToString(Gson gson)` |  traduzir um Gson para String
