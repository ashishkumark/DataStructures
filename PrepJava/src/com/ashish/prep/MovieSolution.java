package com.ashish.prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class MovieSolution
{ 
	
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	// RETURN AN EMPTY SET IF NO SIMILAR MOVIE TO THE GIVEN MOVIE IS FOUND
	public static Set<Movie> getMovieRecommendations (Movie movie, int N) 
	{
		// WRITE YOUR CODE HERE
		
		Set<Movie> recomSet = new HashSet<Movie>();
		
		/*
		movie.relatedMovies.stream().map((m1) -> {
		    recomSet.add(m1);
		    return m1;
		}).forEach((m1) -> {
		    m1.relatedMovies.stream.forEach((m2) -> {
		        recomSet.add(m2);
		    });
		});
		*/
		
/*		for (Movie m1 : movie.relatedMovies) {
		    recomSet.add(m1);
		    for (Movie m2 : m1.relatedMovies) {
		        recomSet.add(m2);
		    }
		}
*/
		getConnectedNodes(movie, recomSet);
		
		// remove the input movie itself
		recomSet.remove(movie);
		
		// To sort the movie based on rating and return selected movies only
		List<Movie> movieRecom = new ArrayList<Movie>(recomSet);
		
		Collections.sort(movieRecom);
		
		if(N < movieRecom.size()) {
		    List<Movie> aList = movieRecom.subList(0, N);
		    recomSet = new HashSet<Movie>(aList);
		}
		
		return recomSet;
	}
	
	private static void getConnectedNodes(Movie movie, Set<Movie> recomSet) {
//		boolean retval = recomSet.addAll(movie.relatedMovies);
//		
//		if (retval) {
//			for (Movie m : movie.relatedMovies) {
//				getConnectedNodes(m, recomSet);
//			}
//		}
		
		for (Movie mov : movie.relatedMovies) {
			boolean retVal = recomSet.add(mov);
			if (retVal) getConnectedNodes(mov, recomSet);
		}
	}
	
	// METHOD SIGNATURE ENDS
	
	public static void main(String args[]) {
//	    Movie m1 = new Movie(1, 1.2f);
//	    Movie m2 = new Movie(2, 9f);
//	    
//	    m1.addRelatedMovie(m2);
//	    Set<Movie> returnSet = MovieSolution.getMovieRecommendations(m1, 1);
//	    for (Iterator<Movie> iterator = returnSet.iterator(); iterator.hasNext();) {
//			Movie movie = (Movie) iterator.next();
//			System.out.println(movie);
//		}
	    

	    Movie m11 = new Movie(1, 1.2f);
	    Movie m21 = new Movie(2, 9f);
	    Movie m31 = new Movie(3, 8.9f);
	    Movie m41 = new Movie(4, 7.9f);
	    Movie m51 = new Movie(5, 5.9f);
	    
	    m11.addRelatedMovie(m21);
	    m21.addRelatedMovie(m31);
	    m31.addRelatedMovie(m41);
	    m41.addRelatedMovie(m51);
	    
	    Set<Movie> returnSet2 = MovieSolution.getMovieRecommendations(m11, 3);
	    for (Iterator<Movie> iterator = returnSet2.iterator(); iterator.hasNext();) {
			Movie movie = (Movie) iterator.next();
			System.out.println(movie);
		}

/*	    List<Movie> mList = m11.relatedMovies;
	    Collections.sort(mList);
//	    List nList = mList.subList(2,  mList.size()); 
	    List nList = mList.subList(0, 2);
	    for (Iterator iterator = nList.iterator(); iterator.hasNext();) {
			Movie movie = (Movie) iterator.next();
			System.out.println(movie);
		}
*/	    	    
	}
}

// Analysis: We are looking at a graph of connected (bi-directional) movie nodes
// with respective movie unique identifier and an awarded movie rating.
// Since the comparision is based on Movie's rating, we shall create a movie class
// with overridden compareTo method for comparing the rating.
// We will add attributes like, unique identifier, rating, and connected movie nodes list.
		
class Movie implements Comparable<Movie> {
    
    int movieUniqueId;
    float movieRating;
    List<Movie> relatedMovies;

    // Constructor to take unique Id, and movie rating.
    public Movie(int movieUniqueId, float movieRating) {
        this.movieUniqueId = movieUniqueId;
        this.movieRating = movieRating;
        relatedMovies = new ArrayList<Movie>();
    }
    
    // To help compare based on movieRating
    public int compareTo(Movie m) {
        return Float.compare(m.movieRating, this.movieRating);
    }
    
    // To add relatedmovies while building the movie node
    // Ensures the movie nodes are connected bi-directional
    public void addRelatedMovie(Movie m) {
        this.relatedMovies.add(m);
        m.relatedMovies.add(this);
    }
    
    @Override
    public String toString() {
    	return "(" + this.movieUniqueId + "," + this.movieRating +")";
    }
}