package QuanLyThuVien;

import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Book implements Serializable {
	private String tenSach, theLoai, tacGia;
	private String maSach, namXB;

//	private static int stt = 1;

	public Book(String maSach, String tenSach, String theLoai, String tacGia, String namXB) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.theLoai = theLoai;
		this.tacGia = tacGia;
		this.namXB = namXB;
	}

	public Book() {
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getNamXB() {
		return namXB;
	}

	public void setNamXB(String namXB) {
		this.namXB = namXB;
	}

	public void nhap() {
		Pattern pattern_maSach = Pattern.compile("^\\d+{1,}$");
		Pattern pattern_namXB = Pattern.compile("^[0-9]{4}$");
		Pattern pattern_string = Pattern.compile("^[\\D]{8,}$");
		Pattern pattern_string2 = Pattern.compile("^[\\D]{8,}$");

		Exception sach_Exception = new Exception("Thông tin sách không được để trống .");
		Scanner scanner = new Scanner(System.in);
		maSach=null;
		tenSach=null;
		tacGia=null;
		theLoai=null;
		namXB=null;
		do {
			try {
				if(maSach==null) {
					System.out.println("Nhập mã sách : ");
					maSach = scanner.nextLine();
				}
				if(tenSach==null) {
					System.out.println("Nhập tên sách : ");
					tenSach = scanner.nextLine();
				}
				if(tacGia==null) {
					System.out.println("Nhập tác giả : ");
					tacGia = scanner.nextLine();
				}
				if(theLoai==null) {
					System.out.println("Nhập thể loại : ");
					theLoai = scanner.nextLine();
				}
				if(namXB==null) {
					System.out.println("Nhập năm xuất bản : ");
					namXB = scanner.nextLine();
				}
				
				if (!pattern_maSach.matcher(maSach).find() || Integer.parseInt(maSach) <= 0) {
					maSach = null;
					throw new Exception("Mã sách phải là số nguyên > 0 .");
				}
				else {
					if(tenSach.length()<10) {
						tenSach=null;
						throw new Exception("Tên sách không hợp lệ và phải từ 10 ký tự");
					}
					else {
						if(!pattern_string.matcher(tacGia).find()) {
							tacGia=null;
							throw new Exception("Tên tác giả không hợp lệ và phải từ 8 ký tự");
						}
						else {
							if(!pattern_string.matcher(theLoai).find()) {
								theLoai=null;
								throw new Exception("Thể loại không hợp lệ và phải từ 8 ký tự");
							}
							else {
								if (!pattern_namXB.matcher(namXB).find() || Integer.parseInt(namXB) <= 0) {
									namXB = null;
									throw new Exception("Năm xuất bản không hợp lệ");
								}
							}
						}
					}
				}
				
			} catch (Exception e) {
				System.out.println("-->Lỗi : " + e.getMessage());
			}
		} while (maSach == null || tenSach == null || tacGia == null || theLoai == null || namXB == null);
		
	}

	public static void inTD() {
		System.out.printf("%-13s %-100s %-47s %-35s  %-15s %n", "Mã sách", "Tên sách", "Tác giả", "Thể loại",
				"Năm xuất bản");
	}

	public void inDL() {
		System.out.printf("%-13s %-100s %-47s %-35s  %-15s %n", maSach, tenSach, tacGia, theLoai, namXB);
	}

	public String getLine() {
		return maSach + ";" + tenSach + ";" + tacGia + ";" + theLoai + ";" + namXB;
	}
}
