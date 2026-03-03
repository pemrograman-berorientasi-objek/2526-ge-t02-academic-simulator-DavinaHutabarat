package academic.driver; // Mendefinisikan paket untuk kelas Driver2

/**
 * @DavinaOlivia 12S24047 Davina Olivia
 * @DavinaOlivia 12S24047 Davina Olivia
 */

import academic.model.Student; // Mengimpor kelas Student dari paket academic.model
import java.util.ArrayList;   // Mengimpor ArrayList untuk penampung sementara
import java.util.Scanner;     // Mengimpor Scanner untuk input dari pengguna

public class Driver2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Objek Scanner untuk membaca input
        
        // Kita gunakan ArrayList sebagai penampung sementara karena kita tidak tahu
        // berapa banyak mahasiswa yang akan dimasukkan.
        ArrayList<Student> tempStudentList = new ArrayList<>(); 

        System.out.println("=== Sistem Penyimpanan Data Mahasiswa ===");
        System.out.println("Masukkan data mahasiswa (format: NIM#Nama#TahunMasuk#ProgramStudi).");
        System.out.println("Ketik '---' untuk berhenti dan menampilkan hasil.");

        String line; // Variabel untuk menyimpan setiap baris input
        while (input.hasNextLine()) { // Terus membaca selama ada baris input
            line = input.nextLine(); // Baca satu baris input

            if (line.equals("---")) { // Jika input adalah '---', berhenti
                break;
            }

            // Memecah baris input berdasarkan karakter '#'
            // Contoh: "12S20999#Wiro Sableng#2020#Information Systems" akan menjadi array String:
            // ["12S20999", "Wiro Sableng", "2020", "Information Systems"]
            String[] segments = line.split("#"); 

            // Validasi sederhana: memastikan ada 4 segmen data
            if (segments.length == 4) {
                String nim = segments[0];
                String name = segments[1];
                
                int entranceYear = 0; // Inisialisasi Tahun Masuk
                try {
                    entranceYear = Integer.parseInt(segments[2]); // Konversi Tahun Masuk dari String ke int
                } catch (NumberFormatException e) {
                    // Jika Tahun Masuk bukan angka, berikan pesan kesalahan dan lewati baris ini
                    System.err.println("Peringatan: Tahun masuk tidak valid untuk baris ini: " + line);
                    continue; // Lanjutkan ke input berikutnya
                }
                
                String major = segments[3];

                // Membuat objek Student baru dari data yang sudah dipecah
                Student student = new Student(nim, name, entranceYear, major);
                tempStudentList.add(student); // Menambahkan objek Student ke ArrayList
            } else {
                System.err.println("Peringatan: Format input tidak sesuai untuk baris ini: " + line);
            }
        }

        // Setelah semua input selesai, kita konversi ArrayList ke array statis Student[].
        // Ini memenuhi syarat "Gunakan array sebagai media penyimpanan" secara eksplisit
        // setelah jumlah elemen diketahui.
        Student[] students = tempStudentList.toArray(new Student[0]);

        System.out.println("\n=== Daftar Mahasiswa Tersimpan ===");
        if (students.length == 0) {
            System.out.println("Tidak ada data mahasiswa yang disimpan.");
        } else {
            // Iterasi melalui array students dan tampilkan setiap objek Student
            for (Student student : students) {
                System.out.println(student); // Memanggil method toString() dari objek Student
            }
        }

        input.close(); // Menutup objek Scanner untuk mencegah resource leak
        System.out.println("\nProgram selesai.");
    }
}
