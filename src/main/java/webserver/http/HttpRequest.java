package webserver.http;

public class HttpRequest {
    private final RequestLine requestLine;

    private final HttpHeaders headers;

    private RequestParams requestParams;

    public HttpRequest(RequestLine requestLine, HttpHeaders headers, String body) {
        this(requestLine, headers, new CachedRequestParams(new DefaultRequestParams(requestLine.getQueryString(), body)));
    }

    public HttpRequest(RequestLine requestLine, HttpHeaders headers, RequestParams requestParams) {
        this.requestLine = requestLine;
        this.headers = headers;
        this.requestParams = requestParams;
    }

    public HttpMethod getMethod() {
        return requestLine.getMethod();
    }

    public String getPath() {
        return requestLine.getPath();
    }

    public String getHeader(String name) {
        return headers.getHeader(name);
    }

    public String getParameter(String name) {
        return requestParams.getParameter(name);
    }

    public HttpCookie getCookies() {
        return headers.getCookies();
    }

    public HttpSession getSession() {
        return headers.getSession();
    }
}
