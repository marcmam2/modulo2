package exercise03;

import java.util.Scanner;

public class Exercise03 {
    static School school = new School();

    public static void main(String[] args) {
        System.out.println("Olá, este é o sistema da escola XPTO!");

        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("=========="); // ver se nao é melhor ficar ao final
            System.out.println("escolha uma opção:");
            System.out.println("1 - adicionar");
            System.out.println("2 - modificar");
            System.out.println("3 - deletar");
            System.out.println("4 - listar");
            System.out.println("5 - exibir");
            System.out.println("6 - calcular média");
            System.out.println("7 - sair");

            int option = scanner.nextInt();
            scanner.nextLine();

            System.out.println("----------");

            switch (option) {
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    list();
                    break;
                case 5:
                    check();
                    break;
                case 6:
                    System.out.print("CPF do aluno a ter média calculada: ");
                    String CPF = scanner.nextLine();
                    Student student = school.findStudentByCPF(CPF);
                    student.getGradesAverage();
                    break;
                case 7:
                    System.out.println("até logo");
                    return;
                default:
                    throw new RuntimeException("opção inválida");
            }
        }
    }

    static void add() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("você deseja adicionar um: ");
        printSubmenu();

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                school.students.add(new Student());
                break;
            case 2:
                school.employees.add(new Employee());
                break;
            case 3:
                school.teachers.add(new Teacher());
                break;
            default:
                throw new RuntimeException("opção inválida; escolha entre aluno, funcionário, professor");
        }
    }

    static void update() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("você deseja modificar um: ");
        printSubmenu();

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.print("CPF do aluno: ");
                String studentCPF = scanner.nextLine();
                school.updateStudent(studentCPF);
                break;
            case 2:
                System.out.print("CPF do funcionário: ");
                String employeeCPF = scanner.nextLine();
                school.updateEmployee(employeeCPF);
                break;
            case 3:
                System.out.print("CPF do professor: ");
                String teacherCPF = scanner.nextLine();
                school.updateTeacher(teacherCPF);
                break;
            default:
                throw new RuntimeException("opção inválida; escolha entre aluno, funcionário, professor");
        }
    }

    static void delete() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("você deseja deletar um: ");
        printSubmenu();

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.print("CPF do aluno a ser deletado: ");
                String studentCPF = scanner.nextLine();
                school.deleteStudent(studentCPF);
                break;
            case 2:
                System.out.print("CPF do funcionário a ser deletado: ");
                String employeeCPF = scanner.nextLine();
                school.deleteEmployee(employeeCPF);
                break;
            case 3:
                System.out.print("CPF do professor a ser deletado: ");
                String teacherCPF = scanner.nextLine();
                school.deleteTeacher(teacherCPF);
                break;
            default:
                throw new RuntimeException("opção inválida; escolha entre aluno, funcionário, professor");
        }
    }

    static void list() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("você deseja listar a categoria: ");
        printSubmenu();

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                school.listStudent();
                break;
            case 2:
                school.listEmployee();
                break;
            case 3:
                school.listTeacher();
                break;
            default:
                throw new RuntimeException("opção inválida; escolha para listar alunos, funcionários, ou professores");
        }
    }

    static void check() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("você deseja exibir os dados de um: ");
        printSubmenu();

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                System.out.print("CPF do aluno:");
                String studentCPF = scanner.nextLine();
                school.checkStudent(studentCPF);
                break;
            case 2:
                System.out.print("CPF do funcionário:");
                String employeeCPF = scanner.nextLine();
                school.checkEmployee(employeeCPF);
                break;
            case 3:
                System.out.print("CPF do professor:");
                String teacherCPF = scanner.nextLine();
                school.checkTeacher(teacherCPF);
                break;
            default:
                throw new RuntimeException("opção inválida; escolha para exibir detalhes de aluno, funcionário, ou professor");
        }
    }

    static void printSubmenu() { // fazer metodo getDesiredRole ou algo assim com o scanner talvez
        System.out.println("1 - aluno");
        System.out.println("2 - funcionário");
        System.out.println("3 - professor");
    }
}