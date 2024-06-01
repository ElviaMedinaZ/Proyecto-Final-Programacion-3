package vista;

import java.awt.Color;

/**
	 * @author WollderSleep
	 */
	@SuppressWarnings("serial")
	public class Vista_calculadora extends javax.swing.JFrame {

	    public float primerNumero;
	    public float segundoNumero;
	    public String operador;
	    
	    public Vista_calculadora() {
	        initComponents();
	        this.setLocationRelativeTo(null);
	        this.setResizable(false);
	    }

	    
	    private void initComponents() {

	        jPanel1 = new javax.swing.JPanel();
	        casilla = new javax.swing.JLabel();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jButton4 = new javax.swing.JButton();
	        jButton5 = new javax.swing.JButton();
	        jButton7 = new javax.swing.JButton();
	        jButton8 = new javax.swing.JButton();
	        jButton10 = new javax.swing.JButton();
	        jButton12 = new javax.swing.JButton();
	        jButton13 = new javax.swing.JButton();
	        jButton6 = new javax.swing.JButton();
	        jButton9 = new javax.swing.JButton();
	        jButton15 = new javax.swing.JButton();
	        jButton16 = new javax.swing.JButton();
	        jButton17 = new javax.swing.JButton();
	        jButton18 = new javax.swing.JButton();
	        jButton19 = new javax.swing.JButton();
	        jButton20 = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	        jPanel1.setBackground(Color.decode("#C7D8D5"));

	        casilla.setBackground(Color.decode("#94A89C"));
	        casilla.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
	        casilla.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
	        casilla.setOpaque(true);

	        jButton2.setText("4");
	        jButton2.setBackground(Color.decode("#00758E"));
	        jButton2.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton2ActionPerformed(evt);
	            }
	        });

	        jButton3.setText("6");
	        jButton3.setBackground(Color.decode("#00758E"));
	        jButton3.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton3ActionPerformed(evt);
	            }
	        });

	        jButton4.setText("5");
	        jButton4.setBackground(Color.decode("#00758E"));
	        jButton4.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton4ActionPerformed(evt);
	            }
	        });

	        jButton5.setText("8");
	        jButton5.setBackground(Color.decode("#00758E"));
	        jButton5.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton5ActionPerformed(evt);
	            }
	        });

	        jButton7.setText("1");
	        jButton7.setBackground(Color.decode("#00758E"));
	        jButton7.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton7ActionPerformed(evt);
	            }
	        });

	        jButton8.setText("0");
	        jButton8.setBackground(Color.decode("#00758E"));
	        jButton8.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton8ActionPerformed(evt);
	            }
	        });

	        jButton10.setText(".");
	        jButton10.setBackground(Color.decode("#488D75"));
	        jButton10.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton10ActionPerformed(evt);
	            }
	        });

	        jButton12.setText("9");
	        jButton12.setBackground(Color.decode("#00758E"));
	        jButton12.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton12ActionPerformed(evt);
	            }
	        });

	        jButton13.setText("=");
	        jButton13.setBackground(Color.decode("#488D75"));
	        jButton13.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton13ActionPerformed(evt);
	            }
	        });

	        jButton6.setText("2");
	        jButton6.setBackground(Color.decode("#00758E"));
	        jButton6.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton6ActionPerformed(evt);
	            }
	        });

	        jButton9.setText("3");
	        jButton9.setBackground(Color.decode("#00758E"));
	        jButton9.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton9ActionPerformed(evt);
	            }
	        });

	        jButton15.setText("7");
	        jButton15.setBackground(Color.decode("#00758E"));
	        jButton15.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton15ActionPerformed(evt);
	            }
	        });

	        jButton16.setText("+");
	        jButton16.setBackground(Color.decode("#488D75"));
	        jButton16.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton16ActionPerformed(evt);
	            }
	        });

	        jButton17.setText("C");
	        jButton17.setBackground(Color.decode("#488D75"));
	        jButton17.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton17ActionPerformed(evt);
	            }
	        });

	        jButton18.setText("/");
	        jButton18.setBackground(Color.decode("#488D75"));
	        jButton18.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton18ActionPerformed(evt);
	            }
	        });

	        jButton19.setText("*");
	        jButton19.setBackground(Color.decode("#488D75"));
	        jButton19.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton19ActionPerformed(evt);
	            }
	        });

	        jButton20.setText("-");
	        jButton20.setBackground(Color.decode("#488D75"));
	        jButton20.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton20ActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(casilla, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
	                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGroup(jPanel1Layout.createSequentialGroup()
	                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addGroup(jPanel1Layout.createSequentialGroup()
	                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addGroup(jPanel1Layout.createSequentialGroup()
	                                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addGroup(jPanel1Layout.createSequentialGroup()
	                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap(12, Short.MAX_VALUE)
	                .addComponent(casilla, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(3, 3, 3)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	    }// </editor-fold>                        

	    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        this.casilla.setText(this.casilla.getText()+"4");
	    }                                        

	    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        this.casilla.setText(this.casilla.getText()+"6");
	    }                                        

	    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        this.casilla.setText(this.casilla.getText()+"5");
	    }                                        

	    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        this.casilla.setText(this.casilla.getText()+"8");
	    }                                        

	    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        this.casilla.setText(this.casilla.getText()+"1");
	    }                                        

	    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        this.casilla.setText(this.casilla.getText()+"0");
	    }                                        

	    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                          
	        if(!this.casilla.getText().contains(("."))){
	        this.casilla.setText(this.casilla.getText()+".");
	        }
	        
	    }                                         

	    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {                                          
	        this.casilla.setText(this.casilla.getText()+"9");
	    }                                         

	    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {                                          
	       this.segundoNumero=Float.parseFloat(this.casilla.getText());
	       switch(this.operador){
	           case "+": this.casilla.setText(sincero(this.primerNumero + this.segundoNumero)); break;
	           case "-": this.casilla.setText(sincero(this.primerNumero - this.segundoNumero)); break;
	           case "/": if(this.segundoNumero==0){this.casilla.setText("No se divide entre cero >:(");}
	           else {
	            this.casilla.setText(sincero(this.primerNumero / this.segundoNumero));} break;
	                     
	               
	           case "*": this.casilla.setText(sincero(this.primerNumero * this.segundoNumero)); break;
	           
	       
	       }
	    }                                         

	    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        this.casilla.setText(this.casilla.getText()+"2");
	    }                                        

	    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        this.casilla.setText(this.casilla.getText()+"3");
	    }                                        

	    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {                                          
	        this.casilla.setText(this.casilla.getText()+"7");
	    }                                         

	    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {                                          
	       this.primerNumero=Float.parseFloat(this.casilla.getText());
	       this.operador="+";
	       this.casilla.setText("");
	       
	    }                                         

	    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {                                          
	        this.casilla.setText("");
	    }                                         

	    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {                                          
	        this.primerNumero=Float.parseFloat(this.casilla.getText());
	       this.operador="/";
	       this.casilla.setText("");
	    }                                         

	    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {                                          
	        this.primerNumero=Float.parseFloat(this.casilla.getText());
	       this.operador="*";
	       this.casilla.setText("");
	    }                                         

	    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {                                          
	        this.primerNumero=Float.parseFloat(this.casilla.getText());
	       this.operador="-";
	       this.casilla.setText("");
	    }                                         

	    public String sincero(float resultado){
	          String retorno="";
	     retorno=Float.toString(resultado);
	           if(resultado%1==0){
	               retorno=retorno.substring(0,retorno.length()-2);
	           
	           }
	          
	          return retorno;
	    }
	    

	    // Variables declaration - do not modify                     
	    private javax.swing.JLabel casilla;
	    private javax.swing.JButton jButton10;
	    private javax.swing.JButton jButton12;
	    private javax.swing.JButton jButton13;
	    private javax.swing.JButton jButton15;
	    private javax.swing.JButton jButton16;
	    private javax.swing.JButton jButton17;
	    private javax.swing.JButton jButton18;
	    private javax.swing.JButton jButton19;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton20;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JButton jButton4;
	    private javax.swing.JButton jButton5;
	    private javax.swing.JButton jButton6;
	    private javax.swing.JButton jButton7;
	    private javax.swing.JButton jButton8;
	    private javax.swing.JButton jButton9;
	    private javax.swing.JPanel jPanel1;
	    // End of variables declaration                   
	}

