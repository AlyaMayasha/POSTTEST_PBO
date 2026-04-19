package aksesorisrajut;

public abstract class Produk implements Diskon {

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

    public void setHarga(int hargaAwal, double diskonPersen) {
        double hargaAkhir = hitungDiskon(hargaAwal, diskonPersen);

        if (hargaAkhir < 0) {
            this.harga = 0;
        } else {
            this.harga = (int) hargaAkhir;
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
        System.out.println("Jenis Produk : " + getJenisProduk());
        System.out.println("Kategori     : " + kategori.getNamaKategori());
        System.out.println("Bahan Rajut  : " + bahan.getNamaBahan());
        System.out.println("Harga        : " + harga);
        System.out.println("Stok         : " + stok);
    }

    public void tampilkanInfo(boolean versiRingkas) {
        if (versiRingkas) {
            System.out.println("ID: " + id + " | " + namaProduk + " | Rp" + harga);
        } else {
            tampilkanInfo();
        }
    }

    @Override
    public double hitungDiskon(double harga, double persen) {
        return harga - (harga * persen / 100);
    }

    @Override
    public void tampilkanDiskon(double hargaAwal, double persen) {
        double hargaAkhir = hitungDiskon(hargaAwal, persen);

        System.out.printf("Harga Awal   : %.0f\n", hargaAwal);
        System.out.printf("Diskon       : %.0f%%\n", persen);
        System.out.printf("Harga Akhir  : %.0f\n", hargaAkhir);
    }

    public abstract String getJenisProduk();
}