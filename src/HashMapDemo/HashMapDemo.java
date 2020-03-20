package HashMapDemo;

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap=new HashMap<>();
        hashMap.put("1",1);
        hashMap.put("2",2);
        hashMap.put("3",3);

        //使用.entrySet()
//        Set<Map.Entry<String, Integer>> set=hashMap.entrySet();
//        for(Map.Entry<String,Integer> item:set){
//            System.out.println(item.getKey()+":"+item.getValue());
//        }

        //使用.keySet()
//        Set<String> a=hashMap.keySet();
//        for(String item:a){
//            System.out.println(item+":"+hashMap.get(item));
//        }

        //使用.values()
        //这里就可以不只用Set了因为value是可以重复的
        //需要注意的是，Collecttion不能强转为子类（ArrayList、LinkedList等）需要用构造函数来实现转换
        LinkedList<Integer> a= new LinkedList<>(hashMap.values());
        for (Integer item:a){
            System.out.println(item);
        }
    }
}
