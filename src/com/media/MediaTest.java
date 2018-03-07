/* 
 
 *  Android开发之初探音频的播放 
 
 *  MyMeidaTest01.java 
 
 *  Created on: 2011-8-23 
 
 *  Author: blueeagle 
 
 *  Email: liujiaxiang@gmail.com 
 
 */  
  
package com.media;
  
   
  
import java.util.HashMap;  
  
import android.app.Activity;  
  
import android.content.Context;  
  
import android.media.AudioManager;  
  
import android.media.MediaPlayer;  
  
import android.media.SoundPool;  
  
import android.os.Bundle;  
  
import android.view.View;  
  
import android.widget.Button;  
  
import android.widget.TextView;  
  
   
  
public class MediaTest extends Activity {  
  
      
  
    Button button1;  
  
    Button button2;  
  
    Button button3;  
  
    Button button4;  
  
    TextView myTextView;  
  
    MediaPlayer myMediaplayer;  
  
    SoundPool mySoundpool;  
  
    HashMap<Integer,Integer> soundPoolMap;  
  
    @Override  
  
    public void onCreate(Bundle savedInstanceState) {  
  
        super.onCreate(savedInstanceState);  
  
        setContentView(R.layout.main);  
  
        initSounds();  
  
        initUI();  
  
    }  
  
    public void playSound(int sound , int loop){  
  
       //SoundPool的播放方法  
  
       AudioManager mgr = (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);  
  
       float streamVolumeCurrent = mgr.getStreamVolume(AudioManager.STREAM_MUSIC);  
  
       float streamVolumeMax = mgr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);  
  
       float volume = streamVolumeCurrent/streamVolumeMax;  
  
       mySoundpool.play(soundPoolMap.get(sound), volume, volume, 1, loop, 1f);  
  
    }  
  
    private void initUI() {  
  
       // TODO Auto-generated method stub  
  
       myTextView = (TextView)findViewById(R.id.mytextview);  
  
       button1 = (Button)findViewById(R.id.button1);  
  
       button2 = (Button)findViewById(R.id.button2);  
  
       button3 = (Button)findViewById(R.id.button3);  
  
       button4 = (Button)findViewById(R.id.button4);  
  
         
  
       button1.setOnClickListener(new Button.OnClickListener(){  
  
   
  
           @Override  
  
           public void onClick(View v) {  
  
              // TODO Auto-generated method stub  
  
              myTextView.setText("使用MediaPlayer播放声音");  
  
              if(!myMediaplayer.isPlaying())  
  
                  myMediaplayer.start();  
  
           }  
  
             
  
       });  
  
       button2.setOnClickListener(new Button.OnClickListener(){  
  
   
  
           @Override  
  
           public void onClick(View v) {  
  
              // TODO Auto-generated method stub  
  
              myTextView.setText("暂停MediaPlayer播放声音");  
  
              if(myMediaplayer.isPlaying())  
  
                  myMediaplayer.pause();  
  
           }  
  
             
  
       });  
  
       button3.setOnClickListener(new Button.OnClickListener(){  
  
   
  
           @Override  
  
           public void onClick(View v) {  
  
              // TODO Auto-generated method stub  
  
              myTextView.setText("使用SoundPool播放声音");  
  
              playSound(1,0);  
  
                
  
           }  
  
             
  
       });  
  
       button4.setOnClickListener(new Button.OnClickListener(){  
  
           @Override  
  
           public void onClick(View v) {  
  
              // TODO Auto-generated method stub  
  
              myTextView.setText("暂停SoundPool播放声音");  
  
              mySoundpool.pause(1);  
  
           }  
  
       });  
  
    }  
  
    private void initSounds() {  
  
       // TODO Auto-generated method stub  
  
       myMediaplayer = MediaPlayer.create(this, R.raw.karlone);  
  
       mySoundpool = new SoundPool(4,AudioManager.STREAM_MUSIC,100);  
  
       soundPoolMap = new HashMap<Integer,Integer>();  
  
      soundPoolMap.put(1,mySoundpool.load(this,R.raw.karlone,1));  
  
       //初始化声音操作，使用SoundPool时，一般将声音放进一个HashMap中，便于声音的管理和操作。  
  
    }  
  
}  