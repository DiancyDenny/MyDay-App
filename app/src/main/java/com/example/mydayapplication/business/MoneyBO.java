package com.example.mydayapplication.business;

import com.example.mydayapplication.model.DiaryRequest;
import com.example.mydayapplication.model.MoneyGetResponse;
import com.example.mydayapplication.model.MoneyPostRequest;

import java.util.ArrayList;

public class MoneyBO {


    /*This function is a sample hardcoded diary data to test card view
     *After api for main response recived use getAllDiaryData*/

    public ArrayList<MoneyPostRequest> getAllMoneyData() {

        ArrayList<MoneyPostRequest> moneyList = new ArrayList<>(2);

        MoneyPostRequest moneyPostRequest = new MoneyPostRequest();
        moneyPostRequest.setUserId(1);
        moneyPostRequest.setDate("14 Dec 2019");
        moneyPostRequest.setBalance(25000);
        moneyPostRequest.setDeposited(25000);
        moneyPostRequest.setWithdrawn(0);
        moneyPostRequest.setPurpose("Nov Salary Credited");
        moneyList.add(moneyPostRequest);

        MoneyPostRequest moneyPostRequest1 = new MoneyPostRequest();
        moneyPostRequest1.setUserId(1);
        moneyPostRequest1.setDate("15 Dec 2019");
        moneyPostRequest1.setBalance(22000);
        moneyPostRequest1.setDeposited(0);
        moneyPostRequest1.setWithdrawn(3000);
        moneyPostRequest1.setPurpose("Car EMI Loan");
        moneyList.add(moneyPostRequest1);

        MoneyPostRequest moneyPostRequest2 = new MoneyPostRequest();
        moneyPostRequest2.setUserId(1);
        moneyPostRequest2.setDate("16 Dec 2019");
        moneyPostRequest2.setBalance(20000);
        moneyPostRequest2.setDeposited(0);
        moneyPostRequest2.setWithdrawn(2000);
        moneyPostRequest2.setPurpose("Toys & Stationaries");
        moneyList.add(moneyPostRequest2);

        MoneyPostRequest moneyPostRequest3 = new MoneyPostRequest();
        moneyPostRequest3.setUserId(1);
        moneyPostRequest3.setDate("17 Dec 2019");
        moneyPostRequest3.setBalance(16000);
        moneyPostRequest3.setDeposited(0);
        moneyPostRequest3.setWithdrawn(4000);
        moneyPostRequest3.setPurpose("Electricity Water Bills");
        moneyList.add(moneyPostRequest3);

        MoneyPostRequest moneyPostRequest4 = new MoneyPostRequest();
        moneyPostRequest4.setUserId(1);
        moneyPostRequest4.setDate("18 Dec 2019");
        moneyPostRequest4.setBalance(28000);
        moneyPostRequest4.setDeposited(12000);
        moneyPostRequest4.setWithdrawn(0);
        moneyPostRequest4.setPurpose("Freelance training");
        moneyList.add(moneyPostRequest4);

        return moneyList;

    }

    //This function is to get all diary data using API in card view

 /*   public ArrayList<MoneyGetResponse> getAllMoneyData() {

        ArrayList<MoneyGetResponse> moneyGetResponseArrayList = new ArrayList<>(1);
        MoneyGetResponse moneyGetResponse = new MoneyGetResponse();
        moneyGetResponse.getMoneyId();
        moneyGetResponse.getDate();
        moneyGetResponse.getBalance();
        moneyGetResponse.getDeposited();
        moneyGetResponse.getWithdrawn();
        moneyGetResponse.getPurpose();
        moneyGetResponseArrayList.add(moneyGetResponse);

        return moneyGetResponseArrayList;
    }*/
}

