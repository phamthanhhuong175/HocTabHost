package phamthanhhuong.com.hoctabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;
    EditText edtUser;
    EditText edtPassword;
    Button btnLogin,btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if(s.equals("t1"))
                {
                    Toast.makeText(MainActivity.this,"Bạn chọn tab đăng nhập",Toast.LENGTH_SHORT).show();
                }
                else if(s.equals("t2"))
                {
                    Toast.makeText(MainActivity.this,"Bạn chọn tab hướng dẫn",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyDangNhap();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void xuLyDangNhap() {
        Toast.makeText(MainActivity.this,"User = "+edtUser.getText().toString()+"password = "+edtPassword.getText().toString(),
                Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        tabHost=findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tab1=tabHost.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("Đăng nhập");
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2=tabHost.newTabSpec("t2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("Hướng dẫn");
        tabHost.addTab(tab2);

        edtUser=findViewById(R.id.edtName);
        edtPassword=findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnDangNhap);
        btnExit=findViewById(R.id.btnThoat);
    }
}
