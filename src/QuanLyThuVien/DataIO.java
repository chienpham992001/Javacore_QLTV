package QuanLyThuVien;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DataIO {
	static String rootDir = "D:\\Java\\Java_DevPro\\BaiTap_VN\\J67_PhamMinhChien_BTCuoiKhoa\\";
	static File file = new File(rootDir + "book_data.txt");

	public static void loadData(ArrayList<Book> dsSach) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String data[] = line.split(";");
				String a = data[0];
				String tenSach = data[1];
				String tacGia = data[2];
				String theLoai = data[3];
				String namXB = data[4];
				Book book = new Book(a, tenSach, theLoai, tacGia, namXB);
				dsSach.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void saveData(ArrayList<Book> dsSach) {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;

		try {
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			for (Book book : dsSach) {
				String line = book.getLine();
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
}
