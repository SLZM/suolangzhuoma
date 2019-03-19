package word;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 统计文件中单词出现的频数并输出到文件
 */
public class WordList {

	// 统计文件中单词出现的频数
	public void wcount(){
		
		 String filecontent = "";//用来存放读取到文件内容信息
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
        //sum[]用来统计单词出现的数量
        String [] sum = filecontent.split("[^a-zA-Z]+");
        for (int i=0;i<sum.length;i++)
        {
            if (map.get(sum[i]) == null)
            {
            	//统计键值对
                map.put(sum[i],1);
            }else {
                int count = map.get(sum[i]);
                map.put(sum[i],++count);
            }
        }
				
				List<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
			
				System.out.println("该文件中共有"+ordlist.size()+"个不同的单词");
				

				//将输出结果发送到results.txt中
				try
				{
					
					FileWriter fw= new FileWriter("src\\results.txt");
					System.out.println("词频统计结果已输出列 result.txt文件·");
				} 
				catch (IOException e)
				{
					
					e.printStackTrace();
				}
				
	}
	
}
