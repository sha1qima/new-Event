import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

class Event {
    
    private String eventID;
    private String eventName;
    private String eventVenue;
    private LocalDate eventDate;
    ArrayList<Attendee> eventAttendees = new ArrayList<>();

    public Event(String eventID, String eventName, String eventVenue, LocalDate eventDate,
            ArrayList<Attendee> eventAttendees) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventDate = eventDate;
        this.eventAttendees = eventAttendees;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public ArrayList<Attendee> getEventAttendees() {
        return eventAttendees;
    }

    public void setEventAttendees(ArrayList<Attendee> eventAttendees) {
        this.eventAttendees = eventAttendees;
    }

    @Override
    public String toString() {
        return "Event [eventID=" + eventID + ", eventName=" + eventName + ", eventVenue=" + eventVenue + ", eventDate="
                + eventDate + ", eventAttendees=" + eventAttendees + "]";
    }

    public void organizeEvent(int choice){
        Scanner reader =new Scanner(System.in);
        switch(choice){
            case 1:
                System.out.println("Enter the Event ID :");
                String id = reader.nextLine();
                setEventID(id);
                
                System.out.println("Enter the name of the Event:");
                String eventName = reader.nextLine();
                setEventName(eventName);
                
                System.out.println("Enter the Event date (YYYY-MM-DD):");
                LocalDate date = LocalDate.parse(reader.nextLine());
                setEventDate(date);
                
                System.out.println("Enter the venue of the Event:");
                String venue =reader.nextLine();
                setEventVenue(venue);

                break;
            case 2:
                System.out.println("How many attendees are coming?:");
                int num = reader.nextInt();
                reader.nextLine();

                for(int i=0;i<num; i++){
                    System.out.println("Enter the name of the attendee:");
                    String name = reader.nextLine();
                    
                    System.out.println("Enter the gender of the attendee:");
                    char gender = reader.nextLine().charAt(0);
                    
                    System.out.println("Enter the age of the attendee:");
                    int age = reader.nextInt();
                    reader.nextLine();

                    System.out.println("Enter the email of the attendee:");
                    String email= reader.nextLine();

                    eventAttendees.add(new Attendee(name,gender,email,age));
                }
                System.out.println("\n added successfully to the list of attendee");
                break;
            case 3:
                System.out.println("Enter the name of the attendee to remove:");
                String nameToRemove = reader.nextLine();
                
                for(Attendee attendee : eventAttendees ){
                    if(nameToRemove.equals(attendee.getName())){
                        eventAttendees.remove(attendee);
                        break;
                    }

                }
                //eventAttendees.removeIf(attendee -> attendee.getName().equals(nameToRemove));
                System.out.println("\n"+ nameToRemove + " removed successfully from the list of attendees");
                break;
            case 4:
                System.out.println("Enter the name of the attendee to update:");
                String nameToUpdate = reader.nextLine();

                for(Attendee attendee :eventAttendees){
                    if(nameToUpdate.equals(attendee.getName())){
                        
                        System.out.println("Enter the new name,or enter null if you don't want to update :");
                        String newName = reader.nextLine();
                        if(!newName.equals("null")){
                            attendee.setName(newName);

                        }

                        System.out.println("Enter the new age,or enter 0 if you don't want to update :");
                        int newAge = reader.nextInt();
                        reader.nextInt();
                        if(newAge != 0){
                            attendee.setAge(newAge);
                        }

                        System.out.println("Enter the new email,or enter null if you don't want to update :");
                        String newEmail = reader.nextLine();
                        if(!newEmail.equals("null")){
                            attendee.setEmail(newEmail);
                        }

                        System.out.println("Enter the new gender,or enter null if you don't want to update :");
                        String newGender = reader.nextLine();// "F", "null"
                        if(!newGender.equals("null")){
                            attendee.setGender(newGender.charAt(0));// "F" -> 'F'
                        }
                        
                        break;
                    }
                }
                break;
            case 5:
                System.out.println("Enter the name of the attendee to find:");
                String nameToFind = reader.nextLine();
                //boolean found = false;
                for(Attendee attendee :eventAttendees){
                    System.out.println(attendee);
                    if(attendee.getName().equals(nameToFind)){
                        System.out.println(attendee);
                        //found = true;
                        break;
                    }
                }
                /*if(found){
                    System.out.println("\n"+ nameToFind + " found in the list of attendees");
                }
                else{
                    System.out.println("\n"+ nameToFind + " not found in the list of attendees");break;
                }*/
                break;
            case 6:
                System.out.println("Here is the list of attendees:" + "\n" + eventAttendees);
                break;
            case 7:
                break;
            default:
                
        }
        reader.close();
    }
}