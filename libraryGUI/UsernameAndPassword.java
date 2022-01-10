import java.util.HashMap;

public class UsernameAndPassword{
  
  HashMap<String, String> loginInfo = new HashMap<String, String>();
  
  UsernameAndPasswords(){
    //Username will be the first names of everyone in our class, and the passwords will be their last names
    loginInfo.put("Affan", "Amir");
    loginInfo.put("Diba", "Alam");
    loginInfo.put("Issac", "Barclay");
    loginInfo.put("Lathushan", "Kanthasamy");
    loginInfo.put("Maryam", "Khan");
    loginInfo.put("AJ", "Kleiman");
    loginInfo.put("Leonardo", "Lai");
    loginInfo.put("James", "Liang");
    loginInfo.put("Apinash", "Sivaganesan");
    loginInfo.put("Hilary", "Sze");
    loginInfo.put("Thomas", "Wong");
    loginInfo.put("Jason", "Ye"); 
  }  
  public HashMap getLoginInfo(){
    return logininfo; 
  }
}