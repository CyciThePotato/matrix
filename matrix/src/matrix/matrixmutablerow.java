package matrix;

import java.util.stream.IntStream;

/**
 * Elke instantie van deze klassse slaat een matrix met gegeven rijen en kolommen op.
 */
public class matrixmutablerow {

	/**
	 * @invar | rows > 0
	 * @invar | columns > 0
	 * @invar | matrix != null
	 */
	private int rows;
	private int columns;
	private double[][] matrix;
	
	
	/**
	 * @pre | rijen > 0
	 * @pre | kolommen > 0
	 * @pre | elements != null
	 * 
	 * @post | getlengthrow() == rijen
	 * @post | getlengthcolumn() == kolommen
	 * @post | getelementlength(elements) == elements.length
	 * @post | IntStream.range(0, rijen).allMatch(i -> (IntStream.range(0, kolommen).allMatch(j -> getlengthcolumn() == kolommen)))
	 */
	public matrixmutablerow(int rijen, int kolommen, double[] elements) {
		this.matrix = new double[rijen][kolommen];		
		this.rows = rijen;
		this.columns = kolommen;
		int elementindex = 0;
		for (int i = 0; i < rijen; i++) {
			for(int j = 0; i < kolommen; j++) {
				matrix[i][j] = elements[elementindex];
				elementindex++;
				if (elementindex >= elements.length)
	                return;
			}
		}
	}
	
	public int getlengthrow() {
		return this.columns;
	}
	
	public int getlengthcolumn() {
		return this.rows;
	}
	
	public int getelementlength(double[] elements) {
		return elements.length;
	}
	
	public double getelementat(int rij, int kolom) {
		return this.matrix[rij][kolom];
	}
	
	public double[] getinrowmajor() {
		double[] matrice = new double[this.rows * this.columns];
		int index = 0;
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				matrice[index++] = this.matrix[i][j];
			}
		}
		return matrice;
	}
	
	public double[] getincolmajor() {
		double[] matrice = new double[this.rows * this.columns];
		int index = 0;
		for (int i = 0; i < this.columns; i++) {
			for (int j = 0; j < this.rows; j++) {
				matrice[index++] = this.matrix[j][i];
			}
		}
		return matrice;
	}
		
	public double [][] getinarrayarray() {
		return this.matrix;
	}
	
	/**
	 * @throws IllegalStateException | matrice.getlengthrow() != getlengthrow() || matrice.getlengthcolumn() != getlengthcolumn()
	 * @mutates | this
	 * 
	 */
	public double[][] add(matrixmutablerow matrice) {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				this.matrix[i][j] += matrice.matrix[i][j];
			}
		}
		return this.matrix;
	}
	
	/**
	 * 
	 * @mutates | this
	 */
	public double[][] scale(double scalar) {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				this.matrix[i][j] *= scalar;
			}
		}
		return this.matrix;
	}
}
