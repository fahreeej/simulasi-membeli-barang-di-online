/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.uas_fahrij;
import java.util.Scanner;
import java.util.ArrayList;

public class UAS_Fahrij {
    static Scanner input = new Scanner(System.in);
    static int saldo = 100000;
    static int totalBelanja = 0;
    static ArrayList<String> keranjang = new ArrayList<>();

    public static void main(String[] args) {
        int pilihan = 0;
        do {
            tampilkanMenu();
            
            if (!input.hasNextInt()) {
                System.out.println("Masukkan angka yang benar!");
                input.next();
                continue;
            }

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> beliBarang();
                case 2 -> checkout();               
                case 3 -> cekSaldo();
                case 4 -> lihatKeranjang();
                case 5 -> System.out.println("Terima kasih telah berbelanja di TOKOPAEDI!");
                default -> System.out.println("Tolong pilih menu yang tertera!");
            }
        } while (pilihan != 5);
    }

    static void tampilkanMenu() {
        System.out.println("\n=== HALO SELAMAT DATANG DI TOKOPAEDI ===");
        System.out.println("1. Membeli Barang");
        System.out.println("2. Checkout dan Bayar");
        System.out.println("3. Cek Saldo");
        System.out.println("4. Lihat Keranjang");
        System.out.println("5. Keluar\n");
        System.out.print("Pilih menu: ");
    }

    static void beliBarang() {
        System.out.println("\n===== DAFTAR BARANG =====");
        System.out.println("1. Laptop - Rp. 50.000");
        System.out.println("2. Mouse - Rp. 10.000");
        System.out.println("3. Keyboard - Rp. 20.000");
        System.out.print("Pilih barang (1-3): ");
        
        if (!input.hasNextInt()) {
            System.out.println("Masukkan angka yang benar!");
            input.next();
            return;
        }

        int pilihan = input.nextInt();
        input.nextLine();

        String barang = "";
        int harga = switch (pilihan) {
            case 1 -> {
                barang = "Laptop - Rp. 50.000";
                yield 50000;
            }
            case 2 -> {
                barang = "Mouse - Rp. 10.000";
                yield 10000;
            }
            case 3 -> {
                barang = "Keyboard - Rp. 20.000";
                yield 20000;
            }
            default -> {
                System.out.println("Tolong pilih menu yang tertera!");
                yield 0;
            }
        };

        if (harga > 0) {
            totalBelanja += harga;
            keranjang.add(barang);
            System.out.println("Barang berhasil ditambahkan ke keranjang!");
        }
    }

    static void checkout() {
        if (totalBelanja == 0) {
            System.out.println("Keranjang masih kosong!");
            return;
        }

        System.out.println("\n===== Checkout =====");
        lihatKeranjang();
        System.out.println("Total belanja: Rp. " + totalBelanja);
        System.out.print("Lanjutkan pembayaran? (y/n): ");
        
        String konfirmasi = input.nextLine().trim().toLowerCase();

        if (konfirmasi.equals("y")) {
            if (saldo >= totalBelanja) {
                saldo -= totalBelanja;
                System.out.println("Pembayaran berhasil! Sisa saldo: Rp. " + saldo);
                totalBelanja = 0;
                keranjang.clear();
            } else {
                System.out.println("Saldo anda tidak mencukupi!");
            }
        } else {
            System.out.println("Checkout dibatalkan.");
        }
    }

    static void cekSaldo() {
        System.out.println("\n=== Cek Saldo ===");
        System.out.println("Saldo Anda saat ini: Rp. " + saldo);
    }

    static void lihatKeranjang() {
        System.out.println("\n=== Keranjang Belanja ===");
        if (keranjang.isEmpty()) {
            System.out.println("Keranjang masih kosong!");
        } else {
            for (String item : keranjang) {
                System.out.println("- " + item);
            }
        }
    }
}
