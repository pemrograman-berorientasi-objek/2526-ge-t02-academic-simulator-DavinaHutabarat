package academic.model; // Mendefinisikan paket untuk kelas Enrollment

/**
 * @DavinaOlivia 12S24047 Davina Olivia
 * @DavinaOlivia 12S24047 Davina Olivia
 */



public class Enrollment {
    // Atribut-atribut kelas Enrollment. Dibuat private untuk enkapsulasi.
    private String courseCode;   // Kode Mata Kuliah yang didaftarkan
    private String studentNim;   // NIM Mahasiswa yang mendaftar
    private String academicYear; // Tahun Ajaran (misal: 2021/2022)
    private String semester;     // Jenis Semester (misal: even/odd)
    private String grade;        // Nilai untuk pendaftaran ini (default "None")

    /**
     * Konstruktor untuk membuat objek Enrollment baru.
     * @param courseCode Kode Mata Kuliah
     * @param studentNim NIM Mahasiswa
     * @param academicYear Tahun Ajaran
     * @param semester Jenis Semester (even/odd)
     */
    public Enrollment(String courseCode, String studentNim, String academicYear, String semester) {
        this.courseCode = courseCode;
        this.studentNim = studentNim;
        this.academicYear = academicYear;
        this.semester = semester;
        this.grade = "None"; // Sesuai permintaan, nilai default adalah "None"
    }

    // Metode getter untuk mengakses nilai atribut dari luar kelas.
    // Tidak ada setter karena kita asumsikan data pendaftaran dan nilainya tidak diubah setelah dibuat di tahap ini.

    public String getCourseCode() {
        return courseCode;
    }

    public String getStudentNim() {
        return studentNim;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }

    /**
     * Metode ini akan dipanggil secara otomatis saat objek Enrollment dicetak.
     * Kita format outputnya sesuai permintaan, menggunakan '|' sebagai separator dan menambahkan "None" untuk nilai.
     * @return String representasi objek Enrollment.
     */
    @Override
    public String toString() {
        // Menggabungkan atribut dengan pemisah '|'
        return courseCode + "|" + studentNim + "|" + academicYear + "|" + semester + "|" + grade;
    }
}
