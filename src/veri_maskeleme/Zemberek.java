package veri_maskeleme;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import zemberek.morphology.TurkishMorphology;
import zemberek.ner.NerDataSet;
import zemberek.ner.NerSentence;
import zemberek.ner.PerceptronNer;

/**
 *
 * @author Miracetdin
 */
public class Zemberek {
    
    // Zemberek kütüphanesi ile maskeleme fonksiyonu
    public static String zemberek_maskeleme(String metin){
        
        Path modelKonum = Paths.get("model").toAbsolutePath();
        
        TurkishMorphology morphology = TurkishMorphology.createWithDefaults();
        PerceptronNer ner = null;
        try {
            ner = PerceptronNer.loadModel(modelKonum, morphology);
        } catch (IOException ex) {
            Logger.getLogger(Zemberek.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Etiketleme işlemi
        NerSentence result = ner.findNamedEntities(metin);
        String etiketlenmisMetin = result.getAsTrainingSentence(NerDataSet.AnnotationStyle.BRACKET);
        
        // Maskeleme işlemi
        String split[] = etiketlenmisMetin.split(" ");
        String maskelenmisMetin = null;
        for(int i=0; i<split.length; i++){
            if((i!=0) && ((split[i-1].equals("[PERSON")) || (split[i-1].equals("[LOCATION")) || (split[i-1].equals("[ORGANIZATION")))){
                int j = i;
                while(!split[j].equals("]")){
                    j++;
                }
                maskelenmisMetin += "] ";
                i = j;
            }
            else{
                maskelenmisMetin += split[i] + " ";
            }
        }
        
        maskelenmisMetin = maskelenmisMetin.replaceAll("null", "");
        maskelenmisMetin = maskelenmisMetin.replaceAll(" ]", "]");
        
        maskelenmisMetin = maskelenmisMetin.replaceAll("PERSON", "KİŞİ");
        maskelenmisMetin = maskelenmisMetin.replaceAll("LOCATION", "YER/ÜLKE/ŞEHİR");
        maskelenmisMetin = maskelenmisMetin.replaceAll("ORGANIZATION", "KURUM/KURULUŞ");
        
        maskelenmisMetin = maskelenmisMetin.replaceAll("[ ]"+"[.]", ".");
        maskelenmisMetin = maskelenmisMetin.replaceAll(" ,", ",");
        maskelenmisMetin = maskelenmisMetin.replaceAll(" ;", ";");
        maskelenmisMetin = maskelenmisMetin.replaceAll(" :", ":");
        maskelenmisMetin = maskelenmisMetin.replaceAll("[ ]"+"[...]", "...");
        maskelenmisMetin = maskelenmisMetin.replaceAll("[ ]"+"[?]", "?");
        maskelenmisMetin = maskelenmisMetin.replaceAll(" -", "-");
        maskelenmisMetin = maskelenmisMetin.replaceAll(" /", "/");
        maskelenmisMetin = maskelenmisMetin.replaceAll("“ ", "“");
        maskelenmisMetin = maskelenmisMetin.replaceAll(" ”", "”");
        maskelenmisMetin = maskelenmisMetin.replaceAll(" \'", "\'");
        maskelenmisMetin = maskelenmisMetin.replaceAll("[(]"+"[ ]", "(");
        maskelenmisMetin = maskelenmisMetin.replaceAll("[ ]"+"[)]", ")");
        maskelenmisMetin = maskelenmisMetin.replaceAll("\\[ ", "[");
        maskelenmisMetin = maskelenmisMetin.replaceAll("[ ]"+"[]]", "]");
        maskelenmisMetin = maskelenmisMetin.replaceAll("[{]"+"[ ]", "{");
        maskelenmisMetin = maskelenmisMetin.replaceAll("[ ]"+"[}]", "}");
        
        return maskelenmisMetin;
    }
}
