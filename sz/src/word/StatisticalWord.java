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
 * ͳ��ָ�����ʸ���
 */
public class StatisticalWord {
		 public void wcount(){
			 
			int count2=0;
			String word="";
			int flag=1;
			 String filecontent = "";//������Ŷ�ȡ�����ļ�������Ϣ
			 
	        //�ü�ֵ�Էֱ�洢���ʺ������ֵĴ���
	        Map<String,Integer> map = new HashMap<String, Integer>();
	        try {
	            //��ȡָ���ļ�DATA.txt,����ʹ�õ������·��
	            FileInputStream fis = new FileInputStream("src\\DATA.txt");

	        	//����BufferedReader�Ļ�������һ���Զ�ȡ�ܶ����ݣ�Ȼ��Ҫ��ִν����ϲ������
	            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	            String str = "";
	            try {
	                //һ��һ�ж�ȡ
	                while ((str = br.readLine()) != null){
	                	filecontent = filecontent + str;
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }catch (FileNotFoundException e){
	            e.printStackTrace();
	        }
	        //sum��������ͳ�Ƶ��ʳ��ֵĴ���
	        String [] sum = filecontent.split("[^a-zA-Z]+");
	        for (int i=0;i<sum.length;i++){

	       
	            if (map.get(sum[i]) == null){
	            	//ͳ�Ƽ�ֵ��
	                map.put(sum[i],1);
	            }else {
	                int count = map.get(sum[i]);
	                map.put(sum[i],++count);
	            }
	        }
	        //����TreeMapʵ��Comparator�ӿ�
	        Comparator<Map.Entry<String, Integer>> valcom = new Comparator<Map.Entry<String,Integer>>() {

	        	//�Դ�Ƶͳ�ƽ����������
		        public int compare(Map.Entry<String, Integer> rst1,Map.Entry<String, Integer> rst2) {
		        	//��������
		        	int sortrst=rst2.getValue()-rst1.getValue();
					return sortrst;					
		        	} 
		        
		        };
					
				List<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
					
				// ��sort����������
				Collections.sort(ordlist,valcom);
				
				Scanner sc = new Scanner(System.in); 
		       System.out.println("��������Ҫͳ�Ƴ����������еĵ���:"); 
		        String w = sc.next();
			
				
				for (Map.Entry<String, Integer> entry : ordlist) {
				
					if(entry.getKey().equals(w)){//
						word=entry.getKey();
						count2=entry.getValue();
						flag=1;
						break;
					}else{
						flag=0;
					}
					
				}
				if(flag==1){
					System.out.println("�õ���"+word+"���ֵĸ���Ϊ:"+count2);	
				}else{
					System.out.println("�Բ���������û�г��ָõ��ʣ�");
				}
				
		}
	
}
