package org.globant.basics.main;

import org.globant.basics.model.Course;
import org.globant.basics.model.Professor;
import org.globant.basics.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class FinalProjectMain {


    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        //***PROFESORES******
        List<Professor> professorList = new ArrayList<>();
        Professor profeVacio = new Professor("", "", 0, 0, "", 0.0, "", false, 0, 0);
        Professor profe1 = new Professor("pepe", "el grillo", 29, 12345, "alo@gmail.com", 3.400000
                , "Ingeniero de sistemas", true, 7, 0);
        professorList.add(profe1);
        ///*******CURSOS*****+
        List<Course> courseList = new ArrayList<>();
        Course cursoVacio = new Course("", 0, "", "", null, null);
        Course curso1 = new Course("Fisica", 30, "martes", "11:30-1:30", null, null);
        courseList.add(curso1);
        //*******ESTUDIANTES********
        List<Student> studentList = new ArrayList<>();
        Student estudianteVacio = new Student("", "", 0, 0, "", 0, 0.0, 0, "");
        Student estudiante1 = new Student("pepe", "el grillo", 23, 12345, "alo@gmail.com", 45076
                , 4.5, 8, "Ingenieria de sistemas");
        Student estudiante2 = new Student("daniel", "", 20, 12345, "alo@gmail.com", 45076
                , 4.0, 5, "Ingenieria electronica");
        studentList.add(estudiante1);
        studentList.add(estudiante2);
        int optionn = 0;
        while (optionn != 9) {
            optionn = showMenuPrincipal();
            switch (optionn) {
                case 1:
                    printProfessorPersonInfo(professorList);
                    break;
                case 2:
                    printAllCoursesWithInfo(courseList);
                    break;
                case 3:
                    addNewStudentThenAddToClass(courseList, studentList);
                    break;
                case 4:
                    addNewCourseThenAddProfessorAndStudents(courseList, professorList, studentList);
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del estudiante que desea consultar:");
                    String nameStudent = keyboard.nextLine();
                    findAllCoursesFromTheStudentByName(studentList, nameStudent);
                    break;
                case 6:
                    addNewProfessor(professorList);
                    break;
                case 7:
                    System.out.println("Ingrese el nombre del profesor que desea consultar:");
                    String nameProfessor = keyboard.nextLine();
                    findAllCoursesFromTheProfessorByName(professorList, nameProfessor);
                    break;
                case 8:
                    printStudentPersonInfo(studentList);
                    break;
                case 9:
                    exit(0);
                default:
                    System.err.println("Intenta de nuevo con una opción valida del menu");
            }
        }
    }

    public static int showMenuPrincipal() {

        int optionn = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("***Bienvenido a Globant Academy*****");
        System.out.println("1) Listar todos los profesores");
        System.out.println("2) Más información sobre las clases");
        System.out.println("3) Crear un nuevo estudiante y añadirlo a una clase");
        System.out.println("4) Crear una clase y asignar profesores y estudiantes");
        System.out.println("5) Consultar las clases de un estudiante por su nombre");
        System.out.println("6) Agregar un nuevo profesor");
        System.out.println("7) Consultar las clases de un profesor por su nombre");
        System.out.println("8) Listar los estudiantes y su información");
        System.out.println("9) Salir");
        optionn = keyboard.nextInt();
        return optionn;
    }


    public static void addNewCourseThenAddProfessorAndStudents(List<Course> courseList, List<Professor> professorList, List<Student> studentList) {
        List<Professor> professorsListToClass = new ArrayList<>();
        List<Student> studentsListToClass = new ArrayList<>();
        Course cursoVacio = new Course("", 0, "", "", null, null);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingrese el nombre del nuevo curso:");
        String nameCourse = keyboard.nextLine();
        System.out.println("Ingrese el día del  curso:");
        String day = keyboard.nextLine();
        System.out.println("Ingrese la hora del  curso (inicio-fin):");
        String hour = keyboard.nextLine();
        System.out.println("Ingrese la capacidad de inscripciones del curso:");
        int capacity = keyboard.nextInt();
        System.out.println("Se debe asignar un profesor para dictar el curso");
        System.err.println("Estos son nuestros profesores disponibles:" + " \n" + getAllTeachers(professorList));
        System.out.println("Por favor ingrese el nombre del profesor");
        keyboard = new Scanner(System.in);
        Course course = new Course(nameCourse, capacity, day, hour, professorsListToClass, studentsListToClass);
        String professorName = keyboard.nextLine();
        Professor profesorToClass = findProfessorByName(professorList, professorName);
        profesorToClass.addCourse(course);
        professorsListToClass.add(profesorToClass);
        String addMoreStudents;
        do {
            System.out.println("Se debe asignar estudiantes para curso");
            System.err.println("Ingrese el nombre de los estudiantes estas son las opciones:" +
                    " \n" + getAllStudents(studentList));
            String studentName = keyboard.nextLine();
            Student studentToClass = findStudentByName(studentList, studentName);
            studentToClass.addCourse(course);
            studentsListToClass.add(studentToClass);
            System.out.println("Desea agregar mas estudiantes");
            addMoreStudents = keyboard.nextLine();
        } while (!addMoreStudents.equalsIgnoreCase("NO"));
        courseList.add(course);
    }


    public static void addNewStudentThenAddToClass(List<Course> courseList, List<Student> studentList) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingrese el nombre del curso al que quiere inscribirse" + " " +
                "" + "(Opciones)" + "\n" + printAllNameCoruses(courseList));
        String curso = keyboard.nextLine();
        Course courseToSuscribe = findCourseByName(courseList, curso);
        System.out.println("Ingrese el nombre del nuevo estudiante:");
        String nameStudent = keyboard.nextLine();
        System.out.println("Ingrese el apellido del nuevo estudiante:");
        String lastNameStudent = keyboard.nextLine();
        keyboard = new Scanner(System.in);
        System.out.println("Ingrese la edad del nuevo estudiante:");
        int age = keyboard.nextInt();
        System.out.println("Ingrese el celular del nuevo estudiante:");
        int phoneNumber = keyboard.nextInt();
        keyboard = new Scanner(System.in);
        System.out.println("Ingrese el correo del nuevo estudiante:");
        String email = keyboard.nextLine();
        System.out.println("Ingrese el código del nuevo estudiante:");
        int studentCode = keyboard.nextInt();
        System.out.println("Ingrese el promedio del nuevo estudiante:");
        Double average = keyboard.nextDouble();
        keyboard = new Scanner(System.in);
        System.out.println("Ingrese el semestre del nuevo estudiante:");
        int semester = keyboard.nextInt();
        keyboard = new Scanner(System.in);
        System.out.println("Ingrese el programa del nuevo estudiante:");
        String program = keyboard.nextLine();
        Student newStudent = new Student(
                nameStudent, lastNameStudent, age, phoneNumber, email, studentCode, average, semester, program);
        newStudent.addCourse(courseToSuscribe);
        courseToSuscribe.addStudentToCurse(newStudent);
        studentList.add(newStudent);
    }


    public static void addNewProfessor(List<Professor> professorList) {
        int hoursPerWeek = 0;
        boolean isFullTime = false;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingrese el nombre del nuevo profesor:");
        String nameProfessor = keyboard.nextLine();
        System.out.println("Ingrese el apellido del nuevo profesor:");
        String lastNameProfessor = keyboard.nextLine();
        keyboard = new Scanner(System.in);
        System.out.println("Ingrese la edad del nuevo profesor:");
        int age = keyboard.nextInt();
        System.out.println("Ingrese el celular del nuevo profesor:");
        int phoneNumber = keyboard.nextInt();
        keyboard = new Scanner(System.in);
        System.out.println("Ingrese el correo del nuevo profesor:");
        String emailProfessor = keyboard.nextLine();
        keyboard = new Scanner(System.in);
        System.out.println("Ingrese la profesión del nuevo profesor:");
        String profileProfessor = keyboard.nextLine();
        System.out.println("¿Es de tiempo completo? (SI/NO):");
        String opt = keyboard.nextLine();
        if (opt.trim().equalsIgnoreCase("SI")) {
            isFullTime = true;
        } else {
            isFullTime = false;
        }
        keyboard = new Scanner(System.in);
        if (isFullTime == false) {
            System.out.println("¿Cuantas horas trabaja por semana?:");
            hoursPerWeek = keyboard.nextInt();
        }
        keyboard = new Scanner(System.in);
        System.out.println("Ingrese los años de experiencia del nuevo profesor:");
        int experience = keyboard.nextInt();
        Professor newProffesor = new Professor(
                nameProfessor, lastNameProfessor, age, phoneNumber, emailProfessor, 0.0, profileProfessor, isFullTime, experience
                , hoursPerWeek);
        professorList.add(newProffesor);
    }


    public static void printProfessorPersonInfo(List<Professor> professorList) {
        String salida = "";
        for (int i = 0; i < professorList.size(); i++) {
            salida += "Nombre:" + " " + professorList.get(i).getName() + "\n"
                    + "Apellido:" + " " + professorList.get(i).getLastName() + "\n"
                    + "Edad:" + " " + professorList.get(i).getAge() + "\n"
                    + "Celular:" + " " + professorList.get(i).getPhoneNumber() + "\n"
                    + "Correo:" + " " + professorList.get(i).getEmailAddress() + "\n"
                    + "Salario:" + " " + professorList.get(i).getSalary() + "\n"
                    + "Profesión:" + " " + professorList.get(i).getProfession() + "\n"
                    + "Tiempo completo:" + " " + ((professorList.get(i).isFullTime() == true ? "SI" : "NO")) + "\n"
                    + "Años de experiencia:" + " " + professorList.get(i).getExpirenceYears() + "\n"
                    + "Cursos dictados:" + " " + (professorList.get(i).getCoursePerson() != null ? professorList.get(i).getCoursePerson().get(i).getNameCourse() : "Sin cursos");
        }
        System.err.println("*************ATENCIÓN*******************");
        System.out.println(salida);
    }


    public static void printAllCoursesWithInfo(List<Course> courseList) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Estos son los cursos disponibles");
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println(courseList.get(i).getNameCourse());
        }
        System.out.println("Puedes acceder la información entera del curso ingresando el nombre del curso");
        String nameCourse = keyboard.nextLine();
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getNameCourse().equalsIgnoreCase(nameCourse)) {
                System.out.println("Capacidad:" + " " + courseList.get(i).getCapacity());
                System.out.println("Día:" + " " + courseList.get(i).getDay());
                System.out.println("Hora:" + " " + courseList.get(i).getHour());
                if (courseList.get(i).getProfessors() != null) {
                    System.out.println("Curso dictador por:" + " " + getAllTeachers(courseList.get(i).getProfessors()));
                }
                if (courseList.get(i).getStudents() != null) {
                    System.out.println("Estudiantes inscritos:" + "\n" +
                            getAllStudents(courseList.get(i).getStudents()));
                }
            }
        }
    }

    public static void printStudentPersonInfo(List<Student> studentList) {
        String salida = "";
        for (int i = 0; i < studentList.size(); i++) {
            salida += "Nombre:" + " " + studentList.get(i).getName() + "\n"
                    + "Apellido:" + " " + studentList.get(i).getLastName() + "\n"
                    + "Edad:" + " " + studentList.get(i).getAge() + "\n"
                    + "Celular:" + " " + studentList.get(i).getPhoneNumber() + "\n"
                    + "Correo:" + " " + studentList.get(i).getEmailAddress() + "\n"
                    + "Código estudiante:" + " " + studentList.get(i).getStudentCode() + "\n"
                    + "Promedio:" + " " + studentList.get(i).getAverage() + "\n"
                    + "Semestre:" + " " + studentList.get(i).getSemester() + "\n"
                    + "Carrera:" + " " + studentList.get(i).getProgram() + "\n";
        }
        System.out.println(salida);
    }

    /**
     * @param studentList
     * @param nameStudent
     * @return All the courses from the student find by his name
     */
    public static void findAllCoursesFromTheStudentByName(List<Student> studentList, String nameStudent) {
        String salida = "";
        List<Course> courseList;
        courseList = studentList.stream().filter(c -> c.getName().toLowerCase().trim().equals(nameStudent)).findFirst().get().getCoursePerson();
        if (courseList != null) {
            for (Course course : courseList) {
                salida += course.getNameCourse() + " ";
            }
        }
        System.err.println("***ATENCIÓN***");
        System.out.println("El estudiante" + " " + nameStudent + " " + "tiene matriculados los siguientes cursos:" + " " + salida);

    }


    /**
     * @param professorList
     * @param nameProfessor
     * @return All the courses from the professor find by his name
     */
    public static String findAllCoursesFromTheProfessorByName(List<Professor> professorList, String nameProfessor) {
        String salida = "";
        List<Course> courseList;
        courseList = professorList.stream().filter(c -> c.getName().toLowerCase().trim().equals(nameProfessor)).findFirst().get().getCoursePerson();
        if (courseList != null) {
            for (Course course : courseList) {
                salida += course.getNameCourse() + " ";
            }
        }
        System.err.println("***ATENCIÓN***");
        System.out.println("El profesor" + " " + nameProfessor + " " + "tiene matriculados los siguientes cursos:" + " " + salida);

        return salida;
    }

    /**
     * @param courseList
     * @return All the courses that exits in the system
     */
    public static String printAllNameCoruses(List<Course> courseList) {
        String salida = "";
        for (int i = 0; i < courseList.size(); i++) {
            salida += courseList.get(i).getNameCourse() + "\n";
        }
        return salida;
    }

    /**
     * @param professorList
     * @return All the professor that exits in the system
     */
    public static String getAllTeachers(List<Professor> professorList) {
        String salida = "";
        for (int i = 0; i < professorList.size(); i++) {
            salida += professorList.get(i).getName() + " " + professorList.get(i).getLastName();
        }
        return salida;
    }


    /**
     * @param studentList
     * @return All the students that exits in the system
     */
    public static String getAllStudents(List<Student> studentList) {
        String salida = "";
        for (int i = 0; i < studentList.size(); i++) {
            salida += studentList.get(i).getName() + "  ";
        }
        return salida;
    }

    /**
     * @param courseList
     * @param nameCourse
     * @return All the Courses from the name course given by parameter
     * @autor sergioyance
     */
    public static Course findCourseByName(List<Course> courseList, String nameCourse) {
        return courseList.stream().filter(c -> c.getNameCourse().toLowerCase().trim().equals(nameCourse)).findFirst().get();
    }

    /**
     * @param professorList
     * @param proffesorName
     * @return All the Courses from the name professor given by parameter
     */
    public static Professor findProfessorByName(List<Professor> professorList, String proffesorName) {
        return professorList.stream().filter(c -> c.getName().toLowerCase().trim().equals(proffesorName)).findFirst().get();
    }

    /**
     * @param studentList
     * @param studentNmae
     * @return All the Courses from the name student given by parameter
     */
    public static Student findStudentByName(List<Student> studentList, String studentNmae) {
        return studentList.stream().filter(c -> c.getName().toLowerCase().trim().equals(studentNmae)).findFirst().get();
    }

}
