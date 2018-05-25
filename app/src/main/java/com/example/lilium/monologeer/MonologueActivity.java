package com.example.lilium.monologeer;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;
import android.app.ActionBar;

import io.realm.Realm;

public class MonologueActivity extends AppCompatActivity {
    TextView imananji;
    EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monologue);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
// 通常表示されるタイトルを非表示にする。
        actionBar.setDisplayShowTitleEnabled(false);
// 独自のビューを表示するように設定。
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM, ActionBar.DISPLAY_SHOW_CUSTOM);
// 独自のビューを指定。 (ここではレイアウトリソースの ID を指定しているが、View オブジェクトを渡すこともできる。)
        actionBar.setCustomView(R.layout.button);
        Button b =actionBar.getCustomView().findViewById(R.id.boyaku_button);
        e =findViewById(R.id.editText2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Mono m=new Mono();
                m.setContent(e.getText().toString());
                Realm r=Realm.getDefaultInstance();
                r.beginTransaction();
                r.copyToRealm(m);
                r.commitTransaction();
                startActivity(intent);

            }
        });
        imananji=findViewById(R.id.imananji);
        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //テキスト変更前
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //テキスト変更中
            }

            @Override
            public void afterTextChanged(Editable s) {
                imananji.setText("現在"+Integer.toString(s.length())+"文字です");


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

}
