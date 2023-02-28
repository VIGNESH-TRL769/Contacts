package org.example;

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
            String print1;
            while(temp!=null)
            {
                c++;
                print.append(c+". "+temp.name+" "+temp.phonenumber+" "+temp.emailaddress+"\n");
                temp=temp.next;
            }
            if(c==0)
            {
                Log.info("No data found.");
            }
            print1="\n"+print;
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
            String print1;
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
                Log.info("No data found..");
            }
            print1="\n"+print;
            Log.info(print1);

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
            String print1;
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
                Log.info("No data found...");
            }
            print1="\n"+print;
            Log.info(print1);

        }
    }
}
