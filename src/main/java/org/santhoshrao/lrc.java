package org.santhoshrao;
import java.util.Scanner;
public class lrc{
    public static int charrep(String s,int k){
        int[] lettercount=new int[26]; // storing how many times each letter coming in window
        int left=0;
        int right=0;
        int maxrepeat=0;   // biggest count of any one letter in window
        int maxlength=0;   // biggest length of good window
        while(right<s.length()){  // moving right side pointer step by step
            char cright=s.charAt(right);
            lettercount[cright-'A']++; // increase count for this letter

            // updating maxrepeat if needed
            if(lettercount[cright-'A']>maxrepeat){
                maxrepeat=lettercount[cright-'A'];
            }
            // if we need to change more than k letters, moving left pointer
            while((right-left+1)-maxrepeat>k){
                char cleft=s.charAt(left);
                lettercount[cleft-'A']--; // decrease count of this letter
                left++;
            }
            // updating maxlength if current window bigger
            if((right-left+1)>maxlength){
                maxlength=right-left+1;
            }
            right++;
        }
        return maxlength;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        // asking user for the string
        System.out.print("enter the string: ");
        String s=sc.nextLine().toUpperCase();

        // asking user for k
        System.out.print("enter max number of replacements k: ");
        int k=sc.nextInt();

        // finding and showing result
        int result=charrep(s,k);
        System.out.println("longest length after replacements: "+result);
    }
}
