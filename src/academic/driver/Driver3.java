package academic.driver; // Mendefinisikan paket untuk kelas Driver3

/**
 * @DavinaOlivia 12S24047 Davina Olivia
 * @DavinaOlivia 12S24047 Davina Olivia
 */

import academic.model.Enrollment; // Mengimpor kelas Enrollment dari paket academic.model
import java.util.ArrayList;     // Mengimpor ArrayList untuk penampung sementara
import java.util.Scanner;       // Mengimpor Scanner untuk input dari pengguna

public class Driver3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Objek Scanner untuk membaca input
        
        // Kita gunakan ArrayList sebagai penampung sementara karena kita tidak tahu
        // berapa banyak pendaftaran yang akan dimasukkan.
        ArrayList<Enrollment> tempEnrollmentList = new ArrayList<>(); 

        System.out.println("=== Sistem Penyimpanan Data Pendaftaran Mata Kuliah ===");
        System.out.println("Masukkan data pendaftaran (format: KodeMK#NIM#TahunAkademik#Semester).");
        System.out.println("Ketik '---' untuk berhenti dan menampilkan hasil.");

        String line; // Variabel untuk menyimpan setiap baris input
        while (input.hasNextLine()) { // Terus membaca selama ada baris input
            line = input.nextLine(); // Baca satu baris input

            if (line.equals("---")) { // Jika input adalah '---', berhenti
                break;
            }

            // Memecah baris input berdasarkan karakter '#'
            // Contoh: "12S2203#12S20999#2021/2022#even" akan menjadi array String:
            // ["12S2203", "12S20999", "2021/2022", "even"]
            String[] segments = line.split("#"); 

            // Validasi sederhana: memastikan ada 4 segmen data
            if (segments.length == 4) {
                String courseCode = segments[0];
                String studentNim = segments[1];
                String academicYear = segments[2];
                String semester = segments[3];
                
                // Membuat objek Enrollment baru dari data yang sudah dipecah
                Enrollment enrollment = new Enrollment(courseCode, studentNim, academicYear, semester);
                tempEnrollmentList.add(enrollment); // Menambahkan objek Enrollment ke ArrayList
            } else {
                System.err.println("Peringatan: Format input tidak sesuai untuk baris ini: " + line);
            }
        }

        // Setelah semua input selesai, kita konversi ArrayList ke array statis Enrollment[].
        // Ini memenuhi syarat "Gunakan array sebagai media penyimpanan" secara eksplisit
        // setelah jumlah elemen diketahui.
        Enrollment[] enrollments = tempEnrollmentList.toArray(new Enrollment[0]);

        System.out.println("\n=== Daftar Pendaftaran Mata Kuliah Tersimpan ===");
        if (enrollments.length == 0) {
            System.out.println("Tidak ada data pendaftaran yang disimpan.");
        } else {
            // Iterasi melalui array enrollments dan tampilkan setiap objek Enrollment
            for (Enrollment enrollment : enrollments) {
                System.out.println(enrollment); // Memanggil method toString() dari objek Enrollment
            }
        }

        input.close(); // Menutup objek Scanner untuk mencegah resource leak
        System.out.println("\nProgram selesai.");
    }
}
