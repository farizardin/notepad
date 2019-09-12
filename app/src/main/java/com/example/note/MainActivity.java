package com.example.note;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.graphics.Typeface;
import  android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    MultiAutoCompleteTextView mainview;
    String copydata;
    Button btn_bold,btn_italic,btn_normal,btn_size,btn_copydata,btn_new,btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_bold = (Button) findViewById(R.id.boldtext);
        btn_italic =(Button) findViewById(R.id.italictext);
        btn_normal =(Button) findViewById(R.id.normaltext);
        btn_size =(Button) findViewById(R.id.fontsize);
        btn_copydata =(Button) findViewById(R.id.copytext);
        btn_new =(Button) findViewById(R.id.newdoc);


        mainview = (MultiAutoCompleteTextView) findViewById(R.id.mainpart);

        btn_bold.setOnClickListener(this);
        btn_italic.setOnClickListener(this);
        btn_normal.setOnClickListener(this);
        btn_size.setOnClickListener(this);
        btn_new.setOnClickListener(this);
        btn_copydata.setOnClickListener(this);

        registerForContextMenu(btn_size);
    }
    public  void onClick(View view) {
        if (view == btn_bold) {
            Typeface setfontstyle = Typeface.defaultFromStyle(Typeface.BOLD);
            mainview.setTypeface(setfontstyle);
            Toast.makeText(getApplicationContext(), "Bold", Toast.LENGTH_LONG).show();
        } else if (view == btn_italic) {
            Typeface setfontstyle = Typeface.defaultFromStyle(Typeface.ITALIC);
            mainview.setTypeface(setfontstyle);
            Toast.makeText(getApplicationContext(), "Italic", Toast.LENGTH_LONG).show();
        } else if (view == btn_normal) {
            Typeface setfontstyle = Typeface.defaultFromStyle(Typeface.NORMAL);
            mainview.setTypeface(setfontstyle);
            Toast.makeText(getApplicationContext(), "Normal", Toast.LENGTH_LONG).show();
        }
        else if (view == btn_size) {
            view.showContextMenu();
            Toast.makeText(getApplicationContext(), "Font Size", Toast.LENGTH_LONG).show();
        }
        else if(view == btn_new)
        {
            String appnametitle ="Notepoint";
            setTitle(appnametitle+" - New Document.txt");
            mainview.setText("");
            mainview.setHint("New Document");
            mainview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            Toast.makeText(getApplicationContext(), "New Document", Toast.LENGTH_LONG).show();
        }
        else if(view == btn_copydata)
        {


            copydata = mainview.getText().toString();
            copydata = mainview.getText().toString();
            Toast.makeText(getApplicationContext(), "Copied Successfully !!", Toast.LENGTH_LONG).show();

        }
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Select Font Size");
        menu.add(0, v.getId(), 0, "5+");
        menu.add(0, v.getId(), 0, "10+");
        menu.add(0, v.getId(), 0, "20+");
        menu.add(0, v.getId(), 0, "25+");
        menu.add(0, v.getId(), 0, "30+");
        menu.add(0, v.getId(), 0, "35+");
        menu.add(0, v.getId(), 0, "40+");
        menu.add(0, v.getId(), 0, "45+");
        menu.add(0, v.getId(), 0, "50");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){

        if (item.getTitle() == "5+") {
            mainview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
        } else if (item.getTitle() == "10+") {
            mainview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        } else if (item.getTitle() == "20+") {
            mainview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        } else if (item.getTitle() == "25+") {
            mainview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        } else if (item.getTitle() == "30+") {
            mainview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        } else if (item.getTitle() == "35+") {
            mainview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 33);
        } else if (item.getTitle() == "40+") {
            mainview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 43);
        } else if (item.getTitle() == "45+") {
            mainview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 48);
        } else if (item.getTitle() == "50") {
            mainview.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        } else {
            Toast.makeText(getApplicationContext(), "Something is Worng", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
