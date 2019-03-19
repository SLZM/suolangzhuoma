package word;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * 统计前K个出现的频次最高的单词
 */
public class Figure {
	public void wcount(){
		
		 String filecontent = "";
              Map<String,Integer> map = new HashMap<String, Integer>();
       try {
          
    	 //读取文件 DATA.txt
           FileInputStream fis = new FileInputStream("src\\DATA.txt");
           BufferedReader br = new BufferedReader(new InputStreamReader(fis));
           String str = "";
           try {
               while ((str = br.readLine()) != null){
               	filecontent = filecontent + str;
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }catch (FileNotFoundException e){
           e.printStackTrace();
       }
       String []sum = filecontent.split("[^a-zA-Z]+");
       for (int i=0;i<sum.length;i++){
           if (map.get(sum[i]) == null){
               map.put(sum[i],1);
           }else {
               int count = map.get(sum[i]);
               map.put(sum[i],++count);
           }
       }
       //利用TreeMap实现Comparator接口
       Comparator<Map.Entry<String, Integer>> valcom = new Comparator<Map.Entry<String,Integer>>() {
	        public int compare(Map.Entry<String, Integer> rst1,Map.Entry<String, Integer> rst2) {
	        	int sortrst=rst2.getValue()-rst1.getValue();
				return sortrst;
				
	        	} 
	        
	        };
				List<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
				Collections.sort(ordlist,valcom);
				Scanner sc = new Scanner(System.in); 
				System.out.println("请输入要查看的最高词频的个数:"); 
		        int k = sc.nextInt();
		        if(k>0&&k<=ordlist.size())
		        {
		        	System.out.println("----------词频最高的前"+k+"个单词及其柱状图-----------");
					
					for (Map.Entry<String, Integer> entry : ordlist) {
						
						System.out.printf("单词 "+"%-8s" + "出现" +"%-3d"+"次 ",entry.getKey(),entry.getValue());	
						//用符号个数来显示模拟柱状图
							for(int i=entry.getValue();i>0;i--)
							{
								System.out.print("▏");
							}
							System.out.println();
							//System.out.println(entry.getKey() + ":" + entry.getValue());
							
							if(--k==0)
								break;//k=0,则不再输出后面的词频					
						
					}
					System.out.println("------------------------------------------------");	

		        }else{
		        	System.out.println("输入有误！请重新输入！");
		        }
	}
}
