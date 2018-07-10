package com.example.bappy_cox.navigationdrawerfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView,textView2,textView3,textView4,textView5;
    String title,details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        textView = (TextView) findViewById(R.id.detailstitle);
        textView2 = (TextView) findViewById(R.id.detailscategory);
        textView3 = (TextView) findViewById(R.id.writerId);
        textView4 = (TextView) findViewById(R.id.dateId);
        textView5 = (TextView) findViewById(R.id.detilsId);
        imageView = (ImageView) findViewById(R.id.imagedetail);



        Intent i=getIntent();
         title =i.getStringExtra("title");
       String image = (String) getIntent().getSerializableExtra("image");

        String category= i.getStringExtra("category");
        String writer= i.getStringExtra("writer");
        String date= i.getStringExtra("date");
        details= i.getStringExtra("details");
        textView.setText(title);
        textView2.setText(category);
        textView3.setText(writer);
        textView4.setText(date);
        textView5.setText(details);
        Picasso.with(this).load(image).into(imageView);

    }
    //........ For menu Inflate........//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //............ For Share Option..............//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.shareId){
            Intent intent = new Intent(Intent.ACTION_SEND);

            intent.setType("text/plain");
            String subject = "News";
            String body= title;
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(intent.createChooser(intent,"share with"));
        }
        return super.onOptionsItemSelected(item);
    }

}
