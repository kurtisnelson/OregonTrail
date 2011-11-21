package com.kelsonprime.oregontrail.gui;
import java.io.File;
import java.io.IOException;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



public class Sound {
	public static Clip clip;
	public static AudioInputStream audioIn;
	public static File soundFile;
	
	public Sound() {
		
		}
	
	public static void music(String fname)
			throws UnsupportedAudioFileException, IOException,
			LineUnavailableException {
		if (clip != null)
			if (clip.isRunning()) {
				clip.stop();
			}
		soundFile = new File(fname);
		System.out.println(fname);
		audioIn = AudioSystem.getAudioInputStream(soundFile);
		clip = AudioSystem.getClip();
		clip.open(audioIn);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public static void stop() {
		clip.stop();
	}
	
	public static void start() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public static boolean isPaused() {
		if (clip.isRunning()) {
			return false;
		}
		
		else 
			return true;
	}
}
