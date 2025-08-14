package org.santhoshrao;
import java.util.Scanner;

public class traincoachmanager{

    // node class for coach
    static class node{
        int coachno;
        node next;
        node prev;
        node(int coachno){
            this.coachno = coachno;
            this.next = null;
            this.prev = null;
        }
    }

    static node head = null; // first coach
    static node tail = null; // last coach

    // adding coach at end
    public static void addcoach(int no){
        node newnode = new node(no);
        if(head == null){
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
        System.out.println("coach added: " + no);
    }

    // removing coach by number
    public static void removecoach(int no){
        if(head == null){
            System.out.println("train empty");
            return;
        }

        node temp = head;
        while(temp != null && temp.coachno != no){
            temp = temp.next;
        }

        if(temp == null){
            System.out.println("coach not found: " + no);
            return;
        }

        // removing node
        if(temp.prev != null){
            temp.prev.next = temp.next;
        } else {
            head = temp.next; // removing first
        }

        if(temp.next != null){
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev; // removing last
        }

        System.out.println("coach removed: " + no);
    }

    // showing coaches forward
    public static void showforward(){
        if(head == null){
            System.out.println("train empty");
            return;
        }
        System.out.println("coaches from front:");
        node temp = head;
        while(temp != null){
            System.out.print(temp.coachno + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // showing coaches backward
    public static void showbackward(){
        if(tail == null){
            System.out.println("train empty");
            return;
        }
        System.out.println("coaches from back:");
        node temp = tail;
        while(temp != null){
            System.out.print(temp.coachno + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n1. add coach");
            System.out.println("2. remove coach");
            System.out.println("3. show coaches front to back");
            System.out.println("4. show coaches back to front");
            System.out.println("5. exit");
            System.out.print("enter choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("enter coach number: ");
                    int addnum = sc.nextInt();
                    addcoach(addnum);
                    break;
                case 2:
                    System.out.print("enter coach number to remove: ");
                    int remnum = sc.nextInt();
                    removecoach(remnum);
                    break;
                case 3:
                    showforward();
                    break;
                case 4:
                    showbackward();
                    break;
                case 5:
                    System.out.println("exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("invalid choice");
            }
        }
    }
}

