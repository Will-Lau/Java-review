package DFSAndBFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DFSAndBFS {
    public static void main(String[] args) {
        HashMap<Character, LinkedList<Character>> graph=new HashMap<>();
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Boolean> map2=new HashMap<>();
        char start;
        LinkedList linkedList1=new LinkedList();
        linkedList1.add('2');
        linkedList1.add('3');

        LinkedList linkedList2=new LinkedList();
        linkedList2.add('4');
        linkedList2.add('5');

        LinkedList linkedList3=new LinkedList();
        linkedList3.add('6');
        linkedList3.add('7');

        graph.put('1',linkedList1);
        graph.put('2',linkedList2);
        graph.put('3',linkedList3);
        graph.put('4',new LinkedList<>());
        graph.put('5',new LinkedList<>());
        graph.put('6',new LinkedList<>());
        graph.put('7',new LinkedList<>());


//        BFS(graph,map,'1');
        DFS(graph,map2,'1');
    }


    /**
     * BFS 广度优先搜索
     * @param graph 存放每个节点的邻接表 使用LinkedList窜访
     * @param map   存放每个节点与顶点的距离
     * @param start 开始的起点字符
     */
    public static void BFS(HashMap<Character, LinkedList<Character>> graph,
                           HashMap<Character,Integer> map,
                           char start){
        //q存放
        Queue<Character> q=new LinkedList<>();
        q.add(start);
        map.put(start,0);
        System.out.println("访问"+start);

        while (!q.isEmpty()){
            //取出队首元素
            char top=q.poll();



            int distance =map.get(top)+1;

            for(Character c:graph.get(top)){
                if(!map.containsKey(c)){
                    map.put(c,distance);
                    q.add(c);
                    System.out.println("访问"+c);
                }
            }

        }

    }



    /**
     * @param graph 存放每个结点的邻接表
     * @param visited 存放是否已经访问
     * @param start     起始结点
     */
    public static void DFS(HashMap<Character,LinkedList<Character>> graph,
                           HashMap<Character,Boolean> visited,
                           char start){
        if(!visited.containsKey(start)){

            //访问自己
            visited.put(start,true);
            System.out.println("访问"+start);

            for(char c:graph.get(start)){
                //如果存在没有访问的就调用DFS
                if(!visited.containsKey(c)){
                    DFS(graph,visited,c);
                }
            }
        }

    }
}
