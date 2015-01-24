   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   import java.awt.geom.*;
   import javax.swing.*;
   import java.io.*;
   import java.util.Map;
	
    public class OptionPanel extends javax.swing.JPanel {
    /**Map containing all the important actions and the respective keyboard locations*/
      private Map<Integer, Integer> myKeys;
   /**Current key being changed*/
      private Integer current;
   /**Timer to update color of Snake, Food, and Background*/
      private Timer timer;
   /**Colors of snake, food, and background*/
      private Color sc, fc, bgc;
   /**Examples of slider colors*/
      private javax.swing.JLabel backgroundLabel, snakeLabel, foodLabel;
   /**Sliders for background color*/
      private javax.swing.JSlider bgb, bgg, bgr;
   /**Buttons that can be clicked to change keys*/
      private javax.swing.JButton escape, left, right, menu, pause, reset, mute;
   /**Sliders for Food color*/
      private javax.swing.JSlider fb, fg, fr;
   /**Instructions on key changing*/
      private javax.swing.JLabel jLabel1;
    /**Panel used in GUI*/
      private javax.swing.JPanel jPanel1;
    /**Sliders for Snake color*/
      private javax.swing.JSlider sb, sg, sr;
    /** Creates new form OptionPanel */
       public OptionPanel(Map<Integer, Integer> keys, Color snakec, Color foodc, Color backgroundc)      {
         myKeys = keys;
         sc = snakec;
         fc = foodc;
         bgc = backgroundc;
         timer = new Timer(1, new Listener());
         timer.start();
         initComponents();      }
   /**Action when left button is clicked*/
       private void leftActionPerformed(java.awt.event.ActionEvent evt)       {
         current = KeyEvent.VK_LEFT;
         requestFocus();      }
   /**Action when right button is clicked*/   
       private void rightActionPerformed(java.awt.event.ActionEvent evt)       {
         current = KeyEvent.VK_RIGHT;
         requestFocus();      }
   /**Action when pause button is clicked*/
       private void pauseActionPerformed(java.awt.event.ActionEvent evt)       {
         current = KeyEvent.VK_P;
         requestFocus();      }
   /**Action when escape button is clicked*/
       private void escapeActionPerformed(java.awt.event.ActionEvent evt)       {
         current = KeyEvent.VK_ESCAPE;
         requestFocus();      }
   /**Action when reset button is clicked*/
       private void resetActionPerformed(java.awt.event.ActionEvent evt)      {
         current = KeyEvent.VK_R;
         requestFocus();      }
   /**Action when mute button is clicked*/
       private void muteActionPerformed(java.awt.event.ActionEvent evt)       {
         current = KeyEvent.VK_SPACE;
         requestFocus();      }
   /**Takes user back to the menu*/
       private void menuActionPerformed(java.awt.event.ActionEvent evt) {
         MenuPanel.setKeys(myKeys);
         MenuPanel.setColors(sc, fc, bgc);
         SnakeDriver.reload(new MenuPanel(false), "Final Project: Snake!");      }
   /**Replaces current key with input*/
       private void formKeyPressed(java.awt.event.KeyEvent evt)       {
         myKeys.put(current, evt.getKeyCode());      }
   /**Events that occur every second*/
       public class Listener implements ActionListener      {
          public void actionPerformed(ActionEvent e)         {
            left.setText("Turn counter-clockwise: " + KeyEvent.getKeyText(myKeys.get(KeyEvent.VK_LEFT)));
            right.setText("Turn clockwise: "+ KeyEvent.getKeyText(myKeys.get(KeyEvent.VK_RIGHT)));
            pause.setText("Pause: " + KeyEvent.getKeyText(myKeys.get(KeyEvent.VK_P)));
            escape.setText("Return to main menu from game: " + KeyEvent.getKeyText(myKeys.get(KeyEvent.VK_ESCAPE)));
            reset.setText("Reset game: " + KeyEvent.getKeyText(myKeys.get(KeyEvent.VK_R)));
            mute.setText("Mute/Unmute: " + KeyEvent.getKeyText(myKeys.get(KeyEvent.VK_SPACE)));
            sc = new Color(sr.getValue(), sg.getValue(), sb.getValue());
            fc = new Color(fr.getValue(), fg.getValue(), fb.getValue());
            bgc = new Color(bgr.getValue(), bgg.getValue(), bgb.getValue());
            snakeLabel.setBackground(sc);
            foodLabel.setBackground(fc);
            backgroundLabel.setBackground(bgc);         }      }
   /**Create all elements of GUI*/
       private void initComponents() {
      
         jPanel1 = new javax.swing.JPanel();
         left = new javax.swing.JButton();
         right = new javax.swing.JButton();
         jLabel1 = new javax.swing.JLabel();
         sr = new javax.swing.JSlider();
         bgr = new javax.swing.JSlider();
         bgg = new javax.swing.JSlider();
         bgb = new javax.swing.JSlider();
         backgroundLabel = new javax.swing.JLabel();
         pause = new javax.swing.JButton();
         escape = new javax.swing.JButton();
         reset = new javax.swing.JButton();
         mute = new javax.swing.JButton();
         sb = new javax.swing.JSlider();
         sg = new javax.swing.JSlider();
         menu = new javax.swing.JButton();
         snakeLabel = new javax.swing.JLabel();
         foodLabel = new javax.swing.JLabel();
         fr = new javax.swing.JSlider();
         fg = new javax.swing.JSlider();
         fb = new javax.swing.JSlider();
      
         javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
         jPanel1.setLayout(jPanel1Layout);
         jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)        );
         jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)        );
      
         setBackground(new java.awt.Color(255, 255, 0));
         setPreferredSize(new java.awt.Dimension(600, 616));
         addKeyListener(
                new java.awt.event.KeyAdapter() {
                   public void keyPressed(java.awt.event.KeyEvent evt) {
                     formKeyPressed(evt);            }        });
      
         left.setBackground(new java.awt.Color(255, 255, 0));
         left.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
         left.setForeground(new java.awt.Color(0, 153, 0));
         left.setText("Turn counter-clockwise");
         left.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     leftActionPerformed(evt);            }        });
      
         right.setBackground(new java.awt.Color(255, 255, 0));
         right.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
         right.setForeground(new java.awt.Color(0, 153, 0));
         right.setText("Turn clockwise");
         right.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     rightActionPerformed(evt);            }        });
      
         jLabel1.setBackground(new java.awt.Color(0, 255, 255));
         jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
         jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
         jLabel1.setText("Click the desired button of change. Then press new key.");
      
         sr.setBackground(new java.awt.Color(255, 255, 0));
         sr.setMaximum(255);
         sr.setValue(sc.getRed());
      
         bgr.setBackground(new java.awt.Color(255, 255, 0));
         bgr.setMaximum(240);
         bgr.setValue(bgc.getRed());
      
         bgg.setBackground(new java.awt.Color(255, 255, 0));
         bgg.setMaximum(240);
         bgg.setValue(bgc.getGreen());
      
         bgb.setBackground(new java.awt.Color(255, 255, 0));
         bgb.setMaximum(240);
         bgb.setValue(bgc.getBlue());
      
         backgroundLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
         backgroundLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
         backgroundLabel.setText("Background Color");
         backgroundLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), null));
         backgroundLabel.setOpaque(true);
      
         pause.setBackground(new java.awt.Color(255, 255, 0));
         pause.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
         pause.setForeground(new java.awt.Color(0, 153, 0));
         pause.setText("Pause");
         pause.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     pauseActionPerformed(evt);            }        });
      
         escape.setBackground(new java.awt.Color(255, 255, 0));
         escape.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
         escape.setForeground(new java.awt.Color(0, 153, 0));
         escape.setText("Return to main menu");
         escape.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     escapeActionPerformed(evt);            }        });
      
         reset.setBackground(new java.awt.Color(255, 255, 0));
         reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
         reset.setForeground(new java.awt.Color(0, 153, 0));
         reset.setText("Reset game");
         reset.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     resetActionPerformed(evt);            }        });
      
         mute.setBackground(new java.awt.Color(255, 255, 0));
         mute.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
         mute.setForeground(new java.awt.Color(0, 153, 0));
         mute.setText("Mute/Unmute");
         mute.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     muteActionPerformed(evt);            }        });
      
         sb.setBackground(new java.awt.Color(255, 255, 0));
         sb.setMaximum(255);
         sb.setValue(sc.getBlue());
      
         sg.setBackground(new java.awt.Color(255, 255, 0));
         sg.setMaximum(255);
         sg.setValue(sc.getGreen());
      
         menu.setBackground(new java.awt.Color(255, 255, 0));
         menu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
         menu.setForeground(new java.awt.Color(0, 153, 0));
         menu.setText("Back to the main menu");
         menu.addActionListener(
                new java.awt.event.ActionListener() {
                   public void actionPerformed(java.awt.event.ActionEvent evt) {
                     menuActionPerformed(evt);            }        });
      
         snakeLabel.setBackground(new java.awt.Color(0, 204, 0));
         snakeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
         snakeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
         snakeLabel.setText("Snake Color");
         snakeLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
         snakeLabel.setOpaque(true);
      
         foodLabel.setBackground(new java.awt.Color(153, 153, 153));
         foodLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
         foodLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
         foodLabel.setText("Food Color");
         foodLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
         foodLabel.setOpaque(true);
      
         fr.setBackground(new java.awt.Color(255, 255, 0));
         fr.setValue(fc.getRed());
      
         fg.setBackground(new java.awt.Color(255, 255, 0));
         fg.setValue(fc.getGreen());
      
         fb.setBackground(new java.awt.Color(255, 255, 0));
         fb.setValue(fc.getBlue());
      
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
         this.setLayout(layout);
         layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(left, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(right, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(pause, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mute, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(escape, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sg, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(sb, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(sr, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(snakeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bgb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(bgr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(bgg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(backgroundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fr, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(fb, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(fg, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(foodLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
            );
         layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(left, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(escape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pause, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sr, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sg, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sb, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(snakeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(foodLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bgr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bgg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bgb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backgroundLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            ); }   }