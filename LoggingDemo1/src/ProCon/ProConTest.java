package ProCon;

import java.util.PriorityQueue;

import java.util.Queue;

import java.util.Random;

import java.io.FileWriter;

import java.io.IOException; 

import java.io.BufferedWriter;

public class ProConTest {
	

	private static final Queue<PassengerDetails> priorityQueue = new PriorityQueue<>();



	public static void main(String[] args) {

	int producerThreadCount = 3; 

	int consumerThreadCount = 2; 



	for (int i = 0; i < producerThreadCount; i++) {

	new Thread(() -> {

	while (true) {

	PassengerDetails passenger = generatePassenger();

	produce(passenger);

	}

	}).start();

	}



	for (int i = 0; i < consumerThreadCount; i++) {

	new Thread(() -> {

	while (true) {

	consume();

	}

	}).start();

	}

	}



	// Method to generate random passenger details

	private static PassengerDetails generatePassenger() {

	Random rand = new Random();

	String[] names = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Harry", "Ivy", "Jack"};

	String name = names[rand.nextInt(names.length)];

	int age = rand.nextInt(80) + 1; // 

	String gender = rand.nextBoolean() ? "Male" : "Female";

	return new PassengerDetails(name, age, gender);

	}



	private static void produce(PassengerDetails passenger) {

	synchronized (priorityQueue) {

	if (passenger.getAge() > 60) {

	priorityQueue.add(passenger); // Priority request

	System.out.println("Priority Request Produced: " + passenger);

	} else {

	priorityQueue.add(passenger); // Regular request

	System.out.println("Regular Request Produced: " + passenger);

	}

	priorityQueue.notifyAll();

	}

	sleep(1000); // 

	}



	private static void consume() {

	synchronized (priorityQueue) {

	while (priorityQueue.isEmpty()) {

	try {

	priorityQueue.wait();

	} catch (InterruptedException e) {

	e.printStackTrace();

	}

	}



	PassengerDetails passenger = priorityQueue.poll();

	/*try { 

	FileWriter fwrite = new FileWriter("C:\\Users\\ritik.kumarsingh\\Desktop\\FileHandling\\Male.txt",true); 


	fwrite.write("Consumed: " + passenger); 


	fwrite.close(); 


	System.out.println("Content is successfully wrote to the file."); 

	} catch (IOException e) { 

	System.out.println("Unexpected error occurred"); 

	e.printStackTrace(); 

	} 


	System.out.println("Consumed: " + passenger);*/

	try {

	String fileName;

	String fileName1;



	// Check age and gender to determine the category

	if (passenger.getAge() < 10) {

	// Exclude children from all files

	return;

	} else if (passenger.getAge() < 60) {

	fileName = "D:\\FileHandling1\\NormalCitizen.txt";

	} else {

	fileName = "D:\\FileHandling1\\SeniorCitizen.txt";

	}



	// Append gender-specific files

	if ("Male".equals(passenger.getGender())) {

	fileName1 = "D:\\FileHandling1\\Male.txt";

	} else {

	fileName1 = "D:\\FileHandling1\\Female.txt";

	}



	try (FileWriter fileWriter = new FileWriter(fileName, true);

	BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {



	bufferedWriter.write("Consumed: " + passenger + "\n");



	System.out.println("Content is successfully written to the file: " + fileName);



	} catch (IOException e) {

	System.out.println("Unexpected error occurred");

	e.printStackTrace();

	}

	try (FileWriter fileWriter = new FileWriter(fileName1, true);

	BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {



	bufferedWriter.write("Consumed: " + passenger + "\n");



	System.out.println("Content is successfully written to the file: " + fileName1);



	} catch (IOException e) {

	System.out.println("Unexpected error occurred");

	e.printStackTrace();

	}

	} finally {

	System.out.println("Consumed: " + passenger);

	}

	sleep(1500); 

	}

	}





	private static void sleep(int millis) {

	try {

	Thread.sleep(millis);

	} catch (InterruptedException e) {

	e.printStackTrace();

	}

	}





	private static class PassengerDetails implements Comparable<PassengerDetails> {

	private final String name;

	private final int age;

	private final String gender;



	public PassengerDetails(String name, int age, String gender) {

	this.name = name;

	this.age = age;

	this.gender = gender;

	}



	public int getAge() {

	return age;

	}

	public String getGender() {

	return gender;

	}



	@Override

	public String toString() {

	return "PassengerDetails{" +

	"name='" + name + '\'' +

	", age=" + age +

	", gender='" + gender + '\'' +

	'}';

	}



	@Override

	public int compareTo(PassengerDetails other) {

	return Integer.compare(this.age, other.age);

	}

	}

	

}
