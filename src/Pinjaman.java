interface PinjamanInterface {
    int getJumlahPinjaman();

    void setJumlahPinjaman(int jumlahPinjaman);

    int getJangkaWaktuPinjaman();

    void setJangkaWaktuPinjaman(int jangkaWaktuPinjaman);

    double getBungaPinjaman();

    void setBungaPinjaman(double bungaPinjaman);

    String getStatuspinjaman();

    void setStatusPinjaman(String statusPinjaman);

    String getNamaPeminjam();

    void setNamaPeminjam(String namaPeminjam);
}

abstract class AbstractPinjaman implements PinjamanInterface {
    protected int jumlahPinjaman;
    protected int jangkaWaktuPinjaman;
    protected double bungaPinjaman;
    protected String statusPinjaman;
    protected String namaPeminjam;

    public AbstractPinjaman(int jumlahPinjaman, int jangkaWaktuPinjaman, double bungaPinjaman, String statusPinjaman,
            String namaPeminjam) {
        this.jumlahPinjaman = jumlahPinjaman;
        this.jangkaWaktuPinjaman = jangkaWaktuPinjaman;
        this.bungaPinjaman = bungaPinjaman;
        this.statusPinjaman = statusPinjaman;
        this.namaPeminjam = namaPeminjam;
    }

    public int getJumlahPinjaman() {
        return jumlahPinjaman;
    }

    public void setJumlahPinjaman(int jumlahPinjaman) {
        this.jumlahPinjaman = jumlahPinjaman;
    }

    public int getJangkaWaktuPinjaman() {
        return jangkaWaktuPinjaman;
    }

    public void setJangkaWaktuPinjaman(int jangkaWaktuPinjaman) {
        this.jangkaWaktuPinjaman = jangkaWaktuPinjaman;
    }

    public double getBungaPinjaman() {
        return bungaPinjaman;
    }

    public void setBungaPinjaman(double bungaPinjaman) {
        this.bungaPinjaman = bungaPinjaman;
    }

    public String getStatuspinjaman() {
        return statusPinjaman;
    }

    public abstract void setStatusPinjaman(String statusPinjaman); // Dibuat abstrak untuk kebutuhan spesifik

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }
}

public class Pinjaman extends AbstractPinjaman {
    public Pinjaman(int jumlahPinjaman, int jangkaWaktuPinjaman, double bungaPinjaman, String statusPinjaman,
            String namaPeminjam) {
        super(jumlahPinjaman, jangkaWaktuPinjaman, bungaPinjaman, statusPinjaman, namaPeminjam);
    }

    @Override
    public void setStatusPinjaman(String statusPinjaman) {
        // Validasi status yang diperbolehkan: Pending, Disetujui, Ditolak, Lunas, Belum
        // Lunas, Dalam Proses
        String[] validStatuses = { "Pending", "Disetujui", "Ditolak", "Lunas", "Belum Lunas", "Dalam Proses" };
        boolean isValid = false;
        for (String validStatus : validStatuses) {
            if (validStatus.equals(statusPinjaman)) {
                isValid = true;
                break;
            }
        }
        if (isValid) {
            this.statusPinjaman = statusPinjaman;
        } else {
            System.out.println(
                    "Status tidak valid. Gunakan: Menunggu, Disetujui, Ditolak, Lunas, Belum Lunas, atau Dalam Proses.");
        }
    }
}
