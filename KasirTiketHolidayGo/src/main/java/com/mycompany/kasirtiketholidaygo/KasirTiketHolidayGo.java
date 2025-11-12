/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kasirtiketholidaygo;

/**
 *
 * @author Randika Fauzy
 */
import java.util.Scanner;
import java.text.DecimalFormat;


public class KasirTiketHolidayGo {

public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        DecimalFormat df = new DecimalFormat("#,###");

        String namaTujuan = "";
        long harga = 0L, jumlah = 0L, total = 0L, bayar = 0L;
        long totalSemua = 0L;
        double diskon = 0.0;
        double totalBayar = 0.0;

        System.out.println("=== Selamat datang di Tiket HolidayGo!! ===");

        char lanjut = 0;
        int nomorTiket;

        do {
            System.out.println("\n=== Tujuan Liburan ===");
            System.out.println("1. Amerika        - Rp 13.500.000");
            System.out.println("2. Jepang         - Rp 5.500.000");
            System.out.println("3. Malaysia       - Rp 1.700.000");
            System.out.println("4. Jerman         - Rp 13.500.000");
            System.out.println("5. Itali          - Rp 9.500.000");
            System.out.print("Pilih nomor tiket (1-5): ");
            nomorTiket = input.nextInt();

            switch (nomorTiket) {
                case 1:
                    namaTujuan = "Amerika";
                    harga = 13500000L;
                    break;
                case 2:
                    namaTujuan = "Jepang";
                    harga = 5500000L;
                    break;
                case 3:
                    namaTujuan = "Malaysia";
                    harga = 1700000L;
                    break;
                case 4:
                    namaTujuan = "Jerman";
                    harga = 13500000L;
                    break;
                case 5:
                    namaTujuan = "Itali";
                    harga = 9500000L;
                    break;
                default:
                    System.out.println("Nomor Tiket tidak valid!");
                    continue;
            }

            System.out.print("Masukkan jumlah tiket: ");
            jumlah = input.nextLong();

            total = harga * jumlah;
            totalSemua += total;

            // tampilkan total per item dengan format ribuan
            System.out.println(namaTujuan + " x" + jumlah + " = Rp " + df.format(total));

            System.out.print("\nApakah ingin menambah Tiket Tujuan lagi? (y/n): ");
            lanjut = input.next().charAt(0);
        } while (lanjut == 'y' || lanjut == 'Y');

        // Hitung diskon berdasarkan totalSemua
        if (totalSemua >= 2_000_000) {
            diskon = 0.20;
        } else if (totalSemua >= 500_000) {
            diskon = 0.10; 
        } else {
            diskon = 0.0;
        }

        totalBayar = totalSemua - (totalSemua * diskon);

        System.out.println("\n=== Struk Pembayaran ===");
        System.out.println("Total          : Rp " + df.format(totalSemua));
        System.out.println("Diskon         : " + (diskon * 100) + "%");
        // totalBayar adalah double, tapi kita format sebagai long jika utuh (pembulatan)
        System.out.println("Total Bayar    : Rp " + df.format(Math.round(totalBayar)));
        System.out.println("===============================");

        System.out.print("Masukkan uang pembayaran: ");
        bayar = input.nextLong();

        long kembalian = bayar - Math.round(totalBayar);
        if (kembalian < 0) {
            System.out.println("Uang tidak cukup! Silakan bayar minimal Rp " + df.format(Math.round(totalBayar)));
        } else {
            System.out.println("Kembalian      : Rp " + df.format(kembalian));
            System.out.println("=== Selamat liburan! Semoga perjalanan Anda menyenangkan! ===");
        }

        input.close();
    }
}

