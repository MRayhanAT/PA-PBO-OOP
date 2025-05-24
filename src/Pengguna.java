import java.util.ArrayList;
import java.util.Scanner;

public class Pengguna {
  ArrayList<String> usernames = new ArrayList<>();
  ArrayList<String> passwords = new ArrayList<>();
  ArrayList<String> roles = new ArrayList<>();
  ArrayList<Integer> ids = new ArrayList<>();
  Integer UserSekarang;
  String menu = null;

  public Pengguna() {
    usernames.add("admin");
    passwords.add("admin");
    roles.add("admin");
    ids.add(usernames.size());

    // User default
    // Untuk testing, bisa dihapus jika tidak diperlukan
    usernames.add("user");
    passwords.add("user");
    roles.add("peminjam");
    ids.add(usernames.size());
  }

  public Integer Menu() {
    Scanner input = new Scanner(System.in);
    System.out.println("====================================");
    System.out.println("Selamat datang di aplikasi kami");
    System.out.println("");
    System.out.println("1. Login");
    System.out.println("2. Register");
    System.out.println("3. Exit");
    System.out.println("");
    menu = input.nextLine();
    switch (menu) {
      case "1":
        System.out.println("Login");
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        Integer loginResult = login(username, password);
        if (loginResult == 1) { // Admin
          return 2;
        } else if (loginResult == 2) { // User
          return 3;
        } else {
          System.out.println("Login failed.");
          break;
        }
      case "2":
        System.out.println("Register");
        System.out.print("Username: ");
        String username2 = input.nextLine();
        System.out.print("Password: ");
        String password2 = input.nextLine();
        register(username2, password2, "peminjam");
        break;
      case "3":
        System.out.println("Exit");
        input.close();
        return 0;
      default:
        System.out.println("Inputan tidak valid");
    }
    return 1;
  }

  void register(String username, String password, String role) {
    if (usernames.contains(username)) {
      System.out.println("Username already exists.");
    } else {
      usernames.add(username);
      passwords.add(password);
      roles.add(role);
      ids.add(usernames.size());
      System.out.println("Registration successful.");
    }
  }

  Integer login(String username, String password) {
    if (usernames.contains(username) && passwords.contains(password)) {
      int index = usernames.indexOf(username);
      String role = roles.get(index);
      int id = ids.get(index);
      // System.out.println("Login successful.");
      // System.out.println("Role: " + role);
      // System.out.println("ID: " + id);
      UserSekarang = id;
      if (role.equals("admin")) { // Admin
        System.out.println("Login successful as admin.");
        return 1;
      } else { // User
        System.out.println("Login successful as user.");
        return 2;
      }
    } else {
      System.out.println("Invalid username or password.");
    }
    return 0;
  }
}

class admin extends Pengguna {
  @Override
  public Integer Menu() {
    System.out.println("Menu Admin");
    System.out.println("1. Lihat  Semua User");
    System.out.println("2. Daftar Pengajuan Pinjaman");
    System.out.println("3. Setujui/Tolak Pengajuan Pinjaman");
    System.out.println("4. Status Pembayaran Pinjaman");
    System.out.println("5. Riwayat Pinjaman");
    System.out.println("6. Exit");
    Scanner input = new Scanner(System.in);
    super.menu = input.nextLine();
    switch (super.menu) {
      case "1":
        System.out.println("Lihat Semua User");
        // tampilkanSemuaUser(); // Menampilkan semua user
        break;
      case "2":
        System.out.println("Daftar Pengajuan Pinjaman");
        break;
      case "3":
        System.out.println("Setujui/Tolak Pengajuan Pinjaman");
        break;
      case "4":
        System.out.println("Status Pembayaran Pinjaman");
        break;
      case "5":
        System.out.println("Riwayat Pinjaman");
        break;
      case "6":
        System.out.println("Exit");
        return 1;
      default:
        System.out.println("Inputan tidak valid");
    }
    return 0;
  }

  void tampilkanSemuaUser() {
    System.out.println("Daftar Semua User:");
    for (int i = 0; i < usernames.size(); i++) {
      System.out.println("ID: " + ids.get(i) + ", Username: " + usernames.get(i) + ", Role: " + roles.get(i));
    }
  }
}

class user extends Pengguna {
  @Override
  public Integer Menu() {
    System.out.println("\nMenu Pengguna:");
    System.out.println("1. Ajukan Pinjaman");
    System.out.println("2. Lihat Riwayat Pinjaman");
    System.out.println("3. Bayar Pinjaman");
    System.out.println("4. Logout");
    System.out.print("Pilih opsi: ");
    Scanner input = new Scanner(System.in);
    super.menu = input.nextLine();

    switch (super.menu) {
      case "1":
        // System.out.print("Masukkan deskripsi pinjaman: ");
        // String deskripsi = input.nextLine();
        // userPinjaman.add(UserSaatIni);
        // riwayatPinjaman.add(deskripsi);
        // System.out.println("Pengajuan pinjaman berhasil.");
        break;
      case "2":
        // System.out.println("Riwayat Pinjaman Anda:");
        // boolean ada = false;
        // for (int i = 0; i < userPinjaman.size(); i++) {
        // if (userPinjaman.get(i).equals(UserSaatIni)) {
        // System.out.println("- " + riwayatPinjaman.get(i));
        // ada = true;
        // }
        // }
        // if (!ada) {
        // System.out.println("Belum ada riwayat pinjaman.");
        // }
        break;
      case "3":
        // System.out.print("Masukkan ID pinjaman yang ingin dibayar: ");
        // String idPinjaman = input.nextLine();
        // boolean found = false;
        // for (int i = 0; i < userPinjaman.size(); i++) {
        // if (userPinjaman.get(i).equals(UserSaatIni) &&
        // riwayatPinjaman.get(i).equals(idPinjaman)) {
        // userPinjaman.remove(i);
        // riwayatPinjaman.remove(i);
        // System.out.println("Pembayaran pinjaman berhasil.");
        // found = true;
        // break;
        // }
        // }
        // if (!found) {
        // System.out.println("ID pinjaman tidak ditemukan.");
        // }
        break;

      case "4":
        System.out.println("Logout berhasil.");
        return 1;
      default:
        System.out.println("Pilihan tidak valid.");

    }
    return 0;
  }
}