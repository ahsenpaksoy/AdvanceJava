package threads.multiThreading;
    /*
    bazı threadlerin main thread ve diğer threadlerden önce çalışmasını ve işini
    tamamladıktan sonra diğer threadlerin kaldığı yerden devam etmesini istediğimizde
    CountDownLatch classının metodları ile öncelik vermek istediğimiz
    threadlerin(worker threads) sayısı kadar bir sayaç başlatıp sayaç 0 olana kadar
    diğer threadler bekletilebilir.
     */

import java.util.concurrent.CountDownLatch;

public class C09_CountDownLatch {
    public static void main(String[] args) {

        System.out.println("Burada main thread basladi...");

        CountDownLatch latch=new CountDownLatch(3);
        //öncelik vermek istediğimiz thread sayısı ile sayaç oluşturuyoruz

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Öğrencinin bilgileri alınıyor...");
                System.out.println("Öğrencinin numarası üretiliyor..");
                //hemzemin gecit
                try {
                    latch.await(); //thread1, worker threadler isini bitirene kadar, sayac 0 olana kadar bekler
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Öğrenci kaydediliyor.....");
            }
        });
        thread1.start();

        System.out.println("Main thread devam ediyor...");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await(); //thread2 worker lari bekler
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Öğrencinin düzeyine göre sorular hazırlanıyor...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread2.start();

        //seviye belirlemek için 3 tane thread
        WorkerThreads worker1=new WorkerThreads("writing",6000,latch);
        WorkerThreads worker2=new WorkerThreads("reading",5000,latch);
        WorkerThreads worker3=new WorkerThreads("speaking",3000,latch);
        worker1.start();
        worker2.start();
        worker3.start();
        //worker lar kendi aralarinda asenkron : yine yaris halinde

        try {
            latch.await();
            //thread1.join();
            //thread2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread devam ediyor...son satir");

    }
}
class WorkerThreads extends Thread{

    public int duration;
    public CountDownLatch latch;

    //paramli const

    public WorkerThreads(String name, int duration, CountDownLatch latch) {
        super(name); //new Thread(String name) parent const kullandik
        this.duration = duration;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " calismaya basladi....");
        System.out.println("Seviye tespiti yapiliyor....");
        try {
            Thread.sleep(this.duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " seviye tespitini tamamladi...");
        latch.countDown(); //sayaci bir azaltir
    }
}







