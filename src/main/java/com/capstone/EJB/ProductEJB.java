package com.capstone.EJB;

import com.capstone.Entity.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ProductEJB {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "DVDStorePU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public boolean createSystemRequirement(SystemRequirement systemRequirement)
    {
	boolean check = true;
	try
	{
            em.persist(systemRequirement);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }

    public boolean createProductDescription(ProductDescription productDescription)
    {
	boolean check = true;
	try
	{
           em.persist(productDescription);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }

    public boolean createSalesProduct(SalesProduct salesProduct)
    {
	boolean check = true;
	try
	{
            em.persist(salesProduct);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }

    public boolean createLeasesProduct(LeasesProduct leasesProduct)
    {
	boolean check = true;
	try
	{
            em.persist(leasesProduct);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }

    public boolean createGame(Game game)
    {
	boolean check = true;
	try
	{
            em.persist(game);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }

    public boolean createMovie(Movie movie)
    {
	boolean check = true;
	try
	{
            em.persist(movie);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }

    public boolean createSoundtrack(Soundtrack soundtrack)
    {
	boolean check = true;
	try
	{
            em.persist(soundtrack);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }
  
    public List<String> findCategories(String strQuery)
    {
	TypedQuery<String> query = em.createQuery(strQuery, String.class);
	List<String> ls = query.getResultList();
	return ls;
    }

    public List<Product> findProductsWithType(String strQuery)
    {
	TypedQuery<Product> query = em.createQuery(strQuery, Product.class);
	List<Product> ls = query.getResultList();
	return ls;
    }
    
    public Product findProductWithId(String strQuery)
    {
	TypedQuery query = em.createQuery(strQuery, Product.class);
	Product ls = (Product) query.getSingleResult();
	return ls;
    }

    public Movie findMovieWithId(String strQuery)
    {
	TypedQuery query = em.createQuery(strQuery, Movie.class);
	Movie ls = (Movie) query.getSingleResult();
	return ls;
    }

    public Game findGameWithId(String strQuery)
    {
	TypedQuery query = em.createQuery(strQuery, Game.class);
	Game ls = (Game) query.getSingleResult();
	return ls;
    }

    public Soundtrack findSoundtrackWithId(String strQuery)
    {
	TypedQuery query = em.createQuery(strQuery, Soundtrack.class);
	Soundtrack ls = (Soundtrack) query.getSingleResult();
	return ls;
    }
    
    public List<Movie> findListMovies(String strQuery)
    {
	TypedQuery<Movie> query = em.createQuery(strQuery, Movie.class);
	List<Movie> ls = query.getResultList();
	return ls;
    }

    public List<Game> findListGame(String strQuery)
    {
	TypedQuery<Game> query = em.createQuery(strQuery, Game.class);
	List<Game> ls = query.getResultList();
	return ls;
    }

    public List<Soundtrack> findListSoundtrack(String strQuery)
    {
	TypedQuery<Soundtrack> query = em.createQuery(strQuery, Soundtrack.class);
	List<Soundtrack> ls = query.getResultList();
	return ls;
    }

    public ProductDescription findProductDescriptionWithId(String strQuery)
    {
	TypedQuery query = em.createQuery(strQuery, ProductDescription.class);
	ProductDescription ls = (ProductDescription) query.getSingleResult();
	return ls;
    }

    public SalesProduct findSalesProductWithId(String strQuery)
    {
	TypedQuery query = em.createQuery(strQuery, SalesProduct.class);
	SalesProduct ls = (SalesProduct) query.getSingleResult();
	return ls;
    }

    public LeasesProduct findLeasesProductWithId(String strQuery)
    {
	TypedQuery query = em.createQuery(strQuery, LeasesProduct.class);
	LeasesProduct ls = (LeasesProduct) query.getSingleResult();
	return ls;
    }
    
    public List<Object[]> findProductDetails(String strQuery)
    {
	TypedQuery<Object[]> query = em.createQuery(strQuery, Object[].class);
	List<Object[]> ls = (List<Object[]>) query.getResultList();
	return ls;
    }
    
    public Object[] findDetails(String strQuery)
    {
        TypedQuery<Object> query = em.createQuery(strQuery, Object.class);
	Object[] ls = (Object[]) query.getSingleResult();
	return ls;
    }
   

    public boolean updateMovie(Movie movie) 
    {
	boolean check = true;
	try
	{
            em.merge(movie);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }
    
    public boolean updateGame(Game game) 
    {
	boolean check = true;
	try
	{
            em.merge(game);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }
    
    public boolean updateSoundtrack(Soundtrack soundtrack) 
    {
	boolean check = true;
	try
	{
            em.merge(soundtrack);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }

    public boolean updateSalesProduct(SalesProduct salesProduct) 
    {
	boolean check = true;
	try
	{
            em.merge(salesProduct);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }
    
    public boolean updateLeasesProduct(LeasesProduct leasesProduct) 
    {
	boolean check = true;
	try
	{
            em.merge(leasesProduct);
	}
	catch(Exception e)
	{
            check = false;
	}
	return check;
    }
    
    public boolean deleteMovie(Movie movie) 
    {
	boolean check = true;
	try
        {
            em.remove(em.merge(movie));
	}
	catch(Exception e)
        {
            check = false;
	}
        return check;
    }
    
    public boolean deleteGame(Game game) 
    {
	boolean check = true;
	try
        {
            em.remove(em.merge(game));
	}
	catch(Exception e)
        {
            check = false;
	}
        return check;
    }
    
    public boolean deleteSoundtrack(Soundtrack soundtrack) 
    {
	boolean check = true;
	try
        {
            em.remove(em.merge(soundtrack));
	}
	catch(Exception e)
        {
            check = false;
	}
        return check;
    }
    

}