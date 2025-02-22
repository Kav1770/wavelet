import java.io.IOException;
import java.net.URI;
import java.util.*;

class Handler implements URLHandler{
  ArrayList<String> strs = new ArrayList<>();

  public String handleRequest(URI url){
    if(url.getPath().equals("/")){
      String s = "";
      if(strs.size()==0){
        return "Nothing has been searched";
      }
      else{
        for(int i =0; i< strs.size(); i++){
          if(i < strs.size()-1){
            s+= strs.get(i)+", ";
          }
          else{
            s+= strs.get(i);
          }
      }
      return "The following has been added: "+s;
      }
      }
      
    
    if (url.getPath().contains("/add")) {
      String[] query = url.getQuery().split("=");
      if(query[0].equals("s")){
        strs.add(query[1]);
        return "Added " + query[1]+ " to the search engine." ;
      }
      else{
         return ("Error 404: Not Found!");
       }
    }
    else if (url.getPath().contains("/search")){
      String[] query = url.getQuery().split("=");
      if(query[0].equals("s") && query.length==2){
      ArrayList<String> searched = new ArrayList<>();
      for(int i =0; i<strs.size(); i++){
        if(strs.get(i).contains(query[1])){
          searched.add(strs.get(i));
        }
      }
      if(searched.size()==0){
        return("There are no matches");
      }
      else{ 
        String r = "";
        for(int i =0; i< searched.size(); i++){
          if(i < searched.size()-1){
            r+= searched.get(i)+", ";
          }
          else{
            r+= searched.get(i);
          }
      }
      return r;
      }
        
      }
      else{
         return ("Error 404: Not Found!");
       }
      
    }
    else{
      return("Error 404: Not Found!");
    }
  }
}
class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
 }
