package QuanLyThuVien;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static ArrayList<Book> dsSach = new ArrayList<>();

	public static void menu() {
		System.out.println(
				"\n\n********************************************* MENU *********************************************");
		System.out.printf("%-90s %5s %n",
				"1. Hiện thị danh sách về các tựa sách có trong thư viện (sắp xếp danh sách theo thể loại)", "*");
		System.out.printf("%-90s %5s %n", "2. Nhập thông tin cho các cuốn sách mới", "*");
		System.out.printf("%-90s %5s %n", "3. Xóa một cuốn sách dựa trên mã sách", "*");
		System.out.printf("%-90s %5s %n", "4. Tra cứu thông tin cuốn sách dựa trên mã sách", "*");
		System.out.printf("%-90s %5s %n", "5. Tìm kiếm sách dựa theo tên tác giả", "*");
		System.out.printf("%-90s %5s %n", "6. Tìm kiếm sách dựa theo tên sách", "*");
		System.out.printf("%-90s %5s %n", "7. Thoát", "*");
		System.out.println(
				"************************************************************************************************\n");
	}

	public static void main(String[] args) {

		Pattern p = Pattern.compile("^\\d+{1}$");

		DataIO.loadData(dsSach);
		String lua_chon = "";
		int count;
		int chon=0;
		do {
			menu();
			System.out.print("Nhập lựa chọn : ");
			lua_chon = scanner.nextLine();
			count = 0;
			try {
				if (!p.matcher(lua_chon).find() || Integer.parseInt(lua_chon) < 1 || Integer.parseInt(lua_chon) > 7) {
					count++;
					throw new NumberFormatException("Cú pháp không hợp lệ .Chọn lại !!!");
				}
			} catch (NumberFormatException e) {
				System.out.println("-->Lỗi : " + e.getMessage());
			}

			if (count == 0) {
				chon = Integer.parseInt(lua_chon);
				switch (chon) {
				case 1:
					Book_Controller.sxTL(dsSach);
					break;
				case 2:
					Book_Controller.nhapDL(dsSach);
					break;
				case 3:
					Book_Controller.xoaDL(dsSach);
					break;
				case 4:
					Book_Controller.traCuuMa(dsSach);
					break;
				case 5:
					Book_Controller.traTacGia(dsSach);
					break;
				case 6:
					Book_Controller.traTenSach(dsSach);
					break;
				case 7:
					System.out.println("Thoát !!!");
					break;
				default:
					break;
				}

			}
		} while (chon != 7 || count != 0);
	}
}
