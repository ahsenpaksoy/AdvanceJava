package enumTypes;

//1-uygulamada icerdigi karakterlere göre password gücü belirlenir:HIGH,MEDIUM,LOW
//2-kullanıcıya mesaj verilecek:
//LOW:Dikkat şifreniz yetersiz seviyededir!!!
//MEDIUM : Şifrenizin güçü orta sevidedir.
//HIGH : Tebrikler, şifre gücünüz yüksek seviyededir:)

public class Runner {

    public static void main(String[] args) {

        //String str="high";//
        //String str2="HIGH";
        //System.out.println(str.toUpperCase());
        //System.out.println(str2.equals(str.toUpperCase()));//false

    }

    //kullanıcıya paramterde verilen password gücüne gore
    //mesaj gonderen bir method olusturalım

    public static void printMesage(String strength){
        if (strength.equals(PasswordStrength.LOW)){
            System.out.println("Dikkat şifreniz yetersiz seviyededir!!!");
        } else if (strength.equals(PasswordStrength.MEDIUM)) {
            System.out.println("Şifrenizin güçü orta sevidedir.");
        } else if (strength.equals(PasswordStrength.HIGH)) {
            System.out.println("Tebrikler, şifre gücünüz yüksek seviyededir☺");
        }
    }

    //kullanıcıya parametre olarak enum type ile verilen password gucune gore
    //mesaj gonderen bir method olusturalım

}





