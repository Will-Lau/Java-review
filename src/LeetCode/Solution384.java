package LeetCode;
import java.util.Random;

public class Solution384 {
    public static int [] shuffle(int []arr){
        int len=arr.length;
        int [] output=new int[len];
        System.arraycopy(arr,0,output,0,len);

        Random ran=new Random();
        for(int i=0;i<len;i++){
            //洗牌算法，每次只交换在0~i之间某个值对应下标的数组元素与output[i]的值
            //这样可以保证各种结果的概率是一样的。
            int random=ran.nextInt(i);

            //交换
            int temp=output[random];
            output[random]=output[i];
            output[i]=temp;
        }
        return output;
    }

}
