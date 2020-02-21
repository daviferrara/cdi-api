package com.gorila.cdi.restservice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CDIRetriver {

    static HashMap<Date,Double> cdiValues = null;
    static SimpleDateFormat csvDtFormat = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat restDtFormat = new SimpleDateFormat("yyyyMMdd");
    static Response response;

    static Response get(String dt1, String dt2)  {
        Date dtIni = null;
        Date currDt =null;

        try {
            dtIni = restDtFormat.parse(dt1);
            currDt = restDtFormat.parse(dt2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        synchronized (CDIRetriver.class){
            if (cdiValues == null || cdiValues.size() == 0) {
                readCSV();
            }
        }

        List<Price> prices = new ArrayList<Price>();
        for (Date dt: cdiValues.keySet()){
            if (dt.compareTo(dtIni) == 1
                 && dt.compareTo(currDt )==-1   ){
                prices.add(new Price(dt,cdiValues.get(dt)));
            }
        }
        return new Response(prices);
    }

    static void readCSV(){
        InputStream in  = CDIRetriver.class.getClassLoader().getResourceAsStream("CDI_Prices.csv");
        String line = "";
        cdiValues=new HashMap<Date,Double>();
        try {
            BufferedReader br= new BufferedReader(new InputStreamReader(in));
            br.readLine(); //HEADER
            while ((line=br.readLine())!=null){
                String[] data =  line.split(",");
                Date dt = csvDtFormat.parse(data[1]);
                Double value = Double.parseDouble(data[2]);
                cdiValues.put(dt,value);
            }
        }catch (Exception e ){

        }
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(get ("20191015","20191102"  ));
    }
}
