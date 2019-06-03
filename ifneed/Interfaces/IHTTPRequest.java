public interface IHTTPRequest {
  // faz uma request numa API Rest por HTTP;
  public String request(String method, String url, String headers, String body, String auth);
  //traduzir um Gson para String;
  public String gsonToStr (Gson gson);
}
