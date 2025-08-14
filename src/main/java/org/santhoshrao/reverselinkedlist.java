package org.santhoshrao;
import java.util.Scanner;
public class reverselinkedlist{
    // node class for playlist
    static class node {
        String name;
        node next;
        node(String name){
            this.name = name;
            this.next = null;
        }
    }

    static node head = null; // first song
    // adding song at end
    public static void addsong(String songname){
        node newnode = new node(songname);
        if(head == null){
            head = newnode;
        } else {
            node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newnode;
        }
        System.out.println("song added: " + songname);
    }
    // reversing linked list in-place
    public static void reverse(){
        node prev = null;
        node current = head;
        node nextnode;

        while(current != null){
            nextnode = current.next;   // saving next
            current.next = prev;       // reversing link
            prev = current;            // moving prev ahead
            current = nextnode;        // moving current ahead
        }
        head = prev; // new head
        System.out.println("playlist reversed");
    }
    // showing all songs
    public static void showsongs(){
        if(head == null){
            System.out.println("playlist empty");
            return;
        }
        System.out.println("playlist songs:");
        node temp = head;
        while(temp != null){
            System.out.println(temp.name);
            temp = temp.next;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n1. add song");
            System.out.println("2. reverse playlist");
            System.out.println("3. show playlist");
            System.out.println("4. exit");
            System.out.print("enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // remove newline

            switch(choice){
                case 1:
                    System.out.print("enter song name: ");
                    String addname = sc.nextLine();
                    addsong(addname);
                    break;
                case 2:
                    reverse();
                    break;
                case 3:
                    showsongs();
                    break;
                case 4:
                    System.out.println("exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("invalid choice");
            }
        }
    }
}
