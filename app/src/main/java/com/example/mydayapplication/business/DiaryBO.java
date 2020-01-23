package com.example.mydayapplication.business;

import com.example.mydayapplication.model.MainResponse;

import java.util.ArrayList;

public class DiaryBO {

    //This function is to get all diary data using api in card view

    public ArrayList<MainResponse> getAllDiaryData() {

        ArrayList<MainResponse> mainResponseArrayList = new ArrayList<>(1);
        MainResponse mainResponse = new MainResponse();
        mainResponse.getId();
        mainResponse.getDate();
        mainResponse.getTitle();
        mainResponse.getDescription();
        mainResponseArrayList.add(mainResponse);

        return mainResponseArrayList;
    }


    /*This function is a sample hardcoded diary data to test card view
     *After api for main response recived use getAllDiaryData*/
 /*  public List<DiaryRequest> getAllDiaryData(){

       List<DiaryRequest> diaryList = new ArrayList<>(2);

       DiaryRequest diaryRequest = new DiaryRequest();
       diaryRequest.setUserId(1);
       diaryRequest.setDate("14 Dec 2019");
       diaryRequest.setTitle("Good Day");
       diaryRequest.setDesc("The day was so good.I had implemented....");
       //diaryRequest.setExpense(2500);
       diaryList.add(diaryRequest);

       DiaryRequest diaryRequest1 = new DiaryRequest();
       diaryRequest1.setUserId(1);
       diaryRequest1.setDate("15 Dec 2019");
       diaryRequest1.setTitle("Interview");
       diaryRequest1.setDesc("Today I went to a company for an interview....");
       //diaryRequest1.setExpense(2500);
       diaryList.add(diaryRequest1);

       DiaryRequest diaryRequest2= new DiaryRequest();
       diaryRequest2.setUserId(1);
       diaryRequest2.setDate("16 Dec 2019");
       diaryRequest2.setTitle("Sick");
       diaryRequest2.setDesc("It was very hard to handle yesterday. I'm totally tired....");
       //diaryRequest.setExpense(2500);
       diaryList.add(diaryRequest2);

       DiaryRequest diaryRequest3= new DiaryRequest();
       diaryRequest3.setUserId(1);
       diaryRequest3.setDate("17 Dec 2019");
       diaryRequest3.setTitle("Christmas Crib");
       diaryRequest3.setDesc("Today we stared the crib work. Stars and lights were purchased....");
       //diaryRequest.setExpense(2500);
       diaryList.add(diaryRequest3);

       DiaryRequest diaryRequest4= new DiaryRequest();
       diaryRequest4.setUserId(1);
       diaryRequest4.setDate("18 Dec 2019");
       diaryRequest4.setTitle("Transfered Bank Account");
       diaryRequest4.setDesc("Transferred the bank account from Thrissur to Ernakulam....");
       //diaryRequest.setExpense(2500);
       diaryList.add(diaryRequest4);

       DiaryRequest diaryReque= new DiaryRequest();
       diaryReque.setUserId(1);
       diaryReque.setDate("19 Dec 2019");
       diaryReque.setTitle("Test Scroll View");
       diaryReque.setDesc("Transferred the bank account from Thrissur to Ernakulam....");
       //diaryRequest.setExpense(2500);
       diaryList.add(diaryReque);

       return diaryList;
   }*/
}

