链接：https://www.nowcoder.com/questionTerminal/b316c7f9617744b98fa311ae29ac516c
来源：牛客网

有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置，求每一种窗口状态下的最大值。（如果数组长度为n，窗口大小为w，
则一共产生n-w+1个窗口的最大值）

输入描述:
第一行输入n和w，分别代表数组长度和窗口大小
第二行输入n个整数X_iX 
i，表示数组中的各个元素

 输出描述:
输出一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int w=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Deque<Integer> queue=new LinkedList<>();
            List<Integer> res=new ArrayList<>();
            for(int i=0;i<n;i++){
                while(!queue.isEmpty()&&arr[queue.peekLast()]<=arr[i]){
                    queue.pollLast();
                }
                queue.offerLast(i);
                
                while(queue.peekFirst()<=i-w){
                    queue.pollFirst();
                }
                
                if(i>=w-1){
                    res.add(arr[queue.peekFirst()]);
                }
            }
            
            for(int num:res){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}