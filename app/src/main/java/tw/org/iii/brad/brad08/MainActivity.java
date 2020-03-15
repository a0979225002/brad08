package tw.org.iii.brad.brad08;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private  MainAPP mainAPP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainAPP = (MainAPP) getApplication();
        Log.v("brad","a="+mainAPP.a);
        Log.v("brad","b="+mainAPP.b);

        input = findViewById(R.id.input);
    }

    public void gotoPage2(View view) {
        //Intent 指向目的,可以呼叫別人的app
        Intent intent = new Intent(this,Page2Activity.class);
        intent.putExtra("name",input.getText().toString());//putExtra更改額外資訊
        intent.putExtra("lottery",(int)(Math.random()*49+1));
        startActivity(intent);//帶向Page2Activity.java執行
    }

    public void gotoPage3(View view) {
        Intent intent = new Intent(this,Page3Activity.class);
        startActivityForResult(intent,3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v("brad","requestCode="+requestCode);
        Log.v("brad","requestCode="+requestCode);

        if (requestCode ==3){
            boolean isSoundOnOff = data.getBooleanExtra("sound",false);
            Log.v("brad","sound"+(isSoundOnOff?"on":"off"));
        }
    }

    @Override
    protected void onRestart() {
        Log.v("brad","onRestart");
        Log.v("brad","a="+mainAPP.a);
        Log.v("brad","b="+mainAPP.b);
        super.onRestart();
    }
}
