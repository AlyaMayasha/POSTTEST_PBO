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
}