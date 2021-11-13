package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author maw-b
 * @date 2021/10/27 14:22
 */
@SpringBootApplication
public class LiquibaseApplication {
    public static void main(String[] args) {
        System.out.println("".length());
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(isMatch("acdcb","a*c?b"));
        SpringApplication.run(LiquibaseApplication.class,args);
    }


    public static boolean isMatch(String s, String p) {
        if(s=="" && p==""){
            return true;
        }
        StringBuilder ss= new StringBuilder(s);
        StringBuilder pp = new StringBuilder(p);
        return isMatch(ss,pp);
    }

    private static boolean isMatch(StringBuilder ss,StringBuilder pp){
        if(ss.toString().equals(pp.toString())){
            return true;
        }
        if(ss.toString().equals("")){
            for(int i=0;i<pp.length();i++){
                if(pp.charAt(i)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(ss.length()>0 && pp.length()> 0 && (ss.charAt(0) == pp.charAt(0) || pp.charAt(0)=='?')){
            return isMatch(ss.deleteCharAt(0),pp.deleteCharAt(0));
        }
        if(ss.length()>0 && pp.length()> 0 && pp.charAt(0)=='*'){
            StringBuilder ssc = new StringBuilder(ss);
            StringBuilder ppc = new StringBuilder(pp);
            return isMatch(ss.deleteCharAt(0),ppc) || isMatch(ssc,pp.deleteCharAt(0));
        }
        return false;
    }
}
