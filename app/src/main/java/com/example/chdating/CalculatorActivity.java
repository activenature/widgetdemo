package com.example.chdating;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;




public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private String operator="";
    private String firstNum="";
    private String nextNum="";
    private String result="";
    private String showText="";
    private TextView tv_result;
    private Button btn_clear;
    private Button btn_divide;
    private Button btn_multiply;
    private Button btn_cancel;
    private Button btn_plus;
    private Button btn_minus;
    private ImageButton btn_sqrt;
    private Button btn_dot;
    private Button btn_equal;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button btn_0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tv_result=findViewById(R.id.tv_result);
        btn_clear=findViewById(R.id.btn_clear);
        btn_divide=findViewById(R.id.btn_divide);
        btn_multiply=findViewById(R.id.btn_multiply);
        btn_cancel=findViewById(R.id.btn_cancel);
        btn_plus=findViewById(R.id.btn_plus);
        btn_minus=findViewById(R.id.btn_minus);
        btn_sqrt=findViewById(R.id.ib_sqrt);
        btn_dot=findViewById(R.id.btn_dot);
        btn_equal=findViewById(R.id.btn_equal);
        btn_1=findViewById(R.id.btn_1);
        btn_2=findViewById(R.id.btn_2);
        btn_3=findViewById(R.id.btn_3);
        btn_4=findViewById(R.id.btn_4);
        btn_5=findViewById(R.id.btn_5);
        btn_6=findViewById(R.id.btn_6);
        btn_7=findViewById(R.id.btn_7);
        btn_8=findViewById(R.id.btn_8);
        btn_9=findViewById(R.id.btn_9);
        btn_0=findViewById(R.id.btn_0);



        btn_clear.setOnClickListener(CalculatorActivity.this);
        btn_divide.setOnClickListener(CalculatorActivity.this);
        btn_multiply.setOnClickListener(CalculatorActivity.this);
        btn_cancel.setOnClickListener(CalculatorActivity.this);
        btn_plus.setOnClickListener(CalculatorActivity.this);
        btn_minus.setOnClickListener(CalculatorActivity.this);
        btn_sqrt.setOnClickListener(CalculatorActivity.this);
        btn_dot.setOnClickListener(CalculatorActivity.this);
        btn_equal.setOnClickListener(CalculatorActivity.this);
        btn_1.setOnClickListener(CalculatorActivity.this);
        btn_2.setOnClickListener(CalculatorActivity.this);
        btn_3.setOnClickListener(CalculatorActivity.this);
        btn_4.setOnClickListener(CalculatorActivity.this);
        btn_5.setOnClickListener(CalculatorActivity.this);
        btn_6.setOnClickListener(CalculatorActivity.this);
        btn_7.setOnClickListener(CalculatorActivity.this);
        btn_8.setOnClickListener(CalculatorActivity.this);
        btn_9.setOnClickListener(CalculatorActivity.this);
        btn_0.setOnClickListener(CalculatorActivity.this);


    }


    @Override
    public void onClick(View view) {


        int resid= view.getId();

        String enter;

        if(resid==R.id.btn_clear){
            clear("");
        }
        else if(resid==R.id.btn_cancel){
            if(operator.equals("")) {
                if (firstNum.length() == 1) {
                    firstNum = "0";
                } else if (firstNum.length() > 1) {
                    firstNum = firstNum.substring(0, firstNum.length() - 1);
                } else {
                    Toast.makeText(CalculatorActivity.this, "没有可取消的数字了", Toast.LENGTH_SHORT).show();
                    return;
                }
                showText = firstNum;
                tv_result.setText(showText);
            }
            else{
                if(nextNum.length()==1){
                    nextNum="";
                }
                else if(nextNum.length()>1){
                    nextNum=nextNum.substring(0,nextNum.length()-1);
                }
                else {
                    Toast.makeText(CalculatorActivity.this, "没有可取消的数字了", Toast.LENGTH_SHORT).show();
                    return;
                }
                showText=showText.substring(0,showText.length()-1);
                tv_result.setText(showText);
            }
        }
        else if(resid==R.id.btn_equal){
            if(operator.length()==0||operator.equals("=")||operator.equals("√")){
                Toast.makeText(CalculatorActivity.this, "请输入运算符", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(nextNum.length()==0){
                Toast.makeText(CalculatorActivity.this, "请输入数字", Toast.LENGTH_SHORT).show();
                return;
            }
            if(calculate()){
                operator= ((TextView)view).getText().toString();
                showText=showText+"="+result;
                tv_result.setText((showText));
            }
        }
        else if(resid==R.id.btn_plus||resid==R.id.btn_divide||resid==R.id.btn_minus||resid==R.id.btn_multiply){
            if(firstNum.length()==0){
                Toast.makeText(CalculatorActivity.this, "请输入数字", Toast.LENGTH_SHORT).show();
                return;
            }
            if(operator.length() == 0 || operator.equals("=") || operator.equals("√")){
                operator= ((TextView)view).getText().toString();
                showText=showText+operator;
                tv_result.setText(showText);
            }
            else if(!operator.equals("")&&!operator.equals(((TextView) view).getText().toString())&&nextNum.equals("")){
                operator= ((TextView)view).getText().toString();
                showText=showText.substring(0,showText.length()-1)+operator;
                tv_result.setText(showText);
            }
            else {
                Toast.makeText(CalculatorActivity.this, "请输入数字", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        else if(resid==R.id.ib_sqrt){
            if(operator.equals("")==false||nextNum.equals("")==false){showText=firstNum;tv_result.setText(showText);}
            if(firstNum.length()==0){
                Toast.makeText(CalculatorActivity.this, "请输入数字", Toast.LENGTH_SHORT).show();
                return;
            }
            else if(Double.parseDouble(firstNum)<0){
                Toast.makeText(CalculatorActivity.this, "开根号的数值不能小于0", Toast.LENGTH_SHORT).show();
                return;
            }
            result=String.valueOf(Math.sqrt(Double.parseDouble(firstNum)));
            firstNum=result;
            nextNum="";
            operator= "√";
            showText=showText+"√="+result;
            tv_result.setText(showText);
        }
        else{
            enter=((TextView)view).getText().toString();
            if(operator.equals("=")||operator.equals("√")){
                operator="";
                firstNum="";
                showText="";
            }
            if(resid==R.id.btn_dot){
                if(firstNum.contains(".")||nextNum.contains(".")) {
                    Toast.makeText(CalculatorActivity.this, "不能重复输入.符号。", Toast.LENGTH_SHORT).show();
                    enter ="";
                }
            }
            if(operator.equals("")){
                firstNum=firstNum+ enter;
            }
            else{
                nextNum=nextNum+ enter;
            }
            showText=showText+ enter;
            tv_result.setText(showText);
        }

    }

    public boolean calculate() {
        if (operator.equals("+")) {
            result = String.valueOf(Double.parseDouble(firstNum) + Double.parseDouble(nextNum));
        } else if (operator.equals("-")) {
            result = String.valueOf(Double.parseDouble(firstNum) - Double.parseDouble(nextNum));
        } else if (operator.equals("*")) {
            result = String.valueOf(Double.parseDouble(firstNum) * Double.parseDouble(nextNum));
        } else if (operator.equals("/")) {
            if (nextNum.equals("0")) {
                Toast.makeText(this, "被除数不能为零", Toast.LENGTH_SHORT).show();
                return false;
            }
            else {
                result = String.valueOf((Double.parseDouble(firstNum))/(Double.parseDouble(nextNum)));
            }
        }
        firstNum = result;
        nextNum = "";
        return true;
    }

    private void clear(String text){
        showText=text;
        tv_result.setText(showText);
        operator="";
        firstNum="";
        nextNum="";
        result="";
    }

}

