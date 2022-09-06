package controller;

import model.http.HttpMethod;
import model.http.HttpRequest;
import model.http.HttpResponse;

import java.io.IOException;

public abstract class AbstractController implements Controller{

    @Override
    public void service(HttpRequest request, HttpResponse response) throws Exception {
        HttpMethod.validationMethod(request.getMethod());

        if (request.getMethod() == HttpMethod.GET) {
            doGet(request, response);
            return;
        }
        doPost(request, response);
    }

    public void doPost(HttpRequest request, HttpResponse response) throws IOException {};
    public void doGet(HttpRequest request, HttpResponse response) throws Exception {};
}