# Java 12 to 16 新特性

## Java 14 switch语句与yield
> 1.switch语句中提供了lambda形式的编程规则 <br/>
> 2.switch可以使用yield替换了return；break；
```java
        for (int i = 0; i < 11; i++) {
            System.out.println("old:grade="+i+" judge="+oldSwitch(i));
            System.out.println("new:grade="+i+" judge="+newSwitch(i));
            System.out.println("yield:grade="+i+" judge="+yieldSwitch(i));
        }
    }

    private static String yieldSwitch(int grade) {
        return switch (grade){
            case 10,9:
                yield "优秀";
            case 8,7:
                yield "良好";
            case 6:
                yield "合格";

            default:
                System.out.println("需要努力了！");
                yield "不合格";
        };
    }

    private static String newSwitch(int grade) {
        return switch (grade){
            case 10,9 -> "优秀";
            case 8,7 -> "良好";
            case 6 -> "合格";
            default -> {
                System.out.println("需要努力了！");
                yield "不合格";
            }
        };
    }

    private static String oldSwitch(int grade) {
        String judge;
        switch (grade){
            case 10:
            case 9:
                judge = "优秀";
                break;
            case 8:
            case 7:
                judge = "良好";
                break;
            case 6:
                judge = "合格";
                break;
            default:
                judge = "不合格";
                break;
        }
        return judge;
```

## Java 15 文本块
> java 15 提供了文本块的定义，对于像html和sql语句等大文内容提供了方便。
```java
        String textStr =
                """
                这是一个还很长很长很长的文本
                在这我们不需要去些换行符等内容
                不需要去使用转义字符
                他会自动解析成文本本来的格式
                """;
        System.out.println(textStr.split("\n").length);//4
```

## Java 16 模式变量 instanceof
> java 16 允许将需要强制转换的变量的定义放在instanceof的后
```java
        if(o instanceof User){
            User user = (User) o;
            return o.equals(this.name);
        }
        if(o instanceof  User user){ //将变量放在intanceof对象的后面
            return user.equals(this.name);
        }
```
## Java 16 空指针异常的改进
> 空指针异常将会给你明确的提示具体是那个变量引起的空指针异常
```java
    public static void main(String[] args) {
        System.out.println(add(10,null));//Cannot invoke "java.lang.Integer.intValue()" because "b" is null
    }

    private static int add(Integer a, Integer b) {
        return a + b;
    }
```

## Java 16 新的类定义类型Record 
> 针对我们的实体类，Java 16 定义自己的修饰关键字Record用于修饰实体类，
> 我们就不需要去使用例如Lombok等实体类注解就能自动生成get，set，构造方法等了。
```java
public record Account(String name, String password) {
}
    public static void main(String[] args) {
        Account account = new Account("LiJun","123456");
        System.out.println(account.name());//LiJun
        System.out.println(account);//Account[name=LiJun, password=123456]
    }
```