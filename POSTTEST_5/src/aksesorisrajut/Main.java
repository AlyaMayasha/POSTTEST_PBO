package aksesorisrajut;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Produk> daftarProduk = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int pilihan;

        do {
            System.out.println("\n=== SISTEM MANAJEMEN PENJUALAN AKSESORIS RAJUT HANDMADE ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Lihat Produk");
            System.out.println("3. Update Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    tambahProduk();
                    break;
                case 2:
                    lihatProduk();
                    break;
                case 3:
                    updateProduk();
                    break;
                case 4:
                    hapusProduk();
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (pilihan != 5);
    }

    static void tambahProduk() {
        input.nextLine();

        System.out.print("Nama Produk: ");
        String nama = input.nextLine();

        System.out.print("Kategori Produk: ");
        String namaKategori = input.nextLine();
        Kategori kategori = new Kategori(namaKategori);

        System.out.print("Bahan Rajut: ");
        String namaBahan = input.nextLine();
        BahanRajut bahan = new BahanRajut(namaBahan);

        System.out.print("Harga: ");
        int harga = input.nextInt();

        System.out.print("Stok: ");
        int stok = input.nextInt();
        input.nextLine();

        System.out.println("Jenis Produk:");
        System.out.println("1. Tas Rajut");
        System.out.println("2. Boneka Rajut");
        System.out.println("3. Keychain Rajut");
        System.out.print("Pilih jenis: ");
        int jenis = input.nextInt();
        input.nextLine();

        Produk produkBaru;

        if (jenis == 1) {
            System.out.print("Model Tas (Ransel/Totebag/Slingbag): ");
            String model = input.nextLine();
            produkBaru = new TasRajut(nama, kategori, bahan, harga, stok, model);

        } else if (jenis == 2) {
            System.out.print("Karakter: ");
            String bentuk = input.nextLine();
            produkBaru = new BonekaRajut(nama, kategori, bahan, harga, stok, bentuk);

        } else {
            System.out.print("Bentuk Keychain (hati/bunga/hewan/dll): ");
            String KeychainRajut = input.nextLine();
            produkBaru = new KeychainRajut(nama, kategori, bahan, harga, stok, KeychainRajut);
        }

        System.out.print("Apakah produk ini sedang diskon? (y/n): ");
        String jawabDiskon = input.nextLine();

        if (jawabDiskon.equals("y") || jawabDiskon.equals("Y")) {
            System.out.print("Masukkan persentase diskon : ");
            double diskon = input.nextDouble();
            input.nextLine();

            produkBaru.setHarga(harga, diskon);
            produkBaru.tampilkanDiskon(harga, diskon);
            System.out.println("Harga setelah diskon berhasil diatur!");
        }

        daftarProduk.add(produkBaru);

        System.out.println("Produk berhasil ditambahkan!");
    }

    static void lihatProduk() {

        if (daftarProduk.isEmpty()) {
            System.out.println("Belum ada data produk.");
            return;
        }

        System.out.println("\nOpsi Tampilan Produk:");
        System.out.println("1. Tampilan Lengkap");
        System.out.println("2. Tampilan Ringkas");
        System.out.print("Pilih opsi (1/2): ");
        int opsi = input.nextInt();
        input.nextLine();

        System.out.println("\n======= DAFTAR PRODUK =======");

        for (Produk p : daftarProduk) {

            if (opsi == 2) {
                p.tampilkanInfo(true);

            } else {
                p.tampilkanInfo();
            }

            System.out.println("-----------------------------");
        }
    }

    static void updateProduk() {

        if (daftarProduk.isEmpty()) {
            System.out.println("Data produk kosong.");
            return;
        }

        System.out.println("\n======= DAFTAR PRODUK =======");

        for (Produk p : daftarProduk) {
            p.tampilkanInfo();
            System.out.println("-----------------------------");
        }

        System.out.print("Masukkan ID produk yang ingin diupdate: ");
        int id = input.nextInt();
        input.nextLine();

        for (Produk p : daftarProduk) {
            if (p.getId() == id) {

                System.out.print("Nama baru: ");
                p.setNamaProduk(input.nextLine());

                System.out.print("Kategori baru: ");
                String kategoriBaru = input.nextLine();
                p.setKategori(new Kategori(kategoriBaru));

                System.out.print("Bahan rajut baru: ");
                String bahanBaru = input.nextLine();
                p.setBahan(new BahanRajut(bahanBaru));

                System.out.print("Harga awal baru: ");
                int hargaBaru = input.nextInt();
                input.nextLine();

                System.out.print("Apakah produk ini sedang diskon? (y/n): ");
                String jawabDiskon = input.nextLine();

                if (jawabDiskon.equals("y") || jawabDiskon.equals("Y")) {
                    System.out.print("Masukkan persentase diskon: ");
                    double diskonBaru = input.nextDouble();
                    input.nextLine();

                    p.setHarga(hargaBaru, diskonBaru);
                } else {
                    p.setHarga(hargaBaru);
                }

                System.out.print("Stok baru: ");
                p.setStok(input.nextInt());
                input.nextLine();

                if (p instanceof TasRajut) {
                    System.out.print("Model tas baru: ");
                    ((TasRajut) p).setModel(input.nextLine());

                } else if (p instanceof BonekaRajut) {
                    System.out.print("Karakter baru: ");
                    ((BonekaRajut) p).setKarakter(input.nextLine());

                } else if (p instanceof KeychainRajut) {
                    System.out.print("Bentuk keychain baru: ");
                    ((KeychainRajut) p).setBentuk(input.nextLine());
                }

                System.out.println("Produk berhasil diupdate!");
                return;
            }
        }

        System.out.println("Produk dengan ID tersebut tidak ditemukan.");
    }

    static void hapusProduk() {

        if (daftarProduk.isEmpty()) {
            System.out.println("Data produk kosong.");
            return;
        }

        System.out.println("\n======= DAFTAR PRODUK =======");

        for (Produk p : daftarProduk) {
            p.tampilkanInfo();
            System.out.println("-----------------------------");
        }

        System.out.print("Masukkan ID produk yang ingin dihapus: ");
        int id = input.nextInt();

        for (int i = 0; i < daftarProduk.size(); i++) {
            if (daftarProduk.get(i).getId() == id) {
                daftarProduk.remove(i);
                System.out.println("Produk berhasil dihapus.");
                return;
            }
        }

        System.out.println("Produk tidak ditemukan.");
    }
}