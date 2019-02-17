package com.gzeinnumer.email;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnEmail)
    Button btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //need internet permition
    }

    @OnClick(R.id.btnEmail)
    public void onViewClicked() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("email"));
        String[] s= {"m.fadli.zein.17@gmail.com","gzeinnumer.17@gmail.com"};
        i.putExtra(Intent.EXTRA_EMAIL,s);
        i.putExtra(Intent.EXTRA_SUBJECT, "Hay, tulis Title pesan kamu disini");
        i.putExtra(Intent.EXTRA_TEXT,"Hay ,tulis pesan kamu disini!!");
        i.setType("message/rfc822");
        Intent chooser= Intent.createChooser(i,"Jalankan Email");
        startActivity(chooser);
    }
}
