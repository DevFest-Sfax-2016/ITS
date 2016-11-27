package com.devfest.its.its_devfest;

import java.util.ArrayList;

/**
 * Created by jihed on 27/11/2016.
 */

public class ModelDevelopper {
    public static String names []= {"Ahmed","Dorsaf","Jihed"};
    public static  String prenoms []= {"Schhaider","Hamdouni","Messaoud"};
    public static  String email [] = {"22815521","54328695","55623778"};
    public static  String adresse [] = {"Sfax","Sfax","Sfax"};
    public static  int imgs [] = {R.drawable.ahmed,R.drawable.dorsaf,R.drawable.jii};
    public static ArrayList<Developper> getDevelopper (){
        ArrayList arrayList = new ArrayList();
        for(int i=0;i<3;i++){
            arrayList.add(new Developper(names[i],prenoms[i],email[i],imgs[i],adresse[i])) ;

        }
        return  arrayList;
    }
}
