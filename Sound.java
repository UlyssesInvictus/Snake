   import java.io.File;
   import java.io.IOException;
   import javax.sound.sampled.*;
   import javax.sound.sampled.AudioFormat;
   import javax.sound.sampled.AudioInputStream;
   import javax.sound.sampled.AudioSystem;
   import javax.sound.sampled.DataLine;
   import javax.sound.sampled.LineUnavailableException;
   import javax.sound.sampled.SourceDataLine;
	/**A Sound class that plays music and other sounds*/    public class Sound
   {
   /**Buffer rate of the sound*/
      private static final int EXTERNAL_BUFFER_SIZE = 128000;
   /**The Clip that plays the sound*/
      Clip line = null;
   /**Has the sound been played at least once?*/
      boolean oncePlayed = false;
		AudioInputStream ais = null;
   	/**The constructor of SoundTest. The filename is used to be read in and the audio is later gotten from it and used.
      *@param filename	The filename of the file containing the sound*/
       public Sound(String filename)      {
		   try {
        File soundname = new File(filename);
        ais = AudioSystem.getAudioInputStream(soundname);
        line = AudioSystem.getClip();
        line.open(ais);			 } 
 			catch (Exception ex) 			{
        line = null;    		}

      }
   	/**Plays the music.*/
       public void play()      {
         FloatControl gainControl = (FloatControl)line.getControl(FloatControl.Type.MASTER_GAIN);
         gainControl.setValue(6);
         if (line != null)         {    
            if (oncePlayed == false)            {
               line.loop(0);
               oncePlayed = true;            }
            else
               line.loop(1);         }      }
   	/**Loops the music*/
       public void loop()      {
         line.loop(Clip.LOOP_CONTINUOUSLY);      }
   	/**Pauses the music*/
       public void stop()      {
         line.stop();      }
   	/**Close and exit the file*/
       public void exit()      {
			line.stop();
			line.flush();
			line.close();
			line = null;
			ais = null;      }   }