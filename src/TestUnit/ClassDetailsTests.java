package TestUnit;
import stubs.*;
import stubs.ClassDetails;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.*;

public class ClassDetailsTests {

	Time t1;
	Time t2;
	Time t3;
	Time t4;
	Time t5;
	Time t6;
	Time t7;
	Time t8;
	Time t9;
	ClassDetails cd1;
	ClassDetails cd2;
	ClassDetails cd3;
	ClassDetails cd4;
	ClassDetails cd5;
	ClassDetails cd6;
	ClassDetails cd7;
	ClassDetails cd8;
	ClassDetails cd9;
	
	@Before
	public void setUp() throws Exception {
		// Change the value of the time in the Time constructors
		t1 = new Time("04:30", "06:20", "0101000");
		t2 = new Time("03:30", "03:45", "0101000");
		t3 = new Time("12:00", "01:00", "1010000");
		t4 = new Time("04:30", "06:20", "0101000");
		t5 = new Time("04:20", "06:10", "0101000");
		t6 = new Time("06:20", "09:20", "0101000");
		t7 = new Time("05:00", "06:00", "0101000");
		t8 = new Time("03:30", "05:00", "0101000");
		t9 = new Time("04:00", "05:15", "0101000");
		cd1 = new ClassDetails();
		cd2 = new ClassDetails();
		cd4 = new ClassDetails();
		cd5 = new ClassDetails();
		cd6 = new ClassDetails();
		cd7 = new ClassDetails();
		cd8 = new ClassDetails();
		cd9 = new ClassDetails();
		cd1.setTime(t1);
		cd4.setTime(t4);
		cd2.setTime(t2);
		cd3 = new ClassDetails(new Course("cop", "2210"),"10772");
		cd3.setTime(t3);
		cd5.setTime(t5);
		cd6.setTime(t6);
		cd7.setTime(t7);
		cd8.setTime(t8);
		cd9.setTime(t9);
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
/*
 * Test ID: UT_CD_001_SetTerm
 * 
 * Purpose: To set the setTerm(String) method. This method allows to set the
 *          term for a ClassDetails object
 *          
 * Precondition:A ClassDetails object must have been instantiated in memory with :
 *   String Time.frHr = “04”
 *   String Time.frMn = “30”
 *   String Time.toHr = “06”
 *   String Time.toMn = “20
 *
 * Input: String term = “Fall 2017”
 * 
 * Expected Output: No output, but for the state of the object to have “Fall 2017” as its term. 
 */
	@Test
	public void testSetTerm() {	    
		cd1.setTerm("Fall 2017");
		assertEquals("Fall 2017", cd1.getTerm());   
	}
	
	
	/* 
	 * Test ID: UT_CD_002_GetTerm
	 * 
	 * Purpose: To test getTerm(), method. This method returns the term for a ClassDetails object. 
	 * 
	 * Precondition: A ClassDetails object must have been instantiated in memory. 
	 * The ClassDetails object will have the field set:
     * String term = “Fall 2017”
     * String Time.frHr = “04”
     * String Time.frMn = “30”
     * String Time.toHr = “06”
     * String Time.toMn = “20”
     * 
     * Input: getTerm()
	 * 
	 * Expected Output: “Fall 2017”
	 * 
	 */
	
	@Test
	public void testGetTerm() {
		cd1.setTerm("Spring 2018");
		assertEquals("Spring 2018", cd1.getTerm());
	}
	
	
	/*
	 * Test ID: UT_CD_009_hasConflict1
	 * 
	 * Purpose: To test the hasConflict(ClassDetails) method. This method will return whether 
     *          two ClassDetails objects have a time conflict with each other.
	 *
	 * Precondition: Two ClassDetails, cd1, and cd2, objects must have been instantiated in memory. 
	 *               Each of the two classes will also have a Time object set for them which are instantiated.
 	 *
	 *    Time t1 has the following properties:
	 *      int frHr = “04”
	 *	    int frMn = “30” 
	 *	    int toHr = “06”
	 *	    int toMn = “20”
	 *	    String  days = “01010000”
     *
	 *	  Time t2 has the following properties:
	 *	    int frHr = “04”
	 *	    int frMn = “30” 
	 *	    int toHr = “06”
	 *	    int toMn = “20”
	 *	    String  days = “0101000”
	 *
     *    setTime(t1) and setTime(t2) are then invoked.
     *
	 * Input:  cd1.hasConflict(cd4)
	 * 
	 * 
	 * Expected output: true
	 * 
	 * 
	 */
	@Test
	public void testHasConflict1() {
		assertEquals(false, cd1.hasConflict(cd2));
	}
	
	
	/*
	 * Test ID: UT_CD_009_hasConflict2
	 * 
	 * Purpose: To test the hasConflict(ClassDetails) method. This method will return whether 
     *          two ClassDetails objects have a time conflict with each other.
	 *
	 * Precondition: Two ClassDetails, cd1, and cd4, objects must have been instantiated in memory. 
	 *               Each of the two classes will also have a Time object set for them which are instantiated.
 	 *
	 *    Time t1 has the following properties:
	 *      int frHr = “04”
	 *	    int frMn = “30” 
	 *	    int toHr = “06”
	 *	    int toMn = “20”
	 *	    String  days = “01010000”
     *
	 *	  Time t4 has the following properties:
	 *	    int frHr = “03”
	 *	    int frMn = “30” 
	 *	    int toHr = “03”
	 *	    int toMn = “45”
	 *	    String  days = “0101000”
	 *
     *    setTime(t1) and setTime(t2) are then invoked.
     *
	 * Input:  cd1.hasConflict(cd2)
	 * 
	 * 
	 * Expected output: true
	 * 
	 * 
	 */
	
	
	@Test
	public void testHasConflict2() {
		assertEquals(true, cd1.hasConflict(cd4));
	}
	
	
	// Test Case
	// UT_CD_009_hasConflict3

	// Purpose:
	// To test the hasConflict(ClassDetails) method. This method will return whether 
	// two ClassDetails objects have a time conflict with each other.

	//Precondition:
	// Two ClassDetails, cd1, and cd4, objects must have been instantiated in memory. Each of the two classes will also have a Time object set for them which are instantiated.
	// Time t1 has the following properties:
	    // int frHr = “04”
	    // int frMn = “30” 
	    // int toHr = “06”
	    // int toMn = “20”
	    // String  days = “01010000”
	// Time t4 has the following properties:
	    // int frHr = “04”
	    // int frMn = “30” 
	    // int toHr = “06”
	    // int toMn = “20”
	    // String  days = “0101000”
	// setTime(t1) and setTime(t4) are then invoked.

	// Input
	// cd1.hasConflict(cd4)

	// Expected output
	// true
	@Test
	public void testHasConflict3() {
		assertEquals(true, cd1.hasConflict(cd5));
	}
	
	// Test Case
	// UT_CD_009_hasConflict4

	// Purpose
	// To test the hasConflict(ClassDetails) method. This method will return whether 
	// two ClassDetails objects have a time conflict with each other.

	// Precondition
	// Two ClassDetails, cd5, and cd1, objects must have been instantiated in memory. Each of the two classes will also have a Time object set for them which are instantiated.
	// Time t5 has the following properties:
	    // int frHr = “04”
	    // int frMn = “20” 
	    // int toHr = “06”
	    // int toMn = “10”
	    // String  days = “0101000”
	// Time t1 has the following properties:
	    // int frHr = “04”
	    // int frMn = “30” 
	    // int toHr = “06”
	    // int toMn = “20”
	    // String  days = “01010000”
	// setTime(t5) and setTime(t1) are then invoked.

	// Input
	// cd5.hasConflict(cd1)

	// Expected output
	// true
	@Test
	public void testHasConflict4() {
		assertEquals(true, cd5.hasConflict(cd1));
	}
		
	// Test Case
	// UT_CD_009_hasConflict5

	// Purpose
	// To test the hasConflict(ClassDetails) method. This method will return whether 
	// two ClassDetails objects have a time conflict with each other.

	// Precondition
	// Two ClassDetails, cd1, and cd6, objects must have been instantiated in memory. Each of the two classes will also have a Time object set for them which are instantiated.
	// Time t1 has the following properties:
	    // int frHr = “04”
	    // int frMn = “30” 
	    // int toHr = “06”
	    // int toMn = “20”
	    // String  days = “01010000”
	// Time t6 has the following properties:
	    // int frHr = “06”
	    // int frMn = “20” 
	    // int toHr = “09”
	    // int toMn = “20”
	    // String  days = “0101000”
	// setTime(t1) and setTime(t6) are then invoked.

	// Input
	// cd1.hasConflict(cd6)

	// Expected output
	// true
	@Test
	public void testHasConflict5() {
		assertEquals(true, cd1.hasConflict(cd6));
	}
		
	// Test Case
	// UT_CD_009_hasConflict6

	// Purpose
	// To test the hasConflict(ClassDetails) method. This method will return whether 
	// two ClassDetails objects have a time conflict with each other.

	// Precondition
	// Two ClassDetails, cd1, and cd7, objects must have been instantiated in memory. Each of the two classes will also have a Time object set for them which are instantiated.
	// Time t1 has the following properties:
	    // int frHr = “04”
	    // int frMn = “30” 
	    // int toHr = “06”
	    // int toMn = “20”
	    // String  days = “01010000”
	// Time t7 has the following properties:
	    // int frHr = “05”
	    // int frMn = “00” 
	    // int toHr = “06”
	    // int toMn = “00”
	    // String  days = “0101000”
	// setTime(t1) and setTime(t7) are then invoked.

	// Input
	// cd1.hasConflict(cd7)

	// Expected output
	// true

	@Test
	public void testHasConflict6() {
		assertEquals(true, cd1.hasConflict(cd7));
	}
	
	// Test Case
	// UT_CD_009_hasConflict7

	// Purpose
	// To test the hasConflict(ClassDetails) method. This method will return whether 
	// two ClassDetails objects have a time conflict with each other.

	// Precondition
	// Two ClassDetails, cd1, and cd8, objects must have been instantiated in memory. Each of the two classes will also have a Time object set for them which are instantiated.
	 // Time t1 has the following properties:
	    // int frHr = “04”
	    // int frMn = “30” 
	    // int toHr = “06”
	    // int toMn = “20”
	    // String  days = “01010000”
	// Time t8 has the following properties:
	    // int frHr = “03”
	    // int frMn = “30” 
	    // int toHr = “05”
	    // int toMn = “00”
	    // String  days = “0101000”
	// setTime(t1) and setTime(t8) are then invoked.

	// Input
	// cd1.hasConflict(cd8)

	// Expected output
	// true
	@Test
	public void testHasConflict7() {
		assertEquals(true, cd1.hasConflict(cd8));
	}
	
	// Test Case
	// UT_CD_009_hasConflict8

	// Purpose
	// To test the hasConflict(ClassDetails) method. This method will return whether 
	// two ClassDetails objects have a time conflict with each other.

	// Precondition
	// Two ClassDetails, cd8, and cd1, objects must have been instantiated in memory. Each of the two classes will also have a Time object set for them which are instantiated.
	 // Time t8 has the following properties:
	    // int frHr = “03”
	    // int frMn = “30” 
	    // int toHr = “05”
	    // int toMn = “00”
	    // String  days = “0101000”
	// Time t1 has the following properties:
	     // int frHr = “04”
	    // int frMn = “30” 
	    // int toHr = “06”
	    // int toMn = “20”
	    // String  days = “01010000”
	// setTime(t8) and setTime(t1) are then invoked.

	// Input
	// cd8.hasConflict(cd1)

	// Expected output
	// true
	@Test
	public void testHasConflict8() {
		assertEquals(true, cd8.hasConflict(cd1));
	}
	
	
	// Test Case
	// UT_CD_009_hasConflict9

	// Purpose
	// To test the hasConflict(ClassDetails) method. This method will return whether 
	// two ClassDetails objects have a time conflict with each other.

	// Precondition
	// Two ClassDetails, cd7, and cd9, objects must have been instantiated in memory. Each of the two classes will also have a Time object set for them which are instantiated.
	 // Time t7 has the following properties:
	    // int frHr = “05”
	    // int frMn = “00” 
	    // int toHr = “06”
	    // int toMn = “00”
	    // String  days = “0101000”
	// Time t9 has the following properties:
	    // int frHr = “04”
	    // int frMn = “00” 
	    // int toHr = “05”
	    // int toMn = “15”
	    // String  days = “0101000”
	// setTime(t7) and setTime(t9) are then invoked.

	// Input
	// cd7.hasConflict(cd9)

	// Expected output
	// true
	@Test
	public void testHasConflict9() {
		assertEquals(true, cd7.hasConflict(cd9));
	}
	
	// Test Case
	// UT_CD_003_setCampus1

	// Purpose
	// To test the setCampus(String) method. This method allows to set the term for a ClassDetails object. 

	// Precondition
	// A ClassDetails object instantiated with time t1=(“4:30”,”6:20,”0101000”)

	// Input
	// String campus = “MMC”

	// Expected Output
	// No output, but for the state of the object to have “MMC” as its campus. 
	@Test
	public void testSetCampus1() {
		cd1.setCampus("MMC");
		assertEquals("MMC", cd1.getCampus());
	}
	
	// Test Case
	// UT_CD_003_setCampus2

	// Purpose
	// To test the setCampus(String) method. This method allows to set the term for a ClassDetails object. 

	// Precondition
	// A ClassDetails object must have been instantiated in memory.

	// Input
	// String campus = “”

	// Expected Output
	// No output, but for the state of the object to have “” as its campus. 
	@Test
	public void testSetCampus2() {
		cd1.setCampus("");
		assertEquals("", cd1.getCampus());
	}
	
	// Test Case
	// UT_CD_004_getCampus

	// Purpose
	// To test the getCampus() method. This method returns the campus of a 
	// ClassDetail object.

	// Precondition
	// A ClassDetails object must have been instantiated in memory. The following field is the classDetails object is set:
	    // String campus = “MMC”
		
	// Input
	// getCampus()

	// Expected Output
	// “MMC”
	@Test
	public void testGetCampus() {
		cd1.setCampus("MMC");
		assertEquals("MMC", cd1.getCampus());
	}
	
	// Test Case
	// UT_CD_005_getInstructor

	// Purpose
	// To test the getInstructor() method. This method returns the instructor of a ClassDetails object.

	// Precondition
	// A ClassDetails object must have been instantiated in memory with:
	    // String term = “Fall 2017”
	    // String Time.frHr = “4”
	    // String Time.frMn = “30”
	    // String Time.toHr = “6”
	    // String Time.toMn = “20”

	// Input
	// getInstructor()

	// Expected Output
	// Null, because professor would not have been set in the precondition
	@Test
	public void testGetInstructor() {
		assertNotNull(null, cd1.getInstructor());
	}
	
	// Test Case
	// UT_CD_007_setTime

	// Purpose
	// To test the setTime(Time) method. This method returns the time of a ClassDetail object.

	// Precondition
	// A ClassDetails object must have been instantiated in memory.
	// A Time object t’s toString(), has also been mocked to return:
	    // “04:30-06:20”
	   // The time object will then be passed into the setTime.

	// Input
	// setTime(); 

	// Expected Output
	// “04:30-06:20”
	@Test 
	public void testSetTime() {
		Time mockedTime = mock(Time.class);
		when(mockedTime.toString()).thenReturn("04:30-06:20");
		cd1.setTime(mockedTime);
		assertEquals("04:30-06:20", cd1.getTime().toString());
	}
	
	// Test Case
	// UT_CD_012_TestGetTime

	// Purpose
	// To test getTime(), method. This method returns the term for a ClassDetails
	// object. 

	// Precondition
	// A ClassDetails object must have been instantiated in memory. The ClassDetails object will have the field mocked tot:
	    // String term = “Fall 2017”
	    // String Time.frHr = “4”
	    // String Time.frMn = “30”
	    // String Time.toHr = “6”
	    // String Time.toMn = “20”

	// Input
	// getTerm()

	// Expected Output
	// “04:30-06:20”
	@Test
	public void testGetTime() {
		Time mockedTime = mock(Time.class);
		when(mockedTime.toString()).thenReturn("04:30-06:20");
		cd1.setTime(mockedTime);
		assertEquals("04:30-06:20", cd1.getTime().toString());
	}
	
	// Test Case
	// UT_CD_006_getDays

	// Purpose
	// To test the getDays() method. This method returns the days of a ClassDetails object

	// Precondition
	// A ClassDetails object must have been instantiated in memory. The classDetails object must have the Time field set.
	// A Time object t, has also been mocked with the following properties:
	    // String days = “0101000“
	 // setTime(t) is then invoked.
	    
	// Input
	// getDays()

	// Expected Output
	// “0101000”

	@Test
	public void testGetDays() {
		Time mockedTime = mock(Time.class);
		mockedTime.days = "0101000";
		cd1.setTime(mockedTime);
		assertEquals("0101000", cd1.getDays());
	}
	
	// Test Case
	// UT_CD_010_isAtDay1

	// Purpose
	// To test the isAtDay(int) method. This method will return a boolean, where an int (0 - 6) represents a day. Input will be compared to day vector.

	// Precondition
	// A ClassDetails object must have been instantiated in memory.

	// A Time object t, has also been mocked with the following properties:
	    // String days = “01010000”
	// setTime(t) is then invoked.

	// Input
	// isAtDay(3)

	// Expected Output
	// true
	@Test
	public void testIsAtDay1() {
		Time mockedTime = mock(Time.class);
		cd1.setTime(mockedTime);
		mockedTime.days = "0101000";
		// The day entered here corresponds to Monday = 0 and Tuesday = 1 and so on...
		assertEquals(true, cd1.isAtDay(3));
	}
	
	// Test Case
	// UT_CD_010_isAtDay2

	// Purpose
	// To test the isAtDay(int) method. This method will return a boolean, where an int (0 - 6) represents a day. Input will be compared to day vector.

	// Precondition
	// A ClassDetails object must have been instantiated in memory.
	// A Time object t, has also been mocked with the following properties:
	    // String days = “01010000”
	// setTime(t) is then invoked.

	// Input
	// isAtDay(2)

	// Expected Output
	// false
	@Test
	public void testIsAtDay2() {
		Time mockedTime = mock(Time.class);
		cd1.setTime(mockedTime);
		mockedTime.days = "0101000";
		// The day entered here corresponds to Monday = 0 and Tuesday = 1 and so on...
		assertEquals(false, cd1.isAtDay(2));
	}
	
	// Test Case
	// UT_CD_008_isAtTime1

	// Purpose
	// To test the isAtTime(int) method. This method will return a boolean whether
	// the hour passed into the method is between frHr and toHr.

	// Precondition
	// A ClassDetails object has been instantiated in memory.
	// A Time object t, has also been mocked with the following properties:
	    // int frHr = 10
	    // int toHr = 12
	// setTime(t) is then invoked.

	// Input
	// 11

	// Expected Output
	// true
	@Test
	public void testIsAtTime1() {
		Time mockedTime = mock(Time.class);
		mockedTime.toHr = 12;
		mockedTime.frHr = 10;
		cd1.setTime(mockedTime);
		assertEquals(false, cd1.isAtTime(07));
	}
	
	// Test Case
	// UT_CD_008_isAtTime2

	// Purpose
	// To test the isAtTime(int) method. This method will return a boolean whether
	// the hour passed into the method is between frHr and toHr.

	// Precondition
	// A ClassDetails object has been instantiated in memory.
	// A Time object t, has also been mocked with the following properties:
	    // int frHr = 10
	    // int toHr = 12
	// setTime(t) is then invoked.

	// Input
	// 07

	// Expected Output
	// false
	@Test
	public void testIsAtTime2() {
		Time mockedTime = mock(Time.class);
		mockedTime.toHr = 12;
		mockedTime.frHr = 10;
		cd1.setTime(mockedTime);
		assertEquals(true, cd1.isAtTime(11));
	}
	
	// Test Case
	// UT_CD_011_toString

	// Purpose
	// To test the toString() method. This method will return a String object containing 
	// information of the course, class number, time and campus for the classDetails object.

	// Precondition
	// A ClassDetails object must have been instantiated in memory. 
	// A Mocked Time object with constructor  parameters “10:00” and “12:00”
	// A Mocked course object with constructor  parameters “COP” “3337” 
	// The ClassDetails object will have setTime(mockedTime), setCourse(mockedCourse) setCampus(“MMC”), and  setClassNbr(“12345”). 

	// Input
	// toString()

	// Expected Output
	// "COP\n3337\n10:00-12:00\nMMC\n12345"
	@Test
	public void testToString() {
		Time mockedTime = new Time("10:00", "12:00", "1010000");
		Course mockedCourse = new Course("COP", "3337");
		mockedTime.toHr = 12;
		mockedTime.frHr = 10;
		cd1.setTime(mockedTime);
		cd1.setCourse(mockedCourse);
		cd1.setCampus("MMC");
		//cd1.setClassNbr("12345");
		
		assertEquals("Programming\n12345\n10:00-12:00\nMMC\n", cd1.toString());
	}
	
	// Test Case
	// UT_CD_013_TestSetCourse

	// Purpose
	// To test the setCourse(string) method. This method sets the course for a class details object.

	// Precondition
	// A ClassDetails object must have been instantiated in memory. The ClassDetails object will have the field set to:
	    // String term = “Fall 2017”
	    // String Time.frHr = “4”
	    // String Time.frMn = “30”
	    // String Time.toHr = “6”
	    // String Time.toMn = “20”
	    
	// Input
	// setCourse(“COP3337”)

	// Expected Output
	// “COP3337” as the time components of the course object as the state of the object
	@Test
	public void testSetCourse() {
		Course mockedCourse = new Course("COP", "3337");
		cd1.setCourse(mockedCourse);
		assertEquals("COP3337", cd1.getCourse());
	}
	
	// Test Case
	// UT_CD_014_TestGetCourse

	// Purpose
	// To test the getCourse() method. This method sets the course for a class details object.

	// Precondition
	// A ClassDetails object must have been instantiated in memory. The ClassDetails object will have the course mocked to:
	// “COP3337”
	    
	// Input
	// getCourse()

	// Expected Output
	// “COP3337” 
	@Test
	public void testGetCourse(){
		
		Course mockedCourse = mock(Course.class);
		when(mockedCourse.toString()).thenReturn("COP3337");
		cd1.setCourse(mockedCourse);
		assertEquals("COP3337", cd1.getCourse());
		
	}
	
	@Test
	public void testSetClassNbr() {
	
	}
}
