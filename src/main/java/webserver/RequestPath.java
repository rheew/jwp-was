package webserver;

import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

public class RequestPath {

    public static final String REGEX_QUESTION_MARK = "\\?";
    public static final int PATH_INDEXT = 0;

    private String path;
    private MultiValueMap<String, String> params;

    public RequestPath(String request) {
        final String[] requests = request.split(REGEX_QUESTION_MARK);

        this.path = requests[PATH_INDEXT];

        if (requests.length < 1) {
            return;
        }
        this.params = UriComponentsBuilder.fromUriString(request).build().getQueryParams();
    }

    public String getPath() {
        return path;
    }

    public MultiValueMap<String, String> getParams() {
        return params;
    }
}