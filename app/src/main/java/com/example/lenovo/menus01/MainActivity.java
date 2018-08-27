package com.example.lenovo.menus01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNameMenu;
    Button bEditButtonMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNameMenu = (EditText) findViewById(R.id.editTextName);
        bEditButtonMenu = (Button) findViewById(R.id.buttonEdit);

        //REGISTER CONTEXT MENU
        registerForContextMenu(etNameMenu);
        registerForContextMenu(bEditButtonMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuStatus:
                Toast.makeText(MainActivity.this, "You clicked on STATUS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSettings:
                Toast.makeText(MainActivity.this, "You clicked on SETTINGS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuMic:
                Toast.makeText(MainActivity.this, "You clicked on MIC", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //this will show both the type of menu we use getMennInflater onle
        //getMenuInflater().inflate(R.menu.context_name_menu,menu);
        switch(v.getId()){
            case R.id.buttonEdit:getMenuInflater().inflate(R.menu.context_edit_button_menu,menu);
                break;
            case R.id.editTextName:getMenuInflater().inflate(R.menu.context_name_menu,menu);
                break;
        }
    }
    //FOR HANDLE THE MENUS

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nameMenuDelete:
                Toast.makeText(MainActivity.this,"Item Deleted",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nameMenuEdit:
                Toast.makeText(MainActivity.this,"Item Edit",Toast.LENGTH_SHORT).show();
                break;
            case R.id.editButtonMenuCut:
                Toast.makeText(MainActivity.this,"Item Cut",Toast.LENGTH_SHORT).show();
                break;
            case R.id.editButtonMenuPaste:
                Toast.makeText(MainActivity.this,"Item Paste",Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
}
