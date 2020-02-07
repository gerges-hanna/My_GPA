package com.example.mygpa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public  static ArrayList<Model> item=new ArrayList<Model>();
    static  ListView listView;
    static MyAdapter myAdapter;
    EditText grade,hour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.lists);
        myAdapter=new MyAdapter(item,MainActivity.this);
        listView.setAdapter(myAdapter);
        grade=findViewById(R.id.eGrade);
        hour=findViewById(R.id.eHour);
    }

    public void rowPlus(View view) {
        try {
                if(Double.parseDouble(grade.getText().toString())<=100 && Double.parseDouble(grade.getText().toString())>=0) {
                    item.add(new Model(Double.parseDouble(grade.getText().toString()), Double.parseDouble(hour.getText().toString())));
                    myAdapter.notifyDataSetChanged();
                    grade.setText("");
                    hour.setText("");
                    Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "0 >= Grade <= 100", Toast.LENGTH_SHORT).show();
                }
        }catch (Exception e){
            Toast.makeText(this, e.getMessage()+"", Toast.LENGTH_SHORT).show();
        }
    }
    public static  void removeList(int position)
    {
        item.remove(position);
        listView.setAdapter(myAdapter);
    }

    public double gradeGpa(double grade,double hour)
    {
        double result=0.0;

        if(grade>=90&& grade<=100)
        {
            result=4;
        }else if(grade>=85)
        {
            result=3.7;
        }else if(grade>=80)
        {
            result=3.3;
        }else if(grade>=75)
        {
            result=3;
        }else if(grade>=70)
        {
            result=2.7;
        }else if(grade>=65)
        {
            result=2.4;
        }else if(grade>=60)
        {
            result=2.1;
        }else if(grade>=50)
        {
            result=1.8;
        }else if(grade<50)
        {
            result=0.0;
        }
        return result*hour;
    }
    public  double claculate(ArrayList<Model> item)
    {
        int i;
        double result2,sum,avg;
        sum=0;
        avg=0;
        for (i=0;i<item.size();i++)
        {
            avg=avg+item.get(i).hour;
           result2=gradeGpa(item.get(i).getGrade(),item.get(i).hour);
           sum=sum+result2;
        }

        avg=sum/avg;
        return avg;
    }
    public String  grade(double gpa){
        String grade=null;
        if(gpa>=3.4 && gpa<=4)
        {
            grade="ممتاز";
        }else if (gpa>=2.8)
        {
            grade="جيد جداً";
        }else if (gpa>=2.4)
        {
            grade="جيد";
        }else if (gpa>=2)
        {
            grade="مقبول";
        }else if (gpa>=1.4)
        {
            grade="ضعيف";
        }else if (gpa<=1.4)
        {
            grade="ضعيف جداً";
        }
        return grade;
    }
    public void ClacButton(View view) {
        double result=claculate(item);
        TextView txt=findViewById(R.id.gpa);
        txt.setText(new DecimalFormat("##.##").format(result)+"");
        TextView res=findViewById(R.id.result);
        res.setText(grade(result));
    }
}
