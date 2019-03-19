package word;

import java.util.Scanner;

public class Main { 
     public static void main(String[] args) { 
    	 
    	System.out.println("\n********************功能 菜单*********************"); 
     	System.out.println("*              功能选项：                           \t\t\t\t\t"); 
   	System.out.println("*  功能1-----统计词频个数并显示结果\t\t"); 
    	System.out.println("*  功能2-----统计指定单词词频个数\t\t\t"); 
    	System.out.println("*  功能3-----查询K个出现频次最高的单词且显示柱状图"); 
    	System.out.println("*************************************************\n"); 
    	     	Scanner sc = new Scanner(System.in);  
       System.out.println("请输入功能号:");   
       String opt=sc.next();//用户的输入可能是各种类型的 
       Main m=new Main(); 
        
   	switch(opt){ 
   	case "1":  
  		m.optWordList(); 
    		main(null); 
    		break; 
   	case "2":   
     		m.optStatisticalWord(); 
     		main(null); 
     		break; 
     	case "3":  
    		m.optFigure(); 
     		main(null); 
     		break;  
     	default:  
     		System.out.println("输入有误，请重新输入！"); 
     		main(null); 
     		break; 
     		 
     	} 
     	 
     } 
     //功能1 
     public void optWordList(){ 
     	WordList WordList= new WordList(); 
     	WordList.wcount(); 
 	}     
     //功能2 
     public void optStatisticalWord(){ 
    	 StatisticalWord StatisticalWord= new StatisticalWord(); 
    	 StatisticalWord.wcount();  	} 
     //功能3
    public void optFigure(){   
    	Figure Figure= new Figure(); 
    	Figure.wcount(); 
 	} 
 } 
