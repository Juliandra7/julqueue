/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.queue;
import java.util.Scanner;
/**
 *
 * @author Andra
 */
class simpul{
   String barang;
   int harga;
   simpul prev,next;
   simpul(String b,int h){barang=b; harga =h;}
}
class queue{
    simpul front,rear;
    queue(){front=rear=null;}
    void enqueue(simpul baru){
        if(rear==null){
            front=rear=baru;
        }
        else{
            rear.prev=baru;
            baru.next=rear;
            rear=baru;
        }
        System.out.println("enqueue sukses....");
    }
    simpul dequeue(){
        simpul t=null;
        if(front==null){
            System.out.println("queue kosong!");
        }
        else if(front.prev==null){
            t=front;
            front=rear=null;
            System.out.println("dequeue sukses....");
        }
        else{
            t=front;
            simpul temp=front.prev;
            front.prev=null;
            temp.next=null;
            front=temp;
            System.out.println("dequeue sukses....");
        }
    return t;
    }
    void view(){
        System.out.println("isi queue");
        for(simpul t=rear; t!=null; t=t.next) {
            System.out.println(t.barang+" ["+t.harga+"]");
        }
        System.out.println("");
    }
}
public class appQueue {
    public static void main(String[] args) {
        simpul s = new simpul("sepatu",200000);
        queue q = new queue();
        Scanner sc = new Scanner(System.in);

        q.enqueue(s); q.view();
        s = new simpul("tas",150000);

        int pilih = 0;
        int pemasukan = 0; //variabel pemasukan toko

        do {
            System.out.println("Antrian pembelian");
            System.out.println("1. Enqueue\n2. Dequeue");
            System.out.println("3. View\n4. Exit");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();

            switch(pilih) {
                case 1:
                    System.out.println("Daftar Barang");
                    System.out.println("1. Sepatu\n2. Tas\n3. Sandal");
                    System.out.print("Pilih = ");
                    int pilih2 = sc.nextInt();
                    switch(pilih2){
                        case 1:
                            s = new simpul("sepatu", 200000);
                            break;
                        case 2:
                            s = new simpul("tas", 150000);
                            break;
                        case 3:
                            s = new simpul("sandal", 100000);
                            break;    
                        default:
                            System.out.println("Pilihan tidak tersedia");
                            continue;
                    }
                    q.enqueue(s);
                    break;

                case 2:
                    simpul t = q.dequeue();
                    if(t != null){
                        System.out.println("Check out: " + t.barang);
                        pemasukan += t.harga; // tambahkan ke pemasukan
                    } else 
                        System.out.println("Queue kosong...");
                        System.out.println("Pemasukan saat ini: " + pemasukan);
                    break;

                case 3:
                    q.view();
                    int total = 0;
                    for (simpul temp = q.front; temp != null; temp = temp.prev){
                        total += temp.harga;
                    }
                    System.out.println("Total Transaksi dalam Antrian: " + total);
                    System.out.println("Total Pemasukan dari Dequeue: " + pemasukan);
                    break;

                case 4:
                    System.out.println("Thanks....");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while(pilih != 4);
    }
}
