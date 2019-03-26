/**  
* <p>Title: DBF-ROOT  </p>  
* <p>Description: The program was developed to practice new methods and techniques in the learning process.
Just for the sake of learning.</p>  
* <p>Copyright: Copyright amwang (c) 2018</p>  
* <p>Company: www.nourl.com</p>  
* @author amwang  
* @date 2019年3月14日  
* @version 1.0  
*/ 
package com.amwang.temptest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;

import com.amwang.utils.Base64;

/**  
* <p>Title: FileReader</p>  
* <p>Description: </p>  
* @author amwang  
* @date 2019年3月14日  
*/
public class FileReader {

	/**  
	 * <p>Title: main</p>  
	 * <p>Description: </p>  
	 * @param args  
	 */
	public static void main(String[] args) {

		// 字节流测试读文件
//		bufferedReader();
		
		// 字符流
//		streamReader();
		
		String result = Base64.encode("qwer");
		System.out.println(result);
	}
	
	/**
	 * 字节流读取
	 * <p>Title: bufferedReader</p>  
	 * <p>Description: </p>
	 */
	private static void bufferedReader() {
		System.out.println("字节流>>>>>>开始");
		String outFile = "D:/amwang_.sql";
		String infile = "E:/amwang_copy.sql";
		BufferedReader br  = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(outFile),"UTF-8"));
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(infile),"UTF-8"));
			String msg = null;
			while((msg = br.readLine())!=null) {
				bw.write(msg);
				bw.newLine();
			}
			bw.flush();
			System.out.println("字节流>>>>>>结束");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 字符流读文件
	 * <p>Title: streamReader</p>  
	 * <p>Description: </p>
	 */
	private static void streamReader() {
		System.out.println("字符流>>>>>>开始");
		long t1 = System.currentTimeMillis();
		File file = new File("D:/mypeanut/pic.rar");
		File path = new File("E:\\test_prj\\pic_copy_"+t1+".rar");
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new BufferedInputStream(new FileInputStream(file));
			os = new BufferedOutputStream(new FileOutputStream(path));
			int len = -1;
			byte[] b = new byte[1024];
			while((len = is.read(b))!=-1) {
				os.write(b);
			}
			os.flush();
			System.out.println("字符流>>>>>>结束");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
	}
}
