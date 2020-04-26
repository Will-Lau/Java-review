package SortAlgorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;

public class Algorithm {

    public int swapHelp(int a,int b){
        return a;
    }

    //冒泡排序
    public void bubbleSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=i;j<n-1-i;j++){
                if(arr[j+1]<arr[j]){
                    arr[j]=swapHelp(arr[j+1],arr[j+1]=arr[j]);
                }
            }
        }
    }
    //鸡尾酒排序
    //Cocktail Sort，即双向冒泡排序，在排序时以双向序列继续排序
    //即先把一个最大值排到最后，再把一个数排到最前
    //性能略好于冒泡排序
    //其实现省略

    //选择排序
    public void selectionSort(int [] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            //找到最小值放到已排序序列的末尾
            int min=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]) min=j;
            }

            //swap
            arr[i]=swapHelp(arr[min],arr[min]=arr[i]);
        }
    }

    //插入排序
    public void insertionSort(int [] arr){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;//得到已排好序序列的末尾index
            //寻找到合适的位置，没找到就让下一个位置的值等于当前位置。
            while (j>=0&&arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    //归并排序MergeSort
    public  void MergeSort(int []arr,int l,int r){
        if(l<r){
            int m=(l+r)>>1;

            //先排好左边和右边
            MergeSort(arr,l,m);
            MergeSort(arr,m+1,r);

            //然后合并
            merge(arr,l,m,r);
        }
    }
    //合并
    public void merge(int []arr,int l,int m,int r){
        int len1=m-l+1;//左边数组长度
        int len2=r-m;//右边数组长度

        int left[]=new int[len1];
        int right[]=new int[len2];

        //把值赋给两个数组
        for(int i=0;i<len1;i++){
            left[i]=arr[i+l];
        }
        for(int i=0;i<len2;i++){
            right[i]=arr[i+m+1];
        }

        //开始合并
        int i=0,j=0;//两个数组的index
        int k=l;
        while (i<len1&&j<len2){
            if(left[i]<right[j]){
                arr[k]=left[i];
                i++;
            }else {
                arr[k]=right[j];
                j++;
            }
            k++;
        }
        while (i<len1){
            arr[k]=left[i];
            k++;
            i++;
        }
        while (j<len2){
            arr[k]=right[j];
            k++;
            j++;
        }
    }

    //快排QuickSort
    public void QuickSort(int[] arr,int low, int high){
        if(low<high){
            int pi=partition(arr,low,high);

            QuickSort(arr,low,pi-1);
            QuickSort(arr,pi+1,high);
        }
    }
    public int partition(int [] arr,int low,int high){
        int pivot=arr[high];//以最右边的值为pivot
        int i=(low-1);//待会要+1的

        for(int j=low;j<high;j++){
            //找到比pivot小的就与比pivot大的进行交换。
            if(arr[j]<pivot){
                i++;
                arr[i]=swapHelp(arr[j],arr[j]=arr[i]);
            }
        }
        //最后把pivot与arr[i+1]交换
        arr[i+1]=swapHelp(arr[high],arr[high]=arr[i+1]);
        return i+1;//返回分界点
    }

    //堆排序
    public void HeapSort(int []arr){
        int n=arr.length;
        //建堆 遍历所有非叶子节点建堆
        for(int i=n/2-1;i>=0;i--) heapify(arr,n,i);

        //把第一个数放到最后，在建堆
        for(int i=n-1;i>=0;i--){
            arr[i]=swapHelp(arr[0],arr[0]=arr[i]);

            heapify(arr,i,0);
        }
    }
    public void heapify(int [] arr,int n,int i){
        //建立最大值堆
        int largest=i;
        int l=2*i+1;
        int r=2*i+2;

        //选择左右孩子大一点的替换largest
        if(l<n&&arr[l]>arr[largest]) largest=l;
        if(r<n&&arr[r]>arr[largest]) largest=r;

        //如果largest变了，就把变动的子树也进行改变
        if(largest!=i){
            arr[i]=swapHelp(arr[largest],arr[largest]=arr[i]);

            heapify(arr,n,largest);
        }
    }

    //shellSort
    public void ShellSort(int[] arr){
        int n=arr.length;

        for(int gap=n/2;gap>0;gap/=2){
            for(int i=gap;i<n;i++){
                int temp=arr[i];

                int j;
                for( j=i;j>=gap&&arr[j-gap]>temp;j-=gap){
                    arr[j]=arr[j-gap];
                }
                arr[j]=temp;
            }
        }
    }

    //bucket Sort
    //对于输入在一个range里面分布均匀的时候比较适合
    //这里以0.0到1.0里的一个range为例
    public void BucketSort(float[] arr){
        int n=arr.length;
        List<Float>[] floats=new ArrayList[n];
        for(int i=0;i<n;i++){
            floats[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            int bi= (int) (n*arr[i]);
            floats[bi].add(arr[i]);
        }

        for(int i=0;i<n;i++){
            //采用一种别的排序法进行排序
            //这里用冒泡好了
            //使用冒泡对float[i]进行排序
            int len=floats[i].size();
            for(int j=0;j<len;j++){
                for(int k=0;k<len-j-1;j++){
                    if(floats[i].get(k)>floats[i].get(k+1)){
                        float temp=floats[i].get(k);
                        floats[i].set(k,floats[i].get(k+1));
                        floats[i].set(k,temp);
                    }
                }
            }
            //冒泡排序结束

        }

        //将桶归一
        int index=0;
        for(int i=0;i<n;i++){
            int len=floats[i].size();
            for(int j=0;j<len;j++){
                arr[index++]=floats[i].get(j);
            }
        }

    }


    //CountSort
    //计数排序
    public void CountSort(int[] arr){

        int len=arr.length;
        //创建一个输出数组,这里size为len+1的原因是让数组的index和数字一一对应（不需要做-1的计算）
        int [] output=new int[len+1];

        //先找到最大值
        int max=arr[0];
        for(int i=0;i<len;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }

        //构建一个count数组，大小为max+1，这样就可以容纳下所有的数
        int[] count=new int[max+1];
        //初始化
        for(int i=0;i<=max;i++){
            count[i]=0;
        }
        //计数
        for(int i=0;i<len;i++){
            count[arr[i]]++;
        }
        //让一个数的计数加上它前面的数的计数
        for(int i=1;i<=max;i++){
            count[i]+=count[i-1];
        }

        //输出到输出数组
        for(int i=0;i<len;i++){
            //count[arr[i]]得到的就是计数，减去一个1就是其在输出数组的index
            output[count[arr[i]]-1]=arr[i];
            //如果有重复数字，减一使得他们之间排好序。
            count[arr[i]]--;
        }
        //将output数组赋值到原数组
        for(int i=0;i<len;i++){
            arr[i]=output[i];
        }
    }

    //RadixSort
    //对每个十进制位进行单独排序，从个位排到最高位
    //每个单独的位使用计数排序，因此基数排序有可能退化为计数排序
    public void RadixSort(int[] arr) {
        //首先找到最大的数字，以确定最高位
        int len=arr.length;
        int max=arr[0];
        for(int i=0;i<len;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        //然后呢，对于每一个digit进行排序
        for(int exp=1;max/exp>0;exp*=10){
            CountSortInRadixSort(arr,len,exp);
        }
    }
    public void CountSortInRadixSort(int []arr,int len,int exp){
        int[] output=new int[len+1];
        int[] count=new int[10];//最多只有10个数0~9
        for (int i=0;i<10;i++){
            count[i]=0;
        }

        //计数
        for(int i=0;i<len;i++){
            //(arr[i]/exp)%10就是当前要排序的位的数
            count[(arr[i]/exp)%10]++;
        }
        //相加
        for(int i=1;i<10;i++){
            count[i]+=count[i-1];
        }
        //输出到输出数组
        for(int i=0;i<len;i++){
            //(arr[i]/exp)%10就是当前要排序的位的数
            //count[(arr[i]/exp)%10]是这个数的计数，-1是为了与index相同
            output[count[(arr[i]/exp)%10]-1]=arr[i];
            count[arr[i]]--;
        }
        //赋值到原数组
        for(int i=0;i<len;i++){
            arr[i]=output[i];
        }
    }

    //BitSort
    //BitSort的思想与计数排序类似，适用于待排序数组没有重复数字的情况
    //因为没有重复的数字，因此每一个数字是否出现只用一个bit来存储
    //由于没有bit这个对象给我们用，就用byte来达到效果，一个byte有8个bit
    public void BitSort(int []arr){
        int len=arr.length;
        //找到最大值确定byte数组长度
        int max=arr[0];
        for(int i=0;i<len;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        byte[] bytes=new byte[max/8+1];
        int length=bytes.length;

        //遍历数组，找到一个数字就将对应的位置为1
        for(int i=0;i<arr.length;i++){
            int group=arr[i]/8;
            int bias=arr[i]%8;
            bytes[group]|=(0x01<<bias);
        }

        //根据byte数组的内容把排序结果输出到arr
        for(int group=0,index=0;group<length;group++){
            for(int bias=0;bias<8;bias++){
                //如果该位为0则跳过
                if(((0x01<<bias)&bytes[group])==0){
                    continue;
                }else {
                    //否则计算出该位对应的值
                    arr[index++]=group*8+bias;
                }
            }
        }
    }




}
