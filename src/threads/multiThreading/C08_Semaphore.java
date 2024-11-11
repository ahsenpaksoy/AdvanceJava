package threads.multiThreading;

import java.util.concurrent.Semaphore;
/*
Semaphore, asiri yuklenmeyi onlemek icin n tane(2,3,4....) aynı anda ortak bir kaynağa erişmesine
izin vermemizi sağlar.Orn:Asansor

Synchronized, birden fazla thread ayni anda ortak bir kaynaga SADECE 1 thread in erismesine
izin vermemizi saglar.Örn:kabin
 */

public class C08_Semaphore {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(4); //4 thread e izin veriyorum
        Car car1 = new Car("Audi",8000,semaphore);
        Car car2 = new Car("Toyota",5000,semaphore);
        Car car3 = new Car("BMW",2000,semaphore);
        Car car4 = new Car("Opel",1000,semaphore);
        Car car5 = new Car("Skoda",9000,semaphore);
        Car car6 = new Car("Honda",3000,semaphore);
        Car car7 = new Car("Mercedes",6000,semaphore);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start(); //main thread haric 7 tane aktif thread var

    }
}

class Car extends Thread{

    public String carName;
    public int duration;
    public Semaphore semaphore; //sinirli kapasitenin izinlerini takip etmek icin kullanicaz gorevli yani

    //paramli cons

    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println(this.carName + " park etmek istiyor");
        //burada baska kodlar
        try {
            semaphore.acquire(); //ortak kaynaga erisim iznini kontrol ediyor. gorevlinin elindeki izin belgesi
            //ortak kaynagin baslangici(veritabani baglantisi ile ilgili isler)
            //Bir thread bir semaphor'den izin almak için acquire() metodunu çağırır.
            //Eğer izin mevcutsa, iş parçacığı bu izni alır ve çalışmaya başlar. Eğer izin yoksa, thread izin alana kadar bekler.
            System.out.println("---> " + this.carName + " park alanina girdi....");
            Thread.sleep(duration);
            System.out.println("<---" + this.carName + " park alanindan cikiyor...");
            //ortak kaynagin sonu
            semaphore.release(); //izin belgesi serbest birakilir,musait alan sayisi arttirilir.
                                 //release methodu cagrildiysa baska bir thread girebilir
            // İş parçacığı işini tamamladığında, izni serbest bırakmak için release() metodunu çağırır,
            // böylece başka bir iş parçacığı bu izni alabilir.

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //burada baska kodlar

    }
}








