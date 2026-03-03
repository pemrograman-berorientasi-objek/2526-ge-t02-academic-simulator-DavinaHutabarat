package academic.driver; // Mendefinisikan paket untuk kelas Driver4


/**
 * @DavinaOlivia 12S24047 Davina Olivia
 * @DavinaOlivia 12S24047 Davina Olivia
 */

// Mengimpor semua kelas model yang akan digunakan
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollment;

import java.util.ArrayList; // Untuk menyimpan objek secara dinamis
import java.util.Scanner;   // Untuk membaca input dari pengguna

public class Driver4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Objek Scanner untuk membaca input
        
        // Tiga ArrayList terpisah untuk menyimpan masing-masing jenis objek
        ArrayList<Course> tempCourseList = new ArrayList<>();
        ArrayList<Student> tempStudentList = new ArrayList<>();
        ArrayList<Enrollment> tempEnrollmentList = new ArrayList<>();

        System.out.println("=== Sistem Informasi Akademik Terintegrasi ===");
        System.out.println("Masukkan data (format: [command]#data1#data2...).");
        System.out.println("Gunakan 'course-add', 'student-add', atau 'enrollment-add'.");
        System.out.println("Ketik '---' untuk berhenti dan menampilkan hasil.");

        String line; // Variabel untuk menyimpan setiap baris input
        while (input.hasNextLine()) { // Terus membaca selama ada baris input
            line = input.nextLine(); // Baca satu baris input

            if (line.equals("---")) { // Jika input adalah '---', berhenti
                break;
            }

            // Memecah baris input menjadi command dan data
            // Contoh: "course-add#12S2203#Object-oriented Programming#3#C"
            // segments[0] = "course-add"
            // segments[1] = "12S2203#Object-oriented Programming#3#C"
            String[] segments = line.split("#", 2); // Split hanya pada '#' pertama

            if (segments.length < 2) {
                System.err.println("Peringatan: Format input tidak sesuai (command atau data tidak lengkap): " + line);
                continue; // Lewati baris ini dan lanjutkan ke input berikutnya
            }

            String command = segments[0];
            String dataString = segments[1]; // Sisa string setelah command

            // Memproses input berdasarkan command
            switch (command) {
                case "course-add":
                    // Data course memiliki 4 segmen: Code#Name#SKS#Grade
                    String[] courseData = dataString.split("#");
                    if (courseData.length == 4) {
                        String code = courseData[0];
                        String name = courseData[1];
                        int sks = 0;
                        try {
                            sks = Integer.parseInt(courseData[2]);
                        } catch (NumberFormatException e) {
                            System.err.println("Peringatan: SKS tidak valid untuk course: " + line);
                            break; // Keluar dari switch, bukan dari loop utama
                        }
                        String grade = courseData[3];
                        tempCourseList.add(new Course(code, name, sks, grade));
                    } else {
                        System.err.println("Peringatan: Format data course tidak sesuai: " + line);
                    }
                    break;

                case "student-add":
                    // Data student memiliki 4 segmen: NIM#Name#EntranceYear#Major
                    String[] studentData = dataString.split("#");
                    if (studentData.length == 4) {
                        String nim = studentData[0];
                        String name = studentData[1];
                        int entranceYear = 0;
                        try {
                            entranceYear = Integer.parseInt(studentData[2]);
                        } catch (NumberFormatException e) {
                            System.err.println("Peringatan: Tahun masuk tidak valid untuk student: " + line);
                            break;
                        }
                        String major = studentData[3];
                        tempStudentList.add(new Student(nim, name, entranceYear, major));
                    } else {
                        System.err.println("Peringatan: Format data student tidak sesuai: " + line);
                    }
                    break;

                case "enrollment-add":
                    // Data enrollment memiliki 4 segmen: CourseCode#StudentNim#AcademicYear#Semester
                    String[] enrollmentData = dataString.split("#");
                    if (enrollmentData.length == 4) {
                        String courseCode = enrollmentData[0];
                        String studentNim = enrollmentData[1];
                        String academicYear = enrollmentData[2];
                        String semester = enrollmentData[3];
                        // Grade otomatis "None" dari konstruktor Enrollment
                        tempEnrollmentList.add(new Enrollment(courseCode, studentNim, academicYear, semester));
                    } else {
                        System.err.println("Peringatan: Format data enrollment tidak sesuai: " + line);
                    }
                    break;

                default:
                    System.err.println("Peringatan: Command tidak dikenal: " + command + " di baris: " + line);
                    break;
            }
        }

        // Setelah semua input selesai, konversi ArrayList ke array statis untuk demonstrasi
        // konsep array sesuai permintaan.
        Course[] courses = tempCourseList.toArray(new Course[0]);
        Student[] students = tempStudentList.toArray(new Student[0]);
        Enrollment[] enrollments = tempEnrollmentList.toArray(new Enrollment[0]);

        System.out.println("\n=== Hasil Penyimpanan Data Akademik ===");

        // Menampilkan Course terlebih dahulu
        for (Course course : courses) {
            System.out.println(course); // Memanggil method toString() dari objek Course
        }

        // Kemudian menampilkan Student
        for (Student student : students) {
            System.out.println(student); // Memanggil method toString() dari objek Student
        }

        // Terakhir menampilkan Enrollment
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment); // Memanggil method toString() dari objek Enrollment
        }

        input.close(); // Menutup objek Scanner
        System.out.println("\nProgram selesai.");
    }
}
