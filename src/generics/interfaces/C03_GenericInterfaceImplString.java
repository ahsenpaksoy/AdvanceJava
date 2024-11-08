package generics.interfaces;

//2. SECENEK Generic Interface in hangi deger olduguna karar verilir
//2.SEÇENEK:Generic interface i implemente ederken data tipine karar verebiliriz

public class C03_GenericInterfaceImplString implements C01_GenericInterface<String>{  // T : generic ifade
    @Override
    public void print(String value) {

    }

    @Override
    public String find() {
        return null;
    }
}
