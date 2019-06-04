package comp.gang.npl;

import java.util.Map;

public interface IHTTPRequest {
  String POST(String url_string, Map parameters, Map auth, Map<String, String> headers, String body) throws Exception;
  String GET(String url_string, Map parameters, Map auth, Map<String, String> headers) throws Exception;
}
