package java11.dmeoString;

public class StringStrengthen {
    public static void main(String[] args) {
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
    }
}
