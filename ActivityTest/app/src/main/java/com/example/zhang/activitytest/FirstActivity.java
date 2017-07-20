package com.example.zhang.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.zhang.activitytest.BaseActivity;

import static android.widget.Toast.*;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity", "Task id is" + getTaskId());
        setContentView(R.layout.firstlayout);
        Button button1=(Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //makeText(FirstActivity.this, "You clicked Button 1", LENGTH_SHORT).show();
                //finish();

                //Intent intent=new Intent("com.example.zhang.activitytest.ACTION_START");
                //intent.addCategory("com.example.zhang.activitytest.MY_CATEGORY");

                //Intent intent=new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));

                //Intent intent=new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse("tel:10086"));

                //String data="Hello SecondActivity";
                //Intent intent=new Intent(FirstActivity.this, SecondActivity.class);
                //intent.putExtra("extra_data", data);

//                Intent intent=new Intent(FirstActivity.this, SecondActivity.class);
//                startActivity(intent);
                //startActivity(intent);
                SecondActivity.actionStart(FirstActivity.this, "data1", "data2");
            }


        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                makeText(FirstActivity.this, "You clicked Add", LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                makeText(FirstActivity.this, "You clicked Remove", LENGTH_SHORT).show();
                break;
            default:
        }
        return true;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        switch(requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnedData=data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("FirstActivity", "onRestart");
    }

}
