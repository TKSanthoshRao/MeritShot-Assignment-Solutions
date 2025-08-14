package org.santhoshrao;
import java.util.Scanner;

// node class for song
class node{
    String name;
    node next;
    node(String name){
        this.name = name;
        this.next = null;
    }
}

public class playlistmanager{
    static node head = null; // first song link
    // adding song at end
    public static void addsong(String songname){
        node newnode = new node(songname);
        if(head == null) {
            head = newnode;
        } else {
            node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newnode;
        }
        System.out.println("song added: " + songname);
    }

    // deleting song by name
    public static void deletesong(String songname){
        if(head == null) {
            System.out.println("playlist empty");
            return;
        }

        // if song is first
        if(head.name.equals(songname)){
            head = head.next;
            System.out.println("song deleted: " + songname);
            return;
        }

        node temp = head;
        while(temp.next != null && !temp.next.name.equals(songname)){
            temp = temp.next;
        }

        if(temp.next == null){
            System.out.println("song not found: " + songname);
        } else {
            temp.next = temp.next.next;
            System.out.println("song deleted: " + songname);
        }
    }
    // showing all songs
    public static void showsongs(){
        if(head == null) {
            System.out.println("playlist empty");
            return;
        }
        System.out.println("playlist songs:");
        node temp = head;
        while(temp != null) {
            System.out.println(temp.name);
            temp = temp.next;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\n1. add song");
            System.out.println("2. delete song");
            System.out.println("3. show playlist");
            System.out.println("4. exit");
            System.out.print("enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    System.out.print("enter song name: ");
                    String addname = sc.nextLine();
                    addsong(addname);
                    break;
                case 2:
                    System.out.print("enter song name to delete: ");
                    String delname = sc.nextLine();
                    deletesong(delname);
                    break;
                case 3:
                    showsongs();
                    break;
                case 4:
                    System.out.println("exiting...");
                    return;
                default:
                    System.out.println("invalid choice");
            }
        }
    }
}
