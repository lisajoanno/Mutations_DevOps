package main;

import java.util.ArrayList;
import java.util.Random;

import data.Names;
import people.Student;
import places.Classroom;
import places.Corridor;
import places.Lab;
import places.Office;
import places.Room;

public class UnGame {

	private String randName;
	private int randNumber;
	private Random rand;
	private int r;
	private ArrayList<Room> school;
	private ArrayList<Student> schoolClass;

	/**
	 * 
	 * Constructor of the game
	 * 
	 */
	public UnGame() {
		rand = new Random();
		schoolClass = new ArrayList<Student>();
		initMap();
		// create an entire school class
		for (int i = 0; i < 10; i++) {
			schoolClass.add(createStudent());
		}

	}

	/**
	 * A method to generate a map of the school
	 */
	public void initMap() {
		school = new ArrayList<Room>();
		// the default corridor
		Corridor corridor = new Corridor(null, false, false, 0);
		corridor.initCorridor();
		Lab lab = new Lab(null, true, null, 0); // the default Lab
		lab.initLab();
		// the default classroom
		Classroom classroom = new Classroom(null, true, 0);
		classroom.initClassroom();
		// the default office
		Office office = new Office(null, false, false, false, 0);
		office.initOffice();

		school.add(corridor);
		school.add(lab);
		school.add(classroom);
		school.add(office);
	}

	/**
	 * A method to create a student with a random name
	 * 
	 */
	public String initStudentName() {
		r = rand.nextInt(Names.values().length);
		randName = Names.values()[r].toString();
		return randName;

	}

	/**
	 * A method to determine (with a radom method) if the student have the key
	 * 
	 */
	public boolean initKey() {
		randNumber = rand.nextInt(2);
		if (randNumber == 1) {
			return true;
		}
		return false;
	}

	/**
	 * A method to determine (with a radom method) if the student have the
	 * digicode
	 * 
	 */
	public boolean initDigicode() {
		randNumber = rand.nextInt(2);
		if (randNumber == 1) {
			return true;
		}
		return false;
	}

	/**
	 * A method to create a new student.
	 */
	public Student createStudent() {
		Student currentStudent = new Student(initStudentName(), initKey(), initDigicode());
		return currentStudent;
	}

	
	public ArrayList<Student> getSchoolClass() {
		return schoolClass;
	}
	
	public ArrayList<Room> getSchoolMap() {
		return school;
	}
}
