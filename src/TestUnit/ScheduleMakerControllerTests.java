package TestUnit;

import stubs.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.util.*;

public class ScheduleMakerControllerTests {

	ScheduleMakerController controller;
	ScheduleOptions mockedScheduleOptions;
	Course mockedCourse;
	Schedule mockedSchedule;
	ClassDetails mockedClassDetails1;
	ClassDetails mockedClassDetails2;
	ClassDetails mockedClassDetails3;
	ClassDetails mockedClassDetails4;
	ClassDetails mockedClassDetails5;
	ClassDetails mockedClassDetails6;
	
	@Before
	public void setUp() throws Exception {

		controller = new ScheduleMakerController();
		mockedScheduleOptions = mock(ScheduleOptions.class);
		mockedCourse = mock(Course.class);
		mockedSchedule = mock(Schedule.class);
		mockedClassDetails1 = mock(ClassDetails.class);
		mockedClassDetails2 = mock(ClassDetails.class);
		mockedClassDetails3 = mock(ClassDetails.class);
		mockedClassDetails4 = mock(ClassDetails.class);
		mockedClassDetails5 = mock(ClassDetails.class);
		mockedClassDetails6 = mock(ClassDetails.class);
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void testCreateScheduleWithObject1() {
		// This block will mock input values on the schedule create page
		when(mockedScheduleOptions.getTerm()).thenReturn("Spring 2007");
		when(mockedScheduleOptions.getCourse1()).thenReturn("COP2210");
		when(mockedScheduleOptions.getCourse2()).thenReturn("");
		when(mockedScheduleOptions.getCourse3()).thenReturn("");
		when(mockedScheduleOptions.getCourse4()).thenReturn("");
		when(mockedScheduleOptions.getCourse5()).thenReturn("");
		when(mockedScheduleOptions.getCourse6()).thenReturn("");
		when(mockedScheduleOptions.getCampus()).thenReturn("Biscayne");
		when(mockedScheduleOptions.getM()).thenReturn("1");
		when(mockedScheduleOptions.getT()).thenReturn("0");
		when(mockedScheduleOptions.getW()).thenReturn("1");
		when(mockedScheduleOptions.getTh()).thenReturn("0");
		when(mockedScheduleOptions.getF()).thenReturn("0");
		when(mockedScheduleOptions.getS()).thenReturn("0");
		when(mockedScheduleOptions.getSu()).thenReturn("1");
		when(mockedScheduleOptions.getGap()).thenReturn(0);
		
		// Mocking courses collection
		Collection<String> courses = new ArrayList<String>();
		courses.add("COP2210");
		
		//Mocking ClassDetails attributes
		when(mockedClassDetails1.toString()).thenReturn("COP2210" + "\n" + "10772" + "\n" + "11:0-12:15" + "\n" + "Biscayne" + "\n");
		when(mockedClassDetails1.getDays()).thenReturn("1010000");
		when(mockedClassDetails1.getTerm()).thenReturn("Spring 2007");
		when(mockedClassDetails1.getCampus()).thenReturn("Biscayne");
		
		// Creating list for the mocked Schedule
		Collection<ClassDetails> classes = new ArrayList<ClassDetails>();
		classes.add(mockedClassDetails1);
		
		// This Schedule object mocks the Collection containing the ClassDetails collection
		when(mockedSchedule.getClasses()).thenReturn(classes);
		
		// Making a String collection containing a campus
		Collection<String> campuses = new ArrayList<String>();
		campuses.add("Biscayne");
		
		// The mocked course object will return all the classDetails in the classes Collection
		when(mockedCourse.getClasses("Spring 2007", campuses)).thenReturn(classes);
		
		// Calling the function under test, it returns a Collection of Collections
		Collection<Schedule> outputSchedule = controller.createSchedule(mockedScheduleOptions);
		
		// The output of the function will be obtained the Collection inside the Collections will be retrieved
		Schedule s = (Schedule)((ArrayList)outputSchedule).get(0);
		
		// Get the classes inside the Schedule object
		Collection<ClassDetails> clclasses = s.getClasses();
		
		// Creating an array that holds the classes
		Object[] arr = new Object[20];
		
		// Counter to traverse the created array
		int count = 0;
		
		// This for loop will traverse the collection of classes and place each class into an array element
		for (Object o : (ArrayList)clclasses) {
			arr[count] = o;
			count++;
		}
		
		// These are the actual class details
		ClassDetails outputClassDetails = (ClassDetails)((ArrayList) arr[0]).get(0);
		
		// Unit testing occurring here
		assertEquals(mockedClassDetails1.toString().substring(0, 7), outputClassDetails.toString().substring(0, 7));
		assertEquals(mockedClassDetails1.getDays(), outputClassDetails.getDays());
		assertEquals(mockedClassDetails1.getTerm(), outputClassDetails.getTerm());
		assertEquals(mockedClassDetails1.getCampus(), outputClassDetails.getCampus());
		
	}
	
	
	@Test
	public void testCreateScheduleWithParameters1() {
		
		// Creating String Collection containing COP2210 course
		Collection<String> courses = new ArrayList<String>();
		courses.add("COP2210");
		
		// Contains the campus that COP2210 is in
		Collection<String> campuses = new ArrayList<String>();
		campuses.add("Biscayne");
		
		// Mock the COP2210 object's methods
		when(mockedClassDetails1.toString()).thenReturn("COP2210" + "\n" + "10772" + "\n" + "11:0-12:15" + "\n" + "Biscayne" + "\n");
		when(mockedClassDetails1.getDays()).thenReturn("1010000");
		when(mockedClassDetails1.getTerm()).thenReturn("Spring 2007");
		when(mockedClassDetails1.getCampus()).thenReturn("Biscayne");
		
		// Create the classDetails collection with the mocked ClassDetails class
		Collection<ClassDetails> classes = new ArrayList<ClassDetails>();
		classes.add(mockedClassDetails1);
		
		// Mock the schedule object to return the list of classDetails
		when(mockedSchedule.getClasses()).thenReturn(classes);
		
		// Creating the schedule object that calls the function under test and store outputs in the Collection
		Collection<Schedule> outputSchedule = controller.createSchedule("Spring 2007", courses, "Biscayne", "1010000");
		
		// Moving Collection object into the loop for the array
		Object[] arr = new Object[20];
		int count = 0;
		for (Object o: (ArrayList) classes) {
			arr[count] = o;	
			count++;
		}
		
		// Moving outputs into the final object
		ClassDetails outputClassDetails = (ClassDetails)((ArrayList) arr[0]).get(0);
		
		// Conducting tests
		assertEquals(mockedClassDetails1.toString().substring(0,7), outputClassDetails.toString().substring(0,7));
		assertEquals(mockedClassDetails1.getDays(), outputClassDetails.getDays());
		assertEquals(mockedClassDetails1.getTerm(), outputClassDetails.getTerm());
		assertEquals(mockedClassDetails1.getCampus(), outputClassDetails.getCampus());
	}
	
	
	@Test
	public void testCreateScheduleWithObject2() {
		
		// Mocking options for the ScheduleOptions class which contains six possible classes
		when(mockedScheduleOptions.getTerm()).thenReturn("Spring2007");
		when(mockedScheduleOptions.getCourse1()).thenReturn("COP2210");
		when(mockedScheduleOptions.getCourse2()).thenReturn("HIS1010");
		when(mockedScheduleOptions.getCourse3()).thenReturn("STA3510");
		when(mockedScheduleOptions.getCourse4()).thenReturn("COP4338");
		when(mockedScheduleOptions.getCourse5()).thenReturn("PHY2048");
		when(mockedScheduleOptions.getCourse6()).thenReturn("PHY2049");
		when(mockedScheduleOptions.getCampus()).thenReturn("All");
		when(mockedScheduleOptions.getM()).thenReturn(null);
		when(mockedScheduleOptions.getT()).thenReturn(null);
		when(mockedScheduleOptions.getW()).thenReturn(null);
		when(mockedScheduleOptions.getTh()).thenReturn(null);
		when(mockedScheduleOptions.getF()).thenReturn(null);
		when(mockedScheduleOptions.getS()).thenReturn(null);
		when(mockedScheduleOptions.getSu()).thenReturn(null);
		when(mockedScheduleOptions.getGap()).thenReturn(0);
		
		// Adding 6 courses into the String collection
		Collection<String> courses = new ArrayList<String>();
		courses.add("COP2210");
		courses.add("HIS1010");
		courses.add("STA3510");
		courses.add("COP4338");
		courses.add("PHY2048");
		courses.add("PHY2049");
		
		// Mocking first ClassDetails class
		when(mockedClassDetails1.toString()).thenReturn("COP2210" + "\n" + "10772" + "\n" + "11:0-12:15" + "\n" + "Biscayne" + "\n");
		when(mockedClassDetails1.getDays()).thenReturn("1010000");
		when(mockedClassDetails1.getTerm()).thenReturn("Spring 2007");
		when(mockedClassDetails1.getCampus()).thenReturn("Biscayne");
		
		// Mocking second ClassDetails class
		when(mockedClassDetails2.toString()).thenReturn("HIS1010" + "\n" + "24536" + "\n" + "08:0-9:15" + "\n" + "University" + "\n");
		when(mockedClassDetails2.getDays()).thenReturn("1010000");
		when(mockedClassDetails2.getTerm()).thenReturn("Spring 2007");
		when(mockedClassDetails2.getCampus()).thenReturn("University");
		
		
		// Mocking third ClassDetails class
		when(mockedClassDetails3.toString()).thenReturn("STA3510" + "\n" + "12345" + "\n" + "09:30-10:15" + "\n" + "University" + "\n");
		when(mockedClassDetails3.getDays()).thenReturn("1010000");
		when(mockedClassDetails3.getTerm()).thenReturn("Spring 2007");
		when(mockedClassDetails3.getCampus()).thenReturn("University");
		
		// Mocking fourth ClassDetails class
		when(mockedClassDetails4.toString()).thenReturn("COP4338" + "\n" + "12345" + "\n" + "01:30-2:15" + "\n" + "Biscayne" + "\n");
		when(mockedClassDetails3.getDays()).thenReturn("1010000");
		when(mockedClassDetails3.getTerm()).thenReturn("Spring 2007");
		when(mockedClassDetails3.getCampus()).thenReturn("Biscayne");
		
		// Mocking fifth ClassDetails class
		when(mockedClassDetails5.toString()).thenReturn("PHY2048" + "\n" + "12345" + "\n" + "02:30-3:15" + "\n" + "University" + "\n");
		when(mockedClassDetails5.getDays()).thenReturn("1010000");
		when(mockedClassDetails5.getTerm()).thenReturn("Spring 2007");
		when(mockedClassDetails5.getCampus()).thenReturn("University");
		
		// Mocking fifth ClassDetails class
		when(mockedClassDetails6.toString()).thenReturn("PHY2049" + "\n" + "12345" + "\n" + "3:30-4:15" + "\n" + "University" + "\n");
		when(mockedClassDetails6.getDays()).thenReturn("1010000");
		when(mockedClassDetails6.getTerm()).thenReturn("Spring 2007");
		when(mockedClassDetails6.getCampus()).thenReturn("University");
		
		// Insert all mocked ClassDetails objects into an ArrayList
		Collection<ClassDetails> classes = new ArrayList<ClassDetails>();
		classes.add(mockedClassDetails1);
		classes.add(mockedClassDetails2);
		classes.add(mockedClassDetails3);
		classes.add(mockedClassDetails4);
		classes.add(mockedClassDetails5);
		classes.add(mockedClassDetails6);

		// Mocked Schedule object will return the created ArrayList just made in the line above
		when(mockedSchedule.getClasses()).thenReturn(classes);
		
		// Creating ArrayList to store the campus for each mocked ClassDetails object
		Collection<String> campuses = new ArrayList<String>();
		campuses.add("Biscayne");
		campuses.add("University");
		campuses.add("University");
		campuses.add("Biscayne");
		campuses.add("University");
		campuses.add("University");
		
		// Mocking method to return the classDetail objects
		when(mockedCourse.getClasses("Spring 2007", campuses)).thenReturn(classes);
		
		// Calling method under test and store results in the Collection of Schedules
		Collection<Schedule> outputSchedule = controller.createSchedule(mockedScheduleOptions);
		
		// Moving output into the Schedule object
		Schedule s = (Schedule)((ArrayList) outputSchedule).get(0);
		
		// Creating ArrayList with the classDetails in the schedule
		Collection<ClassDetails> classDetails = s.getClasses();
		
		
		ClassDetails classDetails1 = new ClassDetails();
		ClassDetails classDetails2 = new ClassDetails();
		ClassDetails classDetails3 = new ClassDetails();
		ClassDetails classDetails4 = new ClassDetails();
		ClassDetails classDetails5 = new ClassDetails();
		ClassDetails classDetails6 = new ClassDetails();
		
		// Process for moving mocked data into real classDetails objects
		int count = 0;
		for(Object o :(ArrayList<ClassDetails>) classDetails){
			ClassDetails cd = (ClassDetails)((ArrayList) o).get(0);
			if(count == 0)
				classDetails1 = cd;
			if(count == 1)
				classDetails1 = cd;
			if(count == 2)
				classDetails1 = cd;
			if(count == 3)
				classDetails1 = cd;
			if(count == 4)
				classDetails1 = cd;
			if(count == 5)
				classDetails1 = cd;
			count++;
		}
			
		// Conducting tests for all six classes
		assertEquals(mockedClassDetails1.toString().substring(0,7), classDetails1.toString().substring(0,7));
		assertEquals(mockedClassDetails1.getTerm(), classDetails1.getTerm());
		assertEquals(mockedClassDetails1.getCampus(), classDetails1.getCampus());	
		assertEquals(mockedClassDetails2.toString().substring(0,7), classDetails2.toString().substring(0,7));
		assertEquals(mockedClassDetails2.getTerm(), classDetails2.getTerm());
		assertEquals(mockedClassDetails2.getCampus(), classDetails2.getCampus());
		assertEquals(mockedClassDetails3.toString().substring(0,7), classDetails3.toString().substring(0,7));
		assertEquals(mockedClassDetails3.getTerm(), classDetails3.getTerm());
		assertEquals(mockedClassDetails3.getCampus(), classDetails3.getCampus());
		assertEquals(mockedClassDetails4.toString().substring(0,7), classDetails4.toString().substring(0,7));
		assertEquals(mockedClassDetails4.getTerm(), classDetails4.getTerm());
		assertEquals(mockedClassDetails4.getCampus(), classDetails4.getCampus());
		assertEquals(mockedClassDetails5.toString().substring(0,7), classDetails5.toString().substring(0,7));
		assertEquals(mockedClassDetails5.getTerm(), classDetails5.getTerm());
		assertEquals(mockedClassDetails5.getCampus(), classDetails5.getCampus());		
		assertEquals(mockedClassDetails6.toString().substring(0,7), classDetails6.toString().substring(0,7));
		assertEquals(mockedClassDetails6.getTerm(), classDetails6.getTerm());
		assertEquals(mockedClassDetails6.getCampus(), classDetails6.getCampus());
	}
	
	@Test
	public void testCreateScheduleScheduleWithParameters2() {
		
		// See Documentation for the method above as the algorithms is the same
		// save for the number of classDetails objects being mocked
		Collection<String> courses = new ArrayList<String>();
		courses.add("COP2210");
		courses.add("HIS1010");
		
		when(mockedClassDetails1.toString()).thenReturn("COP2210" + "\n" + "10772" + "\n" + "11:0-12:15" + "\n" + "Biscayne" + "\n");
		when(mockedClassDetails1.getDays()).thenReturn("1010000");
		when(mockedClassDetails1.getTerm()).thenReturn("Spring 2007");
		when(mockedClassDetails1.getCampus()).thenReturn("Biscayne");
		
		when(mockedClassDetails2.toString()).thenReturn("HIS1010" + "\n" + "24536" + "\n" + "08:0-9:15" + "\n" + "University" + "\n");
		when(mockedClassDetails2.getDays()).thenReturn("1010000");
		when(mockedClassDetails2.getTerm()).thenReturn("Spring 2007");
		when(mockedClassDetails2.getCampus()).thenReturn("Biscayne");
		
		Collection<ClassDetails> classes = new ArrayList<ClassDetails>();
		classes.add(mockedClassDetails1);
		classes.add(mockedClassDetails2);
		
		when(mockedSchedule.getClasses()).thenReturn(classes);
		
		Collection<String> campuses = new ArrayList<String>();
		campuses.add("Biscayne");
		campuses.add("University");
		
		when(mockedCourse.getClasses("Spring 2007", campuses)).thenReturn(classes);
		
		Collection<Schedule> outputSchedule = controller.createSchedule("Spring 2007", courses, "All", "1010000");
		
		Schedule s = (Schedule) ((ArrayList)outputSchedule).get(0);
		
		Collection<ClassDetails> cds = s.getClasses();
		ClassDetails classDetails1 = new ClassDetails();
		ClassDetails classDetails2 = new ClassDetails();
		
		int count = 0;
		for (Object o : (ArrayList<ClassDetails>) cds) {
			ClassDetails c = (ClassDetails)((ArrayList) o).get(0);
			
			if (count == 1) 
				classDetails1 = c;
			if (count == 2) 
				classDetails2 = c;
			count++;
		}
		
		assertEquals(mockedClassDetails1.toString().substring(0,7), classDetails1.toString().substring(0,7));
		assertEquals(mockedClassDetails1.getTerm(), classDetails1.getTerm());
		assertEquals(mockedClassDetails1.getCampus(), classDetails1.getCampus());	
		assertEquals(mockedClassDetails2.toString().substring(0,7), classDetails2.toString().substring(0,7));
		assertEquals(mockedClassDetails2.getTerm(), classDetails2.getTerm());
		assertEquals(mockedClassDetails2.getCampus(), classDetails2.getCampus());
	}
	
	@Test
	public void testCreateScheduleWithObject3() {
		// This block will mock input values on the schedule create page
				when(mockedScheduleOptions.getTerm()).thenReturn("Spring 2007");
				when(mockedScheduleOptions.getCourse1()).thenReturn("");
				when(mockedScheduleOptions.getCourse2()).thenReturn("COP2210");
				when(mockedScheduleOptions.getCourse3()).thenReturn("");
				when(mockedScheduleOptions.getCourse4()).thenReturn("");
				when(mockedScheduleOptions.getCourse5()).thenReturn("");
				when(mockedScheduleOptions.getCourse6()).thenReturn("");
				when(mockedScheduleOptions.getCampus()).thenReturn("Biscayne");
				when(mockedScheduleOptions.getM()).thenReturn("1");
				when(mockedScheduleOptions.getT()).thenReturn("0");
				when(mockedScheduleOptions.getW()).thenReturn("1");
				when(mockedScheduleOptions.getTh()).thenReturn("0");
				when(mockedScheduleOptions.getF()).thenReturn("0");
				when(mockedScheduleOptions.getS()).thenReturn("0");
				when(mockedScheduleOptions.getSu()).thenReturn("1");
				when(mockedScheduleOptions.getGap()).thenReturn(0);
				
				// Mocking courses collection
				Collection<String> courses = new ArrayList<String>();
				courses.add("COP2210");
				
				//Mocking ClassDetails attributes
				when(mockedClassDetails1.toString()).thenReturn("COP2210" + "\n" + "10772" + "\n" + "11:0-12:15" + "\n" + "Biscayne" + "\n");
				when(mockedClassDetails1.getDays()).thenReturn("1010000");
				when(mockedClassDetails1.getTerm()).thenReturn("Spring 2007");
				when(mockedClassDetails1.getCampus()).thenReturn("Biscayne");
				
				// Creating list for the mocked Schedule
				Collection<ClassDetails> classes = new ArrayList<ClassDetails>();
				classes.add(mockedClassDetails1);
				
				// This Schedule object mocks the Collection containing the ClassDetails collection
				when(mockedSchedule.getClasses()).thenReturn(classes);
				
				// Making a String collection containing a campus
				Collection<String> campuses = new ArrayList<String>();
				campuses.add("Biscayne");
				
				// The mocked course object will return all the classDetails in the classes Collection
				when(mockedCourse.getClasses("Spring 2007", campuses)).thenReturn(classes);
				
				// Calling the function under test, it returns a Collection of Collections
				Collection<Schedule> outputSchedule = controller.createSchedule(mockedScheduleOptions);
				
				// The output of the function will be obtained the Collection inside the Collections will be retrieved
				Schedule s = (Schedule)((ArrayList)outputSchedule).get(0);
				
				// Get the classes inside the Schedule object
				Collection<ClassDetails> clclasses = s.getClasses();
				
				// Creating an array that holds the classes
				Object[] arr = new Object[20];
				
				// Counter to traverse the created array
				int count = 0;
				
				// This for loop will traverse the collection of classes and place each class into an array element
				for (Object o : (ArrayList)clclasses) {
					arr[count] = o;
					count++;
				}
				
				// These are the actual class details
				ClassDetails outputClassDetails = (ClassDetails)((ArrayList) arr[0]).get(0);
				
				// Unit testing occurring here
				assertEquals(mockedClassDetails1.toString().substring(0, 7), outputClassDetails.toString().substring(0, 7));
				assertEquals(mockedClassDetails1.getDays(), outputClassDetails.getDays());
				assertEquals(mockedClassDetails1.getTerm(), outputClassDetails.getTerm());
				assertEquals(mockedClassDetails1.getCampus(), outputClassDetails.getCampus());
	}
	
	@Test
	public void testCreateScheduleWithObject4() {
		// This block will mock input values on the schedule create page
				when(mockedScheduleOptions.getTerm()).thenReturn("Spring 2007");
				when(mockedScheduleOptions.getCourse1()).thenReturn("COP2210");
				when(mockedScheduleOptions.getCourse2()).thenReturn(null);
				when(mockedScheduleOptions.getCourse3()).thenReturn(null);
				when(mockedScheduleOptions.getCourse4()).thenReturn(null);
				when(mockedScheduleOptions.getCourse5()).thenReturn(null);
				when(mockedScheduleOptions.getCourse6()).thenReturn(null);
				when(mockedScheduleOptions.getCampus()).thenReturn("Biscayne");
				when(mockedScheduleOptions.getM()).thenReturn("1");
				when(mockedScheduleOptions.getT()).thenReturn("0");
				when(mockedScheduleOptions.getW()).thenReturn("1");
				when(mockedScheduleOptions.getTh()).thenReturn("0");
				when(mockedScheduleOptions.getF()).thenReturn("0");
				when(mockedScheduleOptions.getS()).thenReturn("0");
				when(mockedScheduleOptions.getSu()).thenReturn("1");
				when(mockedScheduleOptions.getGap()).thenReturn(0);
				
				// Mocking courses collection
				Collection<String> courses = new ArrayList<String>();
				courses.add("COP2210");
				
				//Mocking ClassDetails attributes
				when(mockedClassDetails1.toString()).thenReturn("COP2210" + "\n" + "10772" + "\n" + "11:0-12:15" + "\n" + "Biscayne" + "\n");
				when(mockedClassDetails1.getDays()).thenReturn("1010000");
				when(mockedClassDetails1.getTerm()).thenReturn("Spring 2007");
				when(mockedClassDetails1.getCampus()).thenReturn("Biscayne");
				
				// Creating list for the mocked Schedule
				Collection<ClassDetails> classes = new ArrayList<ClassDetails>();
				classes.add(mockedClassDetails1);
				
				// This Schedule object mocks the Collection containing the ClassDetails collection
				when(mockedSchedule.getClasses()).thenReturn(classes);
				
				// Making a String collection containing a campus
				Collection<String> campuses = new ArrayList<String>();
				campuses.add("Biscayne");
				
				// The mocked course object will return all the classDetails in the classes Collection
				when(mockedCourse.getClasses("Spring 2007", campuses)).thenReturn(classes);
				
				// Calling the function under test, it returns a Collection of Collections
				Collection<Schedule> outputSchedule = controller.createSchedule(mockedScheduleOptions);
				
				// The output of the function will be obtained the Collection inside the Collections will be retrieved
				Schedule s = (Schedule)((ArrayList)outputSchedule).get(0);
				
				// Get the classes inside the Schedule object
				Collection<ClassDetails> clclasses = s.getClasses();
				
				// Creating an array that holds the classes
				Object[] arr = new Object[20];
				
				// Counter to traverse the created array
				int count = 0;
				
				// This for loop will traverse the collection of classes and place each class into an array element
				for (Object o : (ArrayList)clclasses) {
					arr[count] = o;
					count++;
				}
				
				// These are the actual class details
				ClassDetails outputClassDetails = (ClassDetails)((ArrayList) arr[0]).get(0);
				
				// Unit testing occurring here
				assertEquals(mockedClassDetails1.toString().substring(0, 7), outputClassDetails.toString().substring(0, 7));
				assertEquals(mockedClassDetails1.getDays(), outputClassDetails.getDays());
				assertEquals(mockedClassDetails1.getTerm(), outputClassDetails.getTerm());
				assertEquals(mockedClassDetails1.getCampus(), outputClassDetails.getCampus());
	}
	
	@Test
	public void testCreateScheduleWithObject5() {
		// This block will mock input values on the schedule create page
				when(mockedScheduleOptions.getTerm()).thenReturn("Spring 2007");
				when(mockedScheduleOptions.getCourse1()).thenReturn(null);
				when(mockedScheduleOptions.getCourse2()).thenReturn(null);
				when(mockedScheduleOptions.getCourse3()).thenReturn(null);
				when(mockedScheduleOptions.getCourse4()).thenReturn(null);
				when(mockedScheduleOptions.getCourse5()).thenReturn(null);
				when(mockedScheduleOptions.getCourse6()).thenReturn("COP2210");
				when(mockedScheduleOptions.getCampus()).thenReturn("Biscayne");
				when(mockedScheduleOptions.getM()).thenReturn("1");
				when(mockedScheduleOptions.getT()).thenReturn("0");
				when(mockedScheduleOptions.getW()).thenReturn("1");
				when(mockedScheduleOptions.getTh()).thenReturn("0");
				when(mockedScheduleOptions.getF()).thenReturn("0");
				when(mockedScheduleOptions.getS()).thenReturn("0");
				when(mockedScheduleOptions.getSu()).thenReturn("1");
				when(mockedScheduleOptions.getGap()).thenReturn(0);
				
				// Mocking courses collection
				Collection<String> courses = new ArrayList<String>();
				courses.add("COP2210");
				
				//Mocking ClassDetails attributes
				when(mockedClassDetails1.toString()).thenReturn("COP2210" + "\n" + "10772" + "\n" + "11:0-12:15" + "\n" + "Biscayne" + "\n");
				when(mockedClassDetails1.getDays()).thenReturn("1010000");
				when(mockedClassDetails1.getTerm()).thenReturn("Spring 2007");
				when(mockedClassDetails1.getCampus()).thenReturn("Biscayne");
				
				// Creating list for the mocked Schedule
				Collection<ClassDetails> classes = new ArrayList<ClassDetails>();
				classes.add(mockedClassDetails1);
				
				// This Schedule object mocks the Collection containing the ClassDetails collection
				when(mockedSchedule.getClasses()).thenReturn(classes);
				
				// Making a String collection containing a campus
				Collection<String> campuses = new ArrayList<String>();
				campuses.add("Biscayne"); 
				
				// The mocked course object will return all the classDetails in the classes Collection
				when(mockedCourse.getClasses("Spring 2007", campuses)).thenReturn(classes);
				
				// Calling the function under test, it returns a Collection of Collections
				Collection<Schedule> outputSchedule = controller.createSchedule(mockedScheduleOptions);
				
				// The output of the function will be obtained the Collection inside the Collections will be retrieved
				Schedule s = (Schedule)((ArrayList)outputSchedule).get(0);
				
				// Get the classes inside the Schedule object
				Collection<ClassDetails> clclasses = s.getClasses();
				
				// Creating an array that holds the classes
				Object[] arr = new Object[20];
				
				// Counter to traverse the created array
				int count = 0;
				
				// This for loop will traverse the collection of classes and place each class into an array element
				for (Object o : (ArrayList)clclasses) {
					arr[count] = o;
					count++;
				}
				
				// These are the actual class details being casted for testing
				ClassDetails outputClassDetails = (ClassDetails)((ArrayList) arr[0]).get(0);
				
				// Unit testing occurring here
				assertEquals(mockedClassDetails1.toString().substring(0, 7), outputClassDetails.toString().substring(0, 7));
				assertEquals(mockedClassDetails1.getDays(), outputClassDetails.getDays());
				assertEquals(mockedClassDetails1.getTerm(), outputClassDetails.getTerm());
				assertEquals(mockedClassDetails1.getCampus(), outputClassDetails.getCampus());
	}
	
	@Test
	public void testCreateScheduleWithObject6() {
		// This block will mock input values on the schedule create page
				when(mockedScheduleOptions.getTerm()).thenReturn("Spring 2007");
				when(mockedScheduleOptions.getCourse1()).thenReturn(null);
				when(mockedScheduleOptions.getCourse2()).thenReturn(null);
				when(mockedScheduleOptions.getCourse3()).thenReturn(null);
				when(mockedScheduleOptions.getCourse4()).thenReturn("COP2210");
				when(mockedScheduleOptions.getCourse5()).thenReturn(null);
				when(mockedScheduleOptions.getCourse6()).thenReturn(null);
				when(mockedScheduleOptions.getCampus()).thenReturn("Biscayne");
				when(mockedScheduleOptions.getM()).thenReturn("1");
				when(mockedScheduleOptions.getT()).thenReturn("0");
				when(mockedScheduleOptions.getW()).thenReturn("1");
				when(mockedScheduleOptions.getTh()).thenReturn("0");
				when(mockedScheduleOptions.getF()).thenReturn("0");
				when(mockedScheduleOptions.getS()).thenReturn("0");
				when(mockedScheduleOptions.getSu()).thenReturn("1");
				when(mockedScheduleOptions.getGap()).thenReturn(0);
				
				// Mocking courses collection
				Collection<String> courses = new ArrayList<String>();
				courses.add("COP2210");
				
				//Mocking ClassDetails attributes
				when(mockedClassDetails1.toString()).thenReturn("COP2210" + "\n" + "10772" + "\n" + "11:0-12:15" + "\n" + "Biscayne" + "\n");
				when(mockedClassDetails1.getDays()).thenReturn("1010000");
				when(mockedClassDetails1.getTerm()).thenReturn("Spring 2007");
				when(mockedClassDetails1.getCampus()).thenReturn("Biscayne");
				
				// Creating list for the mocked Schedule
				Collection<ClassDetails> classes = new ArrayList<ClassDetails>();
				classes.add(mockedClassDetails1);
				
				// This Schedule object mocks the Collection containing the ClassDetails collection
				when(mockedSchedule.getClasses()).thenReturn(classes);
				
				// Making a String collection containing a campus
				Collection<String> campuses = new ArrayList<String>();
				campuses.add("Biscayne");
				
				// The mocked course object will return all the classDetails in the classes Collection
				when(mockedCourse.getClasses("Spring 2007", campuses)).thenReturn(classes);
				
				// Calling the function under test, it returns a Collection of Collections
				Collection<Schedule> outputSchedule = controller.createSchedule(mockedScheduleOptions);
				
				// The output of the function will be obtained the Collection inside the Collections will be retrieved
				Schedule s = (Schedule)((ArrayList)outputSchedule).get(0);
				
				// Get the classes inside the Schedule object
				Collection<ClassDetails> clclasses = s.getClasses();
				
				// Creating an array that holds the classes
				Object[] arr = new Object[20];
				
				// Counter to traverse the created array
				int count = 0;
				
				// This for loop will traverse the collection of classes and place each class into an array element
				for (Object o : (ArrayList)clclasses) {
					arr[count] = o;
					count++;
				}
				
				// These are the actual class details
				ClassDetails outputClassDetails = (ClassDetails)((ArrayList) arr[0]).get(0);
				
				// Unit testing occurring here
				assertEquals(mockedClassDetails1.toString().substring(0, 7), outputClassDetails.toString().substring(0, 7));
				assertEquals(mockedClassDetails1.getDays(), outputClassDetails.getDays());
				assertEquals(mockedClassDetails1.getTerm(), outputClassDetails.getTerm());
				assertEquals(mockedClassDetails1.getCampus(), outputClassDetails.getCampus());
	}
	
	@Test
	public void testCreateScheduleWithObject7() {
		// This block will mock input values on the schedule create page
				when(mockedScheduleOptions.getTerm()).thenReturn("Spring 2007");
				when(mockedScheduleOptions.getCourse1()).thenReturn(null);
				when(mockedScheduleOptions.getCourse2()).thenReturn(null);
				when(mockedScheduleOptions.getCourse3()).thenReturn("COP2210");
				when(mockedScheduleOptions.getCourse4()).thenReturn(null);
				when(mockedScheduleOptions.getCourse5()).thenReturn(null);
				when(mockedScheduleOptions.getCourse6()).thenReturn(null);
				when(mockedScheduleOptions.getCampus()).thenReturn("Biscayne");
				when(mockedScheduleOptions.getM()).thenReturn(null);
				when(mockedScheduleOptions.getT()).thenReturn(null);
				when(mockedScheduleOptions.getW()).thenReturn(null);
				when(mockedScheduleOptions.getTh()).thenReturn(null);
				when(mockedScheduleOptions.getF()).thenReturn(null);
				when(mockedScheduleOptions.getS()).thenReturn(null);
				when(mockedScheduleOptions.getSu()).thenReturn(null);
				when(mockedScheduleOptions.getGap()).thenReturn(0);
				
				// Mocking courses collection
				Collection<String> courses = new ArrayList<String>();
				courses.add("COP2210");
				
				//Mocking ClassDetails attributes
				when(mockedClassDetails1.toString()).thenReturn("COP2210" + "\n" + "10772" + "\n" + "11:0-12:15" + "\n" + "Biscayne" + "\n");
				when(mockedClassDetails1.getDays()).thenReturn("1010000");
				when(mockedClassDetails1.getTerm()).thenReturn("Spring 2007");
				when(mockedClassDetails1.getCampus()).thenReturn("Biscayne");
				
				// Creating list for the mocked Schedule
				Collection<ClassDetails> classes = new ArrayList<ClassDetails>();
				classes.add(mockedClassDetails1);
				
				// This Schedule object mocks the Collection containing the ClassDetails collection
				when(mockedSchedule.getClasses()).thenReturn(classes);
				
				// Making a String collection containing a campus
				Collection<String> campuses = new ArrayList<String>();
				campuses.add("Biscayne");
				
				// The mocked course object will return all the classDetails in the classes Collection
				when(mockedCourse.getClasses("Spring 2007", campuses)).thenReturn(classes);
				
				// Calling the function under test, it returns a Collection of Collections
				Collection<Schedule> outputSchedule = controller.createSchedule(mockedScheduleOptions);
				
				// The output of the function will be obtained the Collection inside the Collections will be retrieved
				Schedule s = (Schedule)((ArrayList)outputSchedule).get(0);
				
				// Get the classes inside the Schedule object
				Collection<ClassDetails> clclasses = s.getClasses();
				
				// Creating an array that holds the classes
				Object[] arr = new Object[20];
				
				// Counter to traverse the created array
				int count = 0;
				
				// This for loop will traverse the collection of classes and place each class into an array element
				for (Object o : (ArrayList)clclasses) {
					arr[count] = o;
					count++;
				}
				
				// These are the actual class details
				ClassDetails outputClassDetails = (ClassDetails)((ArrayList) arr[0]).get(0);
				
				// Unit testing occurring here
				assertEquals(mockedClassDetails1.toString().substring(0, 7), outputClassDetails.toString().substring(0, 7));
				assertEquals(mockedClassDetails1.getDays(), outputClassDetails.getDays());
				assertEquals(mockedClassDetails1.getTerm(), outputClassDetails.getTerm());
				assertEquals(mockedClassDetails1.getCampus(), outputClassDetails.getCampus());
	}
}

