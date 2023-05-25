package sg.edu.rp.c346.id22020995.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String website = "";
    String contact = "";
    String bank = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.language_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
        } else {
            tvDBS.setText("Error Translation");
            tvOCBC.setText("Error Translation");
            tvUOB.setText("Error Translation");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.option_menu, menu);
        if (v == tvDBS){
            // set website and contact number text
            bank = "DBS";
            website = "https://www.dbs.com.sg";
            contact = "18001111111";
        } else if (v == tvOCBC) {
            bank = "OCBC";
            website = "https://www.ocbc.com";
            contact = "18003633333";
        } else if (v == tvUOB){
            bank = "UOB";
            website = "https://www.uob.com.sg";
            contact = "18002222121";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id =item.getItemId();
        if (id == R.id.WebsiteSelection) {
            Intent intentWebsite = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
            startActivity(intentWebsite);
        } else if (id == R.id.ContactSelection) {
            Intent intentContact = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ contact));
            startActivity(intentContact);
        } else if (id == R.id.FavouriteSelection) {
            if (bank.equalsIgnoreCase("DBS")){
                // change "DBS" to red, change the rest to gray
                tvDBS.setTextColor(Color.RED);
                tvOCBC.setTextColor(Color.GRAY);
                tvUOB.setTextColor(Color.GRAY);
            }
            else if (bank.equalsIgnoreCase("OCBC")){
                // change "OCBC" to red, change the rest to gray
                tvDBS.setTextColor(Color.GRAY);
                tvOCBC.setTextColor(Color.RED);
                tvUOB.setTextColor(Color.GRAY);
            }
            else if (bank.equalsIgnoreCase("UOB")){
                // change "UOB" to red, change the rest to gray
                tvDBS.setTextColor(Color.GRAY);
                tvOCBC.setTextColor(Color.GRAY);
                tvUOB.setTextColor(Color.RED);
            }
        }
        return super.onContextItemSelected(item);
    }
}