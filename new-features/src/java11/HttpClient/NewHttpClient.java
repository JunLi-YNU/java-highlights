package java11.HttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class NewHttpClient {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(new URI("https://www.baidu.com")).GET().build();
        var response= client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
