package threads;

public class C01_ThreadCreationWays {
    public static void main(String[] args) {

        //Her java programında default olarak 1 tane thread başlatılır : main thread
        //Thread.currentThread().getName() : mevcut threadin ismini getirmeyi sağlar
        System.out.println("Mevcut Thread : "+Thread.currentThread().getName());//main

        //Java'da thread oluşturmanın 2 farklı yolu vardır
        //run methodunu override ederek thread classını extends ederek
        //1.yol
        Thread thread1=new C02_MyThread();
        //thread1.run();//yeni bir thread başlatılmaz, main thread //method cagırdım şu an main threadde methodu cagırdım
        thread1.start();//threadi başlatmayı saglar run methodunu cagırır
        thread1.setName("Çay Getir"); //thread in adini degistirebiliriz
        //once main in thread i calisir

        //2.yol
        C03_MyRunnable runnable=new C03_MyRunnable();
        Thread thread2=new Thread(runnable);
        thread2.start();
        thread2.setName("Portakallı Kek Yap");

        //System.out.println("Main thread burada bitti. ");

        //2.YOL :anonymous class:isimsiz sınıf
        //Runnable içinde sadece 1 tane implemente edilecek metod var
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                //  try {
                //      Thread.sleep(3000);
                //  } catch (InterruptedException e) {
                //      System.out.println(e.getMessage());
                //  }

                System.out.println("Çalışan Thread : "+Thread.currentThread().getName() );
                System.out.println("anonymous class ile üretilen Thread dinlenme molasına cıktı...");
            }
        });
        thread3.start();
        thread3.setName("Dinlenen Thread");


        //2.yol Lambda exp ile
        Thread thread4=new Thread(()->{
            //run metodunun bodysindeyiz:)

            // try {
            //     Thread.sleep(3000);
            // } catch (InterruptedException e) {
            //     System.out.println(e.getMessage());
            // }

            //ben şu an'da run methodunun icerisindeyim!!!
            System.out.println("Çalışan Thread : "+Thread.currentThread().getName() );
            System.out.println("Lambda exp ile üretilen thread kahve yapmaya başlıyor...");
        });
        thread4.setName("Kahve Yapan");
        thread4.start();

        //main threadi uyutalım yani yaptıgı işlemi uzutalım
        // try {
        //     Thread.sleep(1000);
        // } catch (InterruptedException e) {
        //     System.out.println(e.getMessage());
        // }

        //join methodu hangi threadin icinde cagrılırsa bu thread ondan sonra cagrılan threadi bekletir
        try {
            thread1.join(); //hangi threadin kodları içinde çağrılırsa bu threadi bekletir:thread1 işini bitirene kadar
            thread2.join();//bekletir,thread1 bitince calışır
            thread3.join();//bekletir,thread2 bitince calışır
            thread4.join();//bekletir,thread3 bitince calışır

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } //main thread artık devam edebilir


        System.out.println("Main ile yaptığım işlem bitti."); //main thread görevi

        //NOT:her thread kendi işini(run metodu içindeki kodları) senkron(sıralı)
        //threadler kendi arasında ASENKRON çalışır.



    }


}






