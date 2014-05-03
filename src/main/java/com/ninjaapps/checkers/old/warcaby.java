import java.awt.*;
import java.awt.event.*;
import java.io.*;




public class warcaby
{
	public static void  main(String args[])
	{
		okno OknoGlowne = new okno("Warcaby",640,480);
	}	
} 

class okno extends Frame implements ActionListener, MouseListener
{
	Plansza plansza;
	Ruchy ruchy;
	Bicia bicia;
	Button bTest;
	Button bTest_2;
	Button bNowa;
	Label lTekst;
	
	public okno(String Nazwa, int szer, int wys)
	{
		super(Nazwa);
		setLayout(null);
		
		plansza = new Plansza();
//		plansza.start();
		ruchy = new Ruchy();
		bicia = new Bicia();
		
		setSize(szer,wys);
		setLocation(10,10);
		setFont(new Font("Arial",0,16));
		setResizable(false);
		setBackground(new Color(220,220,220));
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing (WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		bNowa = new Button("Nowa gra");
		bNowa.setSize(100,25);
		bNowa.setLocation(400,45);	
		bNowa.addActionListener(this);	
		add(bNowa);	
		
		bTest = new Button("Test 1");
		bTest.setSize(100,25);
		bTest.setLocation(400,145);	
		bTest.addActionListener(this);	
		add(bTest);	
		
		bTest_2 = new Button("Test 2");
		bTest_2.setSize(100,25);
		bTest_2.setLocation(400,195);	
		bTest_2.addActionListener(this);	
		add(bTest_2);	
		
		lTekst = new Label("Gracz:");
		lTekst.setSize(50,25);
		lTekst.setLocation(5,385);
		add(lTekst);
		
        addMouseListener(this);
        
        show();
	}
	
	public void paint(Graphics g)
	{
		RysujPlansze(g);
	}	
	
	public void RysujPlansze(Graphics g)
	{	
		Image img = createImage(getSize().width,getSize().height);
		
		Graphics2D g2 = (Graphics2D) img.getGraphics();
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(Color.black);
		g2.fillRect(18,38,322,322);	
				
		for (int j = 0; j < 8; j++)
		{
			for (int i = 0; i < 8; i++)	
			{
				if (plansza.pole[i][j] == 0) 
					g2.setColor(new Color(220,205,145)); //jasny
				else 
					g2.setColor(new Color(95,145,95)); //ciemny
				
				g2.fillRect(20 + 40*i, 40 + 40*j,38,38);	
				
				if (plansza.pole[i][j] > 1) 
				{
					g2.setColor(Color.black);
					g2.fillOval(21 + 40*i, 41 + 40*j,36,36);
					
					if (plansza.pole[i][j] == 2 || plansza.pole[i][j] == 4) 
						g2.setColor(new Color(245,240,240));
					if (plansza.pole[i][j] == 3 || plansza.pole[i][j] == 5) 
						g2.setColor(new Color(215,95,95));
						
					g2.fillOval(23 + 40*i, 43 + 40*j,32,32);
					
					if (plansza.pole[i][j] == 4 || plansza.pole[i][j] == 5) 
					{
						g2.setColor(Color.black);
						g2.fillOval(26 + 40*i, 46 + 40*j,26,26);	
					}
					
				}
				
				if (bicia.pole[i][j] != 0)
				{
					g2.setColor(new Color(215,95,95));
					g2.drawRect(20 + 40*i, 40 + 40*j,37,37);
				}
				
				if (ruchy.pole[i][j] == 1)
				{
					g2.setColor(new Color(50,100,250));
					g2.drawRect(20 + 40*i, 40 + 40*j,37,37);
				}
				
				if (ruchy.pole[i][j] == 2 || ruchy.pole[i][j] == 3)
				{
					g2.setColor(new Color(150,150,150));
					g2.fillRect(20 + 40*i, 40 + 40*j,38,38);
				}				
			}
		}
		
		g2.setColor(Color.black); //czarny
		g2.fillRect(58,378,42,42);
		
		g2.setColor(new Color(95,145,95)); //ciemny		
		g2.fillRect(60,380,38,38);
		
		if (ruchy.get_gracz() != 0 )
		{
			g2.setColor(Color.black);
			g2.fillOval(61,381,36,36);
					
			if (ruchy.get_gracz() == 1)
			{
				g2.setColor(new Color(245,240,240));
			}	
			else
			{
				g2.setColor(new Color(215,95,95));
			}
			g2.fillOval(63,383,32,32);
		}
		
	//	Image obraz = Toolkit.getDefaultToolkit().getImage("dupa.jpg");

		g.drawImage(img,0,0,this);
		
	//	g.drawImage(obraz, 0, 0, this);  
		
	}
	
	public void update(Graphics g)
	{
   		paint(g);
 	} 
	
	public void actionPerformed(ActionEvent ev)
	{
		Object 	cel = ev.getSource();
		if (cel == bNowa)
		{
			plansza.rozpoczecie();
			ruchy.zerowanie();
			ruchy.set_gracz(1);
			bicia.zerowanie();
			repaint();
		} 
		else if (cel == bTest)
		{
			int tmp_pole[][] = {{0,3,0,1,0,4,0,3},
						        {1,0,1,0,3,0,1,0},
							    {0,3,0,1,0,1,0,1},
							    {3,0,1,0,1,0,1,0},
							    {0,1,0,3,0,1,0,1},
							    {1,0,1,0,1,0,2,0},
							    {0,2,0,1,0,1,0,2},
							    {1,0,2,0,1,0,2,0},};
							 
			plansza.pole = tmp_pole;
			plansza.transpozycja();
			plansza.wyswietlanie();
			ruchy.zerowanie();
			ruchy.set_gracz(1);
			bicia.zerowanie();
			repaint();
		}
		else if (cel == bTest_2)
		{
			int tmp_pole[][] = {{0,3,0,1,0,4,0,3},
						        {1,0,1,0,1,0,1,0},
							    {0,3,0,1,0,1,0,1},
							    {3,0,1,0,1,0,1,0},
							    {0,1,0,3,0,4,0,1},
							    {1,0,1,0,1,0,2,0},
							    {0,2,0,1,0,1,0,2},
							    {1,0,2,0,5,0,2,0},};
							 
			plansza.pole = tmp_pole;
			plansza.transpozycja();
			plansza.wyswietlanie();
			ruchy.zerowanie();
			ruchy.set_gracz(1);
			bicia.zerowanie();
			repaint();
		}
	}
	
	public void mouseClicked(MouseEvent ev)
	{
		int x = ev.getX();
		int y = ev.getY();
				
		if (x >= 20 && x < 340 && y >= 40 && y < 360 
		    && (x + 22)%40 != 0 && (x + 21)%40 != 0
		    && (y + 2)%40 != 0 && (y + 1)%40 != 0)
		    {
		    	int _x, _y;
		    	_x = (x - 20)/40;
		    	_y = (y - 40)/40;
		    	System.out.println(_x + " " + _y);
		    	bicia.sprawdz_bicia(ruchy.get_gracz(),plansza);
		    	ruchy.klikniecie(_x,_y,plansza,bicia);
		    	repaint();
		    }
	}
	
	public void mousePressed(MouseEvent ev){}
	
	public void mouseReleased(MouseEvent ev){}
	
	public void mouseEntered(MouseEvent ev){}
	
	public void mouseExited(MouseEvent ev){}
}

class Tablica
{
	public int pole[][];
	
	public Tablica()
	{
		pole = new int[8][8];
		this.zerowanie();
	}
	
	public void zerowanie()
	{		
		for (int j = 0; j < 8; j++)
		{
			for (int i = 0; i < 8; i++)			
			{
				pole[i][j] = 0;	
			}
		}
	}
	
	public void wyswietlanie()
	{
		for (int j = 0; j < 8; j++)	
		{
			for (int i = 0; i < 8; i++)
			{
				System.out.print(pole[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void transpozycja()
	{
		int tmp_pole[][] = new int[8][8];
		for (int j = 0; j < 8; j++)	
		{
			for (int i = 0; i < 8; i++)
			{
				tmp_pole[j][i] = pole[i][j];
			}
		}
		pole = tmp_pole;
	}
}

class Plansza extends Tablica
{
	public Plansza(){}	

	public void zerowanie()
	{
		int k = 1;
		for (int j = 0; j < 8; j++)	
		{
			k = (k + 1) % 2;
			for (int i = 0; i < 8; i++)
			{	
				pole[i][j] = k;
				k = (k + 1) % 2;
			}
		}		
	}
	
	public void rozpoczecie()
	{
		zerowanie();
	//	gracz 2 - gora planszy
		for (int j = 0; j < 3; j++)	
			for (int i = 0; i < 8; i++)
				if (pole[i][j] == 1) pole[i][j] = 3;
	
	//	gracz 1 - dol planszy		
		for (int j = 5; j < 8; j++)	
			for (int i = 0; i < 8; i++)
				if (pole[i][j] == 1) pole[i][j] = 2;
	}
}

class Ruchy extends Tablica
{
	private int old_x;
	private int old_y;
	private int gracz;
	
	public Ruchy()
	{
		this.set_gracz(0);
	}

	public void klikniecie(int x,int y,Plansza p, Bicia b)
	{
		b.sprawdz_bicia(gracz,p);
		
		if (this.pole[x][y] == 0)
		{
			this.zerowanie();
			if (p.pole[x][y] > 1) //je�eli w polu znajduje si� pionek
			{	
				this.pole[x][y] = 1; //obecnie zaznaczony pionek
				
				//je�eli jest to pionek gracza 1
				if (p.pole[x][y] == 2 && this.gracz == 1) 
				{
					if (x > 0 && y > 0 && p.pole[x - 1][y - 1] == 1 && !b.przymus)
						this.pole[x - 1][y - 1] = 2;
				
					if (x < 7 && y > 0 && p.pole[x + 1][y - 1] == 1 && !b.przymus)
						this.pole[x + 1][y - 1] = 2;
					
					if (x > 1 && y > 1 && (p.pole[x - 1][y - 1] == 3
						|| p.pole[x - 1][y - 1] == 5) && p.pole[x - 2][y - 2] == 1)
					{
						this.pole[x - 2][y - 2] = 3;
					}		
					
					if (x < 6 && y > 1 && (p.pole[x + 1][y - 1] == 3
						|| p.pole[x + 1][y - 1] == 5) && p.pole[x + 2][y - 2] == 1)
					{
						this.pole[x + 2][y - 2] = 3;
					}
											
					if (x > 1 && y < 6 && (p.pole[x - 1][y + 1] == 3
						|| p.pole[x - 1][y + 1] == 5) && p.pole[x - 2][y + 2] == 1)
					{	
						this.pole[x - 2][y + 2] = 3;
					}
						
					if (x < 6 && y < 6 && (p.pole[x + 1][y + 1] == 3
						|| p.pole[x + 1][y + 1] == 5) && p.pole[x + 2][y + 2] == 1)
					{
						this.pole[x + 2][y + 2] = 3;
					}
						
				}
				//je�eli jest to pionek racza 2
				else if (p.pole[x][y] == 3 && this.gracz == 2) 
				{
					if (x > 0 && y < 7 && p.pole[x - 1][y + 1] == 1 && !b.przymus)
						this.pole[x - 1][y + 1] = 2;
						
					if (x < 7 && y < 7 && p.pole[x + 1][y + 1] == 1 && !b.przymus)
						this.pole[x + 1][y + 1] = 2;
					
					if (x > 1 && y < 6 && (p.pole[x - 1][y + 1] == 2
						|| p.pole[x - 1][y + 1] == 4) && p.pole[x - 2][y + 2] == 1)
					{	
						this.pole[x - 2][y + 2] = 3;
					}
					
					if (x < 6 && y < 6 && (p.pole[x + 1][y + 1] == 2
						|| p.pole[x + 1][y + 1] == 4) && p.pole[x + 2][y + 2] == 1)
					{	
						this.pole[x + 2][y + 2] = 3;
					}
					
					if (x > 1 && y > 1 && (p.pole[x - 1][y - 1] == 2
						|| p.pole[x - 1][y - 1] == 4) && p.pole[x - 2][y - 2] == 1)
					{
						this.pole[x - 2][y - 2] = 3;
					}
					
					if (x < 6 && y > 1 && (p.pole[x + 1][y - 1] == 2
						|| p.pole[x + 1][y - 1] == 4) && p.pole[x + 2][y - 2] == 1)
					{
						this.pole[x + 2][y - 2] = 3;
					}
				}
				//je�eli jest to damka gracza 1 lub gracza 2
				else if ((p.pole[x][y] == 4 && this.gracz == 1)
					|| (p.pole[x][y] == 5 && this.gracz == 2))
				{
					int i = 0; int j = 0;
					int add = (gracz == 1) ? 1 : 0;
					
					while (!b.przymus && x+i > 0 && y+j > 0)
					{
						if (p.pole[x+i - 1][y+j - 1] == 1)
						{
							this.pole[x+i - 1][y+j - 1] = 2;
							--i;
							--j;
						}
						else break;
					}
					
					i = 0; j = 0;
					
					while (!b.przymus && x+i < 7 && y+j > 0)
					{
						if (p.pole[x+i + 1][y+j - 1] == 1)
						{
							this.pole[x+i + 1][y+j - 1] = 2;
							++i;
							--j;
						}
						else break;
					}
					
					i = 0; j = 0;
					
					while (!b.przymus && x+i > 0 && y+j < 7)
					{
						if (p.pole[x+i - 1][y+j + 1] == 1)
						{
							this.pole[x+i - 1][y+j + 1] = 2;
							--i;
							++j;
						}
						else break;
					}
					
					i = 0; j = 0;
					
					while (!b.przymus && x+i < 7 && y+j < 7)
					{
						if (p.pole[x+i + 1][y+j + 1] == 1)
						{
							this.pole[x+i + 1][y+j + 1] = 2;
							++i;
							++j;
						}
						else break;
					}
					
					boolean bij = false; i = 0; j = 0;	
		
					while (x+i > 0 && y+j > 0)
					{
						if (p.pole[x+i - 1][y+j - 1] == 1)
						{
							if (bij) this.pole[x+i - 1][y+j - 1] = 3;
							--i;
							--j;
						}
						else if (p.pole[x+i - 1][y+j - 1] == 2+add || p.pole[x+i - 1][y+j - 1] == 4+add)
						{
							if (!bij) 
							{
								bij = true;
								--i;
								--j;
							}
							else break;
						}
						else break;
					}
					
					bij = false; i = 0; j = 0;	
					
					while (x+i < 7 && y+j > 0)
					{
						if (p.pole[x+i + 1][y+j - 1] == 1)
						{
							if (bij) this.pole[x+i + 1][y+j - 1] = 3;
							++i;
							--j;
						}
						else if (p.pole[x+i + 1][y+j - 1] == 2+add || p.pole[x+i + 1][y+j - 1] == 4+add)
						{
							if (!bij) 
							{
								bij = true;
								++i;
								--j;
							}
							else break;
						}
						else break;
					}
					
					bij = false; i = 0; j = 0;	
		
					while (x+i > 0 && y+j < 7)
					{
						if (p.pole[x+i - 1][y+j + 1] == 1)
						{
							if (bij) this.pole[x+i - 1][y+j + 1] = 3;
							--i;
							++j;
						}
						else if (p.pole[x+i - 1][y+j + 1] == 2+add || p.pole[x+i - 1][y+j + 1] == 4+add)
						{
							if (!bij) 
							{
								bij = true;
								--i;
								++j;
							}
							else break;
						}
						else break;
					}
					
					bij = false; i = 0; j = 0;	
					
					while (x+i < 7 && y+j < 7)
					{
						if (p.pole[x+i + 1][y+j + 1] == 1)
						{
							if (bij) this.pole[x+i + 1][y+j + 1] = 3;
							++i;
							++j;
						}
						else if (p.pole[x+i + 1][y+j + 1] == 2+add || p.pole[x+i + 1][y+j + 1] == 4+add)
						{
							if (!bij) 
							{
								bij = true;
								++i;
								++j;
							}
							else break;
						}
						else break;
					}					
				}
				
				this.wyswietlanie();
			}
			
			old_x = x;
			old_y = y;
		}/*
		else if (this.fields[x][y] == 1)
		{
			this.clearFields();
		}*/
		else if (this.pole[x][y] == 2)
		{
			p.pole[x][y] = p.pole[old_x][old_y];
			p.pole[old_x][old_y] = 1;
			this.zerowanie();
			zamien_pionki_na_damki(p);
			this.zmiana_gracza();
		}
		else if (this.pole[x][y] == 3)
		{
			p.pole[x][y] = p.pole[old_x][old_y];
			int i = old_x;
			int j = old_y;
			int add_i = (old_x < x) ? 1 : -1;
			int add_j = (old_y < y) ? 1 : -1;
			int kill_x = i+add_i;
			int kill_y = j+add_j;
			while (kill_x != x && kill_y != y)
			{
				p.pole[kill_x][kill_y] = 1;
				kill_x += add_i;
				kill_y += add_j;
				System.out.println("kiler : " + kill_x + " " + kill_y);
			}
			p.pole[old_x][old_y] = 1;
			this.zerowanie();
			b.sprawdz_bicia(gracz,p,x,y);
			if (!b.przymus)
			{
				zamien_pionki_na_damki(p);
				this.zmiana_gracza();
			}
			else
			{
				klikniecie(x,y,p,b);
			}
		}
		
		b.sprawdz_bicia(gracz,p);
	}
	
	public void set_gracz(int gracz)
	{
		this.gracz = gracz;
		System.out.println("Gracz " + this.gracz);
	}
	
	public int get_gracz()
	{
		return this.gracz;	
	}
	
	public void zmiana_gracza()
	{
		if (this.gracz == 1)
		{
			this.set_gracz(2);
		}
		else if (this.gracz == 2)
		{
			this.set_gracz(1);
		}
	}
	
	public void zamien_pionki_na_damki(Plansza p)
	{
		if (gracz == 1)
		{
			for (int i = 0; i < 8; i++)
				if (p.pole[i][0] == 2 ) p.pole[i][0] = 4;
		}
		else if (gracz == 2)
		{
			for (int i = 0; i < 8; i++)
				if (p.pole[i][7] == 3 ) p.pole[i][7] = 5;
		}	
		p.wyswietlanie();	
	}
	
}

class Bicia extends Tablica
{
	public boolean przymus;
	
	public Bicia()
	{
		przymus = false;
	}
		
	private int get_bicia(int x,int y,Plansza p)
	{
		int wynik = 0;
		
		if (p.pole[x][y] == 2)
		{
			if (x > 1 && y > 1 && (p.pole[x - 1][y - 1] == 3
			|| p.pole[x - 1][y - 1] == 5) && p.pole[x - 2][y - 2] == 1)
				wynik = wynik + 1;
					
			if (x < 6 && y > 1 && (p.pole[x + 1][y - 1] == 3
			|| p.pole[x + 1][y - 1] == 5) && p.pole[x + 2][y - 2] == 1)
				wynik = wynik + 2;
											
			if (x > 1 && y < 6 && (p.pole[x - 1][y + 1] == 3
			|| p.pole[x - 1][y + 1] == 5) && p.pole[x - 2][y + 2] == 1)
				wynik = wynik + 4;	
						
			if (x < 6 && y < 6 && (p.pole[x + 1][y + 1] == 3
			|| p.pole[x + 1][y + 1] == 5) && p.pole[x + 2][y + 2] == 1)
				wynik = wynik + 8;	
		}
		else if (p.pole[x][y] == 3)
		{
			if (x > 1 && y < 6 && (p.pole[x - 1][y + 1] == 2
			|| p.pole[x - 1][y + 1] == 4) && p.pole[x - 2][y + 2] == 1)
				wynik = wynik + 1;	
						
			if (x < 6 && y < 6 && (p.pole[x + 1][y + 1] == 2
			|| p.pole[x + 1][y + 1] == 4) && p.pole[x + 2][y + 2] == 1)
				wynik = wynik + 2;
					
			if (x > 1 && y > 1 && (p.pole[x - 1][y - 1] == 2
			|| p.pole[x - 1][y - 1] == 4) && p.pole[x - 2][y - 2] == 1)
				wynik = wynik + 4;
					
			if (x < 6 && y > 1 && (p.pole[x + 1][y - 1] == 2
			|| p.pole[x + 1][y - 1] == 4) && p.pole[x + 2][y - 2] == 1)
				wynik = wynik + 8;
		}
		else if (p.pole[x][y] == 4)
		{
			int i = 0; int j = 0;
			while (x+i > 1 && y+j > 1)
			{
				if ((p.pole[x+i - 1][y+j - 1] == 3 || p.pole[x+i - 1][y+j - 1] == 5) 
					&& p.pole[x+i - 2][y+j - 2] == 1)
				{
					wynik = wynik + 1;	
					break;	
				}
				else if (p.pole[x+i - 1][y+j - 1] != 1)
				{
					break;	
				}
				else 
				{
					--i;
					--j;					
				}
			}
			
			i = 0; j = 0;
			
			while (x+i < 6 && y+j > 1)
			{		
				if ((p.pole[x+i + 1][y+j - 1] == 3 || p.pole[x+i + 1][y+j - 1] == 5) 
					&& p.pole[x+i + 2][y+j - 2] == 1)
				{
					wynik = wynik + 2;
					break;	
				}
				else if (p.pole[x+i + 1][y+j - 1] != 1)
				{
					break;	
				}
				else
				{
					++i;
					--j;	
				}
			}	
			
			i = 0; j = 0;
			
			while (x+i > 1 && y+j < 6)
			{
				if ((p.pole[x+i - 1][y+j + 1] == 3 || p.pole[x+i - 1][y+j + 1] == 5) 
					&& p.pole[x+i - 2][y+j + 2] == 1)	
				{
					wynik = wynik + 4;			
					break;	
				}
				else if (p.pole[x+i - 1][y+j + 1] != 1)
				{
					break;	
				}
				else
				{
					--i;
					++j;	
				}				
			}
			
			i = 0; j = 0;		
										
			while (x+i < 6 && y+j < 6)	
			{
				if ((p.pole[x+i + 1][y+i + 1] == 3 || p.pole[x+i + 1][y+j + 1] == 5) 
					&& p.pole[x+j + 2][y+j + 2] == 1)
				{
					wynik = wynik + 8;		
					break;	
				}
				else if (p.pole[x+i + 1][y+j + 1] != 1)
				{
					break;	
				}
				else
				{
					++i;
					++j;	
				}
			}			
			
		} 
		else if (p.pole[x][y] == 5)
		{
			int i = 0; int j = 0;
			while (x+i > 1 && y+j > 1)
			{
				if ((p.pole[x+i - 1][y+j - 1] == 2 || p.pole[x+i - 1][y+j - 1] == 4) 
					&& p.pole[x+i - 2][y+j - 2] == 1)
				{
					wynik = wynik + 4;	
					break;	
				}
				else if (p.pole[x+i - 1][y+j - 1] != 1)
				{
					break;	
				}
				else 
				{
					--i;
					--j;					
				}
			}
			
			i = 0; j = 0;
			
			while (x+i < 6 && y+j > 1)
			{		
				if ((p.pole[x+i + 1][y+j - 1] == 2 || p.pole[x+i + 1][y+j - 1] == 4) 
					&& p.pole[x+i + 2][y+j - 2] == 1)
				{
					wynik = wynik + 8;
					break;	
				}
				else if (p.pole[x+i + 1][y+j - 1] != 1)
				{
					break;	
				}
				else
				{
					++i;
					--j;	
				}
			}	
			
			i = 0; j = 0;
			
			while (x+i > 1 && y+j < 6)
			{
				if ((p.pole[x+i - 1][y+j + 1] == 2 || p.pole[x+i - 1][y+j + 1] == 4) 
					&& p.pole[x+i - 2][y+j + 2] == 1)	
				{
					wynik = wynik + 1;			
					break;	
				}
				else if (p.pole[x+i - 1][y+j + 1] != 1)
				{
					break;	
				}
				else
				{
					--i;
					++j;	
				}				
			}
			
			i = 0; j = 0;		
										
			while (x+i < 6 && y+j < 6)	
			{
				if ((p.pole[x+i + 1][y+i + 1] == 2 || p.pole[x+i + 1][y+j + 1] == 4) 
					&& p.pole[x+j + 2][y+j + 2] == 1)
				{
					wynik = wynik + 2;		
					break;	
				}
				else if (p.pole[x+i + 1][y+j + 1] != 1)
				{
					break;	
				}
				else
				{
					++i;
					++j;	
				}
			}			
			
		}
		
		if (wynik != 0) przymus = true;
		
		return wynik;
	}
	
	public void sprawdz_bicia(int gracz, Plansza p)
	{
		zerowanie();
		przymus = false;
		
		for (int j = 0; j < 8; j++)	
			for (int i = 0; i < 8; i++)
				if ((gracz + 1) == p.pole[i][j] || (gracz + 3) == p.pole[i][j])
				{
					this.pole[i][j] = get_bicia(i,j,p);
				}
				else
				{
					this.pole[i][j] = 0;
				}				
//		this.showFields();
	}
	
	public void sprawdz_bicia(int gracz, Plansza p, int x, int y)
	{
		zerowanie();
		przymus = false;
		
		this.pole[x][y] = get_bicia(x,y,p);
	}
}
