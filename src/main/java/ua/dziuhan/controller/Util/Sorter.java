package ua.dziuhan.controller.Util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import ua.dziuhan.entities.CarData;

/**
 * Sort cars utility
 * */
public class Sorter {

	public static void sortCars(List<CarData> cars,String sortCarBy){
		if(sortCarBy != null){
			switch (sortCarBy) {
			case "byProducer":
				Sorter.sortCarsByProducer(cars);
				break;
			case "byProducerReverse":
				Sorter.sortCarsByProducerReverse(cars);
				break;
			case "byPrice":
				Sorter.sortCarsByPrice(cars);
				break;
			case "byPriceReverse":
				Sorter.sortCarsByPriceReverse(cars);
				break;
			case "byRank":
				Sorter.sortCarsByRank(cars);
				break;
			case "byRankReverse":
				Sorter.sortCarsByRankReverse(cars);
				break;
			}
			//System.out.println(sortCarBy);
		}
	}

	
	public static void sortCarsByProducer(List<CarData> cars){
		Collections.sort(cars,new Comparator<CarData>() {
			@Override
			public int compare(CarData c1, CarData c2) {
				return c1.getProducer().compareTo(c2.getProducer());
			}
		});
	}

	public static void sortCarsByProducerReverse(List<CarData> cars){
		Collections.sort(cars,new Comparator<CarData>() {
			@Override
			public int compare(CarData c1, CarData c2) {
				return c2.getProducer().compareTo(c1.getProducer());
			}
		});		
	}
	
	public static void sortCarsByRank(List<CarData> cars){
		Collections.sort(cars,new Comparator<CarData>() {
			@Override
			public int compare(CarData c1, CarData c2) {
				return c1.getRank().compareTo(c2.getRank());
			}
		});
	}
	
	public static void sortCarsByRankReverse(List<CarData> cars){
		Collections.sort(cars,new Comparator<CarData>() {
			@Override
			public int compare(CarData c1, CarData c2) {
				return c2.getRank().compareTo(c1.getRank());
			}
		});
	}
	
	public static void sortCarsByPrice(List<CarData> cars){
		Collections.sort(cars,new Comparator<CarData>() {
			@Override
			public int compare(CarData c1, CarData c2) {
				return (int) (c1.getPrice()-c2.getPrice());
			}
		});
	}
	
	public static void sortCarsByPriceReverse(List<CarData> cars){
		Collections.sort(cars,new Comparator<CarData>() {
			@Override
			public int compare(CarData c1, CarData c2) {
				return (int) (c2.getPrice()-c1.getPrice());
			}
		});
	}

}
