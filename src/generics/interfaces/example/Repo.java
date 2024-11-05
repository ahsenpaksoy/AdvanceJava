package generics.interfaces.example;

public interface Repo<T> {

    //save : reponun bu methodu farkli objeler icin kullanilmasini saglayacak.
    //farkli data tipleringe kullanilmasini ıstiyoruz

    void save(T obj);

    //find : reponun bu methodu farkli objeler icin kullanilmasini saglayacak.
    //farkli data tipleringe kullanilmasini ıstiyoruz

    T find();
}
