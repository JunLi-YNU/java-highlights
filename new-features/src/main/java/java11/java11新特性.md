# Java 11 新特性

## Java 11 Lambda表达式支持var关键字的使用
> 1.在Java11之前var关键字在lambda中的使用是不支持的，Java11之后就可以使用了<br/>
```java
        //在Java11之前var关键字在lambda中的使用是不支持的，Java11之后就可以使用了
        Consumer<String> stringConsumer = (var s)->{
            System.out.println(s);
        };
        stringConsumer.accept("java 11 lambda of var");
```

## Java 11 对String类的增强
> 1.String.isBlank() //判断空格字符串<br/>
> 2.String.repeat() //复制自身<br/>
> 3.String.lines() //根据换行符切割<br/>
> 4.String.strip() String.stripLeading() String.stripTrailing() //去除首尾空格<br/>
```java
        //1.空格字符串的判断
        String blankStr = "   ";//一个内容全为空格的字符串
        System.out.println(blankStr.isBlank());//true 判断空格字符串
        //2.复制自身
        String repeatStr = "String";
        System.out.println(repeatStr.repeat(3));//StringStringString复制自身
        //3.换行符切割
        String str = "第一行\n第二行\n第三行\n";
        str
                .lines().forEach(System.out::println);
        System.out.println(str.lines().count());//3 根据字符串中的换行符进行切割字符串
        //4.首尾空格的删除
        String preLastBlankStr = " 首部空格 尾部空格 ";
        System.out.println(preLastBlankStr.strip());//去除首尾空格
        System.out.println(preLastBlankStr.stripLeading());//去除首部空格
        System.out.println(preLastBlankStr.stripTrailing());//去除尾部空格
```
## Java 11 全新的HttpClient
> 其实在Java9中就已经引入了全新的Http Client API，用于取代老旧的HttpURLConnection类，
> 新的API支持最新的HTTP2和WebSocket协议<br/>
```java
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(new URI("https://www.baidu.com")).GET().build();
        var response= client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
```