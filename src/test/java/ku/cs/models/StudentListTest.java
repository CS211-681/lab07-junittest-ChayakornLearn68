package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {

    @Test
    @DisplayName("ทดสอบการเพิ่ม Student ใหม่ โดยใช้ id และ name")
    void testAddNewStudentWithIdName() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "Student1");
        assertEquals(1, studentList.getStudents().size());
        assertEquals("6xxxxxxxx", studentList.getStudents().get(0).getId());
        assertEquals("Student1", studentList.getStudents().get(0).getName());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่ม Student ใหม่ โดยใช้ id, name และ score")
    void testAddNewStudentWithIdNameAndScore() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "Student1", 85.0);
        assertEquals(1, studentList.getStudents().size());
        assertEquals(85.0, studentList.getStudents().get(0).getScore());
    }

    @Test
    @DisplayName("ทดสอบการไม่เพิ่ม Student ใหม่หากมี Student ที่มี id ซ้ำ")
    void testAddNewStudentWithDuplicateId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "Student1");
        studentList.addNewStudent("6xxxxxxxx", "StudentDuplicate");
        assertEquals(1, studentList.getStudents().size());
        assertEquals("Student1", studentList.getStudents().get(0).getName());
    }

    @Test
    @DisplayName("ทดสอบการค้นหา Student ตาม id")
    void testFindStudentById() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "Student1");
        Student foundStudent = studentList.findStudentById("6xxxxxxxx");
        assertNotNull(foundStudent);
        assertEquals("Student1", foundStudent.getName());
    }

    @Test
    @DisplayName("ทดสอบการค้นหากรณีที่ไม่พบ Student ตาม id")
    void testFindStudentByIdNotFound() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "Student1");
        Student foundStudent = studentList.findStudentById("7xxxxxxxx");
        assertNull(foundStudent);
    }

    @Test
    @DisplayName("ทดสอบการกรอง Student ด้วยชื่อที่ตรงกัน")
    void testFilterByName() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "Student1");
        studentList.addNewStudent("7xxxxxxxx", "Student2");
        studentList.addNewStudent("8xxxxxxxx", "TestStudent");

        StudentList filteredList = studentList.filterByName("Student");
        assertEquals(3, filteredList.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนกับ Student โดยใช้ id")
    void testGiveScoreToId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "Student1");
        studentList.giveScoreToId("6xxxxxxxx", 90.0);
        assertEquals(90.0, studentList.getStudents().get(0).getScore());
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนกับ Student ที่ไม่มีในรายชื่อ")
    void testGiveScoreToIdNotFound() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "Student1");
        studentList.giveScoreToId("7xxxxxxxx", 90.0);
        assertEquals(0.0, studentList.getStudents().get(0).getScore());
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดของ Student โดยใช้ id")
    void testViewGradeOfId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "Student1", 85.0);
        String grade = studentList.viewGradeOfId("6xxxxxxxx");
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดของ Student ที่ไม่มีในรายชื่อ")
    void testViewGradeOfIdNotFound() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6xxxxxxxx", "Student1", 85.0);
        String grade = studentList.viewGradeOfId("7xxxxxxxx");
        assertNull(grade);
    }
}
