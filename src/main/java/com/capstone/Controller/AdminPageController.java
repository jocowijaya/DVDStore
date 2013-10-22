/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capstone.Controller;

import com.capstone.EJB.ProductEJB;
import com.capstone.Entity.Game;
import com.capstone.Entity.LeasesProduct;
import com.capstone.Entity.Movie;
import com.capstone.Entity.ProductDescription;
import com.capstone.Entity.SalesProduct;
import com.capstone.Entity.Soundtrack;
import com.capstone.Entity.SystemRequirement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author duy
 */
@ManagedBean
@RequestScoped
public class AdminPageController 
{
    @EJB
    private ProductEJB productEJB;
    
    private final static String[] movieClassifications;
    private final static String[] movieCategories;
    private final static String[] gameClassifications;
    private final static String[] gameCategories;
    private final static String[] soundtrackCategories;
    
    
    private List<Object[]> movieDetailList;
    private List<Object[]> gameDetailList;
    private List<Object[]> soundtrackDetailList;
    
    
    private UploadedFile file;
    private String extVadidate;
    
    private Movie movie = new Movie();
    private Game game = new Game();
    private Soundtrack soundtrack = new Soundtrack();
    private ProductDescription productDescription = new ProductDescription();
    private SalesProduct salesProduct = new SalesProduct();
    private LeasesProduct leasesProduct = new LeasesProduct();
    private SystemRequirement systemRequirement = new SystemRequirement();
    
    static {
        movieClassifications = new String[5];
        movieClassifications[0] = "G";
        movieClassifications[1] = "PG";
        movieClassifications[2] = "M";
        movieClassifications[3] = "MA15+";
        movieClassifications[4] = "R18+";
        
        movieCategories = new String[25];
        movieCategories[0] = "Action";
        movieCategories[1] = "Adult";
        movieCategories[2] = "Adventure";
        movieCategories[3] = "Animation";
        movieCategories[4] = "Black Cast";
        movieCategories[5] = "Comedy";
        movieCategories[6] = "Crime";
        movieCategories[7] = "Documentary";
        movieCategories[8] = "Drama";
        movieCategories[9] = "Family";
        movieCategories[10] = "Fantasy";
        movieCategories[11] = "Film-Noir";
        movieCategories[12] = "Horror";
        movieCategories[13] = "Martial Arts";
        movieCategories[14] = "Musical";
        movieCategories[15] = "Mystery";
        movieCategories[16] = "Religious";
        movieCategories[17] = "Romance";
        movieCategories[18] = "Serial";
        movieCategories[19] = "Short";
        movieCategories[20] = "Silent";
        movieCategories[21] = "Sports";
        movieCategories[22] = "Thriller";
        movieCategories[23] = "War";
        movieCategories[24] = "Western";
        
        gameClassifications = new String[6];
        gameClassifications[0] = "U";
        gameClassifications[1] = "PG";
        gameClassifications[2] = "12A";
        gameClassifications[3] = "12";
        gameClassifications[4] = "15";
        gameClassifications[5] = "18";
        
        gameCategories = new String[15];
        gameCategories[0] = "Action & Adventure";
        gameCategories[1] = "Animation";
        gameCategories[2] = "Comedy";
        gameCategories[3] = "Documentary";
        gameCategories[4] = "Drama";
        gameCategories[5] = "Family & Kids";
        gameCategories[6] = "Foreign";
        gameCategories[7] = "Horror";
        gameCategories[8] = "Music & Performing Arts";
        gameCategories[9] = "Mystery & Suspense";
        gameCategories[10] = "Romance";
        gameCategories[11] = "Sci-Fi & Fantasy";
        gameCategories[12] = "Sports & Fitness";
        gameCategories[13] = "War";
        gameCategories[14] = "Western";
        
        soundtrackCategories = new String[29];
        soundtrackCategories[0] = "Alternative";
        soundtrackCategories[1] = "Anime";
        soundtrackCategories[2] = "Blues";
        soundtrackCategories[3] = "Children's Music";
        soundtrackCategories[4] = "Classical";
        soundtrackCategories[5] = "Comedy";
        soundtrackCategories[6] = "Country";
        soundtrackCategories[7] = "Dance";
        soundtrackCategories[8] = "Disney";
        soundtrackCategories[9] = "Easy Listening";
        soundtrackCategories[10] = "Electronic";
        soundtrackCategories[11] = "Enka";
        soundtrackCategories[12] = "French Pop";
        soundtrackCategories[13] = "German Folk";
        soundtrackCategories[14] = "German Pop";
        soundtrackCategories[15] = "HipHop/Rap";
        soundtrackCategories[16] = "Indie";
        soundtrackCategories[17] = "Christian/Gospel";
        soundtrackCategories[18] = "Instrument";
        soundtrackCategories[19] = "J-POP";
        soundtrackCategories[20] = "Jazz";
        soundtrackCategories[21] = "K-POP";
        soundtrackCategories[22] = "Latino";
        soundtrackCategories[23] = "New Age";
        soundtrackCategories[24] = "Opera";
        soundtrackCategories[25] = "Pop";
        soundtrackCategories[26] = "R&B";
        soundtrackCategories[27] = "Reggae";
        soundtrackCategories[28] = "Rock";
              
    }
    
    
    @PostConstruct
    public void setData()
    {
        movieDetailList = productEJB.findProductDetails("select m.PID, m.title, m.nbrInStock, sp.salesPrice, sp.salesDP, lp.leasesPrice, lp.leasesDP, lp.lateChargePerDay from Movie As m JOIN m.salesProduct As sp JOIN m.leasesProduct As lp ");
        gameDetailList = productEJB.findProductDetails("select g.PID, g.title, g.nbrInStock, sp.salesPrice, sp.salesDP, lp.leasesPrice, lp.leasesDP, lp.lateChargePerDay from Game As g JOIN g.salesProduct As sp JOIN g.leasesProduct As lp ");
        soundtrackDetailList = productEJB.findProductDetails("select s.PID, s.title, s.nbrInStock, sp.salesPrice, sp.salesDP, lp.leasesPrice, lp.leasesDP, lp.lateChargePerDay from Soundtrack As s JOIN s.salesProduct As sp JOIN s.leasesProduct As lp "); 
    }
    
    public void onMovieEdit(RowEditEvent event) 
    {  
        Long id = Long.parseLong(((Object[]) event.getObject())[0].toString());
        Movie m = productEJB.findMovieWithId("select m from Movie m where m.PID = " + id);
        m.setTitle(((Object[]) event.getObject())[1].toString());
        m.setNbrInStock(Integer.parseInt(((Object[]) event.getObject())[2].toString()));
        boolean checkMovie = productEJB.updateMovie(m);
        SalesProduct sp = productEJB.findSalesProductWithId("select sp from Movie As m JOIN m.salesProduct As sp where m.PID = " +id);
        sp.setSalesPrice(Double.parseDouble(((Object[]) event.getObject())[3].toString()));
        sp.setSalesDP(Integer.parseInt(((Object[]) event.getObject())[4].toString()));
        boolean checkSalesProduct = productEJB.updateSalesProduct(sp);
        LeasesProduct lp = productEJB.findLeasesProductWithId("select lp from Movie As m JOIN m.leasesProduct As lp where m.PID = " +id);
        lp.setLeasesPrice(Double.parseDouble(((Object[]) event.getObject())[5].toString()));
        lp.setLeasesDP(Integer.parseInt(((Object[]) event.getObject())[6].toString()));
        lp.setLateChargePerDay(Double.parseDouble(((Object[]) event.getObject())[7].toString()));
        boolean checkLeasesProduct = productEJB.updateLeasesProduct(lp);
        if(checkMovie == true && checkSalesProduct == true && checkLeasesProduct == true)
        {
            showMessage("Item edited", "Item edited");
        }
        else
        {
            showMessage("Fail to edit", "Fail to edit"); 
        }
        
        
    }  
      
    public void onMovieCancel(RowEditEvent event) 
    {  
        
    }
    
    public void onMovieDelete(Long id)
    {
        Movie m = productEJB.findMovieWithId("select m from Movie m where m.PID = " + id);
        
        boolean checkMovie = productEJB.deleteMovie(m);
        
        if(checkMovie == true)
        {
            movieDetailList = productEJB.findProductDetails("select m.PID, m.title, m.nbrInStock, sp.salesPrice, sp.salesDP, lp.leasesPrice, lp.leasesDP, lp.lateChargePerDay from Movie As m JOIN m.salesProduct As sp JOIN m.leasesProduct As lp ");     
            showMessage("Item deleted", "Item deleted");
        }
        else
        {
            showMessage("Fail to delete", "Fail to delete");
        }
    }
    
    public void onGameEdit(RowEditEvent event) 
    {  
        Long id = Long.parseLong(((Object[]) event.getObject())[0].toString());
        Game g = productEJB.findGameWithId("select g from Game g where g.PID = " + id);
        g.setTitle(((Object[]) event.getObject())[1].toString());
        g.setNbrInStock(Integer.parseInt(((Object[]) event.getObject())[2].toString()));
        boolean checkGame = productEJB.updateGame(g);
        SalesProduct sp = productEJB.findSalesProductWithId("select sp from Game As g JOIN g.salesProduct As sp where g.PID = " +id);
        sp.setSalesPrice(Double.parseDouble(((Object[]) event.getObject())[3].toString()));
        sp.setSalesDP(Integer.parseInt(((Object[]) event.getObject())[4].toString()));
        boolean checkSalesProduct = productEJB.updateSalesProduct(sp);
        LeasesProduct lp = productEJB.findLeasesProductWithId("select lp from Game As g JOIN g.leasesProduct As lp where g.PID = " +id);
        lp.setLeasesPrice(Double.parseDouble(((Object[]) event.getObject())[5].toString()));
        lp.setLeasesDP(Integer.parseInt(((Object[]) event.getObject())[6].toString()));
        lp.setLateChargePerDay(Double.parseDouble(((Object[]) event.getObject())[7].toString()));
        boolean checkLeasesProduct = productEJB.updateLeasesProduct(lp);
        if(checkGame == true && checkSalesProduct == true && checkLeasesProduct == true)
        {
            showMessage("Item edited", "Item edited");
        }
        else
        {
            showMessage("Fail to edit", "Fail to edit"); 
        }
        
        
    }  
      
    public void onGameCancel(RowEditEvent event) 
    {  
        
    }
    
    public void onGameDelete(Long id)
    {
        Game g = productEJB.findGameWithId("select g from Game g where g.PID = " + id);
        
        boolean checkGame = productEJB.deleteGame(g);
        
        if(checkGame == true)
        {
            gameDetailList = productEJB.findProductDetails("select g.PID, g.title, g.nbrInStock, sp.salesPrice, sp.salesDP, lp.leasesPrice, lp.leasesDP, lp.lateChargePerDay from Game As g JOIN g.salesProduct As sp JOIN g.leasesProduct As lp ");     
            showMessage("Item deleted", "Item deleted");
        }
        else
        {
            showMessage("Fail to delete", "Fail to delete");
        }
    }
    
    public void onSoundtrackEdit(RowEditEvent event) 
    {  
        Long id = Long.parseLong(((Object[]) event.getObject())[0].toString());
        Soundtrack s = productEJB.findSoundtrackWithId("select s from Soundtrack s where s.PID = " + id);
        s.setTitle(((Object[]) event.getObject())[1].toString());
        s.setNbrInStock(Integer.parseInt(((Object[]) event.getObject())[2].toString()));
        boolean checkSoundtrack = productEJB.updateSoundtrack(s);
        SalesProduct sp = productEJB.findSalesProductWithId("select sp from Soundtrack As s JOIN s.salesProduct As sp where s.PID = " +id);
        sp.setSalesPrice(Double.parseDouble(((Object[]) event.getObject())[3].toString()));
        sp.setSalesDP(Integer.parseInt(((Object[]) event.getObject())[4].toString()));
        boolean checkSalesProduct = productEJB.updateSalesProduct(sp);
        LeasesProduct lp = productEJB.findLeasesProductWithId("select lp from Soundtrack As s JOIN s.leasesProduct As lp where s.PID = " +id);
        lp.setLeasesPrice(Double.parseDouble(((Object[]) event.getObject())[5].toString()));
        lp.setLeasesDP(Integer.parseInt(((Object[]) event.getObject())[6].toString()));
        lp.setLateChargePerDay(Double.parseDouble(((Object[]) event.getObject())[7].toString()));
        boolean checkLeasesProduct = productEJB.updateLeasesProduct(lp);
        if(checkSoundtrack == true && checkSalesProduct == true && checkLeasesProduct == true)
        {
            showMessage("Item edited", "Item edited");
        }
        else
        {
            showMessage("Fail to edit", "Fail to edit"); 
        }
        
        
    }  
      
    public void onSoundtrackCancel(RowEditEvent event) 
    {  
        
    }
    
    public void onSoundtrackDelete(Long id)
    {
        Soundtrack s = productEJB.findSoundtrackWithId("select s from Soundtrack s where s.PID = " + id);
        
        boolean checkSoundtrack = productEJB.deleteSoundtrack(s);
        
        if(checkSoundtrack == true)
        {
            soundtrackDetailList = productEJB.findProductDetails("select s.PID, s.title, s.nbrInStock, sp.salesPrice, sp.salesDP, lp.leasesPrice, lp.leasesDP, lp.lateChargePerDay from Soundtrack As s JOIN s.salesProduct As sp JOIN s.leasesProduct As lp ");     
            showMessage("Item deleted", "Item deleted");
        }
        else
        {
            showMessage("Fail to delete", "Fail to delete");
        }
    }
    
    public String copyFile(String fileName, InputStream in) 
    {
        try
        {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            String destination = externalContext.getRealPath("/resources/product_images");
            File source = new File(destination);
            if(!source.exists())
            {
                    source.mkdir();
            }
           
            boolean check = true;
            while(check == true)
            {
                File file = new File(destination + fileName);
                if(file.exists())
                {
                    fileName = fileName + "f";
                }
                else
                {
                    check = false;
                }
            }

            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + "/" + fileName));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1)
            {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            
         }
         catch (Exception e)
         {
            System.out.println(e.getMessage());
         }
         return fileName;
    }
    
    public String newFileName(String extValidate)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String fileName = dateFormat.format(date) + "." + extValidate;
        return fileName;
    }
    
    public void doCreateNewMovie()
    {
        String extValidate;
        if(getFile() != null)
        {
            String ext = getFile().getFileName();
            if(ext != null)
            {
                extValidate = ext.substring(ext.indexOf(".") + 1).toLowerCase();
            }
            else
            {
                extValidate = "null";
            }
            if(extValidate.equals("png") || extValidate.equals("jpg") || extValidate.equals("jpeg") || extValidate.equals("gif"))
            {
                try
                {
                    String fileName = newFileName(extValidate);
                    String name = copyFile(fileName, getFile().getInputstream());
                    
                    boolean checkProductDescription = productEJB.createProductDescription(productDescription);
                    boolean checkSalesProduct = productEJB.createSalesProduct(salesProduct);
                    boolean checkLeasesProduct = productEJB.createLeasesProduct(leasesProduct);
                    Movie m = new Movie(movie.getTitle(), movie.getNbrInStock(), name, movie.getClassification(), movie.getCastName(), movie.getDirector(), movie.getRuntime());
                    m.setProductDescription(productDescription);
                    m.setSalesProduct(salesProduct);
                    m.setLeasesProduct(leasesProduct);
                    boolean checkMovie = productEJB.createMovie(m);
                    if(checkProductDescription == true && checkSalesProduct == true && checkLeasesProduct == true && checkMovie == true)
                    {
                      movieDetailList = productEJB.findProductDetails("select m.PID, m.title, m.nbrInStock, sp.salesPrice, sp.salesDP, lp.leasesPrice, lp.leasesDP, lp.lateChargePerDay from Movie As m JOIN m.salesProduct As sp JOIN m.leasesProduct As lp ");
                      movie = new Movie();
                      productDescription = new ProductDescription();
                      salesProduct = new SalesProduct();
                      leasesProduct = new LeasesProduct();
                      showMessage("Successful","Congratulation, a new movie product have been created successful");
                    }
                    else
                    {
                        showMessage("Error Message","Data cannot persist");
                    }
                }
                catch(Exception e)
                {
                    showMessage("Fail", "Fail");
                }
            }
            else
            {
                showMessage("Wrong", "Wrong");
            }

        }
        else
        {
            showMessage("Please select a picture", "Please select a picture");
        }
    }
    
    public void doCreateNewGame()
    {
        String extValidate;
        if(getFile() != null)
        {
            String ext = getFile().getFileName();
            if(ext != null)
            {
                extValidate = ext.substring(ext.indexOf(".") + 1).toLowerCase();
            }
            else
            {
                extValidate = "null";
            }
            if(extValidate.equals("png") || extValidate.equals("jpg") || extValidate.equals("jpeg") || extValidate.equals("gif"))
            {
                try
                {
                    String fileName = newFileName(extValidate);
                    String name = copyFile(fileName, getFile().getInputstream());
                    
                    boolean checkProductDescription = productEJB.createProductDescription(productDescription);
                    boolean checkSalesProduct = productEJB.createSalesProduct(salesProduct);
                    boolean checkLeasesProduct = productEJB.createLeasesProduct(leasesProduct);
                    boolean checkSystemRequirement = productEJB.createSystemRequirement(systemRequirement);
                    Game g = new Game(game.getTitle(), game.getNbrInStock(), name, game.getClassification(), game.getManufacturer(), game.getNbrOfPlayers());
                    g.setProductDescription(productDescription);
                    g.setSalesProduct(salesProduct);
                    g.setLeasesProduct(leasesProduct);
                    g.setSystemRequirement(systemRequirement);
                    boolean checkGame = productEJB.createGame(g);
                    if(checkProductDescription == true && checkSalesProduct == true && checkLeasesProduct == true && checkSystemRequirement == true && checkGame == true)
                    {
                      gameDetailList = productEJB.findProductDetails("select g.PID, g.title, g.nbrInStock, sp.salesPrice, sp.salesDP, lp.leasesPrice, lp.leasesDP, lp.lateChargePerDay from Game As g JOIN g.salesProduct As sp JOIN g.leasesProduct As lp ");
                      game = new Game();
                      productDescription = new ProductDescription();
                      salesProduct = new SalesProduct();
                      leasesProduct = new LeasesProduct();
                      systemRequirement = new SystemRequirement();
                      showMessage("Successful","Congratulation, a new game product have been created successful");
                    }
                    else
                    {
                        showMessage("Error Message","Data cannot persist");
                    }
                }
                catch(Exception e)
                {
                    showMessage("Fail", "Fail");
                }
            }
            else
            {
                showMessage("Wrong", "Wrong");
            }

        }
        else
        {
            showMessage("Please select a picture", "Please select a picture");
        }
    }
    
    public void doCreateNewSoundtrack()
    {
        String extValidate;
        if(getFile() != null)
        {
            String ext = getFile().getFileName();
            if(ext != null)
            {
                extValidate = ext.substring(ext.indexOf(".") + 1).toLowerCase();
            }
            else
            {
                extValidate = "null";
            }
            if(extValidate.equals("png") || extValidate.equals("jpg") || extValidate.equals("jpeg") || extValidate.equals("gif"))
            {
                try
                {
                    String fileName = newFileName(extValidate);
                    String name = copyFile(fileName, getFile().getInputstream());
                    
                    boolean checkProductDescription = productEJB.createProductDescription(productDescription);
                    boolean checkSalesProduct = productEJB.createSalesProduct(salesProduct);
                    boolean checkLeasesProduct = productEJB.createLeasesProduct(leasesProduct);
                    Soundtrack s = new Soundtrack(soundtrack.getTitle(), soundtrack.getNbrInStock(), name, soundtrack.getAlbum(), soundtrack.getArtist(), soundtrack.getNbrOfTracks());
                    s.setProductDescription(productDescription);
                    s.setSalesProduct(salesProduct);
                    s.setLeasesProduct(leasesProduct);
                    boolean checkSoundtrack = productEJB.createSoundtrack(s);
                    if(checkProductDescription == true && checkSalesProduct == true && checkLeasesProduct == true && checkSoundtrack == true)
                    {
                      soundtrackDetailList = productEJB.findProductDetails("select s.PID, s.title, s.nbrInStock, sp.salesPrice, sp.salesDP, lp.leasesPrice, lp.leasesDP, lp.lateChargePerDay from Soundtrack As s JOIN s.salesProduct As sp JOIN s.leasesProduct As lp ");
                      soundtrack = new Soundtrack();
                      productDescription = new ProductDescription();
                      salesProduct = new SalesProduct();
                      leasesProduct = new LeasesProduct();
                      showMessage("Successful","Congratulation, a new soundtrack product have been created successful");
                    }
                    else
                    {
                        showMessage("Error Message","Data cannot persist");
                    }
                }
                catch(Exception e)
                {
                    showMessage("Fail", "Fail");
                }
            }
            else
            {
                showMessage("Wrong", "Wrong");
            }

        }
        else
        {
            showMessage("Please select a picture", "Please select a picture");
        }
    }
    
    public void showMessage(String str1, String str2)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, str1, str2));
    }
    
    public String[] getMovieClassifications()
    {
        return movieClassifications;
    }
    public String[] getMovieCategories()
    {
        return movieCategories;
    }
    
    public String[] getGameClassifications()
    {
        return gameClassifications;
    }
    public String[] getGameCategories()
    {
        return gameCategories;
    }
    
    public String[] getSoundtrackCategories()
    {
        return soundtrackCategories;
    }
    
    public List<Object[]> getMovieDetailList()
    {
        return movieDetailList;
    }
    
    public void setMovieDetailList(List<Object[]> movieDetailList)
    {
        this.movieDetailList = movieDetailList;
    }
    
    public List<Object[]> getGameDetailList()
    {
        return gameDetailList;
    }
    
    public void setGameDetailList(List<Object[]> gameDetailList)
    {
        this.gameDetailList = gameDetailList;
    }
    
    public List<Object[]> getSoundtrackDetailList()
    {
        return soundtrackDetailList;
    }
    
    public void setSoundtrackDetailList(List<Object[]> soundtrackDetailList)
    {
        this.soundtrackDetailList = soundtrackDetailList;
    }
    
    public UploadedFile getFile()
    {
        return file;
    }

    public void setFile(UploadedFile file)
    {
        this.file = file;
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
    
    public SystemRequirement getSystemRequirement()
    {
        return systemRequirement;
    }
    public void setSystemRequirement(SystemRequirement systemRequirement)
    {
        this.systemRequirement = systemRequirement;
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
    
    public ProductDescription getProductDescription()
    {
        return productDescription;
    }
    public void setProductDescription(ProductDescription productDescription)
    {
        this.productDescription = productDescription;
    }
}
