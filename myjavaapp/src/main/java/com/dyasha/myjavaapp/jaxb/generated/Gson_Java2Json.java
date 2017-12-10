package com.dyasha.myjavaapp.jaxb.generated;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class Gson_Java2Json {
	public static void main(String[] args) throws IOException {
		College cmp = GenerateData.generate();
		Gson gson = new Gson();
        String json = gson.toJson(cmp);
        System.out.println(json);
        FileWriter writer2 = null;
        try  {
        	writer2 = new FileWriter("college2.json");
            gson.toJson(cmp, new FileWriter(""));
        } catch (IOException e) {
            e.printStackTrace();
        } 
	}// End of main
}// End of Class
