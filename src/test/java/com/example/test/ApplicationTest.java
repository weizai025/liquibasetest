package com.example.test;

import org.junit.runner.RunWith;

import java.util.Arrays;

/**
 * @author maw-b
 * @date 2021/10/28 19:15
 */
public class ApplicationTest {

    public static String reorganizeString(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        Arrays.sort(chs);
        if(chs.length%2==0 && chs[0]==chs[n/2]){
            return "";
        }
        if(chs.length%2==0 && chs[n-1]==chs[n/2-1]){
            return "";
        }
        if(chs.length%2!=0 && chs[0]==chs[n/2+1]){
            return "";
        }
        if(chs.length%2!=0 && chs[n-1]==chs[n/2-1]){
            return "";
        }
        int left=0;
        int right=n-1;
        char[] res = new char[n];
        int i=0;
        while(left<right){
            res[i]=chs[left];
            res[i+1]=chs[right];
            i=i+2;
            left++;
            right--;
        }
        res[n-1]=chs[n/2];
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("acac"));
    }
}
