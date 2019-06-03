# Componente `IWebService`

Campo | Valor
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | João Batista, Gabriel Braga, Gabriel Teston, Paulo Pacitti, Leonardo Picoli, Lucca Jordão
Objetivo | Escutar uma porta para ver se requisições estão chegando ao servidor
Interface | `IWebService`

```java
public interface IWebService {
  public boolean startWebService(url, port);
  public boolean closeWebAppointment();
}
```

### Interface `IWebService`
Interface para comunicação de servidores web.

Método | Objetivo
-------| --------
`public boolean startWebService(url, port)`  | inicia o serviço Web
`public boolean closeWebAppointment()`| fecha a conexão do serviço
