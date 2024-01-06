import java.util.*;

public class PatientAppointmentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clinic clinic = new Clinic();

        while (true) {
            System.out.println("Welcome to the Small Clinic Appointment Management System\n");
            System.out.println("1. View Visitors List");
            System.out.println("2. Add New Visitor");
            System.out.println("3. Edit Visitor Details");
            System.out.println("4. View Appointment Schedule for a Day");
            System.out.println("5. Book an Appointment");
            System.out.println("6. Edit/Cancel Appointment");
            System.out.println("7. Exit\n");

            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // View Visitors List
                    System.out.println("Visitors List:");
                    for (Visitor visitor : clinic.getVisitors()) {
                        System.out.println("Name: " + visitor.getName() + ", Age: " + visitor.getAge() +
                                ", Phone Number: " + visitor.getPhoneNumber() +
                                ", Appointment Date: " + visitor.getAppointmentDate() +
                                ", Appointment Time: " + visitor.getAppointmentTime());
                    }
                    break;
                case 2:
                    // Add New Visitor
                    Visitor newVisitor = new Visitor();
                    System.out.print("Enter Visitor's Name: ");
                    newVisitor.setName(scanner.nextLine());

                    System.out.print("Enter Visitor's Age: ");
                    newVisitor.setAge(scanner.nextInt());
                    scanner.nextLine();

                    System.out.print("Enter Visitor's Phone Number: ");
                    newVisitor.setPhoneNumber(scanner.nextLine());

                    System.out.print("Select Appointment Date (DD-MM-YYYY): ");
                    newVisitor.setAppointmentDate(scanner.nextLine());

                    System.out.println("Available Time Slots:\n1. 09:00 AM - 10:00 AM\n2. 11:00 AM - 12:00 PM");
                    System.out.print("Select Time Slot: ");
                    int timeSlotChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (timeSlotChoice == 1) {
                        newVisitor.setAppointmentTime("09:00 AM - 10:00 AM");
                    } else if (timeSlotChoice == 2) {
                        newVisitor.setAppointmentTime("11:00 AM - 12:00 PM");
                    } else {
                        System.out.println("Invalid time slot choice.");
                        break;
                    }

                    clinic.addVisitor(newVisitor);
                    System.out.println("Visitor " + newVisitor.getName() + "'s appointment on " +
                            newVisitor.getAppointmentDate() + " at " + newVisitor.getAppointmentTime() +
                            " has been booked.");
                    break;
                case 3:
                    // Edit Visitor Details
                    System.out.print("Enter Visitor's Name to Edit: ");
                    String oldName = scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Phone Number: ");
                    String newPhoneNumber = scanner.nextLine();

                    clinic.editVisitorDetails(oldName, newName, newAge, newPhoneNumber);
                    break;
                case 4:
                    // View Appointment Schedule for a Day
                    System.out.print("Enter Appointment Date (DD-MM-YYYY): ");
                    String appointmentDate = scanner.nextLine();
                    clinic.viewAppointmentSchedule(appointmentDate);
                    break;
                case 5:
                    // Book an Appointment
                    System.out.print("Enter Visitor's Name: ");
                    String bookName = scanner.nextLine();

                    System.out.print("Enter Visitor's Age: ");
                    int bookAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Visitor's Phone Number: ");
                    String bookPhoneNumber = scanner.nextLine();

                    System.out.print("Select Appointment Date (DD-MM-YYYY): ");
                    String bookAppointmentDate = scanner.nextLine();

                    System.out.println("Available Time Slots:\n1. 09:00 AM - 10:00 AM\n2. 11:00 AM - 12:00 PM");
                    System.out.print("Select Time Slot: ");
                    int bookTimeSlotChoice = scanner.nextInt();
                    scanner.nextLine();

                    String bookAppointmentTime;
                    if (bookTimeSlotChoice == 1) {
                        bookAppointmentTime = "09:00 AM - 10:00 AM";
                    } else if (bookTimeSlotChoice == 2) {
                        bookAppointmentTime = "11:00 AM - 12:00 PM";
                    } else {
                        System.out.println("Invalid time slot choice.");
                        break;
                    }

                    clinic.bookAppointment(bookName, bookAge, bookPhoneNumber, bookAppointmentDate, bookAppointmentTime);
                    break;
                case 6:
                    // Edit/Cancel Appointment
                    System.out.print("Enter Visitor's Name: ");
                    String editCancelName = scanner.nextLine();

                    System.out.println("Available Time Slots:\n1. 09:00 AM - 10:00 AM\n2. 11:00 AM - 12:00 PM");
                    System.out.print("Select New Time Slot: ");
                    int editCancelTimeSlotChoice = scanner.nextInt();
                    scanner.nextLine();

                    String editCancelNewAppointmentTime;
                    if (editCancelTimeSlotChoice == 1) {
                        editCancelNewAppointmentTime = "09:00 AM - 10:00 AM";
                    } else if (editCancelTimeSlotChoice == 2) {
                        editCancelNewAppointmentTime = "11:00 AM - 12:00 PM";
                    } else {
                        System.out.println("Invalid time slot choice.");
                        break;
                    }

                    clinic.editCancelAppointment(editCancelName, editCancelNewAppointmentTime);
                    break;
                case 7:
                    // Exit
                    System.out.println("Exiting the Appointment Management System. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}

class Visitor {
    private String name;
    private int age;
    private String phoneNumber;
    private String appointmentDate;
    private String appointmentTime;

    // Getter and setter methods for encapsulation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}

class Clinic {
    private List<Visitor> visitors = new ArrayList<>();

    // Add a new visitor
    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }
        public List<Visitor> getVisitors() {
        return visitors;
    }

    // Edit visitor details
    public void editVisitorDetails(String oldName, String newName, int newAge, String newPhoneNumber) {
        for (Visitor visitor : visitors) {
            if (visitor.getName().equals(oldName)) {
                visitor.setName(newName);
                visitor.setAge(newAge);
                visitor.setPhoneNumber(newPhoneNumber);
                System.out.println("Visitor details updated successfully.");
                return;
            }
        }
        System.out.println("Visitor not found.");
    }

    // View appointment schedule for a day
    public void viewAppointmentSchedule(String appointmentDate) {
        System.out.println("Appointment Schedule for " + appointmentDate + ":");
        for (Visitor visitor : visitors) {
            if (visitor.getAppointmentDate().equals(appointmentDate)) {
                System.out.println(visitor.getName() + " - " + visitor.getAppointmentTime());
            }
        }
    }

    // Book an appointment
    public void bookAppointment(String name, int age, String phoneNumber, String appointmentDate, String appointmentTime) {
        Visitor visitor = new Visitor();
        visitor.setName(name);
        visitor.setAge(age);
        visitor.setPhoneNumber(phoneNumber);
        visitor.setAppointmentDate(appointmentDate);
        visitor.setAppointmentTime(appointmentTime);
        visitors.add(visitor);
        System.out.println("Appointment booked successfully.");
    }

    // Edit/Cancel appointment
    public void editCancelAppointment(String name, String newAppointmentTime) {
        for (Visitor visitor : visitors) {
            if (visitor.getName().equals(name)) {
                visitor.setAppointmentTime(newAppointmentTime);
                System.out.println("Appointment updated successfully.");
                return;
            }
        }
        System.out.println("Visitor not found.");
    }
}
