import java.util.*;
//===PR Student Menu===
//"Pinjam buku" pada student menu,
// dikaitkan dengan "daftar buku yang di pinjam,
// lalu stok berkurang 1"

//===PR Admin Menu===
//memindah variabel "userAdmin" dan "passwordAdmin",
//dari Main class ke class admin,
//lalu buat logic "add student" dengan array
//logic "display registered mahasiswa" dengan array
//

public class Main {
    public static void main(String[] args) {
        Main menu1 = new Main();
        menu1.menu();
    }
    void menu() {
        System.out.print("\n==== Library System ====\n");
        System.out.println("1. Login As Student");
        System.out.println("2. Login As Admin");
        System.out.println("3. EXIT");

        Scanner userInput1 = new Scanner(System.in);
            while (true) {
                System.out.print("Pilih antara No (1-3) = ");
                int pilihanUser = userInput1.nextInt();
                    if (pilihanUser == 1) {
                        inputNIM();
                        break;
                    } else if (pilihanUser == 2) {
                        checkAdmin();
                        break;
                    } else if (pilihanUser == 3) {
                        System.out.println("\n=== Anda Berhasil Keluar ===");
                        break;
                    } else {
                        System.out.print("");
                    }
            }
    }
    void menuStudent() {
        Scanner userInput2 = new Scanner(System.in);
        System.out.println("\n==== Student Menu ====");
        System.out.println("1. Daftar Buku Yang Di Pinjam");
        System.out.println("2. Pinjam Buku");
        System.out.println("3. Log out");

        Students student = new Students();
            while (true){
                System.out.print("Pilih antara (1-3) = ");
                int input2 = userInput2.nextInt();
                if (input2 == 1) {
                    System.out.println("\n=== Buku yang di Pinjam ===\n");
                    System.out.println(Arrays.toString(buku_dipinjam));
                    menuStudent();
                    break;
                } else if (input2==2) {
                    //method displaybook
                    System.out.println("\n=== Pinjam Buku ===");
                    System.out.println("\n\tDisplay BOOK");
                    student.displayBooks();
                    break;
                } else if (input2==3) {
                    //exit
                    menu();
                    break;
                }else {
                    System.out.println();
                }
            }
    }
    void inputNIM() {
        Scanner userInputNIM = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan NIM Kamu (Pastikan 15 Angka) = ");
            String Nim1 = userInputNIM.nextLine();
                if (Nim1.length()==15){
                    System.out.println("NIM Kamu Valid...");
                    break;
                }else {
                    System.out.println("Input NIM Tidak Valid\nPastikan NIM Kamu Tepat 15 Digit!!");
                }
        }
        menuStudent();
    }
    void checkAdmin(){
        Scanner userAdmin = new Scanner(System.in);
        Scanner passAdmin = new Scanner(System.in);

        System.out.println("\n----Verifikasi Data Admin----");

        while (true){
            System.out.print("Masukkan Username (admin01)= ");
            String adminUser = userAdmin.nextLine();

            System.out.print("Masukkan Password (1234)= ");
            String adminPass = passAdmin.nextLine();
                if (adminUser.equals("admin01") || adminPass.equals("1234")) {
                    System.out.println("Data Anda Valid....");
                    menuAdmin();
                    break;
                }else {
                    System.out.println("Username atau Password Salah. Coba lagi!");
                }
        }
    }
    void menuAdmin() {
        System.out.println("\n==== Admin Menu ====");
        System.out.println("1. Add Student");
        System.out.println("2. Display Registered Students");
        System.out.println("3. Log out");

        Admin admin = new Admin();
        Scanner userInput3 = new Scanner(System.in);
            while (true){
                System.out.print("Pilih antara (1-3) = ");
                int input3 = userInput3.nextInt();
                if (input3 == 1) {
                    System.out.println("\n==== Add Students ====");
                    admin.addStudent();
                    //method Addstudents
                    break;
                } else if (input3==2) {
                    System.out.println("\n==== Display Students ====");
                    admin.displayStudent();
                    //method DisplayStudent
                    break;
                } else if (input3==3) {
                    System.out.println("--Anda telah Keluar--");
                    menu();
                    break;
                }else {
                    System.out.println();
                }
            }
    }
    static int[] stokbuku = {5, 4, 3};
    static String[] author = {"author", "author", "author"};
    static String[] idBuku = {"AAA1-3ee4-d154", "j1i3-00ae-luak", "kn00-l007-lvte"};
    static String[] judul = {"Harry Potter", "Dilan 1991    ", "Laskar Pelangi"};
    static String[] buku_dipinjam = new String[3];
}
class Students{
    static String Nama, NIM, Fakultas, ProgramStudi;
        Main menu3 = new Main();
    void displayBooks() {
            System.out.println("===========================================================================================================================================");
            System.out.println("|| No || Id Buku\t\t\t\t || Nama Buku\t\t\t || Author\t\t || Stock\t || ");
                for (int i = 0; i < 3; i++){
                    System.out.printf("|| %d  || %s\t\t\t || %s\t\t || %s\t\t || %d\t\t || \n", i, Main.idBuku[i], Main.judul[i], Main.author[i], Main.stokbuku[i]);
                }
            System.out.println("===========================================================================================================================================");
            System.out.print("Masukkan ID Buku yang ingin di Pinjam = ");
            Scanner inputbuku1 = new Scanner(System.in);
            String buku1 = inputbuku1.nextLine();

            for (int i = 0; i <Main.buku_dipinjam.length; i++){
                Main.buku_dipinjam[i] = i+". "+ buku1;
            }
            switch (buku1) {
                case "AAA1-3ee4-d154":
                    Main.stokbuku[0] -= 1;
                    System.out.println("Buku "+Main.judul[0]+" berhasil ditambahkan");
                    System.out.println("ID Buku = "+ Main.idBuku[0]);
                    break;
                case "j1i3-00ae-luak":
                    Main.stokbuku[1] -= 1;
                    System.out.println("Buku "+Main.judul[1]+" berhasil ditambahkan");
                    System.out.println("ID Buku = "+ Main.idBuku[1]);
                    break;
                case "kn00-l007-lvte":
                    Main.stokbuku[2] -= 1;
                    System.out.println("Buku "+Main.judul[2]+" berhasil ditambahkan");
                    System.out.println("ID Buku = "+ Main.idBuku[2]);
                    break;
                default:
                    System.out.println("invalid id Book");
                    displayBooks();
                    break;
            }
            menu3.menuStudent();
    }
}
class Admin {
    String adminUsername, adminPassword, studentList;
    Main main = new Main();
    void addStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tambahkan data Mahasiswa:");
        System.out.print("Masukkan Nama: ");
        Students.Nama = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        Students.NIM = scanner.nextLine();
        System.out.print("Masukkan Fakultas: ");
        Students.Fakultas = scanner.nextLine();
        System.out.print("Masukkan Program Studi: ");
        Students.ProgramStudi = scanner.nextLine();
        System.out.println("Data Mahasiswa berhasil ditambahkan");
        main.menuAdmin();
    }
    void displayStudent(){
        System.out.println("Data Mahasiswa ke-1:");
        System.out.println("Nama: " + Students.Nama);
        System.out.println("NIM: " + Students.NIM);
        System.out.println("Fakultas: " + Students.Fakultas);
        System.out.println("Program Studi: " + Students.ProgramStudi+"\n\n");
        main.menuAdmin();
    }
}

