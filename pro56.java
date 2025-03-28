
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;
import javax.sound.sampled.*;
class User {
    private String username;
    private String password;
    private String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
class PlaySound extends Thread {
    private String filename;
    public PlaySound(String filename) {
        this.filename = filename;
    }
    public void run() {
        try {
            File audioFile = new File(filename);
            if (!audioFile.exists()) {
                System.out.println("Music file not found: " + filename);
                return;
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            while (!clip.isRunning()) {
                Thread.sleep(10);
            }
            while (clip.isRunning()) {
                Thread.sleep(10);
            }
            clip.close();
            audioStream.close();
        } catch (Exception e) {
            System.out.println("Error playing audio: " + e.getMessage());
        }
    }
}
class Main {
    static Scanner sc=new Scanner(System.in);
    static double m1;
    static  double m2;
     static  double m3;

    
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String Magenta = "\u001B[35m";
    private static final String Cyan = "\u001B[36m";
    private static List<User> users = new ArrayList<>();
    private static final int MAX_USERS = 50;
    static {
        users.add(new User("Praveena", "Praveena@123", "praveena@gmail.com"));
        users.add(new User("Rohith", "Rohith@123", "rohith@gmail.com"));
        users.add(new User("Prasanth", "Prasanth@123", "prasanth@gmail.com"));
        users.add(new User("Naveena", "Naveena@123", "naveena@gmail.com"));
    }
    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(regex, password);
    }
    public static boolean isValidUsername(String username) {
        return username.length() >= 5;
    }
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]{5,}@gmail\\.com$";
        return Pattern.matches(regex, email);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(RED + "                                           *********************************************" + RESET);
        System.out.println(GREEN + "                                           **************   CHALO BHARAT   *************" + RESET);
        System.out.println(RED + "                                           *********************************************" + RESET);
        System.out.println(  );
         System.out.println(  );
          System.out.println(  );
           System.out.println(  );



        // public static void main(String[] args) {
        System.out.println(YELLOW +  
            "\t\t\t\t\t██     ██  ███████  ██       ██████   ██████  ███    ███  ███████  \n" +
            "\t\t\t\t\t██     ██  ██       ██      ██       ██    ██ ████  ████  ██       \n" +
            "\t\t\t\t\t██  █  ██  █████    ██      ██       ██    ██ ██ ████ ██  █████    \n" +
            "\t\t\t\t\t██ ███ ██  ██       ██      ██       ██    ██ ██  ██  ██  ██       \n" +
            "\t\t\t\t\t ███ ███   ███████  ███████  ██████   ██████  ██      ██  ███████  \n" +
            RESET);
                  System.out.println(  );
                  System.out.println(  );
                  
        boolean exit = false;

        while (!exit) {
            System.out.println(Cyan + "--- Main Menu ---" + RESET);
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print(YELLOW + "Enter your choice: " + RESET);
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                if (users.size() >= MAX_USERS) {
                    System.out.println(RED + "User registration limit reached. No more users can be added." + RESET);
                    continue;
                } 
                System.out.println(Cyan + "--- Register a new user ---" + RESET);
                String newUsername;
                while (true) {
                    System.out.print(YELLOW + "Enter a new username (at least 5 characters): " + RESET);
                    newUsername = scanner.nextLine();
                    if (isValidUsername(newUsername)) {
                        break;
                    }
                    System.out.println(RED + "Username must be at least 5 characters long." + RESET);
                }
                String newPassword;
                while (true) {
                    System.out.print(YELLOW + "Enter a new password: " + RESET);
                    newPassword = scanner.nextLine();
                    if (isValidPassword(newPassword)) {
                        break;
                    }
                    System.out.println(RED + "Password must be at least 8 characters long, contain an uppercase letter, lowercase letter, a number, and a special character." + RESET);
                }
                String newEmail;
                while (true) {
                    System.out.print(YELLOW + "Enter a new email (must be a valid @gmail.com email with at least 5 characters before @): " + RESET);
                    newEmail = scanner.nextLine();
                    if (isValidEmail(newEmail)) {
                        break;
                    }
                    System.out.println(RED + "Invalid email format. Email must be at least 5 characters before @ and end with @gmail.com." + RESET);
                }
                users.add(new User(newUsername, newPassword, newEmail));
				try {
                                // Specify the audio file path
                                File audioFile = new File("Regestration.wav");
                                if (!audioFile.exists()) {
                                    System.out.println(RED + "Music file not found: Regestration.wav" + RESET);
                                    return;
                                }

                                // Prepare the audio stream
                                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                                Clip clip = AudioSystem.getClip();
                                clip.open(audioStream);

                                // Play the audio clip
                                clip.start();

                                // Wait for the clip to finish playing
                                while (!clip.isRunning()) {
                                    try {
                                        Thread.sleep(10);
                                    } catch (InterruptedException e) {
                                        System.out.println(RED + "Playback interrupted." + RESET);
                                    }
                                }
                                while (clip.isRunning()) {
                                    try {
                                        Thread.sleep(10);
                                    } catch (InterruptedException e) {
                                        System.out.println(RED + "Playback interrupted." + RESET);
                                    }
                                }
                                // Close resources
                                clip.close();
                                audioStream.close();

                            } catch (UnsupportedAudioFileException e) {
                                System.out.println(RED + "The specified audio file format is not supported." + RESET);
                            } catch (IOException e) {
                                System.out.println(RED + "Error occurred while playing the audio file." + RESET);
                            } catch (LineUnavailableException e) {
                                System.out.println(RED + "Audio line for playback is unavailable." + RESET);
                            }
                System.out.println(GREEN + "Registration successful! You can now log in with your new account." + RESET);
            } else if (choice == 2) {
                System.out.println(Cyan + "--- Please log in ---" + RESET);
                boolean loggedIn = false;
                while (!loggedIn) {
                    System.out.print(YELLOW + "Enter username: " + RESET);
                    String inputUsername = scanner.nextLine();
                    System.out.print(YELLOW + "Enter password: " + RESET);
                    String inputPassword = scanner.nextLine();
                    for (User user : users) {
                        if (user.getUsername().equals(inputUsername) && user.getPassword().equals(inputPassword)) {
                            System.out.println(GREEN + "\nLogin successful!\n" + RESET);
                            new PlaySound("success.wav").start();
                            loggedIn = true;
                            
                            while (true) {
                                System.out.println("1. Exit");
                                System.out.println("2. Continue");
                                System.out.print(YELLOW + "Enter your choice: " + RESET);
                                int option = scanner.nextInt();
                                scanner.nextLine();
                                if (option == 2) {
                                    exit = true;
                                    break;
                                } else if (option == 1) {
                                  
				    System.out.print(GREEN+"Exiting the application. Good byeeeeeee!"+RESET);				
                                     return;
                                   // System.out.println(GREEN + "Continuing..." + RESET);
                                    //return;
                                } else {
                                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
                                }
                            }
                            break;
                        }
                    }
                    if (!loggedIn) {
                        System.out.println(RED + "Incorrect username or password. Please try again.\n" + RESET);
                    }
                }
            } else if (choice == 3) {
                System.out.println(GREEN + "Exiting the application. Good byeeeeeee!" + RESET);
                exit = true;
				return;
            } else {
                System.out.println(RED + "Invalid choice. Please try again." + RESET);
            }
        }
       // City selection with switch-case
System.out.println(Cyan + "--- Choose Your Travel Route ---"+RESET);
System.out.println(YELLOW +"Available cities:"+ RESET);
System.out.println("1. Agra");
System.out.println("2. Delhi");
System.out.println("3. Visakhapatnam");
System.out.println("4. Hyderabad");
System.out.println("5. Mumbai");
System.out.println("6. Exit");

String startingCity = "";
String destinationCity = "";
// Select starting city
System.out.print(YELLOW + "Enter the number corresponding to your starting city: "+RESET);
int startingCityChoice = scanner.nextInt();
scanner.nextLine(); // Consume newline
switch (startingCityChoice) {
    case 1:
        startingCity = "Agra";
        break;
    case 2:
        startingCity = "Delhi";
        break;
    case 3:
        startingCity = "Visakhapatnam";
        break;
    case 4:
        startingCity = "Hyderabad";
        break;
    case 5:
        startingCity = "Mumbai";
        break;
   case 6:
        startingCity = "Exit";
        System.out.print(GREEN+"Exiting the application. Good byeeeeee"+RESET);
        return;

        default:
        System.out.println(RED + "Invalid choice for starting city. Please restart the application."+RESET);
        return;
}
// Select destination city
System.out.print(YELLOW+ "Enter the number corresponding to your destination city: "+RESET);
int destinationCityChoice = scanner.nextInt();
scanner.nextLine(); // Consume newline
switch (destinationCityChoice) {
    case 1:
        destinationCity = "Agra";
        break;
    case 2:
        destinationCity = "Delhi";
        break;
    case 3:
        destinationCity = "Visakhapatnam";
        break;
    case 4:
        destinationCity = "Hyderabad";
        break;
    case 5:
        destinationCity = "Mumbai";
        break;
    case 6:
        destinationCity = "Exit";
        System.out.print(GREEN+"Exiting the application. Good byeeeeee"+RESET);
        return;

    default:
        System.out.println(RED+ "Invalid choice for destination city. Please restart the application."+RESET);
        return;
}
// Calculate distance and proceed
int distance = getDistance(startingCity, destinationCity);
if (distance == -1) {
    System.out.println(RED + "\nInvalid route. Please restart the application."+RESET );
    return;
}
        if (distance == -1) {
            System.out.println(RED +"\nInvalid cities entered. Please restart the application and enter valid cities."+RESET);
        } else {
            System.out.println(Cyan +"\n--- Your travel route: ---"+RESET );
            System.out.println(YELLOW +"Starting City: "+ RESET + startingCity);
            System.out.println(YELLOW+"Destination City: " +RESET + destinationCity);
            System.out.println(YELLOW + "Distance: "+RESET  + distance + " km");
            // Recommend transport
            System.out.println(Cyan +"\n--- Available Modes of Transport: ---"+RESET);
            String recommendedTransport;
            double busRate = 1.5;    // Cost per km for Bus in INR
            double trainRate = 1.0;  // Cost per km for Train in INR
            double flightRate = 5.0; // Cost per km for Flight in INR
            if (distance < 200) {
                recommendedTransport = "Bus";
                m1=distance * busRate;
                m2=distance * trainRate;
                m3=distance * flightRate;

                System.out.println("1."+GREEN + " Bus (Recommended) - Estimated Cost: " +RESET + (distance * busRate) + " INR");
                System.out.println("2."+GREEN+ " Train - Estimated Cost: " + RESET + (distance * trainRate) + " INR");
                System.out.println("3."+GREEN + " Flight - Estimated Cost: " + RESET + (distance * flightRate) + " INR");
                System.out.println("4."+GREEN + " Exit "+RESET+RED+"don't exit stay connected......!"+RESET );

            } else if (distance <= 800) {
                recommendedTransport = "Train";
                m1=distance * busRate;
                m2=distance * trainRate;
                m3=distance * flightRate;



                System.out.println("1."+GREEN +" Bus - Estimated Cost: " + RESET +(distance * busRate) + " INR");
                System.out.println("2."+GREEN + " Train (Recommended) - Estimated Cost: "+RESET  + (distance * trainRate) + " INR");
                System.out.println("3."+GREEN + " Flight - Estimated Cost: " +RESET + (distance * flightRate) + " INR");
                System.out.println("4."+GREEN + " Exit "+RESET+RED+"don't exit stay connected......!"+RESET );


            } else if(distance > 800){
                recommendedTransport = "Flight";
                m1=distance * busRate;
                m2=distance * trainRate;
                m3=distance * flightRate;

                System.out.println("1."+GREEN+ " Bus - Estimated Cost: " +RESET + (distance * busRate) + " INR");
                System.out.println("2."+GREEN+ " Train - Estimated Cost: " + RESET+ (distance * trainRate) + " INR");
                System.out.println("3."+GREEN+ " Flight (Recommended) - Estimated Cost: " + RESET+(distance * flightRate) + " INR");
                System.out.println("4."+GREEN + " Exit "+RESET+RED+"don't exit stay connected.....!"+RESET );

            }
            else {
                recommendedTransport = "Exit";
                System.out.print("4."+GREEN+"Exit"+RESET);
                return ;
                }

            System.out.print(YELLOW+"Choose your mode of transport (1/2/3/4): "+RESET);
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            String transport;
            switch (choice) {
                case 1:
                    transport = "Bus";
                    break;
                case 2:
                    transport = "Train";
                    break;
                case 3:
                    transport = "Flight";
                    break;
                case 4:
                    transport = "Exit";
                    System.out.print(GREEN+"Exiting the application"+RESET);
                    return;

                default:
                    transport = recommendedTransport;
                    break;
            }

            // Display tourist spots
            System.out.println(Cyan+"\n ---Top Tourist Spots in " + destinationCity + ": ---"+RESET);
            displayTouristSpots(destinationCity);
	    	System.out.println(YELLOW +"choose your place :"+RESET);
		int x = scanner.nextInt();
		if(x==1)
		{
			            System.out.println(Cyan+"\n --- Local Transport Options to Tourist Spots: ---"+RESET);
          			  displayLocalTransport(destinationCity, transport,1);
		}
		else if(x==2)
		{
			            System.out.println(Cyan+"\n ---Local Transport Options to Tourist Spots: ---"+RESET);
          			  displayLocalTransport(destinationCity, transport,2);
		}
		else if(x==3)
		{
			            System.out.println(Cyan+"\n ---Local Transport Options to Tourist Spots: ---"+RESET);
          			  displayLocalTransport(destinationCity, transport,3);
		}
		else if(x==4)
		{
			            System.out.println(GREEN+"Exiting the application"+RESET);
			            return;
          			 
		}
		    
		           System.out.println(Cyan+"\n--- Available Tourist Guides for  " + destinationCity  + ": ---"+RESET);
                   System.out.println(getTouristGuideContact(destinationCity));
                   System.out.print(YELLOW+"Enter the number (1, 2, or 3 ,4) to select a guide: "+RESET);
                  int guideChoice = scanner.nextInt();
                   switch (guideChoice)
                   {
                     case 1:
                       displayGuideDetails(destinationCity, 1);
                         break;
                       case 2:
                      displayGuideDetails(destinationCity, 2);
                          break;
                       case 3:
                     displayGuideDetails(destinationCity, 3);
                          break;
                     case 4:
                      displayGuideDetails(destinationCity, 4);
                          System.out.print(GREEN+"Exiting the application"+RESET);
                          return;
                     default:
                          System.out.println("Invalid choice. Please select 1, 2, or 3 ,4.");
                     break;
                   }

        }
           
            double balance1 = 5000.0;
        double localTransportCharge = 100.0;
       // System.out.print("enter city 1, 2 ,3");
        String destinationCity1 = "city3";
        double distance1;
        double busRate = 5, trainRate = 1.0, flightRate = 5.0;
        double travelCost;

        switch (destinationCity1) {
            case "city1": distance1 = 150; break;
            case "city2": distance1 = 500; break;
            case "city3": distance1 = 1000; break;
            default: System.out.println("Unknown destination. Please restart."); return;
        }

       
		System.out.println(getTouristGuideContact(destinationCity));
		  System.out.print(YELLOW+"Enter the following number to re-conform the guide: "+RESET);
                  int guideChoice = scanner.nextInt();
				  
        double guideCharge = chooseGuideCharge(destinationCity, guideChoice);
        double totalCost = generatePaymentBill(destinationCity, distance1, busRate, trainRate, flightRate, guideCharge, localTransportCharge);

        while (balance1 < totalCost) {
            System.out.println(RED+"Insufficient balance!"+RESET+ YELLOW+"Your balance is "+RESET + balance1 + " INR.");
            System.out.print(YELLOW+"Enter deposit amount: "+RESET);
            double depositAmount = scanner.nextDouble();
            balance1 += depositAmount;
            System.out.println(Cyan+"New Balance: "+RESET + balance1 + " INR");
        }

        System.out.println(GREEN+"\nSelect Payment Method:"+RESET);
        System.out.println("1. PhonePe");
        System.out.println("2. GPay");
        System.out.println("3. Paytm");
        System.out.println("4. Exit");
        System.out.print(YELLOW+"Enter option (1/2/3/4): "+RESET);
        int paymentMethod = scanner.nextInt();

        switch (paymentMethod) {
            case 1: processUPIPayment(scanner, "PhonePe", 4); break;
            case 2: processUPIPayment(scanner, "GPay", 6); break;
            case 3: processUPIPayment(scanner, "Paytm", 4); break;
            case 4: System.out.println("............................Exiting payment method................................."); return;
            default: System.out.println(RED+"Invalid option. Payment canceled."+RESET); 
            return;
        }

        balance1 -= totalCost;
        System.out.println( YELLOW+"Remaining Balance: "+RESET + balance1 + " INR");
    
          System.out.println(Cyan+ "\n---- Tourist Spot Feedback ----" + RESET);
        collectUserFeedback(destinationCity);

        System.out.println(Cyan + "\n ***** Thank you for using the India Tourism App! Have a safe journey! *****"+RESET);
		try {
                                // Specify the audio file path
                                File audioFile = new File("Thankyou.wav");
                                if (!audioFile.exists()) {
                                    System.out.println(RED + "Music file not found: Thankyou.wav" + RESET);
                                    return;
                                }

                                // Prepare the audio stream
                                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                                Clip clip = AudioSystem.getClip();
                                clip.open(audioStream);

                                // Play the audio clip
                                clip.start();

                                // Wait for the clip to finish playing
                                while (!clip.isRunning()) {
                                    try {
                                        Thread.sleep(10);
                                    } catch (InterruptedException e) {
                                        System.out.println(RED + "Playback interrupted." + RESET);
                                    }
                                }
                                while (clip.isRunning()) {
                                    try {
                                        Thread.sleep(10);
                                    } catch (InterruptedException e) {
                                        System.out.println(RED + "Playback interrupted." + RESET);
                                    }
                                }

                                // Close resources
                                clip.close();
                                audioStream.close();

                            } catch (UnsupportedAudioFileException e) {
                                System.out.println(RED + "The specified audio file format is not supported." + RESET);
                            } catch (IOException e) {
                                System.out.println(RED + "Error occurred while playing the audio file." + RESET);
                            } catch (LineUnavailableException e) {
                                System.out.println(RED + "Audio line for playback is unavailable." + RESET);
                            }
    
    }
    private static int getDistance(String startingCity, String destinationCity) 
	{
        if (startingCity.equalsIgnoreCase("Delhi"))
			{
            switch (destinationCity.toLowerCase()) 
			{
                case "agra": return 230;
                case "hyderabad": return 1550;
                case "visakhapatnam": return 1750;
                case "Exit": return 0;
                default: return -1;
            }
        } 
		else if (startingCity.equalsIgnoreCase("Agra")) {
            switch (destinationCity.toLowerCase()) {
                case "delhi": return 230;
                case "hyderabad": return 1250;
                case "visakhapatnam": return 1440;
                case "mumbai": return 1200;
                case "Exit": return 0;
                default: return -1;
            }
        } else if (startingCity.equalsIgnoreCase("Hyderabad")) {
            switch (destinationCity.toLowerCase()) {
                case "delhi": return 1550;
                case "agra": return 1250;
                case "visakhapatnam": return 600;
                case "mumbai": return 700;
                case "Exit": return 0 ;
                default: return -1;
            }
        } else if (startingCity.equalsIgnoreCase("Visakhapatnam")) {
            switch (destinationCity.toLowerCase()) {
                case "delhi": return 1750;
                case "agra": return 1440;
                case "hyderabad": return 600;
                case "mumbai": return 1600;
                case "Exit": return 0;
                default: return -1;
            }
        } else if (startingCity.equalsIgnoreCase("Mumbai")) {
            switch (destinationCity.toLowerCase()) {
                case "delhi": return 1400;
                case "agra": return 1200;
                case "hyderabad": return 700;
                case "visakhapatnam": return 1600;
                case "Exit": return 0;
                default: return -1;
            }
        } else {
            return -1;
        }
    }
    private static void displayTouristSpots(String city)
   {
        if (city.equalsIgnoreCase("Agra")) {
            System.out.println("1- Taj Mahal");
            System.out.println("2- Agra Fort");
            System.out.println("3- Fatehpur Sikri");
            System.out.println("4- Exit");
        } else if (city.equalsIgnoreCase("Delhi")) {
            System.out.println("1- India Gate");
            System.out.println("2- Red Fort");
            System.out.println("3- Qutub Minar");
            System.out.println("4- Exit");
        } else if (city.equalsIgnoreCase("Hyderabad")) {
            System.out.println("1- Charminar");
            System.out.println("2- Golconda Fort");
            System.out.println("3- Ramoji Film City");
            System.out.println("4- Exit");
        } else if (city.equalsIgnoreCase("Visakhapatnam")) {
            System.out.println("1- RK Beach");
            System.out.println("2- Kailasagiri");
            System.out.println("3- Araku Valley");
            System.out.println("4- Exit");
        } else if (city.equalsIgnoreCase("Mumbai")) {
            System.out.println("1- Gateway of India");
            System.out.println("2- Marine Drive");
            System.out.println("3- Elephanta Caves");
            System.out.println("4- Exit");
        } else {
            System.out.println(RED+"No tourist spots found for this city."+RESET);
        }
     }
 


   private static void displayLocalTransport(String city, String transport,int x)
  {
	Scanner scanner = new Scanner(System.in);
    double autoRate = 10.0; // Cost per km for Auto-rickshaw in INR
    double taxiRate = 20.0; // Cost per km for Taxi in INR
    double metroRate = 5.0; // Cost per km for Metro in INR
    int approximateDistance = 10; // Approximate distance in km to tourist spots

    if (city.equalsIgnoreCase("Delhi")) {
        if (transport.equalsIgnoreCase("Bus")) {
	    if(x==1)
	    {
		            System.out.println(GREEN+"India Gate:"+RESET+ "Taxi or Metro from Bus Station");
            		System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR, Metro - " + (approximateDistance * metroRate) + " INR");
		
            }
	    if(x==2)
	    {
	         System.out.println(GREEN+"Red Fort:"+RESET+" Taxi from Bus Station");
            	 System.out.println(GREEN+"Estimated Cost:"+RESET+ "Taxi - " + (approximateDistance * taxiRate) + " INR");
 
		
            }
	    if(x==3)
	    {
           	System.out.println(GREEN+"Qutub Minar:"+RESET +"Metro from Bus Station");
            	System.out.println(GREEN+"Estimated Cost:"+RESET+" Metro - " + (approximateDistance * metroRate) + " INR");	
            }

        } else         if (transport.equalsIgnoreCase("Train")) {
	    if(x==1)
	    {
		            System.out.println(GREEN+"India Gate:"+RESET+ "Taxi or Metro from Bus Station");
            		System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR, Metro - " + (approximateDistance * metroRate) + " INR");
		
            }
	    if(x==2)
	    {
	         System.out.println(GREEN+"Red Fort:"+RESET+" Taxi from Bus Station");
            	 System.out.println(GREEN+"Estimated Cost:"+RESET+ "Taxi - " + (approximateDistance * taxiRate) + " INR");
 
		
            }
	    if(x==3)
	    {
           	System.out.println(GREEN+"Qutub Minar:"+RESET +"Metro from Bus Station");
            	System.out.println(GREEN+"Estimated Cost:"+RESET+" Metro - " + (approximateDistance * metroRate) + " INR");	
            }

        } else         if (transport.equalsIgnoreCase("Flight")) {
	    if(x==1)
	    {
		            System.out.println(GREEN+"India Gate:"+RESET+ "Taxi or Metro from Bus Station");
            		System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR, Metro - " + (approximateDistance * metroRate) + " INR");
		
            }
	    if(x==2)
	    {
	         System.out.println(GREEN+"Red Fort:"+RESET+" Taxi from Bus Station");
            	 System.out.println(GREEN+"Estimated Cost:"+RESET+ "Taxi - " + (approximateDistance * taxiRate) + " INR");
 
		
            }
	    if(x==3)
	    {
           	System.out.println(GREEN+"Qutub Minar:"+RESET +"Metro from Bus Station");
            	System.out.println(GREEN+"Estimated Cost:"+RESET+" Metro - " + (approximateDistance * metroRate) + " INR");	
            }

	}
    }
	else if (city.equalsIgnoreCase("Agra")) {
        if (transport.equalsIgnoreCase("Bus")) {
	    if(x==1)
	    {
            System.out.println(GREEN+"Taj Mahal:"+RESET+" Auto-rickshaw or Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
	    }
	    if(x==2)
	    {
            System.out.println(GREEN+"Agra Fort:"+RESET+"Cycle-rickshaw or Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
	    }
	    if(x==3)
	    {
            System.out.println(GREEN+"Fatehpur Sikri:"+RESET+" Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR");
            }
            //totalCost += (2 * approximateDistance * autoRate);
        } else if (transport.equalsIgnoreCase("Train")) {

            if(x==1)
	    {
            System.out.println(GREEN+"Taj Mahal:"+RESET+" Auto-rickshaw or Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
	    }
	    if(x==2)
	    {
            System.out.println(GREEN+"Agra Fort:"+RESET+"Cycle-rickshaw or Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
	    }
	    if(x==3)
	    {
            System.out.println(GREEN+"Fatehpur Sikri:"+RESET+" Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR");
            }

           // totalCost += (2 * approximateDistance * autoRate);
        } else if (transport.equalsIgnoreCase("Flight")) {

             if(x==1)
	    {
            System.out.println(GREEN+"Taj Mahal:"+RESET+" Auto-rickshaw or Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
	    }
	    if(x==2)
	    {
            System.out.println(GREEN+"Agra Fort:"+RESET+"Cycle-rickshaw or Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
	    }
	    if(x==3)
	    {
            System.out.println(GREEN+"Fatehpur Sikri:"+RESET+" Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR");
            }

            //totalCost += (3 * approximateDistance * taxiRate);
        }
    } else if (city.equalsIgnoreCase("Hyderabad")) {
        if (transport.equalsIgnoreCase("Bus")) {
	    if(x==1){
            System.out.println(GREEN+"Charminar:"+RESET+" Auto or Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==2){
            System.out.println(GREEN+"Golconda Fort:"+RESET+" Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==3){
            System.out.println(GREEN+"Ramoji Film City:"+RESET+" Bus from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+ "Bus - " + (approximateDistance * metroRate) + " INR");
		}
           // totalCost += (2 * approximateDistance * autoRate);
        } else if (transport.equalsIgnoreCase("Train")) {
	
 	    if(x==1){
            System.out.println(GREEN+"Charminar:"+RESET+" Auto or Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==2){
            System.out.println(GREEN+"Golconda Fort:"+RESET+" Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==3){
            System.out.println(GREEN+"Ramoji Film City:"+RESET+" Bus from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+ "Bus - " + (approximateDistance * metroRate) + " INR");
		}

           // totalCost += (2 * approximateDistance * autoRate);
        } else if (transport.equalsIgnoreCase("Flight")) {

           	    if(x==1){
            System.out.println(GREEN+"Charminar:"+RESET+" Auto or Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==2){
            System.out.println(GREEN+"Golconda Fort:"+RESET+" Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==3){
            System.out.println(GREEN+"Ramoji Film City:"+RESET+" Bus from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+ "Bus - " + (approximateDistance * metroRate) + " INR");
		}

          //  totalCost += (3 * approximateDistance * taxiRate);
        }
    } else if (city.equalsIgnoreCase("Visakhapatnam")) {
        if (transport.equalsIgnoreCase("Bus")) {
	    if(x==1){
            System.out.println(GREEN+"RK Beach:"+RESET+" Auto or Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==2){
            System.out.println(GREEN+"Kailasagiri:"+RESET+" Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==3)
	    {
            System.out.println(GREEN+"Araku Valley:"+RESET+" Bus from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Bus - " + (approximateDistance * metroRate) + " INR");
            }
           // totalCost += (2 * approximateDistance * autoRate);
        } else if (transport.equalsIgnoreCase("Train")) {
	
            if(x==1){
            System.out.println(GREEN+"RK Beach:"+RESET+" Auto or Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==2){
            System.out.println(GREEN+"Kailasagiri:"+RESET+" Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==3)
	    {
            System.out.println(GREEN+"Araku Valley:"+RESET+" Bus from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Bus - " + (approximateDistance * metroRate) + " INR");
            }

          //  totalCost += (2 * approximateDistance * autoRate);
        } else if (transport.equalsIgnoreCase("Flight")) {
	
           if(x==1){
            System.out.println(GREEN+"RK Beach:"+RESET+" Auto or Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==2){
            System.out.println(GREEN+"Kailasagiri:"+RESET+" Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==3)
	    {
            System.out.println(GREEN+"Araku Valley:"+RESET+" Bus from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Bus - " + (approximateDistance * metroRate) + " INR");
            }

          //  totalCost += (3 * approximateDistance * taxiRate);
        }
    } else if (city.equalsIgnoreCase("Mumbai")) {
        if (transport.equalsIgnoreCase("Bus")) {
		
	    if(x==1){
            System.out.println(GREEN+"Gateway of India:"+RESET+" Taxi or Auto from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==2){
            System.out.println(GREEN+"Marine Drive:"+RESET+" Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==3){
            System.out.println(GREEN+"Elephanta Caves:"+RESET+"Ferry from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+"Ferry - " + (approximateDistance * metroRate) + " INR");
		}
          //  totalCost += (2 * approximateDistance * autoRate);
        } else if (transport.equalsIgnoreCase("Train")) {

            if(x==1){
            System.out.println(GREEN+"Gateway of India:"+RESET+" Taxi or Auto from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==2){
            System.out.println(GREEN+"Marine Drive:"+RESET+" Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==3){
            System.out.println(GREEN+"Elephanta Caves:"+RESET+"Ferry from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+"Ferry - " + (approximateDistance * metroRate) + " INR");
		}

          //  totalCost += (2 * approximateDistance * autoRate);
        } else if (transport.equalsIgnoreCase("Flight")) {
		
            if(x==1){
            System.out.println(GREEN+"Gateway of India:"+RESET+" Taxi or Auto from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Auto - " + (approximateDistance * autoRate) + " INR, Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==2){
            System.out.println(GREEN+"Marine Drive:"+RESET+" Taxi from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+" Taxi - " + (approximateDistance * taxiRate) + " INR");
		}
	    if(x==3){
            System.out.println(GREEN+"Elephanta Caves:"+RESET+"Ferry from Bus Station");
            System.out.println(GREEN+"Estimated Cost:"+RESET+"Ferry - " + (approximateDistance * metroRate) + " INR");
		}

           // totalCost += (3 * approximateDistance * taxiRate);
        }
    }
    else {
        System.out.println(RED+"No local transport options found for this city.                             "+RESET);
    }
}
    public static String getTouristGuideContact(String city) {
        String guideOptions = " ";

        // Format the guide options to align the names, numbers, and prices neatly
        String guideFormat = "%-3s %-20s %-15s %-10s\n";

        switch (city.toLowerCase()) {
            case "agra":
                guideOptions = String.format(guideFormat, "1.", "Mr. Sharma", "(+91-9876543210)", "1500 INR") +
                               String.format(guideFormat, "2.", "Ms. Kajal", "(+91-9876543220)", "1800 INR") +
                               String.format(guideFormat, "3.", "Mr. pushpa", "(+91-9876543230)", "2000 INR")+
                               String.format(guideFormat, "4.", "Exit", " ", " ");
                break;
            case "delhi":
                guideOptions = String.format(guideFormat, "1.", "Mr. prabhas", "(+91-9876543211)", "1200 INR") +
                               String.format(guideFormat, "2.", "Mr. Ram", "(+91-9876543222)", "1400 INR") +
                               String.format(guideFormat, "3.", "Ms. Rajii", "(+91-9876543233)", "1600 INR")+
                               String.format(guideFormat, "4.", "Exit", " ", " ");
                break;
            case "hyderabad":
                guideOptions = String.format(guideFormat, "1.", "Mr. Nitish", "(+91-9876543230)", "1000 INR") +
                               String.format(guideFormat, "2.", "Mr. Dhoni", "(+91-9876543240)", "1200 INR") +
                               String.format(guideFormat, "3.", "Mr. Iyer", "(+91-9876543250)", "1300 INR")+
                               String.format(guideFormat, "4.", "Exit", " ", " ");
                break;
            case "visakhapatnam":
                guideOptions = String.format(guideFormat, "1.", "Mr. Sachin", "(+91-9876543241)", "800 INR") +
                               String.format(guideFormat, "2.", "Mr. Kumar", "(+91-9876543251)", "1000 INR") +
                               String.format(guideFormat, "3.", "Ms. Shreya", "(+91-9876543261)", "1100 INR")+
                               String.format(guideFormat, "4.", "Exit", " ", " ");
                break;
            case "mumbai":
                guideOptions = String.format(guideFormat, "1.", "Mr. Virat", "(+91-9876543250)", "1500 INR") +
                               String.format(guideFormat, "2.", "Mr. Hardik", "(+91-9876543260)", "1700 INR") +
                               String.format(guideFormat, "3.", "Mr. Rohit", "(+91-9876543270)", "2000 INR")+
                               String.format(guideFormat, "4.", "Exit", " ", " ");
                               
                break;
            case "Exit":
                System.out.print("Exit");
                return " ";
            default:
                guideOptions = "No guide options found for this city.";
                break;
        }

        return guideOptions;
    } 
    public static void displayGuideDetails(String destinationCity, int guideNumber)
    {
        String guideName = "";
        String guideContact = "";
        String guidePrice = "";




        switch (destinationCity.toLowerCase()) 
        {
            case "agra":
                if (guideNumber == 1) {
                    guideName = "Mr. Sharma";
                    guideContact = "(+91-9876543210)";
                    guidePrice = "1500 INR";
                } else if (guideNumber == 2) {
                    guideName = "Ms. Kajal";
                    guideContact = "(+91-9876543220)";
                    guidePrice = "1800 INR";
                } else if (guideNumber == 3) {
                    guideName = "Mr. pushpa";
                    guideContact = "(+91-9876543230)";
                    guidePrice = "2000 INR";
                }
                break;
            case "delhi":
                if (guideNumber == 1) {
                    guideName = "Mr. Prabhas";
                    guideContact = "(+91-9876543211)";
                    guidePrice = "1200 INR";
                } else if (guideNumber == 2) {
                    guideName = "Mr. Ram";
                    guideContact = "(+91-9876543222)";
                    guidePrice = "1400 INR";
                } else if (guideNumber == 3) {
                    guideName = "Ms. Rajii";
                    guideContact = "(+91-9876543233)";
                    guidePrice = "1600 INR";
                }
                break;
            case "hyderabad":
                if (guideNumber == 1) {
                    guideName = "Mr. Nithish";
                    guideContact = "(+91-9876543230)";
                    guidePrice = "1000 INR";
                } else if (guideNumber == 2) {
                    guideName = "Mr. Dhoni";
                    guideContact = "(+91-9876543240)";
                    guidePrice = "1200 INR";
                } else if (guideNumber == 3) {
                    guideName = "Mr. Iyer";
                    guideContact = "(+91-9876543250)";
                    guidePrice = "1300 INR";
                }
                break;
            case "visakhapatnam":
                if (guideNumber == 1) {
                    guideName = "Mr. Sachin";
                    guideContact = "(+91-9876543241)";
                    guidePrice = "800 INR";
                } else if (guideNumber == 2) {
                    guideName = "Mr. Kumar";
                    guideContact = "(+91-9876543251)";
                    guidePrice = "1000 INR";
                } else if (guideNumber == 3) {
                    guideName = "Ms. Shreya";
                    guideContact = "(+91-9876543261)";
                    guidePrice = "1100 INR";
                }
                break;
            case "mumbai":
                if (guideNumber == 1) {
                    guideName = "Mr. Virat";
                    guideContact = "(+91-9876543250)";
                    guidePrice = "1500 INR";
                } else if (guideNumber == 2) {
                    guideName = "Mr. Hardik";
                    guideContact = "(+91-9876543260)";
                    guidePrice = "1700 INR";
                } else if (guideNumber == 3) {
                    guideName = "Mr. Rohit";
                    guideContact = "(+91-9876543270)";
                    guidePrice = "2000 INR";
                }
                break;
            default:
                System.out.println(RED+ "No guide found for the selected city."+RED);
                return;
        }

        // Display the selected guide's details
        System.out.println(YELLOW+"\nSelected Guide Details:"+RESET);
        System.out.println(GREEN +"Name: "+RESET + guideName);
        System.out.println(GREEN+"Contact: "+RESET + guideContact);
        System.out.println(GREEN+"Price: "+RESET + guidePrice);
    }
	
	
	
	
	
	
	
	
	
    public static void processUPIPayment(Scanner scanner, String method, int pinLength) {
        System.out.print("Enter your " + method + " UPI PIN (" + pinLength + " digits): ");
        String pin = scanner.next();
        if (pin.length() == pinLength) {
            System.out.println(method +GREEN+"  Payment Successful!"+RESET);
        } else {
            System.out.println("Invalid PIN. Payment Failed.");
            System.exit(0);
        }
    }

     public static double chooseGuideCharge(String destinationCity, int guideNumber) {
    switch (destinationCity.toLowerCase()) {
        case "agra":
            if (guideNumber == 1) return 1500.0;
            if (guideNumber == 2) return 1800.0;
            if (guideNumber == 3) return 2000.0;
            break;
        case "delhi":
            if (guideNumber == 1) return 1200.0;
            if (guideNumber == 2) return 1400.0;
            if (guideNumber == 3) return 1600.0;
            break;
        case "hyderabad":
            if (guideNumber == 1) return 1000.0;
            if (guideNumber == 2) return 1200.0;
            if (guideNumber == 3) return 1300.0;
            break;
        case "visakhapatnam":
            if (guideNumber == 1) return 800.0;
            if (guideNumber == 2) return 1000.0;
            if (guideNumber == 3) return 1100.0;
            break;
        case "mumbai":
            if (guideNumber == 1) return 1500.0;
            if (guideNumber == 2) return 1700.0;
            if (guideNumber == 3) return 2000.0;
            break;
        default:
            return 250.0;  // Default charge for unknown cities or invalid guide numbers
    }
    return 250.0; // Return default charge if no valid guide is found
}

    public static double generatePaymentBill(String destinationCity1, double distance1, double busRate, double trainRate, double flightRate, double guideCharge, double localTransportCharge) {
        String transportMode;
        double travelCost;

        if (distance1 < 200) {
            transportMode = "Bus";
            travelCost = m1;
        } else if (distance1 <= 800) {
            transportMode = "Train";
            travelCost = m2;
        } else {
            transportMode = "Flight";
            travelCost = m3;
        }

        double totalCost = travelCost + guideCharge + localTransportCharge;
        System.out.println(Cyan+"\n--- Payment Bill ---"+RESET);
        System.out.println(GREEN+"Destination City: "+RESET + destinationCity1);
        System.out.println(GREEN+"Transport Mode: "+RESET + transportMode);
        System.out.println(GREEN+"Travel Cost: "+RESET + travelCost + " INR");
        System.out.println(GREEN+"Guide Charge: "+RESET + guideCharge + " INR");
        System.out.println(GREEN+"Local Transport Charge: "+RESET + localTransportCharge + " INR");
        System.out.println(GREEN+"Total Payable: "+RESET + totalCost + " INR");
        return totalCost;
    }

    private static void collectUserFeedback(String city) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(YELLOW+"Rate your experience in " + city + " on a scale of 1-5:"+RESET);
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (rating < 1 || rating > 5) {
            System.out.println(RED + "Invalid rating. Please rate between 1 and 5." + RESET);
            return;
        }
               System.out.println(YELLOW+"suggestions for improvement:"+RESET);
        String suggest = scanner.nextLine();

        System.out.println(Cyan+ "\nThank you for your feedback!" + RESET);
        System.out.println(GREEN+"Rating: "+RESET+ rating + "/5");
        System.out.println(GREEN+"Feedback Noted");
    }
}
 
    
 