import java.util.ArrayList;
import java.util.Scanner;

public class Pengguna {
  protected ArrayList<String> usernames = new ArrayList<>();
  protected ArrayList<String> passwords = new ArrayList<>();
  protected ArrayList<String> roles = new ArrayList<>();
  protected ArrayList<Integer> ids = new ArrayList<>();
  protected ArrayList<String> emails = new ArrayList<>();
  protected ArrayList<String> nomorTelepons = new ArrayList<>();
  protected ArrayList<String> niks = new ArrayList<>();
  protected Scanner input = new Scanner(System.in);
  protected ArrayList<Pinjaman> pinjaman = new ArrayList<>();
  protected Integer penggunaSekarang;
  protected String menu = null;

  public ArrayList<String> getUsernames() {
    return usernames;
  }

  public ArrayList<String> getPasswords() {
    return passwords;
  }

  public ArrayList<String> getRoles() {
    return roles;
  }

  public ArrayList<Integer> getIds() {
    return ids;
  }

  public ArrayList<String> getEmails() {
    return emails;
  }

  public ArrayList<String> getNomorTelepons() {
    return nomorTelepons;
  }

  public ArrayList<String> getNiks() {
    return niks;
  }

  public ArrayList<Pinjaman> getPinjaman() {
    return pinjaman;
  }

  public Integer getPenggunaSekarang() {
    return penggunaSekarang;
  }

  // user admin
  final protected String usernameAdmin = "admin";
  final protected String passwordAdmin = "admin";
  final protected String emailAdmin = "admin@example.com";
  final protected String nomorTeleponAdmin = "08123456789";
  final protected String nikAdmin = "1234567890";

  // user daffa
  final protected String userExample = "daffa";
  final protected String passwordExample = "daffa";
  final protected String emailExample = "daffa@example.com";
  final protected String nomorTeleponExample = "08223456789";
  final protected String nikExample = "1234567892";

  public Pengguna() {
    usernames.add(usernameAdmin);
    passwords.add(passwordAdmin);
    roles.add("admin");
    emails.add(emailAdmin);
    nomorTelepons.add(nomorTeleponAdmin);
    niks.add(nikAdmin);
    ids.add(usernames.size());

    // Default user
    usernames.add(userExample);
    passwords.add(passwordExample);
    roles.add("peminjam");
    emails.add(emailExample);
    nomorTelepons.add(nomorTeleponExample);
    niks.add(nikExample);
    ids.add(usernames.size());
  }

  public Integer Menu() {
    try {
      System.out.println("====================================");
      System.out.println("Selamat datang di aplikasi kami");
      System.out.println("");
      System.out.println("1. Masuk");
      System.out.println("2. Daftar");
      System.out.println("3. Keluar");
      System.out.println("");
      menu = input.nextLine();
      switch (menu) {
        case "1":
          System.out.println("Masuk");
          System.out.print("Nama Pengguna: ");
          String username = input.nextLine();
          System.out.print("Kata Sandi: ");
          String password = input.nextLine();
          Integer hasilMasuk = masuk(username, password);
          if (hasilMasuk == 1) { // Admin
            return 2;
          } else if (hasilMasuk == 2) { // Pengguna
            return 3;
          } else {
            System.out.println("Gagal masuk.");
            break;
          }
        case "2":
          System.out.println("Daftar");
          System.out.print("NIK: ");
          String nik = input.nextLine();
          System.out.print("Nama Pengguna: ");
          String usernameBaru = input.nextLine();
          try {
            if (usernames.contains(usernameBaru)) {
              throw new Exception("Nama pengguna sudah ada.");
            }
          } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
          }
          System.out.print("Email: ");
          String email = input.nextLine();
          System.out.print("Nomor Telepon: ");
          String nomorTelepon = input.nextLine();
          System.out.print("Kata Sandi: ");
          String passwordBaru = input.nextLine();
          daftar(nik, usernameBaru, email, nomorTelepon, passwordBaru, "peminjam");
          break;
        case "3":
          System.out.println("Keluar");
          return 0;
        default:
          System.out.println("Masukan tidak valid");
      }
      return 1;
    } finally {
      // input.close();
    }
  }

  public void daftar(String nik, String username, String email, String nomorTelepon, String password, String role) {
    if (usernames.contains(username)) {
      System.out.println("Nama pengguna sudah ada.");
    } else {
      usernames.add(username);
      passwords.add(password);
      roles.add(role);
      ids.add(usernames.size());
      emails.add(email);
      nomorTelepons.add(nomorTelepon);
      niks.add(nik);
      System.out.println("Pendaftaran berhasil.");
    }
  }

  public Integer masuk(String username, String password) {
    if (usernames.contains(username) && passwords.contains(password)) {
      int index = usernames.indexOf(username);
      String role = roles.get(index);
      int id = ids.get(index);
      penggunaSekarang = id;
      if (role.equals("admin")) { // Admin
        System.out.println("Berhasil masuk sebagai admin.");
        return 1;
      } else { // User
        System.out.println("Berhasil masuk sebagai pengguna.");
        return 2;
      }
    } else {
      System.out.println("Nama pengguna atau kata sandi salah.");
      return 0;
    }
  }

  public void setUsername(ArrayList<String> usernames) {
    this.usernames = usernames;
  }

  public void setPasswords(ArrayList<String> passwords) {
    this.passwords = passwords;
  }

  public void setRoles(ArrayList<String> roles) {
    this.roles = roles;
  }

  public void setIds(ArrayList<Integer> ids) {
    this.ids = ids;
  }

  public void setEmails(ArrayList<String> emails) {
    this.emails = emails;
  }

  public void setNomorTelepons(ArrayList<String> nomorTelepons) {
    this.nomorTelepons = nomorTelepons;
  }

  public void setNiks(ArrayList<String> niks) {
    this.niks = niks;
  }

  public void setPinjaman(ArrayList<Pinjaman> pinjaman) {
    this.pinjaman = pinjaman;
  }

  public void setPenggunaSekarang(Integer penggunaSekarang) {
    this.penggunaSekarang = penggunaSekarang;
  }
}

class Admin extends Pengguna {
  @Override
  public Integer Menu() {
    System.out.println("====================================");
    System.out.println("Menu Admin");
    System.out.println("1. Lihat Semua Pengguna");
    System.out.println("2. Daftar Pengajuan Pinjaman");
    System.out.println("3. Setujui/Tolak Pengajuan Pinjaman");
    System.out.println("4. Status Pembayaran Pinjaman");
    System.out.println("5. Riwayat Pinjaman");
    System.out.println("6. Keluar");
    System.out.println("");
    Scanner input = new Scanner(System.in);
    try {
      super.menu = input.nextLine();
      switch (super.menu) {
        case "1":
          lihatSemuaPengguna();
          break;
        case "2":
          daftarPengajuanPinjaman();
          break;
        case "3":
          setujuiTolakPengajuan();
          break;
        case "4":
          statusPembayaranPinjaman();
          break;
        case "5":
          riwayatPinjaman();
          break;
        case "6":
          System.out.println("Keluar");
          return 1;
        default:
          System.out.println("Masukan tidak valid");
      }
      return 0;
    } finally {
      // input.close();
    }
  }

  private void lihatSemuaPengguna() {
    System.out.println("Daftar Semua Pengguna");
    if (usernames.isEmpty()) {
      System.out.println("Belum ada pengguna yang terdaftar.");
      return;
    }
    for (int i = 0; i < usernames.size(); i++) {
      System.out.println("Pengguna " + (i + 1));
      System.out.println("ID: " + ids.get(i));
      System.out.println("Nama Pengguna: " + usernames.get(i));
      System.out.println("Peran: " + roles.get(i));
      System.out.println("NIK: " + niks.get(i));
      System.out.println("Email: " + emails.get(i));
      System.out.println("Nomor Telepon: " + nomorTelepons.get(i));
      System.out.println("-----------------------------");
    }
  }

  private void daftarPengajuanPinjaman() {
    System.out.println("Daftar Pengajuan Pinjaman");
    if (pinjaman.isEmpty()) {
      System.out.println("Belum ada pengajuan pinjaman.");
      return;
    }
    for (int i = 0; i < pinjaman.size(); i++) {
      System.out.println("Pengajuan " + (i + 1));
      System.out.println("Jumlah Pinjaman: " + pinjaman.get(i).getJumlahPinjaman());
      System.out.println("Jangka Waktu Pinjaman: " + pinjaman.get(i).getJangkaWaktuPinjaman() + " bulan");
      System.out.println("Bunga Pinjaman: " + pinjaman.get(i).getBungaPinjaman() + "%");
      System.out.println("Status Pinjaman: " + pinjaman.get(i).getStatuspinjaman());
      System.out.println("Nama Peminjam: " + pinjaman.get(i).getNamaPeminjam());
      System.out.println("-----------------------------");
    }
  }

  private void setujuiTolakPengajuan() {
    System.out.println("Setujui/Tolak Pengajuan Pinjaman");
    if (pinjaman.isEmpty()) {
      System.out.println("Belum ada pengajuan pinjaman.");
      return;
    }
    daftarPengajuanPinjaman();
    System.out.print("Pilih nomor pengajuan: ");
    int nomorPengajuan = Integer.parseInt(input.nextLine());
    if (nomorPengajuan > 0 && nomorPengajuan <= pinjaman.size()) {
      System.out.println("1. Setujui");
      System.out.println("2. Tolak");
      String pilihan = input.nextLine();
      if (pilihan.equals("1")) {
        pinjaman.get(nomorPengajuan - 1).setStatusPinjaman("Disetujui");
        System.out.println("Pengajuan disetujui.");
      } else if (pilihan.equals("2")) {
        pinjaman.get(nomorPengajuan - 1).setStatusPinjaman("Ditolak");
        System.out.println("Pengajuan ditolak.");
      } else {
        System.out.println("Pilihan tidak valid.");
      }
    } else {
      System.out.println("Nomor pengajuan tidak valid.");
    }
  }

  private void statusPembayaranPinjaman() {
    System.out.println("Status Pembayaran Pinjaman");
    if (pinjaman.isEmpty()) {
      System.out.println("Belum ada pinjaman yang terdaftar.");
      return;
    }
    boolean adaPinjamanDisetujui = false;
    for (int i = 0; i < pinjaman.size(); i++) {
      if (pinjaman.get(i).getStatuspinjaman().equals("Disetujui")) {
        adaPinjamanDisetujui = true;
        System.out.println("Pinjaman " + (i + 1));
        System.out.println("Jumlah Pinjaman: " + pinjaman.get(i).getJumlahPinjaman());
        System.out.println("Jangka Waktu: " + pinjaman.get(i).getJangkaWaktuPinjaman() + " bulan");
        System.out.println("Bunga: " + pinjaman.get(i).getBungaPinjaman() + "%");
        System.out.println("Status: " + pinjaman.get(i).getStatuspinjaman());
        System.out.println("Nama Peminjam: " + pinjaman.get(i).getNamaPeminjam());
        System.out.println("-----------------------------");
      }
    }
    if (!adaPinjamanDisetujui) {
      System.out.println("Belum ada pinjaman yang disetujui.");
    }
  }

  private void riwayatPinjaman() {
    System.out.println("Riwayat Pinjaman");
    if (pinjaman.isEmpty()) {
      System.out.println("Belum ada riwayat pinjaman.");
      return;
    }
    for (int i = 0; i < pinjaman.size(); i++) {
      System.out.println("Pinjaman " + (i + 1));
      System.out.println("Jumlah Pinjaman: " + pinjaman.get(i).getJumlahPinjaman());
      System.out.println("Jangka Waktu Pinjaman: " + pinjaman.get(i).getJangkaWaktuPinjaman() + " bulan");
      System.out.println("Bunga Pinjaman: " + pinjaman.get(i).getBungaPinjaman() + "%");
      System.out.println("Status Pinjaman: " + pinjaman.get(i).getStatuspinjaman());
      System.out.println("Nama Peminjam: " + pinjaman.get(i).getNamaPeminjam());
      System.out.println("-----------------------------");
    }
  }

  // private void lihatProfil() {
  // System.out.println("Profil Pengguna");
  // System.out.println("NIK: " + niks.get(penggunaSekarang - 1));
  // System.out.println("Nama Pengguna: " + usernames.get(penggunaSekarang - 1));
  // System.out.println("Email: " + emails.get(penggunaSekarang - 1));
  // System.out.println("Nomor Telepon: " + nomorTelepons.get(penggunaSekarang -
  // 1));
  // }
}

class User extends Pengguna {
  @Override
  public Integer Menu() {
    Scanner input = new Scanner(System.in);
    try {
      while (true) {
        printMenu();
        String pilihan = input.nextLine();
        switch (pilihan) {
          case "1":
            lihatProfil();
            break;
          case "2":
            ajukanPinjaman();
            break;
          case "3":
            lihatStatusPending();
            break;
          case "4":
            editPengajuan();
            break;
          case "5":
            batalkanPengajuan();
            break;
          case "6":
            catatPembayaran();
            break;
          case "7":
            System.out.println("Keluar");
            return 1;
          default:
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
      }
    } finally {
      // input.close();
    }
  }

  private void printMenu() {
    System.out.println("====================================");
    System.out.println("Menu Pengguna");
    System.out.println("1. Lihat Profil");
    System.out.println("2. Ajukan Pinjaman");
    System.out.println("3. Lihat Status Pengajuan");
    System.out.println("4. Edit Pengajuan");
    System.out.println("5. Batalkan Pengajuan");
    System.out.println("6. Catat Pembayaran");
    System.out.println("7. Keluar");
    System.out.println("");
  }

  private Boolean cekDuplikatPengajuan(String namaPeminjam) {
    for (Pinjaman pinjamanItem : pinjaman) {
      if (pinjamanItem.getNamaPeminjam().equals(namaPeminjam) && pinjamanItem.getStatuspinjaman().equals("Pending")) {
        return true;
      }
    }
    return false;
  }

  private void lihatProfil() {
    System.out.println("Profil Pengguna");
    System.out.println("NIK: " + niks.get(penggunaSekarang - 1));
    System.out.println("Nama Pengguna: " + usernames.get(penggunaSekarang - 1));
    System.out.println("Email: " + emails.get(penggunaSekarang - 1));
    System.out.println("Nomor Telepon: " + nomorTelepons.get(penggunaSekarang - 1));
  }

  private void ajukanPinjaman() {
    if (cekDuplikatPengajuan(usernames.get(penggunaSekarang - 1))) {
      System.err.println("sudah ada pengajuan pinjaman.");
      return;
    }
    System.out.println("Ajukan Pinjaman");
    System.out.print("Nominal yang ingin Dipinjam: ");
    int jumlahPinjaman = input.nextInt();
    input.nextLine(); // Clear buffer
    System.out.println(
        "\n1. 3 bulan, Bunga 10%\n2. 6 bulan, Bunga 15%\n3. 12 bulan, Bunga 20%\n4. 24 bulan, Bunga 25%\n5. 36 bulan, Bunga 30%\n");
    System.out.print("Pilih Jangka Waktu Pinjaman (1-5): ");

    int pilihanJangkaWaktu = input.nextInt();
    input.nextLine(); // Clear buffer

    int jangkaWaktuPinjaman = 0;
    double bungaPinjaman = 0.0;

    if (pilihanJangkaWaktu < 1 || pilihanJangkaWaktu > 5) {
      System.out.println("Pilihan tidak valid. Silakan coba lagi.");
      return;
    } else if (pilihanJangkaWaktu == 1) {
      System.out.println("Jangka Waktu Pinjaman: 3 bulan, Bunga 10%");
      jangkaWaktuPinjaman = 3;
      bungaPinjaman = 10.0;
    } else if (pilihanJangkaWaktu == 2) {
      System.out.println("Jangka Waktu Pinjaman: 6 bulan, Bunga 15%");
      jangkaWaktuPinjaman = 6;
      bungaPinjaman = 15.0;
    } else if (pilihanJangkaWaktu == 3) {
      System.out.println("Jangka Waktu Pinjaman: 12 bulan, Bunga 20%");
      jangkaWaktuPinjaman = 12;
      bungaPinjaman = 20.0;
    } else if (pilihanJangkaWaktu == 4) {
      System.out.println("Jangka Waktu Pinjaman: 24 bulan, Bunga 25%");
      jangkaWaktuPinjaman = 24;
      bungaPinjaman = 25.0;
    } else if (pilihanJangkaWaktu == 5) {
      System.out.println("Jangka Waktu Pinjaman: 36 bulan, Bunga 30%");
      jangkaWaktuPinjaman = 36;
      bungaPinjaman = 30.0;
    }

    String statusPinjaman = "Menunggu";
    String namaPeminjam = usernames.get(penggunaSekarang - 1);

    pinjaman.add(new Pinjaman(jumlahPinjaman, jangkaWaktuPinjaman, bungaPinjaman, statusPinjaman, namaPeminjam));

    System.out.println("Pinjaman berhasil diajukan.");
  }

  private void lihatStatusPending() {
    System.out.println("Status Pengajuan Pinjaman");
    boolean adaPengajuanPending = false;
    for (Pinjaman pinjamanItem : pinjaman) {
      if (pinjamanItem.getStatuspinjaman().equals("Menunggu")) {
        adaPengajuanPending = true;
        System.out.println("Jumlah Pinjaman: " + pinjamanItem.getJumlahPinjaman());
        System.out.println("Jangka Waktu Pinjaman: " + pinjamanItem.getJangkaWaktuPinjaman() + " bulan");
        System.out.println("Bunga Pinjaman: " + pinjamanItem.getBungaPinjaman() + "%");
        System.out.println("Status Pinjaman: " + pinjamanItem.getStatuspinjaman());

      }
    }
  }

  // private void lihatStatus() {
  // System.out.println("Status Pengajuan");
  // if (pinjaman.isEmpty()) {
  // System.out.println("Belum ada pengajuan pinjaman.");
  // return;
  // }
  // for (int i = 0; i < pinjaman.size(); i++) {
  // System.out.println("Pengajuan " + (i + 1));
  // System.out.println("Jumlah Pinjaman: " +
  // pinjaman.get(i).getJumlahPinjaman());
  // System.out.println("Jangka Waktu Pinjaman: " +
  // pinjaman.get(i).getJangkaWaktuPinjaman() + " bulan");
  // System.out.println("Bunga Pinjaman: " + pinjaman.get(i).getBungaPinjaman() +
  // "%");
  // System.out.println("Status Pinjaman: " +
  // pinjaman.get(i).getStatuspinjaman());
  // System.out.println("Nama Peminjam: " + pinjaman.get(i).getNamaPeminjam());
  // System.out.println("-----------------------------");
  // }
  // }

  private void editPengajuan() {
    System.out.println("Edit Pengajuan");
    if (pinjaman.isEmpty()) {
      System.out.println("Belum ada pengajuan pinjaman.");
      return;
    }
    lihatStatusPending();
    System.out.print("Nomor Pengajuan: ");
    int nomorPengajuan = input.nextInt();
    input.nextLine(); // Clear buffer
    int jumlahPinjaman = 0;
    int jangkaWaktuPinjaman = 0;
    double bungaPinjaman = 0.0;
    if (nomorPengajuan > 0 && nomorPengajuan <= pinjaman.size()) {
      if (pinjaman.get(nomorPengajuan - 1).getStatuspinjaman().equals("Disetujui")) {
        System.out.println("Pengajuan sudah disetujui, tidak bisa diubah.");
        return;
      } else if (pinjaman.get(nomorPengajuan - 1).getStatuspinjaman().equals("Ditolak")) {
        System.out.println("Pengajuan sudah ditolak, tidak bisa diubah.");
        return;
      } else if (pinjaman.get(nomorPengajuan - 1).getStatuspinjaman().equals("Menunggu")) {
        System.out.print("Jumlah Pinjaman: ");
        jumlahPinjaman = input.nextInt();
        input.nextLine(); // Clear buffer
        System.out.println(
            "\n1. 3 bulan, Bunga 10%\n2. 6 bulan, Bunga 15%\n3. 12 bulan, Bunga 20%\n4. 24 bulan, Bunga 25%\n5. 36 bulan, Bunga 30%\n");
        System.out.print("Pilih Jangka Waktu Pinjaman (1-5): ");
        int pilihanJangkaWaktu = input.nextInt();
        input.nextLine(); // Clear buffer

        if (pilihanJangkaWaktu < 1 || pilihanJangkaWaktu > 5) {
          System.out.println("Pilihan tidak valid. Silakan coba lagi.");
          return;
        } else if (pilihanJangkaWaktu == 1) {
          System.out.println("Jangka Waktu Pinjaman: 3 bulan, Bunga 10%");
          jangkaWaktuPinjaman = 3;
          bungaPinjaman = 10.0;
        } else if (pilihanJangkaWaktu == 2) {
          System.out.println("Jangka Waktu Pinjaman: 6 bulan, Bunga 15%");
          jangkaWaktuPinjaman = 6;
          bungaPinjaman = 15.0;
        } else if (pilihanJangkaWaktu == 3) {
          System.out.println("Jangka Waktu Pinjaman: 12 bulan, Bunga 20%");
          jangkaWaktuPinjaman = 12;
          bungaPinjaman = 20.0;
        } else if (pilihanJangkaWaktu == 4) {
          System.out.println("Jangka Waktu Pinjaman: 24 bulan, Bunga 25%");
          jangkaWaktuPinjaman = 24;
          bungaPinjaman = 25.0;
        } else if (pilihanJangkaWaktu == 5) {
          System.out.println("Jangka Waktu Pinjaman: 36 bulan, Bunga 30%");
          jangkaWaktuPinjaman = 36;
          bungaPinjaman = 30.0;
        }
        pinjaman.get(nomorPengajuan - 1).setJumlahPinjaman(jumlahPinjaman);
        pinjaman.get(nomorPengajuan - 1).setJangkaWaktuPinjaman(jangkaWaktuPinjaman);
        pinjaman.get(nomorPengajuan - 1).setBungaPinjaman(bungaPinjaman);
        System.out.println("Pengajuan berhasil diubah.");
        return;
      }
    } else {
      System.out.println("Nomor pengajuan tidak valid.");
    }
  }

  private void batalkanPengajuan() {
    System.out.println("Batalkan Pengajuan");
    if (pinjaman.isEmpty()) {
      System.out.println("Belum ada pengajuan pinjaman.");
      return;
    }
    lihatStatusPending();
    System.out.print("Nomor Pengajuan: ");
    int nomorPengajuan = input.nextInt();
    input.nextLine(); // Clear buffer
    if (nomorPengajuan > 0 && nomorPengajuan <= pinjaman.size()) {
      if (pinjaman.get(nomorPengajuan - 1).getStatuspinjaman().equals("Menunggu")) {
        pinjaman.remove(nomorPengajuan - 1);
        System.out.println("Pengajuan berhasil dibatalkan.");
      } else {
        System.out.println("Pengajuan tidak dapat dibatalkan karena status bukan Menunggu.");
      }
    } else {
      System.out.println("Nomor pengajuan tidak valid.");
    }
  }

  private void catatPembayaran() {
    System.out.println("Catat Pembayaran");
    if (pinjaman.isEmpty()) {
      System.out.println("Belum ada pinjaman yang terdaftar.");
      return;
    }
    boolean adaPinjamanDisetujui = false;
    for (int i = 0; i < pinjaman.size(); i++) {
      if (pinjaman.get(i).getStatuspinjaman().equals("Disetujui")) {
        adaPinjamanDisetujui = true;
        System.out.println("Pinjaman " + (i + 1));
        System.out.println("Jumlah Pinjaman: " + pinjaman.get(i).getJumlahPinjaman());
        System.out.println("Jangka Waktu: " + pinjaman.get(i).getJangkaWaktuPinjaman() + " bulan");
        System.out.println("Bunga: " + pinjaman.get(i).getBungaPinjaman() + "%");
        System.out.println("Status: " + pinjaman.get(i).getStatuspinjaman());
        System.out.println("Nama Peminjam: " + pinjaman.get(i).getNamaPeminjam());
        System.out.println("-----------------------------");
      }
    }
    if (!adaPinjamanDisetujui) {
      System.out.println("Belum ada pinjaman yang disetujui.");
      return;
    }
    System.out.print("Nomor Pinjaman: ");
    int nomorPinjaman = input.nextInt();
    input.nextLine(); // Clear buffer
    if (nomorPinjaman > 0 && nomorPinjaman <= pinjaman.size()) {
      if (pinjaman.get(nomorPinjaman - 1).getStatuspinjaman().equals("Disetujui")) {
        System.out.print("Jumlah Pembayaran: ");
        double jumlahPembayaran = input.nextDouble();
        input.nextLine(); // Clear buffer
        pinjaman.get(nomorPinjaman - 1).catatPembayaran(jumlahPembayaran);
        System.out.println("Pembayaran berhasil dicatat.");
      } else {
        System.out.println("Pinjaman belum disetujui.");
      }
    } else {
      System.out.println("Nomor pinjaman tidak valid.");
    }
  }
}
