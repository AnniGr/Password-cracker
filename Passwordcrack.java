import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.*;
import java.lang.*;

public class PasswordCrack {

    public static ArrayList<String> dictionary = new ArrayList<>();
    public static   ArrayList<String> arraypass = new ArrayList<>();
  public static    ArrayList<String> salt = new ArrayList<>();
    public static   ArrayList<String> password = new ArrayList<>();
    public static   ArrayList<String> passa = new ArrayList<>();
    public static   ArrayList<String> toRemove = new ArrayList<>();
    public static   ArrayList<String> mangled = new ArrayList<>();
    public static   ArrayList<String> mang = new ArrayList<>();
    public static   ArrayList<String> mangreturned = new ArrayList<>();



    public static   ArrayList<String> userpass = new ArrayList<>();
    
    


    static char[] charsTotable ={'0', '1', '2', '3', '4','5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's','t', 'u', 'v', 'w', 'x', 'y', 'z','A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};


public static String crackingP(String word){

 for(int m =0; m<salt.size(); m++){
      String Salt= salt.get(m);
        String encrypted = jcrypt.crypt(Salt, word); //salt and word from the dictionary, encrypt
       //System.out.println(encrypted);
        for(int i =0; i < password.size(); i++){
            String passwords = password.get(i);
        if(passwords.contains(encrypted)){
            System.out.println(word); //skriver ut password
            toRemove.add(encrypted);
        }
    }
    }
    for(String encryptpass : toRemove){
    password.remove(encryptpass);
    }
   return word;
}


public static String toUpperCase(String word){
   
    return word.toUpperCase();
}

public static String toLowerCase( String word){
    return word.toLowerCase();
}


public static String duplicate( String word){  //duplicate tghe strings
   // System.out.println(word+word);
    return word+word;
}

public static String reflect1( String word){  //duplicate tghe strings
    // System.out.println(word+word);
     return reverse(word) + word;
 }

 public static String reflect2( String word){  //duplicate tghe strings
    // System.out.println(word+word);
     return  word + reverse(word);
 }


public static String removefirst( String word){ //remove the first character
    return word.substring(1);
}



public static String removeLastChar( String word){ //remove the last character
  String removelast = word.substring(0, word.length() -1);
  return removelast;
}


public static String capatalizeFirstLetter( String word){ 
   
    return word.substring(0,1).toUpperCase() + word.substring(1);
  }


  public static String capatalizeLastLetter( String word){ 
   
    return word.substring((word.length()-1), word.length()).toUpperCase();
  }

  public static String Upfirstandeveryotherletter(String word){
      String wordedit ="";

      for(int m =0; m<word.length(); m++){
          if(m % 2 == 0){
              wordedit += word.substring(m, m+1).toUpperCase();
          }else{
              wordedit += word.substring(m, m+1).toLowerCase();
          }
      }
     // System.out.println(wordedit);
      return wordedit;

  }

  public static String Upsecondandeveryotherletter(String word){
    String wordedit ="";

    for(int m =0; m<word.length(); m++){
        if(m % 2 != 0){
            wordedit += word.substring(m, m+1).toUpperCase();
        }else{
            wordedit += word.substring(m, m+1).toLowerCase();
        }
    }
    return wordedit;

}

public static String ncapatalize( String word){ 
   
    return word.substring(0,1).toLowerCase() + word.substring(1).toUpperCase();
  }


public static String reverse(String word){
    // System.out.println(new StringBuilder(word).reverse().toString());
     //String result = new StringBuilder(word).reverse().toString();

     byte[] temp =word.getBytes();
     byte[] res = new byte[word.length()];

     for(int m = 0; m<word.length(); m++){
         res[m] = temp[temp.length -m -1];
     }

     return new String(res);
 }
 

 public static void mangle( String word){

       

        if(word.length() != 0){ //password cant be zero 
              //mangled.add(crackingP(word));
            mangled.add(crackingP(toUpperCase(word)));
            mangled.add(crackingP(toLowerCase(word)));
            mangled.add(crackingP(reverse(word)));
      
            mangled.add(crackingP(capatalizeFirstLetter(word)));
            mangled.add(crackingP(ncapatalize(word)));
          
            

        if(word.length() <= 8){ //if word is less than 9
            mangled.add(crackingP(reflect1(word)));
            mangled.add(crackingP(reflect2(word)));
            mangled.add(crackingP(duplicate(word)));
            mangled.add(crackingP(removeLastChar(word)));
            mangled.add(crackingP(capatalizeLastLetter(word)));
        }
            mangled.add(crackingP(Upfirstandeveryotherletter(word)));
            mangled.add(crackingP(Upsecondandeveryotherletter(word)));

            mangled.add(crackingP(removefirst(word)));
    }
            
}
   public static void main(String[] args) throws IOException{

        File inputdict = null;
        File inputpass = null;

        if(2 == args.length){
            inputdict = new File(args[0]);
            inputpass = new File(args[1]);
        }else{
            System.err.println("Need to enter two arguments: " + args.length);
            System.exit(1);
        }

        BufferedReader buffread = null;
        BufferedReader buffread1 = null;

        try{
           
            String string;
             buffread = new BufferedReader(new FileReader(inputdict));
        
             while((string = buffread.readLine()) != null){
                 dictionary.add(string);
                 //System.out.println(dictionary);
             }
        
            String l;
            buffread1 = new BufferedReader(new FileReader(inputpass)); 
          
            while((l =buffread1.readLine()) != null ){
                String det[] = l.split(":");
               // System.out.println(det[1]);
              String[] spl = det[4].split(" ");

                salt.add(det[1].substring(0,2));
           
                arraypass.add(det[1].substring(2,13));
                            
                userpass.add(det[0]);
                userpass.add(det[4]);  
                userpass.add(spl[0]);
                userpass.add(spl[1]);



               //dictionary.add(spl[0].substring());

                password.add(det[1]);
            
                
                
            }
            /*  if(buffread1.readLine() == null){
                System.out.println("The passwordfile is empty");
            }*/
          
            userpass.add("123456");
            userpass.add("123456789");
            userpass.add("qwerty");
            userpass.add("password");
            userpass.add("12345678");
            userpass.add("1234");
            userpass.add("12345");
            userpass.add("iloveyou");
            userpass.add("111111");
            userpass.add("123123");
            userpass.add("abc123");
            userpass.add("qwertyuiop");
            userpass.add("fotball");
            userpass.add("admin");
            userpass.add("1q2w3e4r");
            userpass.add("654321");
            userpass.add("555555");
            userpass.add("lovely");
            userpass.add("7777777");
            userpass.add("888888");
            userpass.add("123qwe");
            userpass.add("666666");
            userpass.add("welcome");
            userpass.add("baseball");
            userpass.add("solo");
            userpass.add("starwars");
            userpass.add("monkey");
            userpass.add("letmein");
            userpass.add("1qaz2wsx");
            userpass.add("passw0rd");
            userpass.add("1234");
            userpass.add("abc123");
            userpass.add("1234567890");
            userpass.add("master");
            userpass.add("Loophole");
            userpass.add("Driftwood");
            userpass.add("Hackenbush");
            userpass.add("Devereaux");
     
        for(String word : userpass){ //mangle each word in dictionary
                mangle(word);
                }

        for(String word : dictionary){ //mangle each word in dictionary
                    crackingP(word);   
                    }
     

        for(String word : dictionary){ //mangle each word in dictionary
               mangle(word);
        

         for(String word: dictionary){
            
             for(int i = 0; i<38; i++){
                       String prepend = charsTotable[i]+ word;
                       //crackingP(prepend);
                        mangle(prepend);  
                    if(word.length() <=8){
                       String append =word + charsTotable[i];
                       //crackingP(append);
                       mangle(append);
                }}
          }
   
            } 
            catch(FileNotFoundException error){
                
               if(!inputdict.exists())
                   {System.err.println("The inputfile " + inputdict.getPath() + " does not exist.");} //om infile.txt inte existerar
                
                  
               if(!inputpass.exists()){
                   System.err.println("The inputfile " + inputpass.getPath() +" does not exist.");
               }
                System.exit(1);
               }


    finally{
         try{
                if(buffread!=null)buffread.close();
                if(buffread1!=null)buffread1.close();
      
            }catch(IOException exception){
                exception.printStackTrace();
                System.exit(1);
            }
         } 
    
}

}

