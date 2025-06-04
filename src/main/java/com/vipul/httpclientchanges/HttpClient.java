package com.vipul.httpclientchanges;

import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.HttpClientResponseHandler;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;

public class HttpClient {

    public static void main(String[] args) {

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Create a POST request
            HttpPost postRequest = new HttpPost("https://example.com/api/resource");

            // Set the request payload
            String jsonPayload = "{\"key1\":\"value1\", \"key2\":\"value2\"}";
            StringEntity entity = new StringEntity(jsonPayload, ContentType.APPLICATION_JSON);
            postRequest.setEntity(entity);

            // Create a custom response handler
            HttpClientResponseHandler<String> responseHandler = response -> {
                int status = response.getCode();
                if (status >= 200 && status < 300) {
                    return EntityUtils.toString(response.getEntity());
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };

            // Execute the request
            String response = httpClient.execute(postRequest, responseHandler);
                // Handle the response
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
