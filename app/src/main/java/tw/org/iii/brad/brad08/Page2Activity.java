package tw.org.iii.brad.brad08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Page2Activity extends AppCompatActivity {
    private TextView tv;
    private MainAPP mainAPP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        //所有的物件能出現都是intent帶出來的
        mainAPP = (MainAPP)getApplication();
        Log.v("brad","a="+mainAPP.a);
        Log.v("brad","b="+mainAPP.b);

        mainAPP.a = 100;
        mainAPP.b ="ok2";


        tv = findViewById(R.id.page2_tv);

        Intent intent = getIntent();
        //物件型別無須加入初始值
        String name = intent.getStringExtra("name");
        //                                               基本型別需加入初始值
        int lottery = intent.getIntExtra("lottery",0);
        tv.setText(name+":"+lottery);

    }

    public void gotoMain(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
