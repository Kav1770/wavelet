import java.io.IOException;
import java.net.URI;
import java.util.*;

class Search implements URLHandler{
  ArrayList<String> strs = new ArrayList<>();
  public String Req(URL url){
    if (url.getPath().contains("/add")) {
      String[] query = url.getQuery().split("=");
      if(query[0].equals("s"){
        strs.add(query[1]);
        return "Added " +query[i]+ " to the search engine." 
      }
       else{
         return "Error 404: Not Found!";
       }
    }
    else if (url.getPath().contains("/search")){
      ArrayList<String> searched = new ArrayList<>();
      for(int i =0; i<strs.size(); i++){
        if(strs.get(i).contains(query[1])){
          searched.add(strs.get(i));
        }
      }
      if(searched.size()==0){
        System.out.println("There are no matches");
      }
      else{ 
        for(int i =0; i< searched.size(); i++){
          if(i < searched.size()-1){
            System.out.print(searched.get(1)+ ", ");
          }
          else{
            System.out.print(searched.get(1));
          }
      }
      }
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

        Server.start(port, new Search());
    }
 }
