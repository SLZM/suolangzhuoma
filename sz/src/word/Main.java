package word;

import java.util.Scanner;

public class Main { 
     public static void main(String[] args) { 
    	 
    	System.out.println("\n********************���� �˵�*********************"); 
     	System.out.println("*              ����ѡ�                           \t\t\t\t\t"); 
   	System.out.println("*  ����1-----ͳ�ƴ�Ƶ��������ʾ���\t\t"); 
    	System.out.println("*  ����2-----ͳ��ָ�����ʴ�Ƶ����\t\t\t"); 
    	System.out.println("*  ����3-----��ѯK������Ƶ����ߵĵ�������ʾ��״ͼ"); 
    	System.out.println("*************************************************\n"); 
    	     	Scanner sc = new Scanner(System.in);  
       System.out.println("�����빦�ܺ�:");   
       String opt=sc.next();//�û�����������Ǹ������͵� 
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
     		System.out.println("�����������������룡"); 
     		main(null); 
     		break; 
     		 
     	} 
     	 
     } 
     //����1 
     public void optWordList(){ 
     	WordList WordList= new WordList(); 
     	WordList.wcount(); 
 	}     
     //����2 
     public void optStatisticalWord(){ 
    	 StatisticalWord StatisticalWord= new StatisticalWord(); 
    	 StatisticalWord.wcount();  	} 
     //����3
    public void optFigure(){   
    	Figure Figure= new Figure(); 
    	Figure.wcount(); 
 	} 
 } 
