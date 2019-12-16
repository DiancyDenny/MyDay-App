package com.example.mydayapplication.business;

import com.example.mydayapplication.model.DiaryRequest;

import java.util.ArrayList;

public class DiaryBO {

   public ArrayList<DiaryRequest> getAllDiaryData(){

       ArrayList<DiaryRequest>  diaryList = new ArrayList<>(2);

       DiaryRequest diaryModel = new DiaryRequest();
       diaryModel.setDate("23 Nov 2019");
       diaryModel.setTitle("Good Day");
       diaryModel.setDesc("The day was....");
       //diaryModel.setExpense(2500);
       diaryList.add(diaryModel);

       DiaryRequest diaryModel2 = new DiaryRequest();
       diaryModel2.setDate("23 Nov 2019");
       diaryModel2.setTitle("Good Day");
       diaryModel2.setDesc("The day was....");
      // diaryModel2.setExpense(2500);
       diaryList.add(diaryModel2);

       return diaryList;

   }
}


  /* static String[] nameArray = {"Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice Cream Sandwich","JellyBean", "Kitkat", "Lollipop", "Marshmallow"};
    static String[] versionArray = {"1.5", "1.6", "2.0-2.1", "2.2-2.2.3", "2.3-2.3.7", "3.0-3.2.6", "4.0-4.0.4", "4.1-4.3.1", "4.4-4.4.4", "5.0-5.1.1","6.0-6.0.1"};

    static Integer[] drawableArray = {R.drawable.ic_attach_file_black_24dp, R.drawable.ic_attach_file_black_24dp, R.drawable.ic_attach_file_black_24dp,
            R.drawable.ic_attach_file_black_24dp, R.drawable.ic_attach_file_black_24dp, R.drawable.ic_attach_file_black_24dp, R.drawable.ic_attach_file_black_24dp,
            R.drawable.ic_attach_file_black_24dp, R.drawable.ic_attach_file_black_24dp, R.drawable.ic_attach_file_black_24dp,R.drawable.ic_attach_file_black_24dp};

    static Integer[] id_ = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; */
