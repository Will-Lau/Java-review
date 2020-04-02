package DynamicPrograming;

public class MaxLengthOfSortedArray {
    //求出从数组中取出一定量的有序的数（相对顺序不变），能取出的最多的数的量
    //比如{4,6,5,7,3}，取出的为4，6，7
    public static int getMaxLength(int []a,int len){
        //int len=a.length;
        int []dp=new int[len];
        for(int i=0;i<len;i++){
            dp[i]=0;
            for (int j=0;j<i;j++){
                if(a[j]<=a[i]&&dp[j]>dp[i])
                    dp[i]=dp[j];
            }
            dp[i]++;
        }
        return dp[len-1];
    }

    public static int getMaxLength2(int []a,int len){
        //int len=a.length;
        int []dp=new int[len];
        for(int i=0;i<len;i++){
            dp[i]=0;
            for (int j=0;j<i;j++){
                if(a[j]<=a[i]&&dp[j]>dp[i])
                    dp[i]=dp[j];
            }
            dp[i]++;
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        int []a={1,3,9,6,5,6,1};
        System.out.println(getMaxLength2(a,5));
    }
}
