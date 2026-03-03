package academic.driver;

/**
 * @DavinaOlivia 12S24047 Davina Olivia
 * @DavinaOlivia 12S24047 Davina Olivia
 */

import academic.model.Course; // Mengimpor kelas Course dari paket academic.model
import java.util.ArrayList;   // Mengimpor ArrayList untuk penampung sementara
import java.util.Scanner;     // Mengimpor Scanner untuk input dari pengguna

public class Driver1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Objek Scanner untuk membaca input
        
        // Kita gunakan ArrayList sebagai penampung sementara karena kita tidak tahu
        // berapa banyak mata kuliah yang akan dimasukkan.
        // ArrayList adalah "dynamic array" yang ukurannya bisa berubah.
        ArrayList<Course> tempCourseList = new ArrayList<>(); 

        System.out.println("=== Sistem Penyimpanan Mata Kuliah ===");
        System.out.println("Masukkan data mata kuliah (format: Kode#Nama#SKS#Nilai).");
        System.out.println("Ketik '---' untuk berhenti dan menampilkan hasil.");

        String line; // Variabel untuk menyimpan setiap baris input
        while (input.hasNextLine()) { // Terus membaca selama ada baris input
            line = input.nextLine(); // Baca satu baris input

            if (line.equals("---")) { // Jika input adalah '---', berhenti
                break;
            }

            // Memecah baris input berdasarkan karakter '#'
            // Contoh: "12S2203#Object-oriented Programming#3#C" akan menjadi array String:
            // ["12S2203", "Object-oriented Programming", "3", "C"]
            String[] segments = line.split("#"); 

            // Validasi sederhana: memastikan ada 4 segmen data
            if (segments.length == 4) {
                String code = segments[0];
                String name = segments[1];
                
                int sks = 0; // Inisialisasi SKS
                try {
                    sks = Integer.parseInt(segments[2]); // Konversi SKS dari String ke int
                } catch (NumberFormatException e) {
                    // Jika SKS bukan angka, berikan pesan kesalahan dan lewati baris ini
                    System.err.println("Peringatan: SKS tidak valid untuk baris ini: " + line);
                    continue; // Lanjutkan ke input berikutnya
                }
                
                String grade = segments[3];

                // Membuat objek Course baru dari data yang sudah dipecah
                Course course = new Course(code, name, sks, grade);
                tempCourseList.add(course); // Menambahkan objek Course ke ArrayList
            } else {
                System.err.println("Peringatan: Format input tidak sesuai untuk baris ini: " + line);
            }
        }

        // Setelah semua input selesai, kita konversi ArrayList ke array statis Course[].
        // Ini memenuhi syarat "Gunakan array sebagai media penyimpanan" secara eksplisit
        // setelah jumlah elemen diketahui.
        Course[] courses = tempCourseList.toArray(new Course[0]);

        System.out.println("\n=== Daftar Mata Kuliah Tersimpan ===");
        if (courses.length == 0) {
            System.out.println("Tidak ada mata kuliah yang disimpan.");
        } else {
            // Iterasi melalui array courses dan tampilkan setiap objek Course
            for (Course course : courses) {
                System.out.println(course); // Memanggil method toString() dari objek Course
            }
        }

        input.close(); // Menutup objek Scanner untuk mencegah resource leak
        System.out.println("\nProgram selesai.");
    }
}