package com.example.rkhat.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number{
        int number;
        public boolean isSquare(){
            double squareroot=Math.sqrt(number);
            if(squareroot==Math.floor(squareroot)){
                return true;
            }
            else {
                return false;
            }

        }

        public boolean isTriangular(){
            int x=1;
            int triangularNumber=1;
            while(triangularNumber<number){
                x++;
                triangularNumber+=x;
            }
            if(triangularNumber==number){
                return true;
            }
            else {
                return false;
            }
        }




    }





    public void testNumber(View view){
        String messaage="";
        EditText numberText=(EditText)findViewById(R.id.numberText);
        if(numberText.getText().toString().isEmpty()){
            messaage="Enter a Number!";
        }
        else{
        Number myNumber=new Number();
        myNumber.number=Integer.parseInt(numberText.getText().toString());

        if(myNumber.isSquare()){
            if(myNumber.isTriangular()){
                messaage=myNumber.number + "is both triangular and square";
            }
            else {
                messaage=myNumber.number + "is square but not triangular!";
            }
        }
        else {
            if(myNumber.isTriangular()){
                messaage=myNumber.number + "is triangular but not square";
            }
            else{
                messaage=myNumber.number + "is neither square nor triangular";
            }
        }
        Toast.makeText(getApplicationContext(),messaage,Toast.LENGTH_SHORT).show();

    }}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
