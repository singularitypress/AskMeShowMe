package co.jaypandya.askmeshowme;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;

public class AskMeShowMe extends Activity implements OnClickListener {

    private static final String TAG = "AskMeShowMe";
    private String selection = "";
    private Menu myMenu = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        String TAG = "Jay Pandya ";
        Log.i(TAG, "062791132");
        //View playButton = findViewById(R.id.play_button);
        //playButton.setOnClickListener(this);

        View promptButton = findViewById(R.id.prompt_button);
        promptButton.setOnClickListener(this);

    }

    public void onClick(View v) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.monthsRadioGroup);
        int checkedRadioButton = radioGroup.getCheckedRadioButtonId();

        switch (checkedRadioButton) {
            case R.id.januaryButton :
                selection = "January";
                break;
            case R.id.juneButton :
                selection = "June";
                break;
            case R.id.julyButton :
                selection = "July";
                break;
        }

        switch(v.getId()) {
            //case R.id.play_button:
            //	Intent k = new Intent(this, Video.class);
            //	startActivity(k);
            //	break;
            case R.id.prompt_button:
                Intent j = new Intent(this, ShowMe.class);
                j.putExtra("choice", selection);
                startActivity(j);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        Log.i(TAG,"AskMeShowMe onCreateOptionsMenu from XML file");

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);

        this.myMenu = menu;

        //when user clicks: More
        addRegularMenuItems(menu);
        //add5SecondaryMenuItems(menu);
        this.addSubMenu(menu);

        return true;
    }

    private void addRegularMenuItems(Menu menu) {
        //Secondary items are shown just like everything else
        int base=Menu.FIRST; // value is 1

        MenuItem item1 = menu.add(base,base,base,"Browser...");
        menu.add(base,base+1,base+1,"DialPad...");
        menu.add(base,base+2,base+2,"About...");

        item1.setIcon(R.drawable.ic_launcher);
    }

    private void addSubMenu(Menu menu) {
        //click on picture menu
        //Secondary items are shown just like everything else
        int base=Menu.FIRST + 100;
        SubMenu sm = menu.addSubMenu(base,base+1,Menu.NONE,"submenu");
        MenuItem item1 = sm.add(base,base+2,base+2,"item 1....");

        sm.add(base,base+3,base+3, "item 2....");
        sm.add(base,base+4,base+4, "item 3....");

        Log.i(TAG,"AskMeShowMe addSubMenu support with android picture icon");
        item1.setIcon(R.drawable.skateboarding_android_1);
        sm.setIcon(R.drawable.skateboarding_android_2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.xml_menu_1:
//    		startActivity(new Intent(this, Video.class));
                break;
            case R.id.xml_menu_2:
//    		startActivity(new Intent(this, About.class));
                break;
            case R.id.xml_menu_3:
//    		startActivity(new Intent(this, Prefs.class));
                break;
        }

        if (item.getItemId() == 1)	{
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
            this.startActivity(intent);
        } else if (item.getItemId() == 2)	{
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:4164669992"));
            this.startActivity(intent);
        }	else if (item.getItemId() == 3)	{
//    		Intent intent = new Intent(this, About.class);
//    		this.startActivity(intent);

            this.myMenu.setGroupVisible(Menu.CATEGORY_SECONDARY,true);
        }

        return true;
    }

//    //Context menu support
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
//    	menu.setHeaderTitle("Sample ctx menu");
//    	menu.add(200, 200, 200, "AskMeShowMeMore");
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//    	if (item.getItemId() == 1)	{
//    		//Intent intent = new Intent(this, About.class);
//    		Intent intent = new Intent(this, Video.class);
//    		this.startActivity(intent);
//    	} else if (item.getItemId() == 2)	{
//    		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.humber.ca"));
//    		this.startActivity(intent);
//    	}	else if (item.getItemId() == 3)	{
//    		Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9056789091"));
//    		this.startActivity(intent);
//    	}
//
//    	return true;
//    }
//
//    //This method is here to demonstrate loading XML menu
//    //You can call this method from the onCreateOptions menu
//    //if you want to use the xml menu instead of programmatically
//    //creating the menus.
//    private void loadXMLMenu(Menu menu) {
//    	MenuInflater inflater = getMenuInflater(); //from activity
//    	inflater.inflate(R.menu.my_menu, menu);
//    }

}
