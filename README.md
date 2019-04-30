# disease-diagnosis :mask:
- Trabalho de MC322 da Unicamp.
- Descobrir diagnosticos de doenças de pacientes com Classes em Java.
![](https://media.giphy.com/media/hdev8OfIVgNVu/giphy.gif)


### Interfaces
- `IVisualization`:
  - `public void render()`: renderiza um módulo visual(Java Swing, por exemplo);
- `IHTTPRequest`:
  - `public String request(String method, String url, String headers, String body, String auth)`: faz uma request numa API Rest por HTTP;
  - `public String GsonToStr (Gson gson)`: traduzir um Gson para String;
