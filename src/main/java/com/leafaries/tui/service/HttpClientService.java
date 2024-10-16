package com.leafaries.tui.service;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class HttpClientService {

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public String fetchData(String endpoint) throws
            IOException, ParseException {
        HttpGet request = new HttpGet(endpoint);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            return EntityUtils.toString(response.getEntity());
        }
    }

    public void close() throws IOException {
        httpClient.close();
    }
}
