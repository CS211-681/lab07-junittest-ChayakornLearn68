package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวณเกรดออกมาเป็น A")
    void testCalculateGrade() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 75 คะแนน และให้ Object คำนวณเกรดออกมาเป็น B")
    void testCalculateGradeB() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(75);
        assertEquals("B", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 65 คะแนน และให้ Object คำนวณเกรดออกมาเป็น C")
    void testCalculateGradeC() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(65);
        assertEquals("C", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 55 คะแนน และให้ Object คำนวณเกรดออกมาเป็น D")
    void testCalculateGradeD() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(55);
        assertEquals("D", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45 คะแนน และให้ Object คำนวณเกรดออกมาเป็น F")
    void testCalculateGradeF() {
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(45);
        assertEquals("F", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการสร้าง Student ด้วย id และ name และตรวจสอบค่าเริ่มต้น score เป็น 0")
    void testConstructorWithIdAndName() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        assertEquals("6xxxxxxxx", s.getId());
        assertEquals("StudentTest", s.getName());
        assertEquals(0, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการสร้าง Student ด้วย id, name และ score ที่กำหนดเอง")
    void testConstructorWithIdNameAndScore() {
        Student s = new Student("6xxxxxxxx", "StudentTest", 75.5);
        assertEquals("6xxxxxxxx", s.getId());
        assertEquals("StudentTest", s.getName());
        assertEquals(75.5, s.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ Student")
    void testChangeName() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.changeName("New Name");
        assertEquals("New Name", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ Student โดยไม่ให้เปลี่ยนชื่อหากชื่อที่ให้มาเป็นค่าว่างหรือเป็นช่องว่าง")
    void testChangeNameWithEmpty() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        s.changeName("   ");
        assertEquals("StudentTest", s.getName());
    }

    @Test
    @DisplayName("ทดสอบการตรวจสอบว่า id ตรงกับ id ของ Student หรือไม่")
    void testIsId() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        assertTrue(s.isId("6xxxxxxxx"));
        assertFalse(s.isId("7xxxxxxxx"));
    }

    @Test
    @DisplayName("ทดสอบการตรวจสอบชื่อว่า มีคำที่ระบุอยู่ในชื่อของ Student หรือไม่")
    void testIsNameContains() {
        Student s = new Student("6xxxxxxxx", "StudentTest");
        assertTrue(s.isNameContains("Student"));
        assertFalse(s.isNameContains("None"));
    }
}
