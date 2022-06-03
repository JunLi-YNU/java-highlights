package java8.lambda.demo;

public class TestInterface {
    public static void main(String[] args) {
        TestInterface testInterface = new TestInterface();
        //主动实现方法
        LambdaInterface lambdaInterface = (a,b)->{
            return a + b;
        };
        //直接引用现有的方法
        LambdaInterface quoteMethod = testInterface::mergeString;
    }
    public String mergeString(String strOne,String strTwo) {
        return strOne = strTwo;
    }
}
