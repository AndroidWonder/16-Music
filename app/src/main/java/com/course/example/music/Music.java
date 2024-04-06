/*
 * Play music file in memory.
 * Make sure you have a music file in Android memory in the
 * directory data/data/package name/files/music file
 * Use the emulator File Explorer to load the file.
 * Place music files in device memory with the Device File Explorer.
 * Use data/data/package name/files/music file
 *
 */

package com.course.example.music;

import android.app.Activity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

import java.io.IOException;


public class Music extends Activity {
	
	MediaPlayer mp;
    Button button01, button02; 
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        button01 = (Button)findViewById(R.id.Button01);
        button02 = (Button)findViewById(R.id.Button02);
                         
        button01.setOnClickListener(
                v -> mp.start());
        
        button02.setOnClickListener(
                v -> mp.pause());
    }
    
    @Override 
    public void onStart() {
    	super.onStart();
    	mp = new MediaPlayer();
		String path = getFilesDir().toString() + "/bobmarley.mp3";
        try {
			mp.setDataSource(path);
	        mp.prepare();
	        } catch (IOException e) {
	        	Toast.makeText(Music.this, "Exception" + e.getMessage(), Toast.LENGTH_LONG).show();
	        }
    }
    
    @Override 
    public void onStop() {
    	super.onStop();
    	mp.release();
    }
}