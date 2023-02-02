package veri_maskeleme;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class Regex {
    
    // Etiketleme fonksiyonu
    public static String etiketle(String metinParam ,String regexParam ,String etiketParam) {
        
        String metin=metinParam;
        String newData="";
        String etiket=etiketParam;

        String regex=regexParam;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(metin);
        List<Integer> l2 = new ArrayList<Integer>();
        ArrayList<String> l3 = new ArrayList<String>();

        while (matcher.find())
        {

          l2.add(matcher.start()); // index leri depolamak için arraylere atıyoruz
          l2.add(matcher.end());

        }

        if(l2.size() >= 2){
            l3.add(metin.substring(0,l2.get(0))); //ilk plakadan önceki kısım eklenir
            l3.add(etiket);
            int i;
            for(i=1 ; i<l2.size()-2 ; i=i+2){
                l3.add(metin.substring(l2.get(i),l2.get(i+1)));  // 2 plaka nın arası eklenir
                l3.add(etiket); // plaka yazısı eklenir    
            }

            l3.add(metin.substring(l2.get((l2.size())-1))); // son plakadan sonraki kısım eklenir

            String res = String.join(newData, l3); //liste sitringe dönüştürülür.

            return res;
        }
        else{
            return metin;
        }
    }
    
    public static String Regex_Maskeleme (String metin) {
        
        //String metin = "burada plaka olabilir :BI-GH-1245. demin  vardı burdada mail var bide şuraya koyalım ,52 es 671. , benim tarih .17.04.2000, , benim tc ise ,18398673904, , pasaport numaramıda eklim :1234567890ABC1234567A1234567<<<<<<<<<<<<<<12. , kredi kartı numaramda bu :3454 6556 7875 5634. telefon numaramadıda eklim 05467447615 son olarak instagram caloglumehmet ";
        String regexmail = "(?=[:.,\\ ]+|\\b)[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}(?=[,.\\ ]+|\\b)"; //kapsamlı email i bulan regex kodları
        String regextc ="(?=[:.,\\ ]+|\\b)[1-9]{1}[0-9]{9}[02468]{1}(?=[.,\\ ]+|\\b)";
        String regexbank ="(?=[:,.\\ ]+|\\b)([0-9]{4})\\s?([0-9]{4})\\s?([0-9]{4})\\s?([0-9]{4})(?=[.,\\ ]+|\\b)";
        String regextarih = "(?=[:,.\\ ]+|\\b)(?:19\\d{2}|20[0-9][0-9]|2020)[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])(?=[.,\\ ]+|\\b)|(?=[.,\\ ]+|\\b)(?:0[1-9]|[12][0-9]|3[01])[-/.](?:0[1-9]|1[012])[-/.](?:19\\d{2}|20[0-9][0-9]|2020)(?=[.,\\ ]+|\\b)|(?=[.,\\ ]+|\\b)(?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])[-/.](?:19\\d{2}|20[0-9][0-9]|2020)(?=[.,\\ ]+|\\b)";
        String regexpasaport = "(?=[:,.\\ ]+|\\b)[A-Z0-9<]{9}[0-9]{1}[A-Z]{3}[0-9]{7}[A-Z]{1}[0-9]{7}[A-Z0-9<]{14}[0-9]{2}(?=[.,\\ ]+|\\b)";
        String regextelefon ="(?=[:,.\\ \\+]+|\\b)(?:(?:\\+90|0090|0)[\\ -]?)?(?:(?<ac>21[26]|22[2468]|23[26]|24[268]|25[268]|26[246]|27[246]|28[2468]|31[28]|32[2468]|33[28]|34[2468]|35[2468]|36[2468]|37[02468]|38[02468]|392|41[246]|42[2468]|43[2468]|44[26]|45[2468]|46[246]47[2468]|48[2468]|50[1567]|51[02]|52[27]|5[34]\\d|55[1234569]|56[124]|59[246]|800|811|822|850|8[89]8|900)|)[\\ -]*(?<sn1>\\d{3})[\\ -]*(?<sn2>\\d{2})[\\ -]*(?<sn3>\\d{2})(?=[:,.\\ ]+|\\b)";
        String regexplaka="((?=[:,.\\ ]+|\\b)(0[1-9]|[1-7][0-9]|8[01])((\\s?[a-zA-Z]\\s?)(\\d{4,5})|(\\s?[a-zA-Z]{2}\\s?)(\\d{3,4})|(\\s?[a-zA-Z]{3}\\s?)(\\d{2,3}))(?=[.,\\ ]+|\\b))|(?=[:,.\\ ]+|\\b)([A-Z]{1,3}[- ][A-Z]{1,2}[- ][0-9]{1,4})(?=[.,\\ ]+|\\b)";


        metin=etiketle(metin,regexmail,"[E-MAIL]");
        metin=etiketle(metin,regextc,"[TC KİMLİK NO]");
        metin=etiketle(metin,regexbank,"[BANKA KARTI NO]");
        // Doğum, evlilik tarihi gibi özel tarihler 
        metin=etiketle(metin,regextarih,"[TARİH]");
        metin=etiketle(metin,regexpasaport,"[PASAPORT NO]");
        metin=etiketle(metin,regexplaka,"[PLAKA]");
        metin=etiketle(metin,regextelefon,"[TELEFON NO]");
        
        return metin;
    }
    
}