package org.example;
import java.util.Scanner;
import java.util.logging.Logger;
class LinkedList
{
    public static final Logger Log = Logger.getLogger(("InfoLogging"));
    Node head;
    Node tail;
    int length = 0;
    int c=0;

    LinkedList() {
        head = null;
        tail = null;
    }

    class Node
    {
        String name;
        long phonenumber;
        String emailaddress;
        Node next;

        Node(String name,long phonenumber,String emailaddress)
        {
            this.name=name;
            this.phonenumber=phonenumber;
            this.emailaddress=emailaddress;
            this.next = null;
        }
    }
    public void insert(String name,long phonenumber,String emailaddress)
    {
        Node node=new Node(name,phonenumber,emailaddress);
        if(this.head==null)
        {
            head=node;
            tail=node;

        }
        else
        {
            tail.next=node;
            tail=node;
        }
        this.length++;
        Log.info("----Your Value is Successfully Inserted----\n");
    }
    public void display()
    {
        StringBuilder print=new StringBuilder();
        Node temp=this.head;
        c=0;
        if(temp==null)
        {
            Log.info("It is empty");
        }
        else
        {
            while(temp!=null)
            {
                c++;
                print.append(c+". "+temp.name+" "+temp.phonenumber+" "+temp.emailaddress+"\n");
                temp=temp.next;
            }
            if(c==0)
            {
                Log.info("No data found");
            }
            String print1="\n"+print;
            Log.info(print1);
            print.delete(0,print1.length());
        }
    }
    public void delete(int index)
    {
        if(index==0)
        {
            this.head=this.head.next;
            this.length--;
            Log.info("-----Your Value is Successfully delete Of Index-----\n");
        }
        else if(index>=length)
        {
            Log.info("Please Enter Valid Range\n");
        }
        else
        {
            Node temp=this.head;
            Node t=temp;
            for(int i=0;i<index;i++)
            {
                t=temp;
                temp=temp.next;
            }
            t.next=temp.next;
            this.length--;
            String print="-----Your Value is Successfully delete from the Index:"+index+"-----\n";
            Log.info(print);
        }


    }
    public void search(long phonenumber)
    {
        StringBuilder print=new StringBuilder();
        Node temp=this.head;
        c=0;
        if(temp==null)
        {
            Log.info("It is empty no data found.");
        }
        else
        {
            while(temp!=null)
            {
                if(temp.phonenumber==phonenumber)
                {
                    c++;
                    print.append(c + ". " + temp.name + " " + temp.phonenumber + " " + temp.emailaddress + "\n");
                }
                temp=temp.next;
            }
            if(c==0)
            {
                Log.info("No data found");
            }
            String print1="\n"+print;
            Log.info(print1);
            print.delete(0,print1.length());
        }
    }
    public void search(String name)
    {
        StringBuilder print=new StringBuilder();
        Node temp=this.head;
        c=0;
        if(temp==null)
        {
            Log.info("It is empty no data found");
        }
        else
        {
            while(temp!=null)
            {

                if(temp.name.equals(name))
                {
                    c++;
                    print.append(c + ". " + temp.name + " " + temp.phonenumber + " " + temp.emailaddress + "\n");
                }
                temp=temp.next;
            }
            if(c==0)
            {
                Log.info("No data found");
            }
            String print1="\n"+print;
            Log.info(print1);
            print.delete(0,print1.length());
        }
    }
}

    public class Main
    {
        public static final Logger Log=Logger.getLogger(("InfoLogging"));
        public static void main(String[] args) {
            Scanner input=new Scanner(System.in);
            LinkedList linkedList=new LinkedList();
            while (true) {
                Log.info("\n1.insert\n2.delete\n3.search phonenumber\n4.search name\n5.display\n6.Exit\nEnter the choice:");
                int key = input.nextInt();
                switch (key) {
                    case 1 -> {
                        Log.info("Enter the name:");
                        String name = input.next();
                        Log.info("Enter the Phonenumber:");
                        long number=input.nextLong();
                        Log.info("Enter the email:");
                        String email=input.next();
                        linkedList.insert(name,number,email);
                    }
                    case 2 -> {
                        Log.info("Enter the index:");
                        int index=input.nextInt();
                        linkedList.delete(index);
                       
                    }
                    case 3 ->
                    {
                        Log.info("Enter the phonenumber:");
                        long phonenumber=input.nextLong();
                        linkedList.search(phonenumber);
                    }
                    case 4->{
                        Log.info("Enter the name:");
                        String name=input.next();
                        linkedList.search(name);}
                    case 5-> linkedList.display();
                    case 6 -> {
                        return;
                    }
                    default -> Log.info("Please Enter the Valid Option.");
                }
            }
        }
    }
