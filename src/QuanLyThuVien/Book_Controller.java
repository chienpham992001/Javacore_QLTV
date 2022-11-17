package QuanLyThuVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Book_Controller {
	static Scanner scanner = new Scanner(System.in);

	public static void inDS(ArrayList<Book> dsSach) {
		Book.inTD();
		
		for (Book book : dsSach) {
			book.inDL();
		}
	}

	public static void sxTL(ArrayList<Book> dsSach) {

		dsSach.sort((o1, o2) -> {
			return o1.getTheLoai().compareTo(o2.getTheLoai());
		});
		System.out.println("\n-----------------------------------------------THÔNG TIN SÁCH(SẮP XẾP THEO THỂ LOẠI)-------------------------------------------------");
		Book_Controller.inDS(dsSach);
	}
	public static void sxMa(ArrayList<Book> dsSach) {

		dsSach.sort((o1, o2) -> {
			if (Integer.parseInt(o1.getMaSach()) > Integer.parseInt(o2.getMaSach())) {
                return 1;
            } else {
                if (Integer.parseInt(o1.getMaSach()) == Integer.parseInt(o2.getMaSach())) {
                    return 0;
                } else {
                    return -1;
                }
            }
		});
		System.out.println("\n-----------------------------------------------THÔNG TIN SÁCH-------------------------------------------------");
		Book_Controller.inDS(dsSach);
	}
//	public boolean checkMa(Book book) {
//		return b
//	}
//	
	public static void nhapDL(ArrayList<Book> dsSach) {
		Book book = new Book();
		int count;
		do {
			count = 0;
			book.nhap();
			for (int i = 0; i < dsSach.size(); i++) {
				if (dsSach.get(i).getMaSach().compareTo(book.getMaSach()) == 0) {
					System.out.println("-->Lỗi : Mã sách đã tồn tại!!\n");
					count++;
				}
			}
		} while (count != 0);
		dsSach.add(book);
		System.out.println("\nThông báo : Nhập sách mới thành công.");
		DataIO.saveData(dsSach);

		
		Book_Controller.sxMa(dsSach);
	}

	public static void xoaDL(ArrayList<Book> dsSach) {
		System.out.println("Nhập mã sách muốn xóa : ");
		String id = scanner.nextLine();
		int count = 0;
		for (int i = 0; i < dsSach.size(); i++) {
			if (dsSach.get(i).getMaSach().compareTo(id) == 0) {
				count++;
			}
		}
		if (count > 0) {
			dsSach.removeIf(o1 -> {
				boolean kq = o1.getMaSach().equals(id);
				return kq;
			});
			System.out.println("\nThông báo : Xóa sách có mã " + id + " thành công.");
			DataIO.saveData(dsSach);

			Book_Controller.sxMa(dsSach);
		} else {
			System.out.println("-->Lỗi : Mã sách không tồn tại");
		}

	}

	public static void traCuuMa(ArrayList<Book> dsSach) {
		System.out.println("Nhập mã sách muốn tra cứu : ");
		String id = scanner.nextLine();
		int count = 0;
		for (Book book : dsSach) {
			if (book.getMaSach().contains(id)) {
				count++;
			}
		}
		if (count == 0)
			System.out.println("\n-->Lỗi : Mã sách không có trong hệ thống .");
		else {
			System.out.println("\n-----------------------------------------------THÔNG TIN SÁCH-------------------------------------------------");
			Book.inTD();
			for (Book book : dsSach) {
				if (book.getMaSach().contains(id)) {
					book.inDL();
				}
			}
		}

	}

	public static void traTacGia(ArrayList<Book> dsSach) {
		System.out.println("Nhập tác giả muốn tra cứu : ");
		String tg = scanner.nextLine();
		int count = 0;
		for (Book book : dsSach) {
			if (book.getTacGia().toUpperCase().contains(tg.toUpperCase())) {
				count++;
			}
		}
		if (count == 0)
			System.out.println("\n-->Lỗi: Tên tác giả không có trong hệ thống .");
		else {
			System.out.println("\n-----------------------------------------------THÔNG TIN SÁCH-------------------------------------------------");
			Book.inTD();
			for (Book book : dsSach) {
				if (book.getTacGia().toUpperCase().contains(tg.toUpperCase())) {
					book.inDL();
				}
			}
		}
	}

	public static void traTenSach(ArrayList<Book> dsSach) {
		System.out.println("Nhập tên sách muốn tra cứu : ");
		String sach = scanner.nextLine();
		int count = 0;
		for (Book book : dsSach) {
			if (book.getTenSach().toUpperCase().contains(sach.toUpperCase())) {
				count++;
			}
		}
		if (count == 0)
			System.out.println("\n-->Lỗi: Tên sách không có trong hệ thống .");
		else {

			Book.inTD();
			for (Book book : dsSach) {
				if (book.getTenSach().toUpperCase().contains(sach.toUpperCase())) {
					book.inDL();
				}
			}
		}
	}

}
