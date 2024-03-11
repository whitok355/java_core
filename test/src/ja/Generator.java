package ja;

import java.util.Random;

public class Generator {
    static String generateNumberAccount(){
        Random rn = new Random();
        String numb = "";
        for(int i = 0; i < 4; i++){
            for(int p = 0 ; p < 4; p++){
                numb += rn.nextInt(0, 9);
            }
            if(i < 3){
                numb += "-";
            }
        }
        return numb;
    }
}
