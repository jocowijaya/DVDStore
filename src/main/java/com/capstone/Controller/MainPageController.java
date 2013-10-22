package com.capstone.Controller;

import com.capstone.EJB.EmployeeEJB;
import com.capstone.EJB.OrderEJB;
import com.capstone.EJB.ProductEJB;
import com.capstone.Entity.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.joda.time.DateMidnight;
import org.joda.time.Days;
import org.primefaces.event.RowEditEvent;

@ManagedBean
@SessionScoped
public class MainPageController
{
    @EJB
    private ProductEJB productEJB;

    @EJB
    private EmployeeEJB employeeEJB;
    
    @EJB
    private OrderEJB orderEJB;

    private Product product = new Product();
    private ProductDescription productDescription = new ProductDescription();
    private Movie movie = new Movie();
    private Game game = new Game();
    private Soundtrack soundtrack = new Soundtrack();
    private SalesProduct salesProduct = new SalesProduct();
    private LeasesProduct leasesProduct = new LeasesProduct();
    private List<Product> listProducts = new ArrayList<Product>();
    private List<Movie> listMovie = new ArrayList<Movie>();
    private List<Game> listGame = new ArrayList<Game>();
    private List<Soundtrack> listSoundtrack = new ArrayList<Soundtrack>();
    private List<String> listCategories = new ArrayList<String>();
    private String type;
    private String dateReleased;
    private Object[] productDetails;
    private List<Object[]> buyItemsDetails = new ArrayList<Object[]>();
    private List<Object[]> rentItemsDetails = new ArrayList<Object[]>();
    private List<SalesOrderDetail> salesOrderDetails = new ArrayList<SalesOrderDetail>();
    private List<LeasesOrderDetail> leasesOrderDetails = new ArrayList<LeasesOrderDetail>();
    private boolean movie_special;
    private boolean game_special;
    private boolean soundtrack_special;
    private final static String[] listType;
    private String strSearch;
    private Long id;
    private Double buySubTotal = 0.0;
    private Double rentSubTotal = 0.0;
    private Double subTotal = 0.0;
    private DecimalFormat twoDForm = new DecimalFormat("#.##");
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    static {
        listType = new String[3];
        listType[0] = "Movie";
        listType[1] = "Game";
        listType[2] = "Soundtrack";
    }

    @PostConstruct
    public void setData()
    {
        listCategories = productEJB.findCategories("select DISTINCT pd.category from Movie As m JOIN m.productDescription As pd");
        listProducts = productEJB.findProductsWithType("select p from Product p, Movie m where p.PID = m.PID");
        type = "Movie";
        if(listProducts.size() == 0)
        {
            try
            {
		Employee e1 = new Employee("admin@yahoo.com", "admin", "Duy", "Huynh", "0405034432", "Admin");
        	boolean ch = employeeEJB.createEmployee(e1);

                SystemRequirement sys1 = new SystemRequirement();
		sys1.setCPU("AMD Athlon 64 X2 Dual-Core 4000");
		sys1.setRAM("1.5GB (Windows XP)");
		sys1.setVGA("ATI X1800");
		sys1.setHDD("Approximately 8 GB ");
		sys1.setOS("Windows XP/Vista/7");
		sys1.setSound("DirectX® 9.0c Compatible Sound Card");
		sys1.setNote("Note that Windows® 95, Windows® 98, Windows® 2000, Windows® ME, and Windows® NT 4.0 are not supported.");
		boolean check1 = productEJB.createSystemRequirement(sys1);

                SystemRequirement sys2 = new SystemRequirement();
		sys2.setCPU("CDB MAXXIS 32 X2 Dual-Core 3000");
		sys2.setRAM("2.5GB (Windows XP)");
		sys2.setVGA("ATI X1800 or better* /nnVidia 7800");
		sys2.setHDD("Approximately 8 GB ");
		sys2.setOS("Windows XP/7");
		sys2.setSound("DirectX® 8.5c Compatible Sound Card");
		sys2.setNote("Note that Windows® 95, Windows® 98, Windows® 2000, Windows® ME, and Windows® NT 4.0 are not supported.");
                boolean check2 = productEJB.createSystemRequirement(sys2);

                SystemRequirement sys3 = new SystemRequirement();
		sys3.setCPU("FDX BRIESK 20 X5 Dual-Core 5000");
		sys3.setRAM("2.5GB (Windows XP)");
		sys3.setVGA("ATI X2200");
		sys3.setHDD("Approximately 8 GB");
		sys3.setOS("Windows XP/Vista");
		sys3.setSound("DirectX® 10.0c Compatible Sound Card");
		sys3.setNote("Note that Windows® 95, Windows® 98, Windows® 2000, Windows® ME, and Windows® NT 4.0 are not supported.");
                boolean check3 = productEJB.createSystemRequirement(sys3);

                SystemRequirement sys4 = new SystemRequirement();
		sys4.setCPU("DOMD Ithlon 20 X2 Dual-Core 4000");
		sys4.setRAM("3.5GB (Windows XP)");
		sys4.setVGA("ATI X2100 ");
		sys4.setHDD("Approximately 4 GB ");
		sys4.setOS("Windows Vista/7");
		sys4.setSound("DirectX® 9.0c Compatible Sound Card");
		sys4.setNote("Note that Windows® 95, Windows® 98, Windows® 2000, Windows® ME, and Windows® NT 4.0 are not supported.");
                boolean check4 = productEJB.createSystemRequirement(sys4);

                SystemRequirement sys5 = new SystemRequirement();
		sys5.setCPU("DOD Othen 32 X2 Dual-Core 4000");
		sys5.setRAM("1.0GB (Windows XP)");
		sys5.setVGA("ATI X3000");
		sys5.setHDD("Approximately 4.5 GB ");
		sys5.setOS("Windows XP/Vista");
		sys5.setSound("DirectX® 9.0c Compatible Sound Card");
		sys5.setNote("Note that Windows® 95, Windows® 98, Windows® 2000, Windows® ME, and Windows® NT 4.0 are not supported.");
                boolean check5 = productEJB.createSystemRequirement(sys5);

           	SystemRequirement sys6 = new SystemRequirement();
		sys6.setCPU("MODREN PISO 32 X2 Dual-Core 4000");
		sys6.setRAM("2.5GB (Windows XP)");
		sys6.setVGA("ATI X2800");
		sys6.setHDD("Approximately 6 GB");
		sys6.setOS("Windows /7");
		sys6.setSound("DirectX® 9.0c Compatible Sound Card");
		sys6.setNote("Note that Windows® 95, Windows® 98, Windows® 2000, Windows® ME, and Windows® NT 4.0 are not supported.");
                boolean check6 = productEJB.createSystemRequirement(sys6);


		ProductDescription pd1 = new ProductDescription("Play as Merida, a Will 'o the Wisp and other popular characters..","Action Adventure", "Nintendo DS, Nintendo Wii, Playstation 3, X Box 360", "English", new Date());
                ProductDescription pd2 = new ProductDescription("Players will become Captain America as he faces the Red Skull...","Action Adventure", "Nintendo Wii, Playstation 3, X Box 360", "English", new Date());
                ProductDescription pd3 = new ProductDescription("Disney Universe is an off-the-wall non-stop multiplayer action-adventure..","Action Adventure", "Nintendo Wii, Playstation 3", "English", new Date());
                boolean check7 = productEJB.createProductDescription(pd1);
                boolean check8 = productEJB.createProductDescription(pd2);
                boolean check9 = productEJB.createProductDescription(pd3);

                ProductDescription pd4 = new ProductDescription("In Pro Evolution Soccer 2013, players are given greater freedom over..","Sport", "Nintendo Wii, Playstation 3", "English", new Date());
                ProductDescription pd5 = new ProductDescription("When the game is on the line and the ball is in your hands..","Sport", "Nintendo Wii, Playstation 3", "English", new Date());
                ProductDescription pd6 = new ProductDescription("With all-new features, improved gameplay...","Sport", "Nintendo Wii, Playstation 3", "English", new Date());
                boolean check10 = productEJB.createProductDescription(pd4);
                boolean check11 = productEJB.createProductDescription(pd5);
                boolean check12 = productEJB.createProductDescription(pd6);

		SalesProduct sp1 = new SalesProduct(35.50, 5);
		SalesProduct sp2 = new SalesProduct(40.00, 5);
                SalesProduct sp3 = new SalesProduct(30.00, 5);
                SalesProduct sp4 = new SalesProduct(45.50, 5);
                SalesProduct sp5 = new SalesProduct(25.50, 5);
                SalesProduct sp6 = new SalesProduct(30.50, 5);
                boolean check13 = productEJB.createSalesProduct(sp1);
                boolean check14 = productEJB.createSalesProduct(sp2);
                boolean check15 = productEJB.createSalesProduct(sp3);
                boolean check16 = productEJB.createSalesProduct(sp4);
                boolean check17 = productEJB.createSalesProduct(sp5);
                boolean check18 = productEJB.createSalesProduct(sp6);

		LeasesProduct lp1 = new LeasesProduct(3.50, 5, 3.00);
                LeasesProduct lp2 = new LeasesProduct(4.50, 10, 3.00);
                LeasesProduct lp3 = new LeasesProduct(6.50, 5, 3.00);
                LeasesProduct lp4 = new LeasesProduct(5.50, 10, 3.00);
                LeasesProduct lp5 = new LeasesProduct(4.50, 5, 3.00);
                LeasesProduct lp6 = new LeasesProduct(2.50, 10, 3.00);
						boolean check19 = productEJB.createLeasesProduct(lp1);
                boolean check20 = productEJB.createLeasesProduct(lp2);
                boolean check21 = productEJB.createLeasesProduct(lp3);
                boolean check22 = productEJB.createLeasesProduct(lp4);
                boolean check23 = productEJB.createLeasesProduct(lp5);
                boolean check24 = productEJB.createLeasesProduct(lp6);


		Game g1 = new Game("Brave", 10, "001.jpg", "PG", "Electronic Arts Inc.", 1);
                Game g2 = new Game("Captain America Super Soldier", 10, "002.jpg", "M", "Electronic Arts Inc.", 1);
                Game g3 = new Game("Disney Universe", 10, "003.jpg", "G", "Electronic Arts Inc.", 1);
                Game g4 = new Game("Pro Evolution Soccer 2013", 10, "004.jpg", "G", "Electronic Arts Inc.", 2);
                Game g5 = new Game("NBA Live 2008", 10, "005.jpg", "G", "Electronic Arts Inc.", 2);
                Game g6 = new Game("Football Manager 2007", 10, "006.jpg", "G", "Electronic Arts Inc.", 2);


		g1.setProductDescription(pd1);
		g1.setSystemRequirement(sys1);
		g1.setSalesProduct(sp1);
		g1.setLeasesProduct(lp1);

                g2.setProductDescription(pd2);
		g2.setSystemRequirement(sys2);
		g2.setSalesProduct(sp2);
		g2.setLeasesProduct(lp2);

                g3.setProductDescription(pd3);
		g3.setSystemRequirement(sys3);
		g3.setSalesProduct(sp3);
		g3.setLeasesProduct(lp3);

                g4.setProductDescription(pd4);
		g4.setSystemRequirement(sys4);
		g4.setSalesProduct(sp4);
		g4.setLeasesProduct(lp4);

                g5.setProductDescription(pd5);
		g5.setSystemRequirement(sys5);
		g5.setSalesProduct(sp5);
		g5.setLeasesProduct(lp5);

                g6.setProductDescription(pd6);
		g6.setSystemRequirement(sys6);
		g6.setSalesProduct(sp6);
		g6.setLeasesProduct(lp6);

                boolean check25 = productEJB.createGame(g1);
                boolean check26 = productEJB.createGame(g2);
                boolean check27 = productEJB.createGame(g3);
                boolean check28 = productEJB.createGame(g4);
                boolean check29 = productEJB.createGame(g5);
                boolean check30 = productEJB.createGame(g6);
			//--------------------------------------------------------------------------------------------------------

		ProductDescription pd7 = new ProductDescription("In Men in Black 3, Agents J and K are back...","Action", "DVD/Bluray", "English", new Date());
		ProductDescription pd8 = new ProductDescription("Marvel Studios presents Marvels The Avengersthe Super..","Action", "DVD/Bluray", "English", new Date());
                ProductDescription pd9 = new ProductDescription("A couple love their new house, bought for a steal out of a foreclosure...","Action", "DVD/Bluray", "English", new Date());
                ProductDescription pd10 = new ProductDescription("Tha action takes place at the time of the Swedish-Russian...","Action", "DVD/Bluray", "English", new Date());
                ProductDescription pd11 = new ProductDescription("Working alone at night in a recently closed hospital, an unstable woman witnesses events that may be connected to a string of murders.","Horror", "DVD/Bluray", "English", new Date());
                ProductDescription pd12 = new ProductDescription("When newlywed Molly Reynolds returns to her long-abandoned family home..","Horror", "DVD/Bluray", "English", new Date());
                ProductDescription pd13 = new ProductDescription("Two slacker employees who work the night desk..","Horror", "DVD/Bluray", "English", new Date());
                ProductDescription pd14 = new ProductDescription("A young lawyer travels to a remote village where he discovers..","Horror", "DVD/Bluray", "English", new Date());
						boolean check31 = productEJB.createProductDescription(pd7);
                boolean check32 = productEJB.createProductDescription(pd8);
                boolean check33 = productEJB.createProductDescription(pd9);
                boolean check34 = productEJB.createProductDescription(pd10);
                boolean check35 = productEJB.createProductDescription(pd11);
                boolean check36 = productEJB.createProductDescription(pd12);
                boolean check37 = productEJB.createProductDescription(pd13);
                boolean check38 = productEJB.createProductDescription(pd14);

                SalesProduct sp7 = new SalesProduct(50.00, 5);
                SalesProduct sp8 = new SalesProduct(45.00, 5);
                SalesProduct sp9 = new SalesProduct(30.00, 5);
                SalesProduct sp10 = new SalesProduct(55.00, 5);
                SalesProduct sp11 = new SalesProduct(50.00, 5);
                SalesProduct sp12 = new SalesProduct(30.00, 5);
                SalesProduct sp13 = new SalesProduct(50.00, 5);
                SalesProduct sp14 = new SalesProduct(40.00, 5);
		boolean check39 = productEJB.createSalesProduct(sp7);
                boolean check40 = productEJB.createSalesProduct(sp8);
                boolean check41 = productEJB.createSalesProduct(sp9);
                boolean check42 = productEJB.createSalesProduct(sp10);
                boolean check44 = productEJB.createSalesProduct(sp11);
                boolean check45 = productEJB.createSalesProduct(sp12);
                boolean check46 = productEJB.createSalesProduct(sp13);
                boolean check47 = productEJB.createSalesProduct(sp14);

		LeasesProduct lp7 = new LeasesProduct(3.50, 10, 3.00);
                LeasesProduct lp8 = new LeasesProduct(4.50, 5, 3.00);
                LeasesProduct lp9 = new LeasesProduct(3.50, 5, 3.00);
                LeasesProduct lp10 = new LeasesProduct(3.50, 5, 3.00);
                LeasesProduct lp11 = new LeasesProduct(5.50, 10, 3.00);
                LeasesProduct lp12 = new LeasesProduct(3.50, 5, 3.00);
                LeasesProduct lp13 = new LeasesProduct(4.00, 15, 3.00);
                LeasesProduct lp14 = new LeasesProduct(3.50, 5, 3.00);
                boolean check48 = productEJB.createLeasesProduct(lp7);
                boolean check49 = productEJB.createLeasesProduct(lp8);
                boolean check50 = productEJB.createLeasesProduct(lp9);
                boolean check51 = productEJB.createLeasesProduct(lp10);
                boolean check52 = productEJB.createLeasesProduct(lp11);
                boolean check53 = productEJB.createLeasesProduct(lp12);
                boolean check54 = productEJB.createLeasesProduct(lp13);
                boolean check55 = productEJB.createLeasesProduct(lp14);

		Movie m1 = new Movie("Men in Black 3" , 10 , "007.jpg" , "M", "Will Smith, Tommy Lee Jones, Josh Brolin", "Barry Sonnenfeld", "106 mins");
                Movie m2 = new Movie("The Avengers" , 10 , "008.jpg" , "M", "Robert Downey Jr., Gwyneth Paltrow, Samuel L. Jackson, Chris Evans, Scarlett", "Joss Whedon", "143 mins");
                Movie m3 = new Movie("Stash House" , 10 , "009.jpg" , "MA15+", "Briana Evigan, Sean Faris, Dolph Lundgren", "Eduardo Rodriguez ", "99 mins");
                Movie m4 = new Movie("Sovereign's Servant" , 10 , "010.jpg" , "MA15+", "Dmitry Miller, Aleksandr Bukharov, Aleksey Chadov", "Oleg Ryaskov", "116 mins");
                Movie m5 = new Movie("Psych: 9" , 10 , "011.jpg" , "MA15+", "Cary Elwes, Michael Biehn, Sara Foster", "Andrew Shortell", "98 mins");
                Movie m6 = new Movie("Lovely Molly" , 10 , "012.jpg" , "MA15+", "Alexandra Holden, Gretchen Lodge, Johnny Lewis", "Eduardo Sanchez", "96 mins");
                Movie m7 = new Movie("The Innkeepers" , 10 , "013.jpg" , "M", "Paxton, Kelly McGillis, Pat Healy", "Ti West", "100 mins");
                Movie m8 = new Movie("The Woman In Black" , 10 , "014.jpg" , "M", "Daniel Radcliffe, Janet McTeer, Ciaran Hinds", "James Watkins", "95 mins");

                m1.setProductDescription(pd7);
		m1.setSalesProduct(sp7);
		m1.setLeasesProduct(lp7);

                m2.setProductDescription(pd8);
		m2.setSalesProduct(sp8);
		m2.setLeasesProduct(lp8);

                m3.setProductDescription(pd9);
		m3.setSalesProduct(sp9);
		m3.setLeasesProduct(lp9);

                m4.setProductDescription(pd10);
		m4.setSalesProduct(sp10);
		m4.setLeasesProduct(lp10);

                m5.setProductDescription(pd11);
		m5.setSalesProduct(sp11);
		m5.setLeasesProduct(lp11);

                m6.setProductDescription(pd12);
		m6.setSalesProduct(sp12);
		m6.setLeasesProduct(lp12);

                m7.setProductDescription(pd13);
		m7.setSalesProduct(sp13);
		m7.setLeasesProduct(lp13);

                m8.setProductDescription(pd14);
		m8.setSalesProduct(sp14);
		m8.setLeasesProduct(lp14);

                boolean check56 = productEJB.createMovie(m1);
                boolean check57 = productEJB.createMovie(m2);
                boolean check58 = productEJB.createMovie(m3);
                boolean check59 = productEJB.createMovie(m4);
                boolean check60 = productEJB.createMovie(m6);
                boolean check61 = productEJB.createMovie(m7);
                boolean check62 = productEJB.createMovie(m8);

		//--------------------------------------------------------------------------------------------------------

		ProductDescription pd15 = new ProductDescription("Track Listing:Goodnite, Dance Me to the End of Love...","Jazz", "CD", "English", new Date());
		ProductDescription pd16 = new ProductDescription("Track Listing:No Disguise ,Evil Woman ,Runaway...","Jazz", "CD", "English", new Date());
		ProductDescription pd17 = new ProductDescription("As one of the 20th century's...","Jazz", "CD", "English", new Date());
		ProductDescription pd18 = new ProductDescription("Alesa Lajana blends her intricate guitar...","Classical", "CD", "English", new Date());
		ProductDescription pd19 = new ProductDescription("What’s typical of John Williamson on this latest album....","Classical", "CD", "English", new Date());
		ProductDescription pd20 = new ProductDescription("Born in Belfast, Northern Ireland, Phil Davidson has been a regular performer on radio and the Sydney...","Classical", "CD", "English", new Date());

                boolean check63 = productEJB.createProductDescription(pd15);
		boolean check64 = productEJB.createProductDescription(pd16);
		boolean check65 = productEJB.createProductDescription(pd17);
		boolean check66 = productEJB.createProductDescription(pd18);
		boolean check67 = productEJB.createProductDescription(pd19);
		boolean check68 = productEJB.createProductDescription(pd20);

		SalesProduct sp15 = new SalesProduct(30.99, 5);
		SalesProduct sp16 = new SalesProduct(31.99, 5);
		SalesProduct sp17 = new SalesProduct(32.99, 5);
		SalesProduct sp18 = new SalesProduct(32.99, 5);
		SalesProduct sp19 = new SalesProduct(25.99, 5);
		SalesProduct sp20 = new SalesProduct(25.00, 5);

                boolean check69 = productEJB.createSalesProduct(sp15);
		boolean check70 = productEJB.createSalesProduct(sp16);
		boolean check71 = productEJB.createSalesProduct(sp17);
		boolean check72 = productEJB.createSalesProduct(sp18);
		boolean check73 = productEJB.createSalesProduct(sp19);
		boolean check74 = productEJB.createSalesProduct(sp20);


		LeasesProduct lp15 = new LeasesProduct(5.50, 5, 3.00);
		LeasesProduct lp16 = new LeasesProduct(3.50, 5, 3.00);
		LeasesProduct lp17 = new LeasesProduct(3.50, 5, 3.00);
		LeasesProduct lp18 = new LeasesProduct(4.50, 5, 3.00);
		LeasesProduct lp19 = new LeasesProduct(3.50, 5, 3.00);
		LeasesProduct lp20 = new LeasesProduct(5.50, 5, 3.00);

                boolean check75 = productEJB.createLeasesProduct(lp15);
		boolean check76 = productEJB.createLeasesProduct(lp16);
		boolean check77 = productEJB.createLeasesProduct(lp17);
		boolean check78 = productEJB.createLeasesProduct(lp18);
		boolean check79 = productEJB.createLeasesProduct(lp19);
		boolean check80 = productEJB.createLeasesProduct(lp20);

		Soundtrack s1 = new Soundtrack("Women of Jazz" , 10 , "015.jpg" , "Putumayo", "Putumayo" , 20);
		Soundtrack s2 = new Soundtrack("Minus" , 10 , "016.jpg" , " Dukes of Windsor", "Duke of Windsor" , 25);
		Soundtrack s3 = new Soundtrack("Nothing But The Best" , 10 , "017.jpg" , "Frank Sinatra", "Frank Sinatra" , 20);
		Soundtrack s4 = new Soundtrack("eltic Gypsy" , 10 , "018.jpg" , "Alesa Lajana", "Alesa Lajana" , 20);
		Soundtrack s5 = new Soundtrack("Hillbilly Road" , 10 , "019.jpg" , "John Williamson", "John Williamson" , 15);
		Soundtrack s6 = new Soundtrack("Edge Of It All" , 10 , "020.jpg" , "Phil Davidson", "Phil Davidson" , 12);

		s1.setProductDescription(pd15);
		s1.setSalesProduct(sp15);
		s1.setLeasesProduct(lp15);

		s2.setProductDescription(pd16);
		s2.setSalesProduct(sp16);
		s2.setLeasesProduct(lp16);

		s3.setProductDescription(pd17);
		s3.setSalesProduct(sp17);
		s3.setLeasesProduct(lp17);

		s4.setProductDescription(pd18);
		s4.setSalesProduct(sp18);
		s4.setLeasesProduct(lp18);

		s5.setProductDescription(pd19);
		s5.setSalesProduct(sp19);
		s5.setLeasesProduct(lp19);

		s6.setProductDescription(pd20);
		s6.setSalesProduct(sp20);
		s6.setLeasesProduct(lp20);

		boolean check81 = productEJB.createSoundtrack(s1);
		boolean check82 = productEJB.createSoundtrack(s2);
		boolean check83 = productEJB.createSoundtrack(s3);
		boolean check84 = productEJB.createSoundtrack(s4);
		boolean check85 = productEJB.createSoundtrack(s5);
		boolean check86 = productEJB.createSoundtrack(s6);

            }
            catch(Exception e)
            {
                showMessage("Persistence error", "Cannot connect to database");
            }
        }
    }

    public void changeType()
    {
        if(type.equals("Movie"))
        {
            listCategories = productEJB.findCategories("select DISTINCT pd.category from Movie As m JOIN m.productDescription As pd");
            listProducts = productEJB.findProductsWithType("select p from Product p, Movie m where p.PID = m.PID");

        }
        else if(type.equals("Game"))
        {
            listCategories = productEJB.findCategories("select DISTINCT pd.category from Game As g JOIN g.productDescription As pd");
            listProducts = productEJB.findProductsWithType("select p from Product p, Game g where p.PID = g.PID");
        }
        else
        {
            listCategories = productEJB.findCategories("select DISTINCT pd.category from Soundtrack As s JOIN s.productDescription As pd");
            listProducts = productEJB.findProductsWithType("select p from Product p, Soundtrack s where p.PID = s.PID");
        }

    }

    public void changeCategory(String str)
    {
        String strCategory = str;
        String strQuery = "";
        if(type.equalsIgnoreCase("Movie"))
        {
           strQuery  = "select p from Movie As m JOIN m.productDescription As pd, Product As p where p.PID = m.PID and pd.category = '" +  strCategory + "'";
        }
        else if(type.equalsIgnoreCase("Game"))
        {
            strQuery  = "select p from Game As g JOIN g.productDescription As pd, Product As p where p.PID = g.PID and pd.category = '" +  strCategory + "'";
        }
        else
        {
            strQuery  = "select p from Soundtrack As s JOIN s.productDescription As pd, Product As p where p.PID = s.PID and pd.category = '" +  strCategory + "'";
        }
         listProducts = productEJB.findProductsWithType(strQuery);
    }

    public void showDetails(Product p)
    {

        id = p.getPID();
        String strQuery = "";
        if(type.equals("Movie"))
        {
            movie_special = true;
            game_special = false;
            soundtrack_special = false;
            strQuery = "select m.image, m.title, m.nbrInStock, m.classification, m.castName, m.director, m.runtime from Movie m where m.PID = " +id;
        }

        else if (type.equals("Game"))
        {
            movie_special = false;
            game_special = true;
            soundtrack_special = false;
             strQuery = "select g.image, g.title, g.nbrInStock, g.classification, g.manufacturer, g.nbrOfPlayers from Game g where g.PID = " +id;
        }
        else
        {
            movie_special = false;
            game_special = false;
            soundtrack_special = true;
            strQuery = "select s.image, s.title, s.nbrInStock, s.album, s.artist, s.nbrOfTracks from Soundtrack s where s.PID = " +id;
        }

        productDetails = productEJB.findDetails(strQuery);

        productDescription = productEJB.findProductDescriptionWithId("select pd from Product As p JOIN p.productDescription As pd where p.PID = " +id);
        salesProduct = productEJB.findSalesProductWithId("select sp from Product As p JOIN p.salesProduct As sp where p.PID = " +id);
        leasesProduct = productEJB.findLeasesProductWithId("select lp from Product As p JOIN p.leasesProduct As lp where p.PID = " +id);

        dateReleased = format.format(productDescription.getReleasedDate());

    }

    public void search()
    {

        if(type.equals("Movie"))
        {
            listProducts = productEJB.findProductsWithType("select p from Product p, Movie m where p.PID = m.PID and p.title LIKE '%" + strSearch + "%'");
            if(listProducts.size() > 0)
            {
                listCategories = productEJB.findCategories("select DISTINCT pd.category from Movie As m JOIN m.productDescription As pd");
            }

        }
        else if(type.equals("Game"))
        {
            listProducts = productEJB.findProductsWithType("select p from Product p, Game g where p.PID = g.PID and p.title LIKE '%" + strSearch + "%'");
            if(listProducts.size() > 0)
            {
                listCategories = productEJB.findCategories("select DISTINCT pd.category from Game As g JOIN g.productDescription As pd");
            }
        }
        else
        {
            listProducts = productEJB.findProductsWithType("select p from Product p, Soundtrack s where p.PID = s.PID and p.title LIKE '%" + strSearch + "%'");
            if(listProducts.size() > 0)
            {
                listCategories = productEJB.findCategories("select DISTINCT pd.category from Soundtrack As s JOIN s.productDescription As pd");
            }

        }

    }

    public void addBuyItem()
    {
        try
        {
            boolean checkExtisted = false;
            if(buyItemsDetails.size() > 0)
            {
                for(int i = 0; i < buyItemsDetails.size(); i++)
                {
                    Object[] object = buyItemsDetails.get(i);
                    if(object[0] == id)
                    {
                        object[2] = Integer.parseInt(object[2].toString()) + 1;
                        checkExtisted = true;
                        break;
                    }
                }

            }
            if(checkExtisted == false)
            {
                Product p = productEJB.findProductWithId("select p from Product p where p.PID = " + id);
                salesProduct = productEJB.findSalesProductWithId("select sp from Product As p JOIN p.salesProduct As sp where p.PID = " + id);
                Double price = salesProduct.getSalesPrice();
                Integer discount = salesProduct.getSalesDP();

                Object[] obj = {p.getPID(), p.getTitle(), 1, price,  discount};

                buyItemsDetails.add(obj);
                showMessage("Success", "An item has been added to shopping cart");
            }
            calculateSubTotal();
        }
        catch(Exception e)
        {
            showMessage("Error:", "Cannot add new item to shopping cart");
        }
    }

    public void calculateSubTotal()
    {
        if(buyItemsDetails.size() > 0)
        {
            buySubTotal = 0.0;
            for(int i = 0; i < buyItemsDetails.size(); i++)
            {
                Object[] object = buyItemsDetails.get(i);
                Integer quantity = Integer.parseInt(object[2].toString());
                Double price = Double.parseDouble(object[3].toString());
                Integer discountPercent = Integer.parseInt(object[4].toString());
                buySubTotal = buySubTotal + ((quantity * price) * (100 - discountPercent) / 100);
            }

        }
        else
        {
            buySubTotal = 0.0;
        }
        if(rentItemsDetails.size() > 0)
        {
            rentSubTotal = 0.0;
            int days = 0;
            for(int i = 0; i < rentItemsDetails.size(); i++)
            {
                try
                {
                Object[] object = rentItemsDetails.get(i);
                Integer quantity = Integer.parseInt(object[2].toString());
                Double price = Double.parseDouble(object[3].toString());
                Integer discountPercent = Integer.parseInt(object[4].toString());
                String strLeasesDate = format.format(object[5]);
                String strDueDate = format.format(object[6]);
                
                
                DateMidnight start = new DateMidnight(strLeasesDate);
                DateMidnight end = new DateMidnight(strDueDate);

                days = Days.daysBetween(start, end).getDays();
                
                rentSubTotal = rentSubTotal + (((quantity * price) * (100 - discountPercent) / 100) * days);

                }
                catch(Exception e)
                {
                      showMessage("here", "here"+days);  
                }
            }

        }
        else
        {
            rentSubTotal = 0.0;
        }
        
        subTotal = buySubTotal + rentSubTotal;
    }

    public void onBuyCartItemEdit(RowEditEvent event)
    {

        id = Long.parseLong(((Object[]) event.getObject())[0].toString());
        Integer quantity = Integer.parseInt(((Object[]) event.getObject())[2].toString());

        for(int i = 0; i < buyItemsDetails.size(); i++)
        {
            Object[] object = buyItemsDetails.get(i);
            if(object[0] == id)
            {
                object[2] = quantity;
                showMessage("Item edited", "Item edited");
                break;
            }
        }
        calculateSubTotal();
    }

    public void onBuyCartItemCancel(RowEditEvent event)
    {

    }

    public void onBuyCartItemDelete(Long id)
    {
        for(int i = 0; i < buyItemsDetails.size(); i++)
        {
            Object[] object = buyItemsDetails.get(i);
            if(object[0] == id)
            {
                buyItemsDetails.remove(object);
                showMessage("Item deleted", "Item deleted");
                break;
            }
        }
        calculateSubTotal();
    }

    public void addRentItem()
    {
        try
        {
            boolean checkExtisted = false;
            if(rentItemsDetails.size() > 0)
            {
                for(int i = 0; i < rentItemsDetails.size(); i++)
                {
                    Object[] object = rentItemsDetails.get(i);
                    if(object[0] == id)
                    {
                        object[2] = Integer.parseInt(object[2].toString()) + 1;
                        checkExtisted = true;
                        break;
                    }
                }

            }
            if(checkExtisted == false)
            {
                Product p = productEJB.findProductWithId("select p from Product p where p.PID = " + id);
                leasesProduct = productEJB.findLeasesProductWithId("select lp from Product As p JOIN p.leasesProduct As lp where p.PID = " + id);
                Double price = leasesProduct.getLeasesPrice();
                Integer discount = leasesProduct.getLeasesDP();

                
                Date now = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(now);
                cal.add(Calendar.DAY_OF_YEAR, 1);
                Date leasesDate = cal.getTime();
                cal.add(Calendar.DAY_OF_YEAR, 1);
                Date dueDate = cal.getTime();
                

                Object[] obj = {p.getPID(), p.getTitle(), 1, price,  discount, leasesDate, dueDate};

                rentItemsDetails.add(obj);
                showMessage("Success", "An item has been added to shopping cart");
            }
            calculateSubTotal();
        }
        catch(Exception e)
        {
            showMessage("Error:", "Cannot add new item to shopping cart");
        }
    }

    public void onRentCartItemEdit(RowEditEvent event)
    {

        id = Long.parseLong(((Object[]) event.getObject())[0].toString());
        Integer quantity = Integer.parseInt(((Object[]) event.getObject())[2].toString());
        try
        {
            //Date leasesDate = (Date)format.parse(((Object[]) event.getObject())[5].toString());
            //Date dueDate = (Date)format.parse(((Object[]) event.getObject())[6].toString());
            for(int i = 0; i < rentItemsDetails.size(); i++)
            {
                Object[] object = rentItemsDetails.get(i);
                if(object[0] == id)
                {
                    object[2] = quantity;
                    //object[5] = ((Object[]) event.getObject())[5].toString();
                    //object[6] = ((Object[]) event.getObject())[5].toString();
                    break;
                }
            }
            calculateSubTotal();
            
        }
        catch(Exception e)
        {
            showMessage("Error", "Cannot convert to Date datatype");
        }

        
    }

    public void onRentCartItemCancel(RowEditEvent event)
    {

    }

    public void onRentCartItemDelete(Long id)
    {
        for(int i = 0; i < rentItemsDetails.size(); i++)
        {
            Object[] object = rentItemsDetails.get(i);
            if(object[0] == id)
            {
                rentItemsDetails.remove(object);
                showMessage("Item deleted", "Item deleted");
                break;
            }
        }
        calculateSubTotal();
    }
    
    public void checkOut()
    {
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username") != null)
        {
            boolean checkSalesOrder = true;
            boolean checkLeasesOrder = true;
            String username = String.valueOf(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username"));
            int buySize = buyItemsDetails.size();
            int rentSize = rentItemsDetails.size();
            if(buySize == 0 && rentSize == 0)
            {
                showMessage("No data", "Please choose the product you want ti buy or rent");
            }
            else
            {
                for(int i = 0; i < buySize; i++)
                {
                    Object[] obj = buyItemsDetails.get(i);
                    Long productId = Long.parseLong(obj[0].toString());
                    Product p = productEJB.findProductWithId("select p from Product p where p.PID = " + productId);
                    Double price = Double.parseDouble(obj[3].toString());
                    Integer quantity = Integer.parseInt(obj[2].toString());
                    Integer discountPercent = Integer.parseInt(obj[4].toString());
                    SalesOrderDetail salesDetail = new SalesOrderDetail(price, quantity, discountPercent, 0);
                    salesDetail.setProduct(p);
                    checkSalesOrder = orderEJB.createSalesOrder(salesDetail);
                    if(checkSalesOrder == true)
                    {
                        salesOrderDetails.add(salesDetail);
                    }
                    else
                    {
                        showMessage("Fail", "Fail");
                        break;
                    }
                }
                
                for(int i = 0; i < rentSize; i++)
                {
                    Object[] obj = rentItemsDetails.get(i);
                    Long productId = Long.parseLong(obj[0].toString());
                    Product p = productEJB.findProductWithId("select p from Product p where p.PID = " + productId);
                    Double price = Double.parseDouble(obj[3].toString());
                    Integer quantity = Integer.parseInt(obj[2].toString());
                    Integer discountPercent = Integer.parseInt(obj[4].toString());

                    try 
                    {
                        String strLeasesDate = format.format(obj[5]);
                        String strDueDate = format.format(obj[6]);
                        Date leasesDate = new SimpleDateFormat("yyyy-MM-dd").parse(strLeasesDate);
                        Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(strDueDate);
                        
                        LeasesOrderDetail leasesDetail = new LeasesOrderDetail(price, leasesDate, dueDate, new Date(), quantity, discountPercent, 0);
                        leasesDetail.setProduct(p);
                        checkLeasesOrder = orderEJB.createLeasesOrder(leasesDetail);
                        if(checkLeasesOrder == true)
                        {
                            leasesOrderDetails.add(leasesDetail);
                        }
                        else
                        {
                            showMessage("Fail", "Fail");
                            break;
                        }
                    } 
                    catch (Exception e) 
                    {
                        showMessage("Wrong", "Wrongggggg");
                    }
 
                }
               if(checkSalesOrder == true && checkLeasesOrder == true)
               {
                   showMessage("Congratulation", "Your order has been placed successfully");
               }  
            }
        }
        else
        {
            showMessage("Information require", "Please log in before check out");
        }
    }
    
    public String newOrderNumber()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String orderNumber = dateFormat.format(date);
        return orderNumber;
    }

    public void showMessage(String str1, String str2)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, str1, str2));
    }

    public List<String> getListCategories()
    {
        return listCategories;
    }

    public void seListCategories(List<String> listCategories)
    {
        this.listCategories = listCategories;
    }

    public List<Product> getListProducts()
    {
        return listProducts;
    }

    public void seListProducts(List<Product> listProducts)
    {
        this.listProducts = listProducts;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public ProductDescription getProductDescription()
    {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription)
    {
        this.productDescription = productDescription;
    }

    public SalesProduct getSalesProduct()
    {
        return salesProduct;
    }

    public void setSalesProduct(SalesProduct salesProduct)
    {
        this.salesProduct = salesProduct;
    }

    public LeasesProduct getLeasesProduct()
    {
        return leasesProduct;
    }

    public void setLeasesProduct(LeasesProduct leasesProduct)
    {
        this.leasesProduct = leasesProduct;
    }

    public Movie getMovie()
    {
        return movie;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    public Game getGame()
    {
        return game;
    }

    public void setGame(Game game)
    {
        this.game = game;
    }

    public Soundtrack getSoundtrack()
    {
        return soundtrack;
    }

    public void setSoundtrack(Soundtrack soundtrack)
    {
        this.soundtrack = soundtrack;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public SimpleDateFormat getFormat()
    {
        return format;
    }

    public String getDateReleased()
    {
        return dateReleased;
    }

    public void setDateReleased(String dateReleased)
    {
        this.dateReleased = dateReleased;
    }

    public Object[] getProductDetails()
    {
        return productDetails;
    }

    public void setProductDetails(Object[] productDetails)
    {
        this.productDetails = productDetails;
    }

    public List<Object[]> getBuyItemsDetails()
    {
        return buyItemsDetails;
    }

    public void setBuyItemsDetails(List<Object[]> buyItemsDetails)
    {
        this.buyItemsDetails = buyItemsDetails;
    }

    public List<Object[]> getRentItemsDetails()
    {
        return rentItemsDetails;
    }

    public void setRentItemsDetails(List<Object[]> rentItemsDetails)
    {
        this.rentItemsDetails = rentItemsDetails;
    }

    public boolean getMovie_special()
    {
        return movie_special;
    }

    public void setMovie_special(boolean movie_special)
    {
        this.movie_special = movie_special;
    }
    public boolean getGame_special()
    {
        return game_special;
    }

    public void setGame_special(boolean game_special)
    {
        this.game_special = game_special;
    }

    public boolean getSoundtrack_special()
    {
        return soundtrack_special;
    }

    public void setSoundtrack_special(boolean soundtrack_special)
    {
        this.soundtrack_special = soundtrack_special;
    }

    public String[] getListType()
    {
        return listType;
    }

    public String getStrSearch()
    {
        return strSearch;
    }

    public void setStrSearch(String strSearch)
    {
        this.strSearch = strSearch;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Double getBuySubTotal()
    {
        return buySubTotal;
    }

    public void setBuySubTotal(Double buySubTotal)
    {
        this.buySubTotal = buySubTotal;
    }

    public Double getRentSubTotal()
    {
        return rentSubTotal;
    }

    public void setRentSubTotal(Double rentSubTotal)
    {
        this.rentSubTotal = rentSubTotal;
    }

    public Double getSubTotal()
    {
        return subTotal;
    }

    public void setSubTotal(Double subTotal)
    {
        this.subTotal = subTotal;
    }
    
    public DecimalFormat getTwoDForm()
    {
        return twoDForm;
    }
    
    public List<SalesOrderDetail> getSalesOrderDetails()
    {
        return salesOrderDetails;
    }

    public void setSalesOrderDetails(List<SalesOrderDetail> salesOrderDetails)
    {
        this.salesOrderDetails = salesOrderDetails;
    }
    
    public List<LeasesOrderDetail> getLeasesOrderDetails()
    {
        return leasesOrderDetails;
    }

    public void setLeasesOrderDetails(List<LeasesOrderDetail> leasesOrderDetails)
    {
        this.leasesOrderDetails = leasesOrderDetails;
    }
    
    
}
