package Decimal;

import java.math.BigDecimal;

public class DecimalDemo {
    public static void main(String[] args) {
        BigDecimal bigDecimal=new BigDecimal(1.48553572);
        //保留三位小数，并四舍五入
        bigDecimal=bigDecimal.setScale(3,BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal);

    }
}
