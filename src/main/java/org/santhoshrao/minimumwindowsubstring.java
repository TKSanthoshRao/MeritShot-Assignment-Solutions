package org.santhoshrao;
import java.util.Scanner;

public class minimumwindowsubstring{
    public static String minwindow(String s,String t){
        if(s.length()==0||t.length()==0){
            return "";
        }
        // counting chars in target
        int[] targetcount=new int[128];
        for(char c:t.toCharArray()){
            targetcount[c]++;
        }
        int left=0,right=0;
        int required=t.length();
        int minlen=Integer.MAX_VALUE;
        int minstart=0;

        // moving right pointer
        while(right<s.length()){
            char cright=s.charAt(right);
            if(targetcount[cright]>0){
                required--;
            }
            targetcount[cright]--;
            right++;

            while(required==0){   // moving left pointer to shrink window
                if(right-left<minlen){
                    minlen=right-left;
                    minstart=left;
                }
                char cleft=s.charAt(left);
                targetcount[cleft]++;
                if(targetcount[cleft]>0){
                    required++;
                }
                left++;
            }
        }
        return (minlen==Integer.MAX_VALUE) ? "" : s.substring(minstart,minstart+minlen);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the main text: ");          // taking main text
        String s=sc.nextLine();


        System.out.print("enter the target text: ");          // taking target text
        String t=sc.nextLine();

        // finding and showing smallest window
        String result=minwindow(s,t);
        if(result.isEmpty()){
            System.out.println("no window found");
        } else {
            System.out.println("smallest window is: " + result);
        }
    }
}
