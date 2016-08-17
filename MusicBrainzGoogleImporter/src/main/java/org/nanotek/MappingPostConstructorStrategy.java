package org.nanotek;

/**
 *
 * This class has the objective to concentrate, the mapping strategy for the CsvReader on
 * OpnCSV component, the CSV parser uses an Array to manage the mapping between items on a CSV row and
 * the POJO that will be used as a spectrum of the line. ;-)
 *
 * @author josecanovamauger
 *
 * @param <T>
 */
public interface MappingPostConstructorStrategy<T> {

	public String[] buildMapping();

}