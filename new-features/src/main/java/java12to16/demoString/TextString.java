package java12to16.demoString;

public class TextString {
    public static void main(String[] args) {
        String textStr =
                """
                这是一个还很长很长很长的文本
                在这我们不需要去些换行符等内容
                不需要去使用转义字符
                他会自动解析成文本本来的格式
                """;
        System.out.println(textStr.split("\n").length);//4
    }
}
