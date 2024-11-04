package generics.classes;

//amacımız: farklı data tipindeki ürün kodlarını tutabilmek için
//ayrı ayrı classlar oluşturmadan (book, phone, laptop,...)
//tek bir class ile ürün objelerini oluşturmak
//ÇÖZÜM : Generic Class olusturalım

/*
        E --> Element, collection gibi yapılarda kullanılır
        K --> Key
        V --> Value
        N --> Number
        T --> Type
        S,U,V , vb --> 2., 3. ve 4. tipler için
      */

public class GenericProduct<T> {
    private T code; // T: herhangi bir NON-PRIMITIVE data turu olabilir

    //getter-setter

    public T getCode() {
        return code;
    }

    public void setCode(T code) {
        this.code = code;
    }
}



