package com.example.thuchanh2;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.thuchanh2.DescriptionPlace.locationn;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView detail;
    private ImageView image;
    private Button location;
    String detail2;
    String[] place = locationn();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        String tmp = "";
        detail2 = getIntent().getStringExtra("place");
        switch (detail2){
            case "Hồ Gươm":
                    tmp=tmp+place[0];
                    detail.setText(tmp);
                    image.setImageResource(R.drawable.thaprua);
                    break;
            case "Lăng Chủ Tịch":
                    tmp=tmp+place[1];
                    detail.setText(tmp);
                    image.setImageResource(R.drawable.langchutich);
                    break;
            case "Cột cờ Hà Nội":
                    tmp=tmp+place[2];
                    detail.setText(tmp);
                    image.setImageResource(R.drawable.cotcohanoi);
                    break;
            case "Chùa Một Cột":
                    tmp=tmp+place[3];
                    detail.setText(tmp);
                    image.setImageResource(R.drawable.chuamotcot);
                    break;
            case "Hồ Tây":
                    tmp=tmp+place[4];
                    detail.setText(tmp);
                    image.setImageResource(R.drawable.hotay);
                    break;
            case "Chùa Trấn Quốc":
                    tmp=tmp+place[5];
                    detail.setText(tmp);
                    image.setImageResource(R.drawable.chuatranquoc);
                    break;
        }
        location.setOnClickListener(this);
//        detail.setText(tmp);
    }

    private void initView() {
        detail = findViewById(R.id.detail);
        image = findViewById(R.id.image);
        location = findViewById(R.id.location);
    }

    @Override
    public void onClick(View v) {
        if(v == location){
            String s = "geo:0,0?q=";
            s+=detail2;
            Uri gmmIntentUri = Uri.parse(s);
            Intent map = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            map.setPackage("com.google.android.apps.maps");
            startActivity(map);

        }

    }
}