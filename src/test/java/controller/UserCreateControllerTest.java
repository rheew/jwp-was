package controller;

import model.HttpHeader;
import model.HttpRequest;
import model.HttpResponse;
import org.junit.jupiter.api.Test;
import utils.FileIoUtils;
import webserver.RequestLine;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserCreateControllerTest {

    @Test
    void 회원가입시_index_페이지_리다이렉트_응답() throws IOException, URISyntaxException {

        final UserCreateController controller = new UserCreateController();
        final HttpRequest httpRequest = createHttpRequest();
        final HttpResponse response = controller.process(httpRequest);
        final byte[] responseBody = FileIoUtils.loadFileFromClasspath("/index.html");

        assertThat(response.getMessages().get(0)).isEqualTo("HTTP/1.1 302 OK \r\n");
    }

    private HttpRequest createHttpRequest() throws UnsupportedEncodingException {

        final String requestBody = "userId=javajigi&password=password&name=%EB%B0%95%EC%9E%AC%EC%84%B1&email=javajigi%40slipp.net";

        return new HttpRequest(new HttpHeader(headers()), requestBody);
    }

    private List<String> headers() {
        return Arrays.asList("POST /user/create HTTP/1.1",
                "Host: localhost:8080",
                "Connection: keep-alive",
                "Content-Length: 59",
                "Content-Type: application/x-www-form-urlencoded",
                "Accept: */*");
    }
}