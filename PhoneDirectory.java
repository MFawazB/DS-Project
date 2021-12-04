import java.util.*;

class PhoneBook{
    class Contact{
        String first_name;
        String last_name;
        String phone_num;

        Contact link;
        Contact(String fname, String lname, String number) {
            first_name = fname;
            last_name = lname;
            phone_num= number;
            this.link = null;
    }
}
Contact last= null;

//displaying the list of contacts
void display() {
    System.out.println("\t\t[Phone Directory]\n\t_________________________________\t");
    System.out.println("First Name         Last Name         Number");
    System.out.println("***********      *************     ***********");
    if(last == null) {
        System.out.println("No phone records Found!!");
        return;
    } else {
        Contact temp = last.link;
        do {
            System.out.println(temp.first_name + "\t           " + temp.last_name + "\t         " + temp.phone_num);
            temp = temp.link;
        } while (temp != last.link);
    }
}

//adding a contact
void addContact(String fname, String lname, String number) {
    Contact newcontact = new Contact(fname,lname,number);
    if(last == null) {
        last = newcontact;
        newcontact.link = last;
    } else {
        newcontact.link= last.link;
        last.link = newcontact;
    }
}

//deleting a contact
void deleteContact(String key) {
    if(last == null) {
        System.out.println("Phone Directory is empty");
        return;
    } else {
        Contact cur = last.link;
        String space = " ";
        do {
            if(key.equals(cur.link.first_name.concat(space.concat(cur.link.last_name)))) {
                cur.link = cur.link.link;
                break;
            }
            cur = cur.link;
        } while(cur != last.link);
    }
}

//search a contact
void searchContact(String key) {
    if(last == null) {
        System.out.println("Phone Directory is empty");
    } else {
        Contact cur = last.link;
        String space = " ";
        do {
            if(key.equals(cur.first_name.concat(space.concat(cur.last_name)))) {
                System.out.println("Contact : " + cur.phone_num);
                break;
            }
            cur = cur.link;
        } while(cur != last.link);
    }
}

//change the first name of a given contact
void changeFname(String fullname, String name) {
    if(last == null) {
        System.out.println("Phone Directory is empty");
    } else {
        Contact cur = last.link;
        String space = " ";
        do {
            if(fullname.equals(cur.first_name.concat(space.concat(cur.last_name)))) {
                cur.first_name = name;
                break;
            }
            cur = cur.link;
        } while(cur != last.link);
    }
}

//change the last name of a given contact
void changeLname(String fullname, String name) {
    if(last == null) {
        System.out.println("Phone Directory is empty");
    } else {
        Contact cur = last.link;
        String space = " ";
        do {
            if(fullname.equals(cur.first_name.concat(space.concat(cur.last_name)))) {
                cur.last_name = name;
                break;
            }
            cur = cur.link;
        } while(cur != last.link);
    }
}

//change the name of a given contact
void changeNum(String fullname, String number) {
    if(last == null) {
        System.out.println("Directory empty");
    } else {
        Contact cur = last.link;
        String space = " ";
        do {
            if(fullname.equals(cur.first_name.concat(space.concat(cur.last_name)))) {
                cur.phone_num = number;
                break;
            }
            cur = cur.link;
        } while(cur != last.link);
    }
}
}
//main class
public class PhoneDirectory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PhoneBook p1 = new PhoneBook();
        Boolean flag = true;

        System.out.println("Welcome to the Phone Directory!!!");
        while(flag) {
            System.out.println("Please select your option");
            System.out.println("1.View the directory\n2.Add Contact\n3.Delete a Contact\n4.Search Contact\n5.Change First name\n6.Change Last name\n7.Change Contact Number\n8.Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1: 
                    p1.display();
                    break;
                
                case 2:
                    System.out.println("Enter the First name:");
                    String fn = sc.nextLine();
                    System.out.println("Enter the Last name:");
                    String ln = sc.nextLine();
                    System.out.println("Enter the number");
                    String num = sc.nextLine();
                    p1.addContact(fn, ln, num);
                    System.out.println("Number Added Successfully!");
                    break;
                
                case 3:
                    System.out.println("Enter the Full name of the Contact");
                    String dl = sc.nextLine();
                    p1.deleteContact(dl);
                    System.out.println("Contact Deleted Successfully!");
                    break;

                case 4:
                    System.out.println("Enter Full name of the Contact");
                    String src = sc.nextLine();
                    p1.searchContact(src);
                    break;

                case 5:
                    System.out.println("Enter Full name of the Contact");
                    String rep = sc.nextLine();
                    System.out.println("Enter the new first name");
                    String ne = sc.nextLine();
                    p1.changeFname(rep, ne);
                    break;

                case 6:
                    System.out.println("Enter Full name of the Contact");
                    String re = sc.nextLine();
                    System.out.println("Enter the new Last name");
                    String neww = sc.nextLine();
                    p1.changeLname(re, neww);
                    break;

                case 7:
                    System.out.println("Enter Full name of the contact");
                    String r = sc.nextLine();
                    System.out.println("Enter the new number");
                    String n= sc.nextLine();
                    p1.changeNum(r, n);
                    break;
                    
                case 8:
                    System.out.println("Thank You for using the directory!");
                    flag = false;
                    break;

                default :System.out.println("Invalid choice. Please Enter valid choice");
            };
        }
        sc.close();
    }
}
