package java12to16.demoSwitch;

public class NewSwitch {
    public static void main(String[] args) {
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
    }
}
