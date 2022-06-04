package java11.HttpClient;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WormNewHttpClient {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        var client = HttpClient.newHttpClient();
        for (int i = 0; i < 10; i++) {
            var request = HttpRequest.newBuilder(new URI("https://pic.netbian.com/tupian/"+(29450 + i)+".html")).GET().build();
            var response= client.send(request, HttpResponse.BodyHandlers.ofString());
            var html = response.body();
            var prefix = "<a href=\"\" id=\"img\"><img src=\"";
            var suffix = "\" data-pic=";
            html = html.substring(html.indexOf(prefix) + prefix.length());
            html = html.substring(0,html.indexOf(suffix));
            System.out.println(html);

            var imagesRequest =
                    HttpRequest.newBuilder(new URI("https://pic.netbian.com"+html)).build();
            var imagesResponse =
                    client.send(imagesRequest, HttpResponse.BodyHandlers.ofInputStream());
            var imagesInput = imagesResponse.body();
            var fileStream = new FileOutputStream("images/"+i+".jpg");
            try(fileStream;imagesInput){
                int size;
                byte[] bytes = new byte[1024];
                while ((size = imagesInput.read(bytes)) > 0){
                    fileStream.write(bytes,0,size);
                }
            }
        }

    }
}
