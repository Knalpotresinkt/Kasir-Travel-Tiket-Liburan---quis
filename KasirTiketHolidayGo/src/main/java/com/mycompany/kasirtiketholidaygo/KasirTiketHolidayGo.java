/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kasirtiketholidaygo;

/**
 *
 * @author Randika
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.text.DecimalFormat;

public class KasirTiketHolidayGo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,###");

        String namaDestinasi = "";
        long hargaTiket = 0L, jumlahPenumpang = 0L, total = 0L, bayar = 0L;
        long totalSemua = 0L;
        double diskon = 0.0;
        double totalBayar = 0.0;

        // format tanggal keberangkatan
        DateTimeFormatter formatterOutput = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");
        LocalDateTime tanggalKeberangkatan = null;

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
                    namaDestinasi = "Amerika";
                    hargaTiket = 13_500_000L;
                    tanggalKeberangkatan = LocalDateTime.of(2025, 12, 20, 9, 0);
                    break;
                case 2:
                    namaDestinasi = "Jepang";
                    hargaTiket = 5_500_000L;
                    tanggalKeberangkatan = LocalDateTime.of(2025, 11, 25, 8, 30);
                    break;
                case 3:
                    namaDestinasi = "Malaysia";
                    hargaTiket = 1_700_000L;
                    tanggalKeberangkatan = LocalDateTime.of(2025, 11, 18, 7, 45);
                    break;
                case 4:
                    namaDestinasi = "Jerman";
                    hargaTiket = 13_500_000L;
                    tanggalKeberangkatan = LocalDateTime.of(2026, 1, 5, 10, 15);
                    break;
                case 5:
                    namaDestinasi = "Itali";
                    hargaTiket = 9_500_000L;
                    tanggalKeberangkatan = LocalDateTime.of(2025, 12, 10, 9, 30);
                    break;
                default:
                    System.out.println("Nomor Tiket tidak valid!");
                    continue;
            }

            System.out.print("Masukkan jumlah penumpang: ");
            jumlahPenumpang = input.nextLong();

            total = hargaTiket * jumlahPenumpang;
            totalSemua += total;

            System.out.println("\n" + namaDestinasi + " x" + jumlahPenumpang + 
                               " = Rp " + df.format(total));
            System.out.println("Tanggal Keberangkatan: " + tanggalKeberangkatan.format(formatterOutput));

            System.out.print("\nApakah ingin menambah Tiket Tujuan lagi? (y/n): ");
            lanjut = input.next().charAt(0);
        } while (lanjut == 'y' || lanjut == 'Y');

        // Hitung diskon
        if (totalSemua >= 2_000_000) {
            diskon = 0.20;
        } else if (totalSemua >= 500_000) {
            diskon = 0.10;
        } else {
            diskon = 0.0;
        }

        totalBayar = totalSemua - (totalSemua * diskon);

        // Cetak struk
        System.out.println("\n=== Struk Pembayaran Tiket HolidayGo ===");
        System.out.println("Tujuan Terakhir       : " + namaDestinasi);
        System.out.println("Tanggal Keberangkatan : " + tanggalKeberangkatan.format(formatterOutput));
        System.out.println("Total Harga Tiket     : Rp " + df.format(totalSemua));
        System.out.println("Diskon                : " + (diskon * 100) + "%");
        System.out.println("Total Bayar           : Rp " + df.format(Math.round(totalBayar)));
        System.out.println("=========================================");

        System.out.print("Masukkan uang pembayaran: ");
        bayar = input.nextLong();

        long kembalian = bayar - Math.round(totalBayar);
        if (kembalian < 0) {
            System.out.println("Uang tidak cukup! Silakan bayar minimal Rp " + df.format(Math.round(totalBayar)));
        } else {
            System.out.println("Kembalian              : Rp " + df.format(kembalian));
            System.out.println("=== Selamat liburan! Semoga perjalanan Anda menyenangkan! ===");
        }

        input.close();
    }
}
