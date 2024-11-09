package threads.multiThreading;

public class C07_Volatile {

    public static volatile int flag=0;
    //volatile: sadece flag değişkeninin main memoryden okunmasını ve yazılmasını garanti eder.

    public static void main(String[] args) {

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
               // int sayac = 0;
                while (flag==0){
                   // sayac++;
                    System.out.println("Bu sadece bir RİSK!");
                }
                //  System.out.println("işlem gerceklesene kadar yazdıgı sayı : "+sayac);
            }
        });
        thread1.start();//1.çekirdek, cache:flag=0

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag=1;
                System.out.println("Flag değişkenin değeri değişti.");

            }
        });
        thread2.start();//2.çekirdek, cache:flag=1

    }
}