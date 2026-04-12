package aksesorisrajut;

public class Produk {

    private static int counter = 1;

    protected int id;
    private String namaProduk;
    private Kategori kategori;
    private BahanRajut bahan;
    private int harga;
    private int stok;

    public Produk(String namaProduk, Kategori kategori, BahanRajut bahan, int harga, int stok) {
        this.id = counter++;
        this.namaProduk = namaProduk;
        this.kategori = kategori;
        this.bahan = bahan;
        setHarga(harga);
        setStok(stok);
    }

    public int getId() {
        return id;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        if (namaProduk.isEmpty()) {
            System.out.println("Nama produk tidak boleh kosong.");
        } else {
            this.namaProduk = namaProduk;
        }
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public BahanRajut getBahan() {
        return bahan;
    }

    public void setBahan(BahanRajut bahan) {
        this.bahan = bahan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        if (harga < 0) {
            System.out.println("Harga tidak boleh negatif.");
            this.harga = 0;
        } else {
            this.harga = harga;
        }
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok < 0) {
            System.out.println("Stok tidak boleh negatif.");
            this.stok = 0;
        } else {
            this.stok = stok;
        }
    }

    public void tampilkanInfo() {
        System.out.println("ID Produk    : " + id);
        System.out.println("Nama Produk  : " + namaProduk);
        System.out.println("Kategori     : " + kategori.getNamaKategori());
        System.out.println("Bahan Rajut  : " + bahan.getNamaBahan());
        System.out.println("Harga        : " + harga);
        System.out.println("Stok         : " + stok);
    }


    public void setHarga(int hargaAwal, double diskonPersen) {
        int potongan = (int) (hargaAwal * (diskonPersen / 100));
        int hargaAkhir = hargaAwal - potongan;

        if (hargaAkhir < 0) {
            this.harga = 0;
        } else {
            this.harga = hargaAkhir;
        }
    }

    public void tampilkanInfo(boolean versiRingkas) {
        if (versiRingkas == true) {
            System.out.println("ID: " + id + " | " + namaProduk + " | Rp" + harga);
        } else {
            tampilkanInfo();
        }
    }
}



