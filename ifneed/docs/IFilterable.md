# Componente `IFilterable`

Campo | Valor
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | João Batista, Gabriel Braga, Gabriel Teston, Paulo Pacitti, Leonardo Picoli, Lucca Jordão
Objetivo | Filtrar o conhecimento do médico para um melhor manejo na hora da consulta
Interface | `IFilterable`

```java
public interface IFilterable {
  public String[][] filter(String[][], String params);
}
```

### Interface `IFilterable`
Interface provida para filtrar uma matriz

Método | Objetivo
-------| --------
`filter(String[][], String params)` | filtra uma estrutura de dados com base nos parametros;
