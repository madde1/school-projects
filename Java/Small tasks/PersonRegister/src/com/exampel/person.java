package com.exampel;

 public class person {

    private String name;
    private String age;
    private String adress;
    private String phoneNumber;

 public person( String name, String age, String adress, String phoneNumber){
     this.name = name;
     this.age = age;
     this.adress = adress;
     this.phoneNumber = phoneNumber;
 }
public String Personinfo(){
     String persText = "\n Namn: " + name + "\n Ålder: " + age + "\n Adress: " + adress + "\n Telefonnummer: " + phoneNumber;
     return persText;
}
}
